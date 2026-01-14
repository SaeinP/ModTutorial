package net.insanescanner.tutorialmod.entity.client.watching_entity;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;


public class WatchingEntityAnimations {
    public static final AnimationDefinition WATCHING_ENTITY_WALK = AnimationDefinition.Builder.withLength(2.5417F).looping()
		.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(0.75F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(0.75F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.0F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(0.75F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.0F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(0.75F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition WATCHING_ENTITY_IDLE = AnimationDefinition.Builder.withLength(8.5417F).looping()
		.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(0.4573F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 34.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.5833F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 27.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 34.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.75F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 27.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 34.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 19.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -0.5F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -19.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -14.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -22.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -17.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -13.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -21.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -12.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -18.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -11.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -18.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.7073F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -18.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(4.374F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(4.375F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -19.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.4583F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -14.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.5417F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -22.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.5833F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -17.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.625F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -13.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -21.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.75F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -12.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.7917F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -18.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.8333F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -11.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(4.875F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -18.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(4.9573F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, -18.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(4.9583F, KeyframeAnimations.degreeVec(0.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(6.749F, KeyframeAnimations.degreeVec(0.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(6.75F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 16.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(6.7917F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 16.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(6.8333F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 21.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(6.9167F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 13.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(6.9583F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 18.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(7.0F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 22.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(7.0833F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 14.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(7.125F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 23.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(7.1667F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 17.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(7.2083F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 24.0F), AnimationChannel.Interpolations.CATMULLROM),
            new Keyframe(7.25F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 17.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(7.3323F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 17.0F), AnimationChannel.Interpolations.LINEAR),
            new Keyframe(7.3333F, KeyframeAnimations.degreeVec(1.0F, 0.0F, 17.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .build();

}
