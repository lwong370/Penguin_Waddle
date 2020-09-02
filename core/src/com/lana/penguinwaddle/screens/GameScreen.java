package com.lana.penguinwaddle.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.stages.GameStage;
import com.lana.penguinwaddle.utils.GameManager;

public class GameScreen implements Screen {

    private PenguinWaddle game;
    private GameStage gameStage;

    private InputMultiplexer multiplexer;

    public GameScreen(PenguinWaddle game){
        this.game = game;
        gameStage = new GameStage();
        multiplexer = new InputMultiplexer();
    }

    @Override
    public void show() {
        multiplexer.addProcessor(gameStage);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameStage.draw();
        gameStage.act(delta);

        if(GameManager.getInstance().getGameState() == GameState.GAME_OVER){
            game.setScreen(new GameOverScreen(game));
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
    }

    @Override
    public void dispose() {
        gameStage.dispose();
    }

}
