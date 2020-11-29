package com.lana.penguinwaddle;

import com.badlogic.gdx.Game;
import com.lana.penguinwaddle.enums.GameState;
import com.lana.penguinwaddle.screens.MenuScreen;
import com.lana.penguinwaddle.utils.AdsController;
import com.lana.penguinwaddle.utils.AssetsManager;
import com.lana.penguinwaddle.utils.GameManager;

public class PenguinWaddle extends Game {
	private AdsController adsController;

	//Checks screen just popped up. Assures that ad doesn't spontaneously show and hide.
	private boolean adInit;

	public PenguinWaddle(AdsController adsController){
		adInit = false;
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
				if(adInit == false){
					adInit = true;
					adsController.showBanner();
				}
			}else{
				adInit = false;
				adsController.hideBanner();
			}
	}
}
