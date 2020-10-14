package com.lana.penguinwaddle.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lana.penguinwaddle.actors.Background;
import com.lana.penguinwaddle.actors.ScoreLabel;
import com.lana.penguinwaddle.actors.buttons.BackButton;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.Constants;
import com.lana.penguinwaddle.utils.GameManager;

public class LeaderboardStage extends Stage {
   public static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
   public static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

   private OrthographicCamera camera;

   private Background bkgrd;
   private BackButton backButton;
   private ScoreLabel highScoreLabel;

   private Table scoreTable;
   private Skin skin;

    public LeaderboardStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        addWorldComponents();
        setUpBackButton();
        setUpCamera();

        skin = AssetsManager.getInstance().getSkin();

        scoreTable = new Table();
        scoreTable.setFillParent(true);
        scoreTable.setFillParent(true);
        scoreTable.setBounds(0,0, 30, 30);
        addActor(scoreTable);

        Label header1 = new Label("Rank", skin, "test");
        header1.setScale(2f, 2f);
        scoreTable.add(header1).width(150);

        Label header2 = new Label("Score", skin, "test");
        scoreTable.add(header2).width(150);

        for(int i = 1; i <= 5; i++){
            scoreTable.row();
            Label label = new Label(Integer.toString(i), skin, "default");
            scoreTable.add(label).width(150);

            label = new Label(Integer.toString(GameManager.getInstance().getScoreFromPref("Rank"+i)), skin, "default");
            scoreTable.add(label).width(150);
        }
    }

    private void addWorldComponents(){
        bkgrd = new Background(Constants.WORDLESS_BACKGROUND_IMAGE_PATH);
        addActor(bkgrd);
    }

    private void setUpCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth, camera.viewportHeight, 0f);
        camera.update();
    }

    private void setUpBackButton(){
        Rectangle bounds = new Rectangle(getCamera().viewportWidth / 22,
                getCamera().viewportHeight * 3/4, getCamera().viewportWidth / 10,
                getCamera().viewportWidth / 10);
        backButton = new BackButton(bounds, new ToMainMenuListener());
        addActor(backButton);
    }

    private void onGetMainMenu(){
        GameManager.getInstance().setGameState(GameState.MENU);
    }

    private class ToMainMenuListener implements BackButton.BackButtonListener{
        @Override
        public void back() {
            clear();
            onGetMainMenu();
        }
    }
}
