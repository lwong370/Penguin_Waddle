package com.lana.penguinwaddle.utils;

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
    public static final Vector2 RUNNER_LINEAR_JUMP_IMPULSE = new Vector2(0, 150f);
    public static final Vector2 RUNNER_LINEAR_STOP_TUMBLE_IMPULSE = new Vector2(-10, 0);

    public static final float OBSTACLE_X = 25f;
    public static final float OBSTACLE_GROUND_Y = 2.5f;
    public static final float OBSTACLE_FLY_Y = 10f;
    public static final float OBSTACLE_HOVER_Y = 10f;
    public static final float OBSTACLE_DENSITY = RUNNER_DENSITY;
    public static final Vector2 OBSTACLE_LINEAR_VELOCITY = new Vector2(-8f, 0);

    public static final String PENGUIN_RUNNING_ASSETS_ID = "penguin_run";
    public static final String PENGUIN_TUMBLE_ASSETS_ID = "penguin_tumble";
    public static final String PENGUIN_HOPPING_ASSETS_ID = "penguin_hop";
    public static final String PENGUIN_STOP_ASSETS_ID = "penguin_stop";
    public static final String OBSTACLE_GROUND_ASSETS_ID = "obstacle_ground";
    public static final String OBSTACLE_FLY_ASSETS_ID = "obstacle_fly";
    public static final String OBSTACLE_HOVER_GENERATE_ASSETS_ID = "obstacle_hover_generate";
    public static final String OBSTACLE_HOVER_REPEAT_ASSETS_ID =  "obstacle_hover_repeat";
    public static final String BUTTON_INFO_ASSET_ID = "info_button";
    public static final String BUTTON_LEADERBOARD_ASSET_ID = "leaderboard_button";
    public static final String BUTTON_MENU_ASSET_ID = "menu_button";
    public static final String BUTTON_PAUSE_ASSET_ID = "pause_button";
    public static final String BUTTON_PLAY_ASSET_ID = "play_button";
    public static final String BUTTON_REPLAY_ASSET_ID = "replay_button";
    public static final String BUTTON_BACK_ASSET_ID = "back_button";


    public static final String[] PENGUIN_RUNNING_ANIMATION_FRAMES = new String[] {"penguin_waddle1", "penguin_waddle2"};
    public static final String[] PENGUIN_TUMBLING_ANIMATION_FRAMES = new String[] {
            "penguin_tumble1", "penguin_tumble2", "penguin_tumble3", "penguin_tumble4"
    };
    public static final String[] SEAGULL_ANIMATION_FRAMES = new String[]{"seagull1", "seagull2"};
    public static final String[] STORM_GENERATE_FRAMES = new String[]{"cloud1", "cloud2", "cloud3"};
    public static final String[] STORM_REPEAT_FRAMES = new String[]{"cloud4", "cloud5"};

    public static final String GAME_BACKGROUND_IMAGE_PATH = "bkgrd.png";
    public static final String WORDLESS_BACKGROUND_IMAGE_PATH = "wordless_bkgrd.png";
    public static final String MENU_BACKGROUND_IMAGE_PATH = "main_menu_bkgrd.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";
    public static final String PENGUIN_ATLAS_PATH = "penguin_sprites.txt";
    public static final String OBSTACLES_ATLAS_PATH = "obstacle_sprites.txt";
    public static final String BUTTON_ATLAS_PATH = "button_sprites.txt";

    public static final String SCORE_PREFERENCE_NAME = "Score Preference";
    public static final String CURRENT_SCORE_KEY = "Current Score";
    public static final String HIGH_SCORE_PREFERENCE_KEY = "High Score";
    public static final String SCORE_FONT = "roboto_bold.ttf";

}
