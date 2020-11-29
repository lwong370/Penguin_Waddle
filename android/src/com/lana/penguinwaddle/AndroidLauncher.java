package com.lana.penguinwaddle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.lana.penguinwaddle.utils.AdsController;

import java.util.Map;

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

		//Define Layout
		layout = new RelativeLayout(this);
		layout.addView(gameView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

		params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);

		bannerAd = new AdView(this);
		bannerAd.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
		bannerAd.setAdSize(AdSize.SMART_BANNER);

		layout.addView(bannerAd, params);
		setContentView(layout);

		MobileAds.initialize(this, new OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(InitializationStatus initializationStatus) {
				Map<String, AdapterStatus> statusMap = initializationStatus.getAdapterStatusMap();
				for (String adapterClass : statusMap.keySet()) {
					AdapterStatus status = statusMap.get(adapterClass);
					Log.d("MyApp", String.format(
							"Adapter name: %s, Description: %s, Latency: %d",
							adapterClass, status.getDescription(), status.getLatency()));
				}
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
//				bannerAd.setVisibility(View.VISIBLE);
				AdRequest ad = new AdRequest.Builder().build();
				bannerAd.loadAd(ad);
			}
		});
	}

	@Override
	public void hideBanner() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
//				bannerAd.setVisibility(View.INVISIBLE);
				bannerAd.destroy();
			}
		});
	}
}
