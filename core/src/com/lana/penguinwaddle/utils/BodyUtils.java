package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.lana.penguinwaddle.box2d_physics.UserData;
import com.lana.penguinwaddle.enums.UserDataType;

public class BodyUtils {
    public static boolean bodyIsPenguin(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.PENGUIN;
    }

    public static boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }
}
