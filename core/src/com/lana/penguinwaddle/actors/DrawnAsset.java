package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class DrawnAsset extends Actor {
    protected String textureName;

    public DrawnAsset(String textureName){
        this.textureName = textureName;
    }
}
