package com.kamaldeep.ligero.ui.main.ledFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.kamaldeep.ligero.R;
import com.kamaldeep.ligero.SERVER;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.SVBar;


public class LED2Fragment extends Fragment
{
    private final String TAG = LED2Fragment.class.getSimpleName();

    private String _URL;

    private Button changeColourButton;
    private ColorPicker picker;
    private TextView rgbInfo;


    private int redCol;
    private int blueCol;
    private int greenCol;
    private int col;
    private int power;

    public LED2Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_led2, container, false);

        picker = root.findViewById(R.id.colorPicker2);
        SVBar svBar = root.findViewById(R.id.svbar2);
        picker.addSVBar(svBar);

        rgbInfo = root.findViewById(R.id.rgbTextView2);
        col = picker.getColor();
        redCol = Color.red(col);
        blueCol = Color.green(col);
        greenCol = Color.blue(col);
        rgbInfo.setText("R: "+redCol+"\nG: "+ greenCol+"\nB: "+ blueCol);

        picker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color)
            {
                int r = Color.red(color);
                int g = Color.green(color);
                int b = Color.blue(color);
                rgbInfo.setText("R: " + r +"\nG: " + g +"\nB: " + b);
            }
        });

        changeColourButton = root.findViewById(R.id.changeColorButton2);
        changeColourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = picker.getColor();
                redCol = Color.red(color);
                greenCol = Color.green(color);
                blueCol = Color.blue(color);
                picker.setOldCenterColor(color);
                makeURL();
                SERVER.urlHit(_URL);
                Log.e(TAG,"LED2 URL: " + _URL);
                //urlHIT();
            }
        });

        ToggleButton toggleButton = root.findViewById(R.id.toggleButton2);
        toggleButton.setChecked(true);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    power = 1;
                    SERVER.urlHit("http://"+ SERVER.IP_ADDRESS+"/change_led2/1");
                    changeColourButton.setEnabled(true);
                }
                else
                {
                    power = 0;
                    SERVER.urlHit("http://"+ SERVER.IP_ADDRESS+"/change_led2/0");
                    changeColourButton.setEnabled(false);
                }
            }
        });

        return root;
    }

    private void makeURL()
    {
        if(true){
            power = 1;
        }
        else{
            power = 0;
        }

        _URL = "http://"+ SERVER.IP_ADDRESS+"/change_led2/"+redCol+","+
                +greenCol+","+blueCol+","+power;
    }
}
