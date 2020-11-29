package com.lana.penguinwaddle;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.lana.penguinwaddle.utils.AdsController;

import java.util.Arrays;
import java.util.List;

public class AndroidLauncher extends AndroidApplication implements AdsController {
	private RelativeLayout layout;
	private RelativeLayout.LayoutParams params;
	private AdView bannerAd;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new PenguinWaddle(this), config);
		View gameView = initializeForView(new PenguinWaddle(this), config);
//		MediationTestSuite.launch(this);

		//Test ad
		List<String> testDeviceIds = Arrays.asList("FF817A91E46E37F071F846C6EC7D0DD3");
		RequestConfiguration configuration =
				new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
		MobileAds.setRequestConfiguration(configuration);

		//Define Layout
		layout = new RelativeLayout(this);
		layout.addView(gameView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

		//Set up Admob view
		bannerAd = new AdView(this);
		bannerAd.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
		bannerAd.setAdSize(AdSize.SMART_BANNER);

		params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);

		layout.addView(bannerAd, params);
		setContentView(layout);

		MobileAds.initialize(this, new OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(InitializationStatus initializationStatus) {
				AdRequest ad = new AdRequest.Builder().build();
				bannerAd.loadAd(ad);
			}
		});
	}

	@Override
	public void showBanner() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				bannerAd.setVisibility(View.VISIBLE);
			}
		});
	}

	@Override
	public void hideBanner() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				bannerAd.setVisibility(View.INVISIBLE);
			}
		});
	}
}
