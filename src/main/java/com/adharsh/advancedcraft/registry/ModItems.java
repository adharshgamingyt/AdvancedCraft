package com.adharsh.advancedcraft.registry;

import com.adharsh.advancedcraft.AdvancedCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item RAW_TITANIUM = RegisterItem("raw_titanium", Item::new);
    public static final Item TITANIUM_INGOT = RegisterItem("titanium_ingot", Item::new);

    private static  Item RegisterItem(String name, Function<Item.Settings, Item> function) {
        Identifier id = AdvancedCraft.id(name);

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(Registries.ITEM, id, function.apply(new Item.Settings().registryKey(key)));
    }

    public static void RegisterModItems () {
        AdvancedCraft.LOGGER.info("Registering Items For " + AdvancedCraft.MOD_ID);
    }

}
