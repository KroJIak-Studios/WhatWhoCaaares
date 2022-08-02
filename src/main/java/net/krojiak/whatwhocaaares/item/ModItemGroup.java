package net.krojiak.whatwhocaaares.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.krojiak.whatwhocaaares.whatwhocaaares;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup ENVIRONMENT = registerItemGroup("environment", ModItems.RAW_BAUXITE);
    public static final ItemGroup ASTROLOGY = registerItemGroup("astrology", ModItems.NEPHELINE_CRYSTAL);
    public static final ItemGroup PRODUCTION = registerItemGroup("production", ModItems.ALUMINA);
    public static final ItemGroup NIGHTOSPHERE = registerItemGroup("nightosphere", ModItems.SYENITE_SHARD);

    private static ItemGroup registerItemGroup(String name, Item item){
        return FabricItemGroupBuilder.build(new Identifier(whatwhocaaares.MOD_ID, name), () -> new ItemStack(item));
    }
}
