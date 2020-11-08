package com.lana.penguinwaddle.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.stages.InstructionsStage;
import com.lana.penguinwaddle.utils.GameManager;

public class InstructionsScreen implements Screen {
    private PenguinWaddle game;
    private InstructionsStage instructionsStage;
    private InputMultiplexer multiplexer;

    public InstructionsScreen(PenguinWaddle game) {
        this.game = game;
        multiplexer = new InputMultiplexer();
        instructionsStage = new InstructionsStage();
    }

    @Override
    public void show() {
        multiplexer.addProcessor(instructionsStage);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        instructionsStage.draw();

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
        instructionsStage.dispose();
    }
}
