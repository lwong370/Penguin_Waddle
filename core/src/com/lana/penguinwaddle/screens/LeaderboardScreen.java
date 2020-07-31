package com.lana.penguinwaddle.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.stages.LeaderboardStage;
import com.lana.penguinwaddle.utils.GameManager;

public class LeaderboardScreen implements Screen {

    private PenguinWaddle game;
    private LeaderboardStage leaderboardStage;

    public LeaderboardScreen(PenguinWaddle game) {
        this.game = game;
        leaderboardStage = new LeaderboardStage();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(leaderboardStage);
    }

    @Override
    public void render(float delta) {
        leaderboardStage.draw();

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
        leaderboardStage.dispose();
    }
}
