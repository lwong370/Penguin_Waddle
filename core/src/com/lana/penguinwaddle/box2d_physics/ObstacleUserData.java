package com.lana.penguinwaddle.box2d_physics;

import com.badlogic.gdx.math.Vector2;
import com.lana.penguinwaddle.enums.UserDataType;
import com.lana.penguinwaddle.utils.Constants;

public class ObstacleUserData extends UserData {
    private Vector2 linearVelocity;
    private String assetId;

    public ObstacleUserData(float width, float height, String assetId) {
        super(width, height);
        userDataType = UserDataType.OBSTACLE;
        this.assetId = assetId;
        linearVelocity = Constants.OBSTACLE_LINEAR_VELOCITY;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
