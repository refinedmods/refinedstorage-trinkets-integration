package com.refinedmods.refinedstorage.trinkets;

import com.refinedmods.refinedstorage2.platform.api.PlatformApi;
import com.refinedmods.refinedstorage2.platform.api.RefinedStoragePlugin;
import com.refinedmods.refinedstorage2.platform.common.util.IdentifierUtil;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrinketsRefinedStoragePlugin implements RefinedStoragePlugin {
    public static final String ID = "refinedstorage_trinkets_integration";

    private static final Logger LOGGER = LoggerFactory.getLogger(TrinketsRefinedStoragePlugin.class);

    @Override
    public void onPlatformApiAvailable(final PlatformApi platformApi) {
        PlatformApi.INSTANCE.getSlotReferenceFactoryRegistry().register(
            new ResourceLocation(ID, "trinkets"),
            TrinketsSlotReferenceFactory.INSTANCE
        );
        PlatformApi.INSTANCE.addSlotReferenceProvider(new TrinketsSlotReferenceProvider());
        LOGGER.info(
            "Refined Storage - Trinkets Integration has loaded. RS2 ModId: {}",
            IdentifierUtil.MOD_ID
        );
    }
}
