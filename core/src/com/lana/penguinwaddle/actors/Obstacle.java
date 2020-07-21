package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.lana.penguinwaddle.box2d_physics.ObstacleUserData;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.Constants;

public class Obstacle extends GameActor {

    private Animation animation;
    private TextureRegion textureRegion;
    private float stateTime;

    public Obstacle(Body body) {
        super(body);
//        textureRegion = AssetsManager.getTextureRegion(getUserData().getAssetId());
//        animation = AssetsManager.getAnimation(getUserData().getAssetId());
        stateTime = 0f;
    }

    @Override
    public ObstacleUserData getUserData() {
        return (ObstacleUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float x = rectangleRendered.x - (rectangleRendered.width * 0.1f);
        float y = rectangleRendered.y;
        float width = rectangleRendered.width * 1.2f;
        if (getUserData().getAssetId().equals(Constants.OBSTACLE_GROUND_ASSETS_ID)) {
            batch.draw(AssetsManager.getTextureRegion(Constants.OBSTACLE_GROUND_ASSETS_ID), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
                    rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
        } else {
//        if(getUserData().getAssetId().equals(Constants.OBSTACLE_GROUND_ASSETS_ID)){
            batch.draw(AssetsManager.getTextureRegion(Constants.OBSTACLE_FLY_ASSETS_ID), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
                    rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
//        }else{
//            stateTime += Gdx.graphics.getDeltaTime();
//            batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
//                    rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
        }
    }
}
