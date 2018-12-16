package com.example.andrew.andrewsleepfan;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer fan;
    private MediaPlayer heater;
    private MediaPlayer waves;

    private Button fanButton;
    private Button heaterButton;
    private Button wavesButton;

    private ImageView fanImageView;
    private ImageView heaterImageView;
    private ImageView waveImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fan = new MediaPlayer();
        fan = MediaPlayer.create(getApplicationContext(), R.raw.fan);

        heater = new MediaPlayer();
        heater = MediaPlayer.create(getApplicationContext(), R.raw.heater);

        waves = new MediaPlayer();
        waves = MediaPlayer.create(getApplicationContext(), R.raw.waves);

        fanButton = findViewById(R.id.button1ID);
        heaterButton = findViewById(R.id.button2ID);
        wavesButton = findViewById(R.id.button3ID);

        fanImageView = findViewById(R.id.fanImageViewID);
        heaterImageView = findViewById(R.id.heaterImageViewID);
        waveImageView = findViewById(R.id.wavesImageViewID);



        fanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fan.isPlaying()){
                    pauseMusic(fan, fanButton, fanImageView);
                } else
                {
                    startMusic(fan, fanButton, fanImageView);
                }
            }
        });

        heaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(heater.isPlaying()){
                    pauseMusic(heater, heaterButton, heaterImageView);
                } else
                {
                    startMusic(heater, heaterButton, heaterImageView);
                }
            }
        });

        wavesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(waves.isPlaying()){
                    pauseMusic(waves, wavesButton, waveImageView);

                } else
                {
                    startMusic(waves, wavesButton, waveImageView);
                }

            }
        });

    }



    public void pauseMusic(MediaPlayer mediaPlayer, Button button, ImageView imageView){
        if(mediaPlayer!= null){
            mediaPlayer.pause();

            imageView.setVisibility(View.INVISIBLE);

            if (mediaPlayer == fan){
                button.setText(R.string.button1Text);
//                fanImageView.setVisibility(View.INVISIBLE);
            }
            else if (mediaPlayer == heater){
                button.setText(R.string.button2Text);
//                heaterImageView.setVisibility(View.INVISIBLE);
            }
            else {
                button.setText(R.string.button3Text);
//                waveImageView.setVisibility(View.INVISIBLE);
            }
        }

    }
    public void startMusic(MediaPlayer mediaPlayer, Button button, ImageView imageView){
        if (mediaPlayer!= null){
            mediaPlayer.start();
            imageView.setVisibility(View.VISIBLE);
            button.setText("Turn off");

        }

    }
}
