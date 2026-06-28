package net.dukino.slotmachinemod.CustomBlock;

import net.dukino.slotmachinemod.SlotMachineMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomBlock {
    // Define custom block object
    public static final Block SLOT_MACHINE = new SlotMachineBlock(
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
    );

    // Helper method that registers the block and its item form
    private static void registerBlock(String name, Block block){
        Identifier id = Identifier.of(SlotMachineMod.MOD_ID, name);

        // Register the block
        Registry.register(Registries.BLOCK, id, block);

        // Register the item version to hold
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
    }

    // This will be called by the main "mod"
    public static void registerCustomBlock()
    {
        // // "slot_machine" is the internal registry name of the custom block
        registerBlock("slot_machine", SLOT_MACHINE);
    }
}

