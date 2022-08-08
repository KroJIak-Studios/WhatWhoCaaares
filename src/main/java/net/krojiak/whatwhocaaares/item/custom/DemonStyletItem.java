package net.krojiak.whatwhocaaares.item.custom;

import net.krojiak.whatwhocaaares.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DemonStyletItem extends Item {

    public DemonStyletItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        if(!world.isClient()) {
            world.setBlockState(blockPos.offset(context.getSide()), ModBlocks.SYENITE.getDefaultState());
            player.getMainHandStack().setDamage(player.getMainHandStack().getDamage() + 1);
        }
        return super.useOnBlock(context);
    }
}
