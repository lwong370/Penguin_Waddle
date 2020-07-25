package com.lana.penguinwaddle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputMultiplexer;
import com.lana.penguinwaddle.screens.GameScreen;
import com.lana.penguinwaddle.screens.MenuScreen;
import com.lana.penguinwaddle.utils.AssetsManager;

public class PenguinWaddle extends Game {

	@Override
	public void create () {
		AssetsManager.loadAssets();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}
}
