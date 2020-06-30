package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Timer;
import com.lana.penguinwaddle.box2d_physics.PenguinUserData;
import com.lana.penguinwaddle.utils.Constants;

public class Penguin extends GameActor {

    private boolean hopping;
    private boolean tumbling;
    private boolean correcting;
    private boolean hit;

    public Penguin(Body body) {
        super(body);
    }

    @Override
    public PenguinUserData getUserData() {
        return (PenguinUserData) userData;
    }

    public void hop(){
        System.out.println("Check if tumbl before hop:" + tumbling);
        if(!hopping && !tumbling && !correcting){
            hopping = true;
            body.applyLinearImpulse(getUserData().getLinearJumpImpulse(), body.getWorldCenter(), true);
        }
    }

    public void tumble(){
        if(!hopping && !tumbling && !correcting){
            tumbling = true;
//            body.setAngularVelocity(-10f);
            body.setTransform(getUserData().getDodgePosition(), (float) (-90f * (Math.PI / 180f)));
        }
    }

    public void stopTumbling(){
        tumbling = false;
        body.setTransform(getUserData().getRunningPosition(), 0f);
    }

    public void land(){
        hopping = false;
    }

    public void stopCorrecting(){
        correcting = false;
    }

    public boolean isHopping(){
        return hopping;
    }

    public boolean isTumbling(){
        return tumbling;
    }

    public boolean isCorrecting(){
        return correcting;
    }

    public boolean isHit(){
        return hit;
    }

    public void hit(){
        hit = true;
    }

}
