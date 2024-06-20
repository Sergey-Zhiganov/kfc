package net.zhiganov.kfc;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.zhiganov.kfc.item.ModItems;

public class ModCreativeModeTab {
    public static final CreativeModeTab KFC = new CreativeModeTab("KFC") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FRIED_CHICKEN.get());
        }
    };
}
