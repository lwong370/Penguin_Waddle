package com.lana.penguinwaddle.actors.buttons;

import com.badlogic.gdx.math.Rectangle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class InfoButton extends GameButton {
    public interface InfoButtonListener{
        public void onToInfoSreen();
    }

    private InfoButtonListener listener;

    public InfoButton(Rectangle bounds, InfoButtonListener listener) {
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
        listener.onToInfoSreen();
    }

    @Override
    protected String getRegionName() {
        return Constants.BUTTON_INFO_ASSET_ID;
    }
}
