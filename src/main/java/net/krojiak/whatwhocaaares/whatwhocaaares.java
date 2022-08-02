package net.krojiak.whatwhocaaares;

import net.fabricmc.api.ModInitializer;
import net.krojiak.whatwhocaaares.block.ModBlocks;
import net.krojiak.whatwhocaaares.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class whatwhocaaares implements ModInitializer {
	public static final String MOD_ID = "whatwhocaaares";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
