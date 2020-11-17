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

    public static boolean bodyIsObstacle(Body body){
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.OBSTACLE;
    }

    public static boolean bodyInBounds(Body body) {
        UserData userData = (UserData) body.getUserData();
        switch (userData.getUserDataType()) {
            case PENGUIN:
            case OBSTACLE:
                return body.getPosition().x + userData.getWidth() / 2 > 0;
        }
        return true;
    }
}
