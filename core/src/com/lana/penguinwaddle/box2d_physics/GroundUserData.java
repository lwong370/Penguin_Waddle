package com.lana.penguinwaddle.box2d_physics;

import com.lana.penguinwaddle.enums.UserDataType;

public class GroundUserData extends UserData {
    public GroundUserData(){
        super();
        userDataType = UserDataType.GROUND;
    }

    @Override
    public UserDataType getUserDataType() {
        return super.getUserDataType();
    }
}
