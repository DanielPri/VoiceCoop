package com.danapps.voicecoop;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private TextView voiceOutput;

    ShakeDetector.ShakeListener shakeListener = new ShakeDetector.ShakeListener() {
        @Override public void onShakeDetected() {
            //shake started, do something
            voiceOutput.setText("SHAKING");
            getSpeechInput(null);
        }

        @Override public void onShakeStopped() {
           //Done shaking
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voiceOutput = findViewById(R.id.voiceOutput);
        Sensey.getInstance().init(this);
        Sensey.getInstance().startShakeDetection(shakeListener);
    }

    public void getSpeechInput(View view){
        Sensey.getInstance().stopShakeDetection(shakeListener);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your device does not support speech input", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode == RESULT_OK && data != null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    voiceOutput.setText(result.get(0));
                    Sensey.getInstance().startShakeDetection(shakeListener);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Sensey.getInstance().stop();
    }

}
