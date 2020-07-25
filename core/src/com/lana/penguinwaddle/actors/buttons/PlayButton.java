package com.lana.penguinwaddle.actors.buttons;

import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.utils.GameManager;


public class PlayButton extends GameButton {

    public interface PlayButtonListener {
        public void onPlay();
    }

    private PlayButtonListener listener;

    public PlayButton(Rectangle bounds, PlayButtonListener listener) {
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
        listener.onPlay();
    }

    @Override
    protected String getRegionName() {
        return Constants.PENGUIN_HOPPING_ASSETS_ID;
    }
}
