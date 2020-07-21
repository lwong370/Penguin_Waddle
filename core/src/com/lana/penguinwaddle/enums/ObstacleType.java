package com.lana.penguinwaddle.enums;

import com.lana.penguinwaddle.utils.Constants;

public enum ObstacleType {
    GROUND(2f, 1f, Constants.OBSTACLE_X, Constants.OBSTACLE_GROUND_Y, Constants.OBSTACLE_DENSITY, Constants.OBSTACLE_GROUND_ASSETS_ID),
    FLY(4f, 3f, Constants.OBSTACLE_X, Constants.OBSTACLE_FLY_Y, Constants.OBSTACLE_DENSITY, Constants.OBSTACLE_FLY_ASSETS_ID),
    HOVER(3f, 2f, Constants.OBSTACLE_X, Constants.OBSTACLE_HOVER_Y, Constants.OBSTACLE_DENSITY, Constants.OBSTACLE_HOVER_GENERATE_ASSETS_ID);

    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String animationAssetId;

    ObstacleType(float width, float height, float x, float y, float density, String animationAssetId) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
        this.animationAssetId = animationAssetId;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getDensity() {
        return density;
    }

    public String getAnimationAssetId() {
        return animationAssetId;
    }
}

