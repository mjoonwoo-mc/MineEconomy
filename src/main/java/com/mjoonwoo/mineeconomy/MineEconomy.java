package com.mjoonwoo.mineeconomy;

import com.mjoonwoo.mineeconomy.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineEconomy implements ModInitializer {
	public static final String MOD_ID = "mineeconomy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
	}
}