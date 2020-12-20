package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.lana.penguinwaddle.box2d_physics.GroundUserData;
import com.lana.penguinwaddle.box2d_physics.ObstacleUserData;
import com.lana.penguinwaddle.box2d_physics.PenguinUserData;
import com.lana.penguinwaddle.enums.ObstacleType;

/**
 * Holds methods that set up shape, Box2D body, and userdata for world and penguin.
 * @author Lana
 */
public class WorldUtils {
    public static World createWorld(){
        return new World(Constants.GRAVITY, true);
    }

    /**
     * Sets up ground shape, body, and userdata.
     * @param world
     * @return
     */
    public static Body createGround(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(0f,0f));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.GROUND_WIDTH + Constants.GROUND_WIDTH, Constants.GROUND_HEIGHT/2);
        body.createFixture(shape, Constants.GROUND_DENSITY);
        body.setUserData(new GroundUserData(Constants.GROUND_WIDTH, Constants.GROUND_HEIGHT));
        shape.dispose();
        return body;
    }

    /**
     * Sets up penguin shape body and userdata.
     * @param world
     * @return
     */
    public static Body createPenguin(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.RUNNER_WIDTH/2, Constants.RUNNER_HEIGHT/2);
        body.setGravityScale(Constants.RUNNER_GRAVITY_SCALE);
        body.createFixture(shape, Constants.RUNNER_DENSITY);
        body.setUserData(new PenguinUserData(Constants.RUNNER_WIDTH, Constants.RUNNER_HEIGHT));
        body.resetMassData();
        shape.dispose();
        return body;
    }

    /**
     * Sets up obstacle shape body and userdata.
     * @param world
     * @return
     */
    public static Body createObstacle(World world){
        ObstacleType obstacleType = RandomUtils.getRandomObstacleType();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(new Vector2(obstacleType.getX(), obstacleType.getY()));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(obstacleType.getWidth()/4, obstacleType.getHeight()/4);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, obstacleType.getDensity());
        body.resetMassData();
        body.setUserData(new ObstacleUserData(obstacleType.getWidth(), obstacleType.getHeight(), obstacleType.getAnimationAssetId()));
        shape.dispose();
        return body;
    }
}
