package net.krojiak.whatwhocaaares.item;

import net.minecraft.item.FoodComponent;

public class ModFoods {
    public static final FoodComponent SCARLET_APPLE = (new FoodComponent.Builder().hunger(8).saturationModifier(0.6F)).build();
    public static final FoodComponent DEMON_APPLE = (new FoodComponent.Builder().hunger(2)).build();

    public static final FoodComponent TIRED_APPLE = (new FoodComponent.Builder().hunger(8).saturationModifier(0.6F)).build();
    public static final FoodComponent SPIRIT_APPLE = (new FoodComponent.Builder().hunger(2)).build();
}
