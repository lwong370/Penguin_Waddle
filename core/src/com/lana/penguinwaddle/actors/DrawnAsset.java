package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Drawn asset actor from texture region image drawn with Autodesk Sketchbook.
 * Parent class for hand-drawn labels.
 * @author Lana
 */
public abstract class DrawnAsset extends Actor {
    protected String textureName;

    public DrawnAsset(String textureName){
        this.textureName = textureName;
    }
}
