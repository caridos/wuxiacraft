package com.airesnor.wuxiacraft.proxy;

import com.airesnor.wuxiacraft.capabilities.CapabilitiesHandler;
import com.airesnor.wuxiacraft.capabilities.CultivationFactory;
import com.airesnor.wuxiacraft.capabilities.CultivationStorage;
import com.airesnor.wuxiacraft.cultivation.ICultivation;
import com.airesnor.wuxiacraft.handlers.EventHandler;
import com.airesnor.wuxiacraft.handlers.RendererHandler;
import com.airesnor.wuxiacraft.networking.*;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {

	/**
	 * Does in the server so this method is empty because server doesn't need textures i guess
	 * @param item
	 * @param meta
	 * @param id
	 */
	public void registerItemRenderer(Item item, int meta, String id) { }

	public void init() {
		CapabilityManager.INSTANCE.register(ICultivation.class, new CultivationStorage(), new CultivationFactory());

		NetworkWrapper.INSTANCE.registerMessage(new CultivationMessageHandler(), CultivationMessage.class, 167001, Side.CLIENT);

		MinecraftForge.EVENT_BUS.register(new CapabilitiesHandler());
		MinecraftForge.EVENT_BUS.register(new RendererHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

}
