package com.adharsh.advancedcraft.registry;

import com.adharsh.advancedcraft.AdvancedCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ModItemGroups {

    public static final ItemGroup ADVANCEDCRAFT_ITEMGROUP = Registry.register(Registries.ITEM_GROUP,
            AdvancedCraft.id("advancedcraft_item_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.TITANIUM_INGOT))
                    .displayName(Text.translatable("itemGroup.advancedcraft.itemgroup"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_TITANIUM);
                        entries.add(ModItems.TITANIUM_INGOT);
                        entries.add(ModItems.TITANIUM_NUGGET);
                        entries.add(ModBlocks.RAW_TITANIUM_BLOCK);
                        entries.add(ModBlocks.TITANIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TITANIUM_ORE);
                        entries.add(ModBlocks.TITANIUM_BLOCK);
                    })
                    .build()
    );

    public static void RegisterModItemGroups() {
        AdvancedCraft.LOGGER.info("Registering ModItemGroups For " + AdvancedCraft.MOD_ID);
    }

}
