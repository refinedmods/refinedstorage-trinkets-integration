package com.refinedmods.refinedstorage.trinkets;

import com.refinedmods.refinedstorage.platform.api.PlatformApi;
import com.refinedmods.refinedstorage.platform.api.RefinedStoragePlugin;

import net.minecraft.resources.ResourceLocation;

public class TrinketsRefinedStoragePlugin implements RefinedStoragePlugin {
    public static final String ID = "refinedstorage_trinkets_integration";

    @Override
    public void onPlatformApiAvailable(final PlatformApi platformApi) {
        PlatformApi.INSTANCE.getSlotReferenceFactoryRegistry().register(
            ResourceLocation.fromNamespaceAndPath(ID, "trinkets"),
            TrinketsSlotReferenceFactory.INSTANCE
        );
        PlatformApi.INSTANCE.addSlotReferenceProvider(new TrinketsSlotReferenceProvider());
    }
}
