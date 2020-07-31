package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.utils.Constants;

public class BackButton extends GameButton {

    public interface BackButtonListener{
        public void back();
    }

    private BackButtonListener listener;

    public BackButton(Rectangle bounds, BackButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void touched() {
        listener.back();
    }

    @Override
    protected String getRegionName() {
        return Constants.BUTTON_BACK_ASSET_ID;
    }
}
