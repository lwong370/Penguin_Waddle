package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.GameLabel;
import com.lana.penguinwaddle.actors.ScoreLabel;
import com.lana.penguinwaddle.actors.buttons.ReplayButton;
import com.lana.penguinwaddle.actors.buttons.ToMenuButton;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class GameOverStage extends Stage {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private OrthographicCamera camera;

    private Background bkgrd;
    private ScoreLabel scoreLabel;
    private GameLabel gameOverLabel;

    private ToMenuButton toMenuButton;
    private ReplayButton replayButton;

    public GameOverStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        addWorldComponents();
        setUpCamera();
        setUpToMenuButton();
        setUpReplayButton();
        setUpScoreLabel();
    }

    private void addWorldComponents(){
        bkgrd = new Background(Constants.WORDLESS_BACKGROUND_IMAGE_PATH);

        int labelWidth = (int) (getCamera().viewportWidth / 3);
        Rectangle bounds = new Rectangle(getCamera().viewportWidth * 11/16 - labelWidth/ 2,
                getCamera().viewportHeight / 2, labelWidth,
                getCamera().viewportHeight / 5);
        gameOverLabel = new GameLabel(bounds, Constants.LABEL_GAME_OVER_ID);

        addActor(bkgrd);
        addActor(gameOverLabel);
    }

    private void setUpScoreLabel(){
        int labelWidth = (int) (getCamera().viewportWidth / 4);
        Rectangle bounds = new Rectangle(getCamera().viewportWidth * 11/16 - labelWidth / 2,
                getCamera().viewportHeight / 3, labelWidth,
                getCamera().viewportWidth / 5);
        scoreLabel = new ScoreLabel(bounds, ScoreLabel.ScoreLabelType.SCORE);
        addActor(scoreLabel);
    }

    private void setUpToMenuButton(){
        int buttonWidth = (int) (getCamera().viewportWidth / 4);
        Rectangle bounds = new Rectangle(getCamera().viewportWidth / 3 - buttonWidth / 2,
                getCamera().viewportHeight / 5, buttonWidth,
                getCamera().viewportHeight / 4);
        toMenuButton = new ToMenuButton(bounds, new ToMainMenuListener());
        addActor(toMenuButton);
    }

    private void setUpReplayButton(){
        int buttonWidth = (int) (getCamera().viewportWidth / 4);
        Rectangle bounds = new Rectangle(getCamera().viewportWidth / 3 - buttonWidth / 2,
                getCamera().viewportHeight / 2, buttonWidth,
                getCamera().viewportHeight / 4);
        replayButton = new ReplayButton(bounds, new ReplayGameListener());
        addActor(replayButton);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth, camera.viewportHeight, 0f);
        camera.update();
    }

    private void onGetMenu(){
        GameManager.getInstance().setGameState(GameState.MENU);
    }

    private void onReplayGame(){
        GameManager.getInstance().setGameState(GameState.PLAY);
    }

    private class ToMainMenuListener implements ToMenuButton.ToMainMenuListener{
        @Override
        public void toMenu() {
            clear();
            onGetMenu();
        }
    }

    private class ReplayGameListener implements ReplayButton.ReplayButtonListener{
        @Override
        public void onReplay() {
            clear();
            onReplayGame();
        }
    }
}
