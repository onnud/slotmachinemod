package net.dukino.slotmachinemod;

import net.dukino.slotmachinemod.CustomBlock.CustomBlock;
import net.dukino.slotmachinemod.CustomBlock.CustomBlockEnteties;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.impl.util.log.ConsoleLogHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.datafixer.fix.BannerCustomNameToItemNameFix;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlotMachineMod implements ModInitializer {
	public static final String MOD_ID = "slotmachinemod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Suh dude, ready to gamble?");

		// "Wake up" the custom blocks
		CustomBlock.registerCustomBlock();

		CustomBlockEnteties.registerBlockEnteties();

		// Add the custom block to the creative tab under redstone
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content-> {
			content.add(CustomBlock.SLOT_MACHINE);
		});

	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
