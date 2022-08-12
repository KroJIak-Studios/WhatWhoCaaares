package net.krojiak.whatwhocaaares.item.custom;

import net.krojiak.whatwhocaaares.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class DoneStyletItem extends Item {

    public DoneStyletItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        if(!world.isClient() && player != null) {
            world.setBlockState(blockPos.offset(context.getSide()), outputBlock().getDefaultState());
            ItemStack itemStack = player.getMainHandStack();
            itemStack.setDamage(itemStack.getDamage() + 1);
            player.getItemCooldownManager().set(this, 5);
            if(itemStack.getDamage() == itemStack.getMaxDamage()) { itemStack.setCount(0); }
        }
        return super.useOnBlock(context);
    }
    public abstract Block outputBlock();
}
