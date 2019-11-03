package com.example.subdicoding;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Loading extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView tvLogo;
    private TextView persentase;
    private int loading = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        progressBar = findViewById(R.id.progbar);
        tvLogo = findViewById(R.id.tv_logo);
        persentase = findViewById(R.id.persentase);
        progressBar.setProgress(0);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                persentase.setText(String.valueOf(loading)+"%");
                if(loading == progressBar.getMax()){
                    Toast.makeText(getApplicationContext(), "Bekasi On Apps", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Loading.this, MainActivity.class));
                    finish();
                }
                loading++;
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0; i<=progressBar.getMax(); i++){
                        progressBar.setProgress(i);
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(50);
                    }
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
