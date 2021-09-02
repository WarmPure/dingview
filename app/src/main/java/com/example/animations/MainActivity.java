package com.example.animations;

import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn, btnAction;

    private DingView dingView;

    private Long totalDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String androidId = Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID);

        btn = findViewById(R.id.btn_startDraw);
        btnAction = findViewById(R.id.btn_startAction);
        dingView = findViewById(R.id.dingView);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                totalDuration = dingView.startAnimation();
                if (totalDuration != -1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnAction.setVisibility(View.VISIBLE);
                        }
                    },totalDuration);
                }else {
                    Toast.makeText(MainActivity.this,"计算动画时长异常",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dingView.startMouth();
            }
        });
    }

}
