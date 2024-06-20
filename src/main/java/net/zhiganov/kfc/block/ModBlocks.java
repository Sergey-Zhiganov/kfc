package net.zhiganov.kfc.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zhiganov.kfc.KFC;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KFC.MOD_ID);


    public static final RegistryObject<Block> KFC_BUCKET = BLOCKS.register("kfc_bucket",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.5F, 3.0F)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> KFC_BLOCK = BLOCKS.register("kfc_block", () ->
            new KFCBlock(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(0.5f)
                    .noOcclusion()));

    public static final RegistryObject<Block> KFC_SIGN = BLOCKS.register("kfc_sign",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2F, 5F)
                    .sound(SoundType.METAL)
                    .lightLevel((state) -> 14)));
    public static final RegistryObject<Block> SODA_MACHINE = BLOCKS.register("soda_machine",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(2.5F, 6.0F)
                    .sound(SoundType.METAL)));
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
