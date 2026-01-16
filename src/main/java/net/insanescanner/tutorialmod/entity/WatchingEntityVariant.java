package net.insanescanner.tutorialmod.entity;

import net.insanescanner.tutorialmod.entity.client.watching_entity.WatchingEntityAnimations;

import java.util.Arrays;
import java.util.Comparator;

public enum WatchingEntityVariant {

    STALK(0),
    ATTACK(1);


    private static final WatchingEntityVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(WatchingEntityVariant::getId)).toArray(WatchingEntityVariant[]::new);
    private final int id;

    WatchingEntityVariant(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static WatchingEntityVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
