package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.utils.Constants;

public class InstructionsButton extends GameButton {

    public interface InstructionsButtonListener{
        public void onClick();
    }

    private InstructionsButtonListener listener;

    public InstructionsButton(Rectangle bounds, InstructionsButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    public void touched() {
        listener.onClick();
    }

    @Override
    protected String getRegionName() {
        return Constants.BUTTON_INSTRUCT_ID;
    }
}
