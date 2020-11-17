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
    public static final float RUNNER_WIDTH = 2.9f;
    public static final float RUNNER_HEIGHT = 4.35f;
    public static final float RUNNER_DENSITY = 0.5f;

    public static float RUNNER_GRAVITY_SCALE = 2.75f;
    public static final Vector2 RUNNER_LINEAR_JUMP_IMPULSE = new Vector2(0, 106f);

    public static final float OBSTACLE_X = 23f;
    public static final float OBSTACLE_GROUND_Y = 2.5f;
    public static final float OBSTACLE_FLY_Y = 7f;
    public static final float OBSTACLE_HOVER_Y = 10f;
    public static final float OBSTACLE_DENSITY = RUNNER_DENSITY;
    public static final Vector2 OBSTACLE_LINEAR_VELOCITY = new Vector2(-9f, 0);

    public static final String PENGUIN_RUNNING_ASSETS_ID = "penguin_run";
    public static final String PENGUIN_TUMBLE_ASSETS_ID = "penguin_tumble";
    public static final String PENGUIN_HOPPING_ASSETS_ID = "penguin_hop";
    public static final String PENGUIN_STOP_ASSETS_ID = "penguin_stop";
    public static final String OBSTACLE_GROUND_ASSETS_ID = "obstacle_ground";
    public static final String OBSTACLE_FLY_ASSETS_ID = "obstacle_fly";
    public static final String OBSTACLE_CLOUD_ASSETS_ID =  "obstacle_cloud_repeat";
    public static final String OBSTACLE_RAIN_ASSETS_ID = "obstacle_rain";
    public static final String OBSTACLE_GROUND2_ASSETS_ID = "obstacle_seal";

    public static final String BUTTON_INFO_ASSET_ID = "info_button";
    public static final String BUTTON_SCOREBOARD_ASSET_ID = "scoreboard_button";
    public static final String BUTTON_MENU_ASSET_ID = "menu_button";
    public static final String BUTTON_PAUSE_ASSET_ID = "pause_button";
    public static final String BUTTON_PLAY_ASSET_ID = "play_button";
    public static final String BUTTON_REPLAY_ASSET_ID = "replay_button";
    public static final String BUTTON_BACK_ASSET_ID = "back_button";
    public static final String BUTTON_INSTRUCT_ID = "instructions_button";
    public static final String LABEL_MENU_TITLE_ID = "menu_label";
    public static final String LABEL_GAME_OVER_ID = "game_over_label";
    public static final String INSTRUCT_ROLL = "instructions_roll";
    public static final String INSTRUCT_JUMP = "instructions_jump";
    public static final String INSTRUCT_EVADE = "instructions_evade";

    public static final String[] PENGUIN_RUNNING_ANIMATION_FRAMES = new String[] {"penguin_waddle1", "penguin_waddle2"};
    public static final String[] PENGUIN_TUMBLING_ANIMATION_FRAMES = new String[] {
            "penguin_tumble1", "penguin_tumble2", "penguin_tumble3", "penguin_tumble4"};
    public static final String[] SEAGULL_ANIMATION_FRAMES = new String[]{"seagull1", "seagull2"};
    public static final String[] SNOWBALL_ANIMATION_FRAMES = new String[]{"snowball1", "snowball2", "snowball3", "snowball4"};
    public static final String[] CLOUD_FRAMES = new String[]{"cloud1", "cloud2"};
    public static final String[] RAIN_FRAMES = new String[]{"rain1", "rain2"};
    public static final String[] SEAL_FRAMES = new String[]{"seal3", "seal2", "seal1", "seal2"};

    public static final String GAME_BACKGROUND_IMAGE_PATH = "bkgrd.png";
    public static final String WORDLESS_BACKGROUND_IMAGE_PATH = "wordless_bkgrd.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";
    public static final String PENGUIN_ATLAS_PATH = "penguin_sprites.txt";
    public static final String OBSTACLES_ATLAS_PATH = "obstacle_sprites.txt";
    public static final String BUTTON_LABEL_ATLAS_PATH = "button_and_label_sprites.txt";

    public static final String PREFERENCE_NAME = "Preference";
    public static final String CURRENT_SCORE_KEY = "Current Score";
    public static final String RANK_KEY_1 = "Rank1";
    public static final String RANK_KEY_2 = "Rank2";
    public static final String RANK_KEY_3 = "Rank3";
    public static final String RANK_KEY_4 = "Rank4";
    public static final String RANK_KEY_5 = "Rank5";

    public static final String INFO_HEADER = "About the Developer & Credits";
    public static final String GDX_CREDIT = "Powered by: libGDX";
    public static final String ZAPSPLAT_CREDIT = "Sound Effects: https://www.zapsplat.com";
    public static final String BENSOUND_CREDIT = "Music: www.bensound.com";
    public static final String ABOUT_TEXT = "\n\nHello! My name is Lana, an engineering student and art enthusiast who craves a lot of dark chocolate and boba. " +
            "I've always wanted to develop my own mobile game, and I finally mustered my coding knowledge and art skills to create my first app! " +
            "Thank you for your support! \n";
}
