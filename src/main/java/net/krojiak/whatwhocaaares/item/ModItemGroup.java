package net.krojiak.whatwhocaaares.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.krojiak.whatwhocaaares.whatwhocaaares;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ENVIRONMENT = FabricItemGroupBuilder.build(new Identifier(whatwhocaaares.MOD_ID, "environment"),
            () -> new ItemStack(ModItems.RAW_BAUXITE));
    public static final ItemGroup ASTROLOGY = FabricItemGroupBuilder.build(new Identifier(whatwhocaaares.MOD_ID, "astrology"),
            () -> new ItemStack(ModItems.NEPHELINE_CRYSTAL));
    public static final ItemGroup PRODUCTION = FabricItemGroupBuilder.build(new Identifier(whatwhocaaares.MOD_ID, "production"),
            () -> new ItemStack(ModItems.ALUMINA));
    public static final ItemGroup NIGHTOSPHERE = FabricItemGroupBuilder.build(new Identifier(whatwhocaaares.MOD_ID, "nightosphere"),
            () -> new ItemStack(ModItems.SYENITE_SHARD));
}
