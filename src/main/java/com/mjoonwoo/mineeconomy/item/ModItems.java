package com.mjoonwoo.mineeconomy.item;

import com.mjoonwoo.mineeconomy.MineEconomy;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item BILL_ITEM = registerItem("bill_item", Item::new, new Item.Settings());
    public static final Item COIN_ITEM = registerItem("coin_item", Item::new, new Item.Settings());

    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MineEconomy.MOD_ID, name));
        return Items.register(registerKey,factory, settings);
    }

}
