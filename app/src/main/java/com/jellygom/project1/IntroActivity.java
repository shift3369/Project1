package com.jellygom.project1;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.jellygom.view.kbv.KenBurnsView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class IntroActivity extends AppCompatActivity {

  /**
   * KenBurnsView
   * KenBurnsEffect 적용한 배경화면
   * https://github.com/flavioarfaria/KenBurnsView
   * Apache License 2.0
   */
  private KenBurnsView mKenBurns;
  private TextView mLogo, appName;
  private Intent intent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intro);

    /**
     * ImageLoader
     * 이미지 로딩 및 캐시 관련 라이브러리
     * https://github.com/nostra13/Android-Universal-Image-Loader
     * Apache License 2.0
     */
    ImageLoader imageLoader = ImageLoader.getInstance();
    if (!imageLoader.isInited()) {
      imageLoader.init(ImageLoaderConfiguration.createDefault(this));
    }

    mKenBurns = (KenBurnsView) findViewById(R.id.ken_burns_images);
    mLogo = (TextView) findViewById(R.id.logo);
    appName = (TextView) findViewById(R.id.welcome_text);

    mKenBurns.setImageResource(R.drawable.intro_activity_background);
    animation();

    // 3초 뒤 MainActivity로 전환
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      public void run() {
        intent = new Intent(IntroActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
      }
    }, 3000);
  }

  private void animation() {
    mLogo.setAlpha(1.0F);
    Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
    mLogo.startAnimation(anim);
    ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(appName, "alpha", 0.0F, 1.0F);
    alphaAnimation.setStartDelay(1700);
    alphaAnimation.setDuration(500);
    alphaAnimation.start();
  }

  @Override
  public void onBackPressed() {
  }

}
