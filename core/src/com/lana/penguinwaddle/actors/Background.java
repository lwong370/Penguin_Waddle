package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lana.penguinwaddle.utils.Constants;

/**
 * Background actor
 * @author Lana
 */
public class Background extends Actor {
    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds1;
    private Rectangle textureRegionBounds2;
    private int speed = 100;

    private boolean stop;

    /**
     * Constructs a new background actor.
     * Aligns two background texture regions next to each other.
     * Initial position has the left background texture region fill the whole screen frame.
     * This set-up allows for scrolling/moving the background for running effect.
     * @param path Path to the background image.
     */
    public Background(String path) {
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(path)));
        textureRegionBounds1 = new Rectangle(0, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        textureRegionBounds2 = new Rectangle(Constants.APP_WIDTH, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
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
        batch.draw(textureRegion, textureRegionBounds1.x, textureRegionBounds1.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(textureRegion, textureRegionBounds2.x, textureRegionBounds2.y, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
    }

    /**
     * Checks whether the second background texture region has reached the left end of the screen.
     * @param delta Amount of time (in seconds) the last frame took to be rendered.
     * @return true if second texture region reaches left end of screen.
     */
    public boolean reachedLeftBound(float delta){
        return (textureRegionBounds2.x - (delta * speed)) <= 0;
    }

    /**
     * Slides the background from right to left to give a running effect.
     * @param delta
     * @param stopped Checks if background should stop moving. EX: When the penguin stops, background should stop too.
     */
    public void updateXBounds(float delta, boolean stopped){
        if(!stopped){
            textureRegionBounds1.x += delta * speed;
            textureRegionBounds2.x += delta * speed;
        }else{
            textureRegionBounds1.x = textureRegionBounds1.x;
            textureRegionBounds2.x = textureRegionBounds2.x;
        }
    }

    public void setStop(boolean isStopped){
        stop = isStopped;
    }

    /**
     * Sets background texture regions to the original position.
     */
    public void resetBounds(){
        textureRegionBounds1 = textureRegionBounds2;
        textureRegionBounds2 = new Rectangle(Constants.APP_WIDTH, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
    }
}
