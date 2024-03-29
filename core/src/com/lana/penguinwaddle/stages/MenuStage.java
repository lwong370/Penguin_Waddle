package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.DrawnGameLabel;
import com.lana.penguinwaddle.actors.buttons.InfoButton;
import com.lana.penguinwaddle.actors.buttons.InstructionsButton;
import com.lana.penguinwaddle.actors.buttons.ScoreboardButton;
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
    private InfoButton infoButton;
    private ScoreboardButton scoreboardButton;
    private InstructionsButton instructionsButton;
    private DrawnGameLabel titleLabel;

    public MenuStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        addBackground();
        addTitleLabel();
        setUpStartButton();
        setUpInfoButton();
        setUpInstructionsButton();
        setUpScoreboardButton();
        setUpCamera();
    }

    private void setUpStartButton(){
        Rectangle bounds = new Rectangle(getCamera().viewportWidth * 1/6 + 25,
                getCamera().viewportHeight / 4, getCamera().viewportWidth / 4,
                getCamera().viewportWidth / 4);
        playButton = new PlayButton(bounds, new GamePlayButtonListener());
        addActor(playButton);
    }

    private void setUpInfoButton(){
        Rectangle bounds = new Rectangle(getCamera().viewportWidth * 7 / 8,
                getCamera().viewportHeight * 1 / 20, getCamera().viewportWidth / 10,
                getCamera().viewportWidth / 12);
        infoButton = new InfoButton(bounds, new InfoButtonListener());
        addActor(infoButton);
    }

    private void setUpInstructionsButton(){
        int width = (int) (getCamera().viewportWidth * 2/7);
        Rectangle bounds = new Rectangle(getCamera().viewportWidth / 2,
                getCamera().viewportHeight / 4, width,
                getCamera().viewportWidth / 12);
        instructionsButton = new InstructionsButton(bounds, new InstructButtonListener());
        addActor(instructionsButton);
    }

    private void setUpScoreboardButton(){
        int width = (int) (getCamera().viewportWidth * 2/7);
        Rectangle bounds = new Rectangle(getCamera().viewportWidth / 2,
                getCamera().viewportHeight * 4/9, width,
                getCamera().viewportWidth / 10);
        scoreboardButton = new ScoreboardButton(bounds, new ScoreBoardButtonListener());
        addActor(scoreboardButton);
    }

    private void addBackground(){
        bkgrd = new Background(Constants.WORDLESS_BACKGROUND_IMAGE_PATH);
        addActor(bkgrd);
    }

    private void addTitleLabel(){
        float width = getCamera().viewportWidth * 9/10;
        float height = getCamera().viewportHeight * 2/9;
        Rectangle bounds = new Rectangle(getCamera().viewportWidth - width, getCamera().viewportHeight - height, getCamera().viewportWidth * 4/5, height);
        titleLabel = new DrawnGameLabel(bounds, Constants.LABEL_MENU_TITLE_ID);
        addActor(titleLabel);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth, camera.viewportHeight, 0f);
        camera.update();
    }

    private void onGameStart(){
        GameManager.getInstance().setGameState(GameState.PLAY);
    }

    private void onToScoreboard(){
        GameManager.getInstance().setGameState(GameState.SCOREBOARD);
    }

    private void toInfoScreen(){
        GameManager.getInstance().setGameState(GameState.INFO);
    }

    private void toInstructionsScreen(){
        GameManager.getInstance().setGameState(GameState.INSTRUCTIONS);
    }

    private class GamePlayButtonListener implements PlayButton.PlayButtonListener{
        @Override
        public void onPlay() {
            clear();
            onGameStart();
        }
    }

    private class ScoreBoardButtonListener implements ScoreboardButton.ScoreboardButtonListener {
        @Override
        public void toScoreboard() {
            clear();
            onToScoreboard();
        }
    }

    private class InfoButtonListener implements InfoButton.InfoButtonListener{
        @Override
        public void onToInfoScreen() {
            clear();
            toInfoScreen();
        }
    }

    private class InstructButtonListener implements InstructionsButton.InstructionsButtonListener{
        @Override
        public void onClick() {
            clear();
            toInstructionsScreen();
        }
    }
}
