package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class ScoreboardButton extends GameButton {

    public interface ScoreboardButtonListener {
        public void toScoreboard();
    }

    private ScoreboardButtonListener listener;

    public ScoreboardButton(Rectangle bounds, ScoreboardButtonListener listener) {
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
        listener.toScoreboard();
    }

    @Override
    protected String getRegionName() {
        return Constants.BUTTON_SCOREBOARD_ASSET_ID;
    }
}
