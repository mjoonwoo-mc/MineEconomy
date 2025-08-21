package com.mjoonwoo.mineeconomy.item;

import com.mjoonwoo.mineeconomy.MineEconomy;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item BILL_ITEM = register("bill_item", Item::new, new Item.Settings());
    public static final Item COIN_ITEM = register("coin_item", Item::new, new Item.Settings());

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MineEconomy.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final RegistryKey<ItemGroup> MINEECONOMY_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MineEconomy.MOD_ID, "item_group"));
    public static final ItemGroup MINEECONOMY_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BILL_ITEM))
            .displayName(Text.translatable("itemGroup.mineeconomy"))
            .build();

    public static void registerItemGroups() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, MINEECONOMY_GROUP_KEY, MINEECONOMY_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(MINEECONOMY_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.BILL_ITEM);
            itemGroup.add(ModItems.COIN_ITEM);
            // ...
        });
    }

    public static void initialize() {
    }

}
