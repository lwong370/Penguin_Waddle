package com.lana.penguinwaddle.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.stages.MenuStage;
import com.lana.penguinwaddle.utils.GameManager;

public class MenuScreen implements Screen {
    private PenguinWaddle game;
    private MenuStage menuStage;
    private InputMultiplexer multiplexer;

    public MenuScreen(PenguinWaddle game) {
        this.game = game;
        menuStage = new MenuStage();
        multiplexer = new InputMultiplexer();
    }

    @Override
    public void show() {
        multiplexer.addProcessor(menuStage);
        Gdx.input.setInputProcessor(multiplexer);
        Gdx.graphics.setContinuousRendering(true);
    }

    @Override
    public void render(float delta) {
        menuStage.draw();

        if(GameManager.getInstance().getGameState() == GameState.PLAY){
            game.setScreen(new GameScreen(game));
        } else if(GameManager.getInstance().getGameState() == GameState.SCOREBOARD){
            game.setScreen(new ScoreboardScreen(game));
        } else if(GameManager.getInstance().getGameState() == GameState.INFO){
            game.setScreen(new InfoScreen(game));
        }else if(GameManager.getInstance().getGameState() == GameState.INSTRUCTIONS){
            game.setScreen(new InstructionsScreen(game));
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
        multiplexer.removeProcessor(menuStage);
    }

    @Override
    public void dispose() {
        menuStage.dispose();
    }

}
