package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class ReplayButton extends GameButton {
    public interface ReplayButtonListener{
        public void onReplay();
    }

    private ReplayButtonListener listener;

    public ReplayButton(Rectangle bounds, ReplayButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(GameManager.getInstance().getGameState() != GameState.MENU){
            remove();
        }
    }

    @Override
    public void touched() {
        listener.onReplay();
    }

    @Override
    protected String getRegionName() {
        return Constants.BUTTON_REPLAY_ASSET_ID;
    }
}
