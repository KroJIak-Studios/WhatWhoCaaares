package net.krojiak.whatwhocaaares.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.krojiak.whatwhocaaares.fluid.ModFluids;
import net.krojiak.whatwhocaaares.item.custom.DemonStyletItem;
import net.krojiak.whatwhocaaares.item.custom.ElegantStyletItem;
import net.krojiak.whatwhocaaares.whatwhocaaares;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item RAW_BAUXITE = registerItem("raw_bauxite", new Item(new FabricItemSettings().group(ModItemGroup.ENVIRONMENT)));
    public static final Item RAW_ALUNITE = registerItem("raw_alunite", new Item(new FabricItemSettings().group(ModItemGroup.ENVIRONMENT)));
    public static final Item NEPHELINE_CRYSTAL = registerItem("nepheline_crystal", new Item(new FabricItemSettings().group(ModItemGroup.ENVIRONMENT)));
    public static final Item SYENITE_SHARD = registerItem("syenite_shard", new Item(new FabricItemSettings().group(ModItemGroup.ENVIRONMENT)));
    public static final Item ALUMINA = registerItem("alumina", new Item(new FabricItemSettings().group(ModItemGroup.PRODUCTION)));
    public static final Item SULPHURIC_ACID_BUCKET = registerItem("sulphuric_acid_bucket",
            new BucketItem(ModFluids.SULPHURIC_ACID_STILL, new FabricItemSettings().maxCount(1).group(ModItemGroup.ENVIRONMENT)));
    public static final Item ELEGANT_STYLET = registerItem("elegant_stylet",
            new ElegantStyletItem(new FabricItemSettings().maxCount(1).maxDamage(8).group(ModItemGroup.NIGHTOSPHERE)));
    public static final Item SCARLET_APPLE = registerItem("scarlet_apple",
            new Item(new FabricItemSettings().food(ModFoods.SCARLET_APPLE).group(ModItemGroup.NIGHTOSPHERE)));
    public static final Item DEMON_APPLE = registerItem("demon_apple",
            new Item(new FabricItemSettings().food(ModFoods.DEMON_APPLE).group(ModItemGroup.NIGHTOSPHERE)));
    public static final Item DEMON_STYLET = registerItem("demon_stylet",
            new DemonStyletItem(new FabricItemSettings().maxCount(1).maxDamage(128).group(ModItemGroup.NIGHTOSPHERE)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(whatwhocaaares.MOD_ID, name), item);
    }
    public static void registerModItems(){
        whatwhocaaares.LOGGER.debug("Registering Mod Items for " + whatwhocaaares.MOD_ID);
    }
}
