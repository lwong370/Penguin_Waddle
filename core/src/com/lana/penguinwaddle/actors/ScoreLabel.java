package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;
import com.lana.penguinwaddle.utils.PreferencesManager;

public class ScoreLabel extends Actor {
    private Integer score;
    private Rectangle bounds;
    private BitmapFont font;

    public ScoreLabel(Rectangle bounds) {
        this.score = PreferencesManager.getInstance().readFromPreferences(Constants.CURRENT_SCORE_KEY);
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManager.getInstance().getSkin().getFont("Subsciber-aXdK");
        font.getData().setScale(((float) 1.15));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(GameManager.getInstance().getGameState() != GameState.GAME_OVER){
            remove();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, "Score: " + score, bounds.x, bounds.y, bounds.width, Align.center, true);
    }

}
