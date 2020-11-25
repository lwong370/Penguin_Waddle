package com.lana.penguinwaddle.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.stages.InfoStage;
import com.lana.penguinwaddle.utils.GameManager;

public class InfoScreen implements Screen {

    private PenguinWaddle game;
    private InputMultiplexer multiplexer;
    private InfoStage infoStage;

    public InfoScreen(PenguinWaddle game) {
        this.game = game;
        multiplexer = new InputMultiplexer();
        infoStage = new InfoStage();
    }

    @Override
    public void show() {
        multiplexer.addProcessor(infoStage);
        Gdx.input.setInputProcessor(multiplexer);
        Gdx.graphics.setContinuousRendering(false);
    }

    @Override
    public void render(float delta) {
        infoStage.draw();

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
    }

    @Override
    public void dispose() {

    }
}
