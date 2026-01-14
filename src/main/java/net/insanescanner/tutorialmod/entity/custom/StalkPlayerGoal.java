package net.insanescanner.tutorialmod.entity.custom;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Monster;

public class StalkPlayerGoal extends Goal {
    private final Monster mob;
    private final double speed;
    private final double stopDistance;

    public StalkPlayerGoal(Monster mob, double speed, double stopDistance) {
        this.mob = mob;
        this.speed = speed;
        this.stopDistance = stopDistance;
    }

    @Override
    public boolean canUse() {
        return mob.getTarget() != null && mob.getTarget().isAlive();
    }

    @Override
    public void tick() {
        if (mob.getTarget() != null) {
            double distanceSq = mob.distanceToSqr(mob.getTarget());
            if (distanceSq > stopDistance * stopDistance) {
                mob.getNavigation().moveTo(mob.getTarget(), speed);
            } else {
                mob.getNavigation().stop();
            }
        }
    }
}
