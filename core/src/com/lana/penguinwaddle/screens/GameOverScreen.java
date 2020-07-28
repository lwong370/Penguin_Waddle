package com.lana.penguinwaddle.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.stages.GameOverStage;
import com.lana.penguinwaddle.utils.GameManager;

public class GameOverScreen implements Screen {

    private PenguinWaddle game;
    private GameOverStage gameOverStage;
    private InputMultiplexer multiplexer;

    public GameOverScreen(PenguinWaddle game) {
        this.game = game;
        gameOverStage = new GameOverStage();
        multiplexer = new InputMultiplexer();
    }

    @Override
    public void show() {
        multiplexer.addProcessor(gameOverStage);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        gameOverStage.draw();

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
        Gdx.input.setInputProcessor(null);
        multiplexer.removeProcessor(gameOverStage);
    }

    @Override
    public void dispose() {
        gameOverStage.dispose();
    }
}
