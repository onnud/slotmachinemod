package net.dukino.slotmachinemod.CustomBlock;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomBlockEnteties {

    public static final BlockEntityType<SlotMachineBlockEntity> SLOT_MACHINE_BE =
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of("slotmachinemod", "slot_machine_be"),
                    BlockEntityType.Builder.create(SlotMachineBlockEntity::new, CustomBlock.SLOT_MACHINE).build()
            );
    public static void registerBlockEnteties()
    {

    }

}

