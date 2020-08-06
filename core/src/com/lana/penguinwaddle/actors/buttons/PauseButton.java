package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.utils.Constants;

public class PauseButton extends GameButton {

    public interface PauseButtonListener{
        public void onClicked();
    }

    private PauseButtonListener listener;

    public PauseButton(Rectangle bounds, PauseButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void touched() {
        listener.onClicked();
    }

    @Override
    protected String getRegionName() {
        return Constants.BUTTON_PAUSE_ASSET_ID;
    }
}
