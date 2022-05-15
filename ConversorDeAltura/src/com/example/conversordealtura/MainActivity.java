package com.example.conversordealtura;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	int alturaEmCentimetros = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtMetros = (TextView)findViewById(R.id.txtMetros);
        final TextView txtPes = (TextView)findViewById(R.id.txtPes);
   
        final SeekBar seekBar1 = (SeekBar)findViewById(R.id.seekBar1);
        seekBar1.setMax(230);
        //==============================================================
        seekBar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
        	@Override
        	public void onStopTrackingTouch(SeekBar seekBar) {
        	}
        	@Override 
        	public void onStartTrackingTouch(SeekBar seekbar){
        		txtPes.setText("pé(s): toque em Converter");
        	}
        	@Override 
        	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
        		alturaEmCentimetros = progress;
        		String texto = formataValorComDoisDigitos(progress/100.0);
        		texto += "m.";
        		txtMetros.setText(texto);
        	}
        });
        //==============================================================
        final Button  button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		double alturaEmPes = alturaEmCentimetros / 30.48;
        		String texto = formataValorComDoisDigitos(alturaEmPes);
        		texto += "pé(s)";
        		txtPes.setText(texto);
        	}
        });
    }
    //==============================================================
    private String formataValorComDoisDigitos(double valor) {
    	return String.format(Locale.FRANCE, "%.2f", valor);
    }
}

