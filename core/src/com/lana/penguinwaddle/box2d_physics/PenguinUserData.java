package com.lana.penguinwaddle.box2d_physics;

import com.badlogic.gdx.math.Vector2;
import com.lana.penguinwaddle.enums.UserDataType;
import com.lana.penguinwaddle.utils.Constants;

public class PenguinUserData extends UserData {

    private Vector2 linearJumpAmount;

    public PenguinUserData(){
        super();
        userDataType = UserDataType.PENGUIN;
        linearJumpAmount = Constants.RUNNER_LINEAR_JUMP_AMOUNT;
    }

    public Vector2 getLinearJumpAmount() {
        return linearJumpAmount;
    }

    public void setLinearJumpAmount(Vector2 linearJumpAmount) {
        this.linearJumpAmount = linearJumpAmount;
    }

}
