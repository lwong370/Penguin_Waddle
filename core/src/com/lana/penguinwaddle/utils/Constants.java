package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final int APP_WIDTH = Gdx.graphics.getWidth();
    public static final int APP_HEIGHT = Gdx.graphics.getHeight();

    public static final Vector2 GRAVITY = new Vector2(0, -10);

    public static final float GROUND_WIDTH = 65f;
    public static final float GROUND_HEIGHT = 3f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_WIDTH = 1.75f;
    public static final float RUNNER_HEIGHT = 2.5f;
    public static final float RUNNER_DENSITY = 0.5f;
    public static final float RUNNER_X = 3;
    public static final float RUNNER_Y = GROUND_HEIGHT;
    public static final float RUNNER_DODGE_X = 3;
    public static final float RUNNER_DODGE_Y = 2.4f;


    public static float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_LINEAR_JUMP_IMPULSE = new Vector2(0, 25f);
    public static final Vector2 RUNNER_LINEAR_STOP_TUMBLE_IMPULSE = new Vector2(-10, 0);
}
