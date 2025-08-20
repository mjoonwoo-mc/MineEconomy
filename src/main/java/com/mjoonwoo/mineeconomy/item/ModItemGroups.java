package com.mjoonwoo.mineeconomy.item;

import com.mjoonwoo.mineeconomy.MineEconomy;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MINEECONOMY_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MineEconomy.MOD_ID, "mineeconomy_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BILL_ITEM))
                    .displayName(Text.translatable("itemgroup.mineeconomy.mineeconomy_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BILL_ITEM);
                        entries.add(ModItems.COIN_ITEM);

                    }).build());


    public static void registerItemGroups() {
        MineEconomy.LOGGER.info("Registering Item Groups for " + MineEconomy.MOD_ID);
    }
}
