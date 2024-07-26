package com.refinedmods.refinedstorage.trinkets;

import com.refinedmods.refinedstorage.common.api.support.slotreference.SlotReference;
import com.refinedmods.refinedstorage.common.api.support.slotreference.SlotReferenceFactory;

import java.util.Optional;

import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

record TrinketsSlotReference(String groupName, String slotName, int index) implements SlotReference {
    @Override
    public boolean isDisabledSlot(final int playerSlotIndex) {
        return false;
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
