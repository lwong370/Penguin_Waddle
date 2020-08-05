package com.lana.penguinwaddle.box2d_physics;

import com.badlogic.gdx.math.Vector2;
import com.lana.penguinwaddle.enums.UserDataType;
import com.lana.penguinwaddle.utils.Constants;

public class PenguinUserData extends UserData {

    private final Vector2 runningPosition = new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y);
    private final Vector2 dodgePosition = new Vector2(Constants.RUNNER_DODGE_X, Constants.RUNNER_DODGE_Y);

    private Vector2 linearJumpImpulse;
    private Vector2 linearStopTumbleImpulse;

    public PenguinUserData(){
        super();
        userDataType = UserDataType.PENGUIN;
        linearJumpImpulse = Constants.RUNNER_LINEAR_JUMP_IMPULSE;
        linearStopTumbleImpulse = Constants.RUNNER_LINEAR_STOP_TUMBLE_IMPULSE;
    }

    public PenguinUserData(float width, float height){
        super(width, height);
        userDataType = UserDataType.PENGUIN;
        linearJumpImpulse = Constants.RUNNER_LINEAR_JUMP_IMPULSE;
        linearStopTumbleImpulse = Constants.RUNNER_LINEAR_STOP_TUMBLE_IMPULSE;
    }

    public Vector2 getLinearJumpImpulse() {
        return linearJumpImpulse;
    }

    public Vector2 getRunningPosition(){
        return runningPosition;
    }

    public Vector2 getDodgePosition(){
        return dodgePosition;
    }

    public float getDodgeAngle(){
        return (float) (-90f * (Math.PI / 180f));
    }

    public void setLinearJumpImpulse(Vector2 linearJumpImpulse){
        this.linearJumpImpulse = linearJumpImpulse;
    }
}
