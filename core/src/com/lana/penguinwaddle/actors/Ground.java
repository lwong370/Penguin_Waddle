package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.lana.penguinwaddle.box2d_physics.GroundUserData;
import com.lana.penguinwaddle.utils.Constants;

public class Ground extends GameActor {

    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds1;
    private Rectangle textureRegionBounds2;
    private int speed = 10;

    private boolean stop;

    public Ground(Body body) {
        super(body);
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Constants.GROUND_IMAGE_PATH)));
        textureRegionBounds1 = new Rectangle(0 - getUserData().getWidth()/2, 0, getUserData().getWidth(), getUserData().getHeight());
        textureRegionBounds2 = new Rectangle(getUserData().getWidth()/2, 0, getUserData().getWidth(), getUserData().getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(reachedLeftBound(delta)){
            resetBounds();
        }else{
            updateXBounds(-delta, stop);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, textureRegionBounds1.x, rectangleRendered.y, rectangleRendered.width,
                rectangleRendered.height);
        batch.draw(textureRegion, textureRegionBounds2.x, rectangleRendered.y, rectangleRendered.width,
                rectangleRendered.height);
    }

    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }

    private boolean reachedLeftBound(float delta){
        return (textureRegionBounds2.x - transformToPixels(delta * speed)) <= 0;
    }

    private void updateXBounds(float delta, boolean stopped){
        if(!stopped){
            textureRegionBounds1.x += transformToPixels(delta * speed);
            textureRegionBounds2.x += transformToPixels(delta *speed);
        }else{
            textureRegionBounds1.x = textureRegionBounds1.x;
            textureRegionBounds2.y = textureRegionBounds2.y;
        }
    }

    public void setStop(boolean isStopped){
        stop = isStopped;
    }

    private void resetBounds(){
        textureRegionBounds1 = textureRegionBounds2;
        textureRegionBounds2 = new Rectangle(textureRegionBounds1.x + rectangleRendered.width, 0, rectangleRendered.width, rectangleRendered.height);
    }
}