package com.lana.penguinwaddle.box2d_physics;

import com.badlogic.gdx.math.Vector2;
import com.lana.penguinwaddle.enums.UserDataType;
import com.lana.penguinwaddle.utils.Constants;

public class PenguinUserData extends UserData {

    private Vector2 linearJumpImpulse;
    private Vector2 linearStopTumbleImpulse;

    public PenguinUserData(){
        super();
        userDataType = UserDataType.PENGUIN;
        linearJumpImpulse = Constants.RUNNER_LINEAR_JUMP_IMPULSE;
        linearStopTumbleImpulse = Constants.RUNNER_LINEAR_STOP_TUMBLE_IMPULSE;
    }

    public Vector2 getLinearJumpImpulse() {
        return linearJumpImpulse;
    }

    public void setLinearJumpImpulse(Vector2 linearJumpImpulse) {
        this.linearJumpImpulse = linearJumpImpulse;
    }

    public Vector2 getLinearStopTumbleImpulse() {
        return linearStopTumbleImpulse;
    }
}
