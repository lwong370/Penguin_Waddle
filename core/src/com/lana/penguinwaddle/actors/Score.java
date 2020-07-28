package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class Score extends Actor {
    private float score;
    private Rectangle bounds;
    private int multiplier;
    private BitmapFont font;

    public Score(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        score = 0;
        multiplier = 2;

        //Font
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.SCORE_FONT));
        font = generator.generateFont(new FreeTypeFontGenerator.FreeTypeFontParameter());
        font.setColor(.21f, .22f, .21f, 1f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(GameManager.getInstance().getGameState() != GameState.PLAY){
            return;
        }
        score += delta * multiplier;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(getScore() == 0){
            return;
        }
        font.draw(batch,String.format("%d", getScore()), bounds.x, bounds.y, bounds.width, Align.right, true);
    }

    public int getScore(){
        return (int) score;
    }
}
