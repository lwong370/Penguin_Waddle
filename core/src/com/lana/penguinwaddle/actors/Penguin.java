package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.lana.penguinwaddle.box2d_physics.PenguinUserData;
import com.lana.penguinwaddle.box2d_physics.UserData;
import com.lana.penguinwaddle.utils.Constants;

public class Penguin extends GameActor {

    private boolean hopping;

    public Penguin(Body body) {
        super(body);
    }

    @Override
    public PenguinUserData getUserData() {
        return (PenguinUserData) userData;
    }

    public void hop(){
        if(!hopping){
            body.applyLinearImpulse(getUserData().getLinearJumpAmount(), body.getWorldCenter(), true);
            hopping = true;
        }
    }

    public void tumble(){
        if(!hopping){
            body.setAngularVelocity(-10f);
        }
    }

    public void land(){
        hopping = false;
    }
}
