package com.lana.penguinwaddle.box2d_physics;

import com.lana.penguinwaddle.enums.UserDataType;

/**
 * UserData used to store information needed by Box2D bodies for movement.
 * UserData basically attaches libGDX actors to Box2D body.
 * Parent class for all other userdata classes to extend from.
 * @author Lana
 */
public class UserData {

    protected UserDataType userDataType;
    private float width;
    private float height;

    public UserData(){

    }

    public UserData(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public UserDataType getUserDataType(){
        return userDataType;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
