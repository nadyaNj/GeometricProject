package com.mLab.geometric.model.enums;

/**
 * Created by nadya on 6/27/14.
 */
public enum WorldSide {
    EAST("my east"),
    WEST("my west"),
    NORTH("my north"),
    SOUTH("my south");

    private String txt ;

    private static WorldSide current = EAST;

    public static WorldSide getCurrentWorldSide() {
        if(current == null) {

        }
        return current;
    }

    public static WorldSide getCurrent() {
        return current = values()[(current.ordinal()+1)%values().length];
    }

    private WorldSide(String txt) {
        this.txt = txt;
    }
}
