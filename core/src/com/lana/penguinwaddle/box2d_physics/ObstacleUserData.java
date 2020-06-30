package com.lana.penguinwaddle.box2d_physics;

import com.badlogic.gdx.math.Vector2;
import com.lana.penguinwaddle.enums.UserDataType;
import com.lana.penguinwaddle.utils.Constants;

public class ObstacleUserData extends UserData {
    private Vector2 linearVelocity;
    private String animationAssetId;

    public ObstacleUserData(float width, float height, String animationAssetId) {
        super(width, height);
        userDataType = UserDataType.OBSTACLE;
        this.animationAssetId = animationAssetId;
        linearVelocity = Constants.OBSTACLE_LINEAR_VELOCITY;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public String getAnimationAssetId() {
        return animationAssetId;
    }

    public void setAnimationAssetId(String animationAssetId) {
        this.animationAssetId = animationAssetId;
    }
}
