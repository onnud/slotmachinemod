package net.dukino.slotmachinemod.CustomBlock;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class SlotMachineBlockEntity extends BlockEntity {

    public ItemStack betSize = ItemStack.EMPTY;

    public SlotMachineBlockEntity(BlockPos pos, BlockState state)
    {
        super(CustomBlockEnteties.SLOT_MACHINE_BE, pos, state);
    }

}
