package com.lana.penguinwaddle.utils;

import com.badlogic.gdx.input.GestureDetector;

public class DirectionGestureDetector extends GestureDetector {

    public DirectionGestureDetector(DirectionListener listener) {
        super(new DirectionGestureListener(listener));
    }

    public interface DirectionListener {
        void onLeft();
        void onRight();
        void onUp();
        void onDown();
    }

    private static class DirectionGestureListener extends GestureAdapter{
        DirectionListener directionListener;

        public DirectionGestureListener(DirectionListener directionListener) {
            this.directionListener = directionListener;
        }

        @Override
        public boolean pan(float x, float y, float deltaX, float deltaY) {
            if(deltaX > 0){
                directionListener.onLeft();
            } else if(deltaX < 0){
                directionListener.onRight();
            }

            if(deltaY > 0){
                if(Math.abs(deltaX) < 2.5){
                    directionListener.onDown();
                }
            } else if(deltaY < 0){
                if(Math.abs(deltaX) < 2.5){
                    directionListener.onUp();
                }
            }
            return super.pan(x, y, deltaX, deltaY);
        }
    }
}
