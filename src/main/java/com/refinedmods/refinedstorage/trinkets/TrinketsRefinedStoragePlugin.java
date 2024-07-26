package com.refinedmods.refinedstorage.trinkets;

import com.refinedmods.refinedstorage.common.api.RefinedStorageApi;
import com.refinedmods.refinedstorage.fabric.api.RefinedStoragePlugin;

import net.minecraft.resources.ResourceLocation;

public class TrinketsRefinedStoragePlugin implements RefinedStoragePlugin {
    public static final String ID = "refinedstorage_trinkets_integration";

    @Override
    public void onApiAvailable(final RefinedStorageApi api) {
        api.getSlotReferenceFactoryRegistry().register(
            ResourceLocation.fromNamespaceAndPath(ID, "trinkets"),
            TrinketsSlotReferenceFactory.INSTANCE
        );
        api.addSlotReferenceProvider(new TrinketsSlotReferenceProvider());
    }
}
