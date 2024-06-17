package com.refinedmods.refinedstorage.trinkets;

import java.util.Optional;

import com.refinedmods.refinedstorage2.platform.api.support.network.bounditem.SlotReference;
import com.refinedmods.refinedstorage2.platform.api.support.network.bounditem.SlotReferenceFactory;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

class TrinketsSlotReference implements SlotReference {
    private final String groupName;
    private final String slotName;
    private final int index;

    TrinketsSlotReference(final String groupName, final String slotName, final int index) {
        this.groupName = groupName;
        this.slotName = slotName;
        this.index = index;
    }

    @Override
    public boolean isDisabledSlot(final int playerSlotIndex) {
        return false;
    }

    @Override
    public void writeToBuffer(final FriendlyByteBuf buf) {
        buf.writeUtf(groupName);
        buf.writeUtf(slotName);
        buf.writeInt(index);
    }

    @Override
    public Optional<ItemStack> resolve(final Player player) {
        return TrinketsApi.getTrinketComponent(player)
            .map(trinkets -> trinkets.getInventory().get(groupName))
            .map(groupMap -> groupMap.get(slotName))
            .map(trinketInventory -> trinketInventory.getItem(index));
    }

    @Override
    public SlotReferenceFactory getFactory() {
        return TrinketsSlotReferenceFactory.INSTANCE;
    }
}
