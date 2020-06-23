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

    public Penguin(Body body) {
        super(body);
    }

    @Override
    public PenguinUserData getUserData() {
        return (PenguinUserData) userData;
    }

    public void hop(){
        System.out.println("Check if tumbl before hop:" + tumbling);
        if(!hopping && !tumbling){
            hopping = true;
            body.applyLinearImpulse(getUserData().getLinearJumpImpulse(), body.getWorldCenter(), true);
        }
    }

    public void tumble(){
        if(!hopping && !tumbling){
            tumbling = true;
            body.setAngularVelocity(-10f);
        }
    }

    public void correctAfterTumble(){
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                body.setAngularVelocity(0);
                body.setTransform(new Vector2(body.getPosition().x, body.getPosition().y), 0f);
            }
        }, 1f);
        if(body.getPosition().x > Constants.RUNNER_X){
            body.setLinearVelocity(-2, 0);
        }
        stopTumbling();
    }

    public void stopTumbling(){
        tumbling = false;
    }

    public void land(){
        hopping = false;
    }

    public boolean isHopping(){
        return hopping;
    }

    public boolean isTumbling(){
        return tumbling;
    }
}
