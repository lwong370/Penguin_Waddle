package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.buttons.LeaderboardButton;
import com.lana.penguinwaddle.actors.buttons.PlayButton;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class MenuStage extends Stage {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private OrthographicCamera camera;

    private Background bkgrd;
    private PlayButton playButton;
    private LeaderboardButton leaderboardButton;

    public MenuStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        addWorldComponents();
        setUpStartButton();
        setUpLeaderboardButton();
        setUpCamera();
    }

    private void setUpStartButton(){
        Rectangle bounds = new Rectangle(getCamera().viewportWidth * 1/3,
                getCamera().viewportHeight / 4, getCamera().viewportWidth / 4,
                getCamera().viewportWidth / 4);
        playButton = new PlayButton(bounds, new GamePlayButtonListener());
        addActor(playButton);
    }

    private void setUpLeaderboardButton(){
        int width = (int) (getCamera().viewportWidth / 4);
        Rectangle bounds = new Rectangle(getCamera().viewportWidth / 2 - width / 2,
                getCamera().viewportHeight / 10, width,
                getCamera().viewportWidth / 15);
        leaderboardButton = new LeaderboardButton(bounds, new LeaderBoardButtonListener());
        addActor(leaderboardButton);
    }

    private void addWorldComponents(){
        bkgrd = new Background(Constants.MENU_BACKGROUND_IMAGE_PATH);
        addActor(bkgrd);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth, camera.viewportHeight, 0f);
        camera.update();
    }

    private void onGameStart(){
        GameManager.getInstance().setGameState(GameState.PLAY);
    }

    private void onToLeaderboard(){
        GameManager.getInstance().setGameState(GameState.LEADERBOARD);
    }

    private class GamePlayButtonListener implements PlayButton.PlayButtonListener{
        @Override
        public void onPlay() {
            clear();
            onGameStart();
        }
    }

    private class LeaderBoardButtonListener implements LeaderboardButton.LeaderboardButtonListener{
        @Override
        public void toLeaderboard() {
            clear();
            onToLeaderboard();
        }
    }
}
