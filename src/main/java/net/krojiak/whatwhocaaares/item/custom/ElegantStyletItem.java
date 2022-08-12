package net.krojiak.whatwhocaaares.item.custom;

import net.krojiak.whatwhocaaares.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Souls {
    Item apple, resultApple, stylet;
    public Souls(Item apple, Item resultApple, Item stylet){
        this.apple = apple;
        this.resultApple = resultApple;
        this.stylet = stylet;
    }
}

public class ElegantStyletItem extends Item {
    public ElegantStyletItem(Settings settings) {
        super(settings);
    }

    public static Map<Integer, Souls> listSouls;

    public static void addSoulsToMap(){
        listSouls.put(1, new Souls(ModItems.TIRED_APPLE, ModItems.SPIRIT_APPLE, ModItems.SPIRIT_STYLET));
        listSouls.put(2, new Souls(ModItems.SCARLET_APPLE, ModItems.DEMON_APPLE, ModItems.DEMON_STYLET));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            listSouls = new HashMap<>();
            addSoulsToMap();
            ItemStack itemMain = user.getMainHandStack();
            ItemStack itemOff = user.getOffHandStack();
            int nbtSoul = itemMain.getOrCreateNbt().getInt("soul");
            for(Map.Entry<Integer, Souls> entry : listSouls.entrySet()) {
                if (nbtSoul == 0 || nbtSoul == entry.getKey()) {
                    Souls s = entry.getValue();
                    useStylet(user, itemMain, itemOff, this, entry.getKey(), s.apple, s.resultApple, s.stylet);
                }
            }

        }
        return super.use(world, user, hand);
    }

    public static void useStylet(PlayerEntity user, ItemStack itemMain, ItemStack itemOff, ElegantStyletItem thisItem, int number,
                                 ItemConvertible needItemOff, ItemConvertible resultItem, ItemConvertible zeroDamageItem){
        if(itemMain.getItem().equals(new ItemStack(ModItems.ELEGANT_STYLET).getItem())
                && itemOff.getItem().equals(new ItemStack(needItemOff).getItem())){
            itemOff.setCount(itemOff.getCount()-1);
            user.getItemCooldownManager().set(thisItem, 20);
            if(Random.createLocal().nextInt(10) < 3){
                itemMain.setDamage(user.getMainHandStack().getDamage()-1);
                itemMain.getOrCreateNbt().putInt("soul", number);
                user.giveItemStack(new ItemStack(resultItem));
            }
            if(itemMain.getDamage() == 0){
                int slot = user.getInventory().selectedSlot;
                user.getInventory().main.set(slot, new ItemStack(zeroDamageItem));
            }
        }
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isClient()) {
            stack.setDamage(stack.getMaxDamage());
            stack.getOrCreateNbt().putInt("soul", 0);
        }
        super.onCraft(stack, world, player);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.getOrCreateNbt().getInt("soul") != 0){
            Souls soul = listSouls.get(stack.getOrCreateNbt().getInt("soul"));
            System.out.println(new TranslatableTextContent("item.whatwhocaaares.elegant_stylet.tooltip"));
            tooltip.add(Text.literal(soul.resultApple.getName().getString()).formatted(Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
