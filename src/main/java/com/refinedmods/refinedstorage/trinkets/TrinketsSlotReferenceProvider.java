package com.refinedmods.refinedstorage.trinkets;

import com.refinedmods.refinedstorage.platform.api.support.slotreference.SlotReference;
import com.refinedmods.refinedstorage.platform.api.support.slotreference.SlotReferenceProvider;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

class TrinketsSlotReferenceProvider implements SlotReferenceProvider {
    @Override
    public List<SlotReference> find(final Player player, final Set<Item> validItems) {
        return TrinketsApi.getTrinketComponent(player)
            .map(trinkets -> trinkets.getEquipped(s -> validItems.contains(s.getItem())))
            .orElse(Collections.emptyList())
            .stream()
            .map(Tuple::getA)
            .map(trinketsSlotReference -> (SlotReference) new TrinketsSlotReference(
                trinketsSlotReference.inventory().getSlotType().getGroup(),
                trinketsSlotReference.inventory().getSlotType().getName(),
                trinketsSlotReference.index()
            ))
            .toList();
    }
}
