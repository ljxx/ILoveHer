package com.iloveher.www;

import android.content.Intent;
import android.os.Bundle;

import com.iloveher.www.ui.MainActivity;
import com.iloveher.www.ui.base.BaseFragmentActivity;

public class SplashActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
