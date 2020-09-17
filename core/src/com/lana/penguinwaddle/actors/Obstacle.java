package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.lana.penguinwaddle.box2d_physics.ObstacleUserData;
import com.lana.penguinwaddle.enums.Difficulty;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class Obstacle extends GameActor {

    private float stateTime;
    private boolean isStormRaining;

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

        switch (getUserData().getAssetId()){
            case Constants.OBSTACLE_GROUND_ASSETS_ID:
                batch.draw((TextureRegion) AssetsManager.getAnimation(Constants.OBSTACLE_GROUND_ASSETS_ID).getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
                        rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
                break;
            case Constants.OBSTACLE_FLY_ASSETS_ID:
                batch.draw((TextureRegion) AssetsManager.getAnimation(Constants.OBSTACLE_FLY_ASSETS_ID).getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
                        rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
                break;
            case Constants.OBSTACLE_CLOUD_ASSETS_ID:
                drawCloud(batch);
                if(isStormRaining()){
                    batch.draw((TextureRegion) AssetsManager.getAnimation(Constants.OBSTACLE_RAIN_ASSETS_ID).getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.05f)),
                            rectangleRendered.y-208, rectangleRendered.width * 1.08f, rectangleRendered.height * 2.7f);
                    drawCloud(batch);

                    //Add rain fixture for collision detection
                    if(GameManager.getInstance().getGameState() == GameState.PLAY){
                        PolygonShape shape = new PolygonShape();
                        shape.setAsBox(6/2, 12/2);
                        body.createFixture(shape, Constants.OBSTACLE_DENSITY);
                    }
                }else{
                    for(Fixture fixture: body.getFixtureList()){
                        body.destroyFixture(fixture);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void changeDifficulty(Difficulty newDifficulty){
        getUserData().setLinearVelocity(newDifficulty.getObstacleLinearVelocity());
    }

    private void drawCloud(Batch batch){
        batch.draw((TextureRegion) AssetsManager.getAnimation(Constants.OBSTACLE_CLOUD_ASSETS_ID).getKeyFrame(stateTime, true), (rectangleRendered.x - (rectangleRendered.width * 0.1f)),
                rectangleRendered.y, rectangleRendered.width * 1.2f, rectangleRendered.height * 1.1f);
    }

    public boolean isStormRaining() {
        return isStormRaining;
    }

    public void setStormRaining(boolean isStormRaining){
        this.isStormRaining = isStormRaining;
    }
}
