package net.insanescanner.tutorialmod.villagers;

import com.google.common.collect.ImmutableSet;
import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.insanescanner.tutorialmod.sounds.ModSounds;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TutorialMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TutorialMod.MOD_ID);

    public static final RegistryObject<PoiType> ESTEEMED_POI = POI_TYPES.register("esteemed_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.TEXTURELESS_CHAIR.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> ESTEEMED_VILLAGER = VILLAGER_PROFESSIONS.register("esteemed_villager",
            () -> new VillagerProfession("esteemed_villager", holder -> holder.value() == ESTEEMED_POI.get(),
                    holder -> holder.value() == ESTEEMED_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.MAGIC_BLOCK_HIT.get()));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
