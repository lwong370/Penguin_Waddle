package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 410;
    public static final float WORLD_TO_SCREEN = 32;

    public static final Vector2 GRAVITY = new Vector2(0, -10);

    public static final float GROUND_WIDTH = 65f;
    public static final float GROUND_HEIGHT = 4f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_X = 3f;
    public static final float RUNNER_Y = GROUND_HEIGHT;
    public static final float RUNNER_DODGE_X = 3;
    public static final float RUNNER_DODGE_Y = 3.4f;
    public static final float RUNNER_WIDTH = 3.5f;
    public static final float RUNNER_HEIGHT = 5.25f;
    public static final float RUNNER_DENSITY = 0.5f;

    public static float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_LINEAR_JUMP_IMPULSE = new Vector2(0, 130f);
    public static final Vector2 RUNNER_LINEAR_STOP_TUMBLE_IMPULSE = new Vector2(-10, 0);

    public static final float OBSTACLE_X = 25f;
    public static final float OBSTACLE_WATER_Y = 2f;
    public static final float OBSTACLE_BIRD_Y = 4f;
    public static final float OBSTACLE_STORM_Y = 5f;
    public static final float OBSTACLE_DENSITY = RUNNER_DENSITY;
    public static final Vector2 OBSTACLE_LINEAR_VELOCITY = new Vector2(-8f, 0);

    public static final String PENGUIN_RUNNING_ASSETS_ID = "penguin_run";
    public static final String PENGUIN_TUMBLE_ASSETS_ID = "penguin_tumble";
    public static final String PENGUIN_HOPPING_ASSETS_ID = "penguin_hop";
    public static final String PENGUIN_STOP_ASSETS_ID = "penguin_stop";
    public static final String OBSTACLE_GROUND_ASSETS_ID = "obstacle_ground";
    public static final String OBSTACLE_FLY_ASSETS_ID = "obstacle_fly";
    public static final String OBSTACLE_HOVER_ASSETS_ID = "obstacle_hover";

    public static final String[] PENGUIN_RUNNING_ANIMATION_FRAMES = new String[] {"penguin_waddle1", "penguin_waddle2"};
    public static final String[] PENGUIN_TUMBLING_ANIMATION_FRAMES = new String[] {
            "penguin_tumble1", "penguin_tumble2", "penguin_tumble3", "penguin_tumble4"
    };

    public static final String BACKGROUND_IMAGE_PATH = "bkgrd.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";
    public static final String PENGUIN_NEUTRAL_STANCE_PATH = "penguin.png";
    public static final String PENGUIN_ATLAS_PATH = "penguin_sprites.txt";

}
