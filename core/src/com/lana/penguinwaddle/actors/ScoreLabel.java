package com.lana.penguinwaddle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;
import com.lana.penguinwaddle.utils.ScorePreferencesManager;

public class ScoreLabel extends Actor {
    private Integer score;
    private Rectangle bounds;
    private BitmapFont font;

    //Score label: High score, or just score.
    private ScoreLabelType label;

    public ScoreLabel(Rectangle bounds, ScoreLabelType label) {
        this.score = ScorePreferencesManager.getInstance().readFromPreferences(Constants.CURRENT_SCORE_KEY);
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.SCORE_FONT));
        font = generator.generateFont(new FreeTypeFontGenerator.FreeTypeFontParameter());

        font.setColor(Color.WHITE);
        font.getData().setScale(1.5f);

        this.label = label;
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
        String printedValue = null;
        if(label == ScoreLabelType.HIGH_SCORE){
            printedValue = label.getLabel() + ScorePreferencesManager.getInstance().readFromPreferences(Constants.HIGH_SCORE_PREFERENCE_KEY);
        } else if(label == ScoreLabelType.SCORE){
            printedValue = label.getLabel() + score;
        }
        font.draw(batch, printedValue, bounds.x, bounds.y, bounds.width, Align.center, true);
    }

    public enum ScoreLabelType {
        SCORE ("Score: "),
        HIGH_SCORE("High Score: ");

        private final String label;

        private ScoreLabelType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
