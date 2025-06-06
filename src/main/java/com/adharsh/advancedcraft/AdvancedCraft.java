package com.adharsh.advancedcraft;

import com.adharsh.advancedcraft.registry.ModBlocks;
import com.adharsh.advancedcraft.registry.ModItemGroups;
import com.adharsh.advancedcraft.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedCraft implements ModInitializer {
	public static final String MOD_ID = "advancedcraft";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//	An global identifier function
	public static Identifier id (String path) {
		return  Identifier.of(MOD_ID, path);
	}


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Loading Message
		LOGGER.info("Hello From AdvancedCraft!");
		LOGGER.info("Loading...");

		// Registering Mod Items, Blocks, Mobs etc
		ModItems.RegisterModItems();
		ModBlocks.RegisterModBlocks();
		ModItemGroups.RegisterModItemGroups();

		// Finished Message
		AdvancedCraft.LOGGER.info("AdvancedCraft is loaded!");
	}
}