package com.ssquare.timestable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SeekBar seekBar;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listview);
        seekBar.setMax(100);
        seekBar.setProgress(5);
        tableMaker(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if(progress<min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }else {
                    timesTableNumber = progress;
                }

                tableMaker(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    void tableMaker(int value){
        ArrayList<String> table = new ArrayList<String>();
        for(int i=1;i<=10;i++){
            String s = String.valueOf(i);
            table.add(value+" x "+i+" = "+i*value);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,table);
        listView.setAdapter(adapter);
    }
}