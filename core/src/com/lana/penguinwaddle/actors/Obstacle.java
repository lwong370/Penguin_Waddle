package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.lana.penguinwaddle.box2d_physics.ObstacleUserData;
import com.lana.penguinwaddle.enums.Difficulty;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class Obstacle extends GameActor {

    private Animation animation;
    private TextureRegion textureRegion;
    private float stateTime;

    public Obstacle(Body body) {
        super(body);
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

        //For animation
        if(GameManager.getInstance().getGameState() == GameState.PLAY){
            stateTime += Gdx.graphics.getDeltaTime();
        }

        if (getUserData().getAssetId().equals(Constants.OBSTACLE_GROUND_ASSETS_ID)) {
            batch.draw((TextureRegion) AssetsManager.getAnimation(Constants.OBSTACLE_GROUND_ASSETS_ID).getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
                    rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
        } else if(getUserData().getAssetId().equals(Constants.OBSTACLE_FLY_ASSETS_ID)){
            batch.draw((TextureRegion) AssetsManager.getAnimation(Constants.OBSTACLE_FLY_ASSETS_ID).getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
                    rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
        }else if(getUserData().getAssetId().equals(Constants.OBSTACLE_CLOUD_ASSETS_ID)){
            batch.draw((TextureRegion) AssetsManager.getAnimation(Constants.OBSTACLE_CLOUD_ASSETS_ID).getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
                    rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
            if(getUserData().isStormRaining()){
                batch.draw((TextureRegion) AssetsManager.getAnimation(Constants.OBSTACLE_RAIN_ASSETS_ID).getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.03f)),
                        rectangleRendered.y-100, rectangleRendered.width * 1.08f, rectangleRendered.height * 1.3f);
                System.out.println("is rainingg");
            }else{
                System.out.println("is not raining");
            }
        }
    }

    public void changeDifficulty(Difficulty newDifficulty){
        getUserData().setLinearVelocity(newDifficulty.getObstacleLinearVelocity());
    }
}
