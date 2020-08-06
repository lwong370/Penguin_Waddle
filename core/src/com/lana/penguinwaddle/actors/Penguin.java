package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.lana.penguinwaddle.box2d_physics.PenguinUserData;
import com.lana.penguinwaddle.enums.Difficulty;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class Penguin extends GameActor {

    private boolean hopping;
    private boolean tumbling;
    private boolean hit;
    private boolean frightStopped;

    private Animation waddleAnimation;
    private TextureRegion hoppingTexture;
    private TextureRegion dodgingTexture;

    private Animation runningAnimation;
    private Animation tumbleAnimation;

    private float stateTime;

    public Penguin(Body body) {
        super(body);
        stateTime = 0f;

        runningAnimation = AssetsManager.getAnimation(Constants.PENGUIN_RUNNING_ASSETS_ID);
        tumbleAnimation = AssetsManager.getAnimation(Constants.PENGUIN_TUMBLE_ASSETS_ID);
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

        //For animation
        if(GameManager.getInstance().getGameState() == GameState.PLAY){
            stateTime += Gdx.graphics.getDeltaTime();
        }

        if(hopping){
            batch.draw(AssetsManager.getTextureRegion(Constants.PENGUIN_HOPPING_ASSETS_ID), x, y, width, rectangleRendered.height);
        } else if (tumbling) {
            batch.draw((TextureRegion) tumbleAnimation.getKeyFrame(stateTime, true), x, y, width, rectangleRendered.height);
        }else if(frightStopped){
            batch.draw(AssetsManager.getTextureRegion(Constants.PENGUIN_STOP_ASSETS_ID), x, y, width, rectangleRendered.height);
        } else {
            batch.draw((TextureRegion) runningAnimation.getKeyFrame(stateTime, true), x, y, width, rectangleRendered.height);
        }
    }

    public void hop(){
        if(!hopping && !tumbling && !frightStopped){
            hopping = true;
            body.applyLinearImpulse(getUserData().getLinearJumpImpulse(), body.getWorldCenter(), true);
        }
    }

    public void land(){
        hopping = false;
    }

    public void tumble(){
        if(!hopping && !tumbling && !frightStopped){
            tumbling = true;
            body.setTransform(getUserData().getDodgePosition(), (float) (-90f * (Math.PI / 180f)));
        }
    }

    public void stopTumbling(){
        tumbling = false;
        body.setTransform(getUserData().getRunningPosition(), 0f);
    }

    public void frightStop(){
        if(!hopping && !tumbling && !frightStopped){
            frightStopped = true;
        }
    }

    public void undoFrightStop(){
        frightStopped = false;
    }

    public void hit(){
        hit = true;
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

    public boolean isFrightStopped(){
        return frightStopped;
    }

    public void changeDifficulty(Difficulty newDifficulty){
        body.setGravityScale(newDifficulty.getRunnerGravityScale());
        getUserData().setLinearJumpImpulse(newDifficulty.getRunnerJumpingLinearImpulse());
    }
}
