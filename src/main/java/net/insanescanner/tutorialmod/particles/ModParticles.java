package net.insanescanner.tutorialmod.particles;

import net.insanescanner.tutorialmod.TutorialMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPE =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> PURPLE_FACE =
            PARTICLE_TYPE.register("purpleface", () -> new SimpleParticleType(true));
    public static void register(IEventBus eventBus){
        PARTICLE_TYPE.register(eventBus);;
    }


}
