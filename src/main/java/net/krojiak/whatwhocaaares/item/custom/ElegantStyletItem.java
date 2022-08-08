package net.krojiak.whatwhocaaares.item.custom;

import net.krojiak.whatwhocaaares.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ElegantStyletItem extends Item {
    public ElegantStyletItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            ItemStack itemMain = user.getMainHandStack();
            ItemStack itemOff = user.getOffHandStack();
            if(itemMain.getItem().equals(new ItemStack(ModItems.ELEGANT_STYLET).getItem())
                    && itemOff.getItem().equals(new ItemStack(ModItems.SCARLET_APPLE).getItem())){
                itemOff.setCount(itemOff.getCount()-1);
                user.animateDamage();
                user.getItemCooldownManager().set(this, 20);
                if(Random.createLocal().nextInt(10) < 3){
                    itemMain.setDamage(user.getMainHandStack().getDamage()-1);
                    user.giveItemStack(new ItemStack(ModItems.DEMON_APPLE));
                }
            }
            if(itemMain.getDamage() == 0){
                int slot = user.getInventory().selectedSlot;
                user.getInventory().main.set(slot, new ItemStack(ModItems.DEMON_STYLET));
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isClient()) { stack.setDamage(stack.getMaxDamage()); }
    }
}
