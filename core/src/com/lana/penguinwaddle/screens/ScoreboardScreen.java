package com.lana.penguinwaddle.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.stages.ScoreboardStage;
import com.lana.penguinwaddle.utils.GameManager;

public class ScoreboardScreen implements Screen {

    private PenguinWaddle game;
    private ScoreboardStage scoreboardStage;

    public ScoreboardScreen(PenguinWaddle game) {
        this.game = game;
        scoreboardStage = new ScoreboardStage();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(scoreboardStage);
    }

    @Override
    public void render(float delta) {
        scoreboardStage.draw();

        if(GameManager.getInstance().getGameState() == GameState.MENU){
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        scoreboardStage.dispose();
    }
}
