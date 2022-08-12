package net.krojiak.whatwhocaaares.item.custom;

import net.krojiak.whatwhocaaares.block.ModBlocks;
import net.minecraft.block.Block;

public class SpiritStyletItem extends DoneStyletItem {

    public SpiritStyletItem(Settings settings) {
        super(settings);
    }

    @Override
    public Block outputBlock() {
        return ModBlocks.SPIRIT_SYMBOL;
    }


}
