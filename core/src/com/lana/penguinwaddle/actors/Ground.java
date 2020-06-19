package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.lana.penguinwaddle.box2d_physics.GroundUserData;

public class Ground extends GameActor {

    public Ground(Body body) {
        super(body);
    }

    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }
}