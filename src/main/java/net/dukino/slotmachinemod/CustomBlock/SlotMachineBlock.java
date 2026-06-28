package net.dukino.slotmachinemod.CustomBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.entity.BlockEntity;

public class SlotMachineBlock extends Block implements BlockEntityProvider {
    public SlotMachineBlock(Settings settings)
    {
        super(settings);
    }
    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        if(!world.isClient())
        {
            BlockEntity entity = world.getBlockEntity(pos);

            if(player.isSneaking())
            {
                player.sendMessage(Text.literal("Spinning..."), false);
            }
            else
            {
                if(stack.isEmpty())
                {
                    player.sendMessage(Text.literal("Changing Volatility!"), false);
                }
                else
                {
                    if(entity instanceof SlotMachineBlockEntity slotMachineEntity)
                    {
                        int maxBet = 64;

                        if(slotMachineEntity.betSize.isEmpty())
                        {
                            int amountToTake = Math.min(stack.getCount(),maxBet);
                            slotMachineEntity.betSize = stack.copyWithCount(amountToTake);
                            stack.decrement(amountToTake);

                            player.sendMessage(Text.literal("Current bet : " + slotMachineEntity.betSize.getCount() +" "+ slotMachineEntity.betSize.getName().getString() + "s"), false);
                        }
                        else
                        {
                           if(stack.isOf(slotMachineEntity.betSize.getItem()))
                           {
                               int currentAmount = slotMachineEntity.betSize.getCount();

                               if(currentAmount < maxBet)
                               {
                                   int spaceLeft = maxBet - currentAmount;
                                   int amountToTake = Math.min(stack.getCount(), spaceLeft);

                                   slotMachineEntity.betSize.increment(amountToTake);
                                   stack.decrement(amountToTake);
                                   player.sendMessage(Text.literal("Current bet: " + slotMachineEntity.betSize.getCount() + " " + slotMachineEntity.betSize.getName().getString() + "s"), false);
                               }
                               else
                               {
                                   player.sendMessage(Text.literal("Max bet reached, Pull the lever!"), false);
                               }
                           }
                           else
                           {
                                player.sendMessage(Text.literal("You cant mix items!"));
                           }
                        }
                    }
                }
            }
        }
        return ItemActionResult.success(world.isClient());
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return new SlotMachineBlockEntity(pos,state);
    }

}
