package com.lazydragonstudios.wuxiacraft.init;

import com.lazydragonstudios.wuxiacraft.WuxiaCraft;
import com.lazydragonstudios.wuxiacraft.blocks.entity.FormationCore;
import com.lazydragonstudios.wuxiacraft.blocks.entity.InscriberEntity;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("ConstantConditions")
public class WuxiaBlockEntities {

	public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, WuxiaCraft.MOD_ID);

	public static RegistryObject<BlockEntityType<InscriberEntity>> INSCRIBER_TYPE = BLOCK_ENTITIES.register("inscriber_type",
			() -> BlockEntityType.Builder
					.of(InscriberEntity::new, WuxiaBlocks.TECHNIQUE_INSCRIBER.get())
					.build(Util.fetchChoiceType(References.BLOCK_ENTITY, "inscriber_type"))
	);

	public static RegistryObject<BlockEntityType<FormationCore>> FORMATION_CORE = BLOCK_ENTITIES.register("formation_core",
			() -> BlockEntityType.Builder
					.of(FormationCore::new, WuxiaBlocks.WOOD_FORMATION_CORE.get())
					.build(Util.fetchChoiceType(References.BLOCK_ENTITY, "formation_core"))
			);

}
