package com.adharsh.advancedcraft.registry;

import com.adharsh.advancedcraft.AdvancedCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block TITANIUM_BLOCK = RegisterBlock("titanium_block", properties -> new Block(properties
            .requiresTool()
            .strength(5.0f, 7.0f)
            .sounds(BlockSoundGroup.METAL)));

    public static final Block TITANIUM_ORE = RegisterBlock("titanium_ore", properties -> new Block(properties
            .requiresTool()
            .strength(4.0f, 5.0f)
            .sounds(BlockSoundGroup.STONE)
    ));

    public static final Block DEEPSLATE_TITANIUM_ORE = RegisterBlock("deepslate_titanium_ore", properties -> new Block(properties
            .requiresTool()
            .strength(4.0f, 5.0f)
            .sounds(BlockSoundGroup.STONE)
    ));

    public static final Block RAW_TITANIUM_BLOCK = RegisterBlock("raw_titanium_block", properties -> new Block(properties
            .requiresTool()
            .strength(5.0f, 6.0f)
            .sounds(BlockSoundGroup.METAL)));

    private static Block RegisterBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Identifier id = AdvancedCraft.id(name);

        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(key));

        RegisterBlockItem(name, toRegister);

        return Registry.register(Registries.BLOCK, id, toRegister);
    }
    private static Block RegisterBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, AdvancedCraft.id(name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,  AdvancedCraft.id(name)))));
    }

    private static void RegisterBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM,  AdvancedCraft.id(name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM,  AdvancedCraft.id(name)))));
    }

    public static void RegisterModBlocks() {
        AdvancedCraft.LOGGER.info("Registering Blocks For " + AdvancedCraft.MOD_ID);
    }
}
