package com.lana.penguinwaddle;

import com.badlogic.gdx.Game;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.screens.MenuScreen;
import com.lana.penguinwaddle.utils.AdsController;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.GameManager;

public class PenguinWaddle extends Game {
	private AdsController adsController;

	public PenguinWaddle(AdsController adsController){
		this.adsController = adsController;
	}

	@Override
	public void create () {
		AssetsManager.getInstance().loadAssets();
		setScreen(new MenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
		if(GameManager.getInstance().getGameState() == GameState.GAME_OVER){
			adsController.showBanner();
		}else{
			adsController.hideBanner();
		}
	}
}
