package com.lana.penguinwaddle.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lana.penguinwaddle.PenguinWaddle;
import com.lana.penguinwaddle.utils.AdsController;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new PenguinWaddle(new AdsController() {
			@Override
			public void showBanner() {

			}

			@Override
			public void hideBanner() {

			}
		}), config);
	}
}
