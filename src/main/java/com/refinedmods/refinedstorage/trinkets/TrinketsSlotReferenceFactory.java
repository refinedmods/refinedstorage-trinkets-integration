package com.refinedmods.refinedstorage.trinkets;

import com.refinedmods.refinedstorage.platform.api.support.slotreference.SlotReference;
import com.refinedmods.refinedstorage.platform.api.support.slotreference.SlotReferenceFactory;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

class TrinketsSlotReferenceFactory implements SlotReferenceFactory {
    static final SlotReferenceFactory INSTANCE = new TrinketsSlotReferenceFactory();
    private static final StreamCodec<RegistryFriendlyByteBuf, TrinketsSlotReference> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, TrinketsSlotReference::groupName,
            ByteBufCodecs.STRING_UTF8, TrinketsSlotReference::slotName,
            ByteBufCodecs.INT, TrinketsSlotReference::index,
            TrinketsSlotReference::new
        );

    private TrinketsSlotReferenceFactory() {
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public StreamCodec<RegistryFriendlyByteBuf, SlotReference> getStreamCodec() {
        return (StreamCodec) STREAM_CODEC;
    }
}
