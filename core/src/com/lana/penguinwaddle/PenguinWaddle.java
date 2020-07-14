package com.lana.penguinwaddle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lana.penguinwaddle.screens.GameScreen;
import com.lana.penguinwaddle.utils.AssetsManager;

public class PenguinWaddle extends Game {

	@Override
	public void create () {
		AssetsManager.loadAssets();
		setScreen(new GameScreen());
	}
}
