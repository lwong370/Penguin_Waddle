package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class ToMenuButton extends GameButton {

    public interface ToMainMenuListener{
        public void toMenu();
    }

    private ToMainMenuListener listener;

    public ToMenuButton(Rectangle bounds, ToMainMenuListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(GameManager.getInstance().getGameState() != GameState.GAME_OVER){
            remove();
        }
    }

    @Override
    public void touched() {
        listener.toMenu();
    }

    @Override
    protected String getRegionName() {
        return Constants.BUTTON_MENU_ASSET_ID;
    }
}
