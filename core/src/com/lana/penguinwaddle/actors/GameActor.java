package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lana.penguinwaddle.box2d_physics.UserData;

public abstract class GameActor extends Actor {

    protected Body body;
    protected UserData userData;

    public GameActor(Body body){
        this.body = body;
        this.userData = (UserData) body.getUserData();
    }

    public abstract UserData getUserData();

    public Body getBody(){
        return body;
    }
}
