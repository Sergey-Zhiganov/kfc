    package net.zhiganov.kfc.item;

    import net.minecraft.world.effect.MobEffectInstance;
    import net.minecraft.world.effect.MobEffects;
    import net.minecraft.world.food.FoodProperties;
    import net.minecraft.world.item.BlockItem;
    import net.minecraft.world.item.Item;
    import net.minecraftforge.eventbus.api.IEventBus;
    import net.minecraftforge.registries.DeferredRegister;
    import net.minecraftforge.registries.ForgeRegistries;
    import net.minecraftforge.registries.RegistryObject;
    import net.zhiganov.kfc.KFC;
    import net.zhiganov.kfc.ModCreativeModeTab;
    import net.zhiganov.kfc.block.ModBlocks;

    public class ModItems {
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, KFC.MOD_ID);
        public static final RegistryObject<Item> SPICES = ITEMS.register("spices", () ->
                new Item(new Item.Properties().tab(ModCreativeModeTab.KFC)));
        public static final RegistryObject<Item> RAW_CHICKEN_WITH_SPICES = ITEMS.register("raw_chicken_with_spices", ()
        -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).build()).tab(ModCreativeModeTab.KFC)));
        public static final RegistryObject<Item> FRIED_CHICKEN = ITEMS.register("fried_chicken", ()
        -> new Item(new Item.Properties()
                .food((new FoodProperties.Builder())
                        .nutrition(8)
                        .saturationMod(0.8F)
                        .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1.0F)
                        .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0F)
                        .alwaysEat()
                        .build()).tab(ModCreativeModeTab.KFC)));

        public static final RegistryObject<Item> KFC_BUCKET = ITEMS.register("kfc_bucket", () ->
                new BlockItem(ModBlocks.KFC_BUCKET.get(), new Item.Properties().tab(ModCreativeModeTab.KFC)));
        public static final RegistryObject<Item> KFC_BLOCK = ITEMS.register("kfc_block", () ->
                new BlockItem(ModBlocks.KFC_BLOCK.get(), new Item.Properties().tab(ModCreativeModeTab.KFC)));

        public static final RegistryObject<Item> KFC_SIGN = ITEMS.register("kfc_sign", () ->
                new BlockItem(ModBlocks.KFC_SIGN.get(), new Item.Properties().tab(ModCreativeModeTab.KFC)));
        public static final RegistryObject<Item> SODA_MACHINE = ITEMS.register("soda_machine", () ->
                new BlockItem(ModBlocks.SODA_MACHINE.get(), new Item.Properties().tab(ModCreativeModeTab.KFC)));
        public static void register(IEventBus eventBus){
            ITEMS.register(eventBus);
        }

    }