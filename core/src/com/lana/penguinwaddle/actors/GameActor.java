package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lana.penguinwaddle.box2d_physics.UserData;
import com.lana.penguinwaddle.utils.Constants;

public abstract class GameActor extends Actor {

    protected Body body;
    protected UserData userData;
    protected Rectangle rectangleRendered;

    public GameActor(Body body){
        this.body = body;
        this.userData = (UserData) body.getUserData();
        rectangleRendered = new Rectangle();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(body.getUserData() != null){
            updateRectangle();
        }else{
            remove();
        }
    }

    public abstract UserData getUserData();

    private void updateRectangle(){
        rectangleRendered.x = transformToPixels(body.getPosition().x - userData.getWidth()/2);
        rectangleRendered.y = transformToPixels(body.getPosition().y - userData.getHeight()/2);
        rectangleRendered.width = transformToPixels(userData.getWidth());
        rectangleRendered.height = transformToPixels(userData.getHeight());
    }

    public Body getBody(){
        return body;
    }

    protected float transformToPixels(float n){
        //1 meter = 32 pixels...method transforms meters to pixels
        //Needed b/c Box2D measures in meters
        return Constants.WORLD_TO_SCREEN * n;
    }
}
