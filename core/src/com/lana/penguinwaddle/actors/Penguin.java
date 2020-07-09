package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Timer;
import com.lana.penguinwaddle.box2d_physics.PenguinUserData;
import com.lana.penguinwaddle.utils.Constants;

public class Penguin extends GameActor {

    private boolean hopping;
    private boolean tumbling;
    private boolean hit;

    private TextureRegion testRegion;

    public Penguin(Body body) {
        super(body);
        testRegion = new TextureRegion(new Texture(Gdx.files.internal(Constants.PENGUIN_NEUTRAL_STANCE_PATH)));
    }

    @Override
    public PenguinUserData getUserData() {
        return (PenguinUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float x = rectangleRendered.x - (rectangleRendered.width * 0.1f);
        float y = rectangleRendered.y;
        float width = rectangleRendered.width * 1.2f;

        batch.draw(testRegion, x, y, width, rectangleRendered.height);
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


    public boolean isHopping(){
        return hopping;
    }

    public boolean isTumbling(){
        return tumbling;
    }

    public boolean isHit(){
        return hit;
    }

    public void hit(){
        hit = true;
    }
}
