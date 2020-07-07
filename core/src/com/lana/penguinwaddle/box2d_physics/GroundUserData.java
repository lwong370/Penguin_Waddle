package com.lana.penguinwaddle.box2d_physics;

import com.lana.penguinwaddle.enums.UserDataType;

public class GroundUserData extends UserData {
    public GroundUserData(float width, float height){
        super(width, height);
        userDataType = UserDataType.GROUND;
    }
}
