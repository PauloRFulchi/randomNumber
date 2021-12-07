package com.example.randomnumber;

import com.example.randomnumber.funcoes.Funcoes;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	Context Context;
	
	TextView lblResult;
	EditText txtInicio, txtFim;
	Button btnGerar;	
	
	private void Gerar(int parInicio, int parFim){
		try{
			lblResult.setText("Resultado: " + String.valueOf(Funcoes.getRandomInt(parInicio, parFim)));
		}catch(Exception e){
			Funcoes.Alerta(Context, e.toString());
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
	
		try{		
			Context = this;
			
			lblResult = (TextView) findViewById(R.id.Main_lblResult);		
			txtInicio = (EditText) findViewById(R.id.Main_txtNum_Inicio);
			txtFim = (EditText) findViewById(R.id.Main_txtNum_Fim);
	
			btnGerar = (Button) findViewById(R.id.Main_btnGerar);
			btnGerar.setOnClickListener(new OnClickListener() {             
	    		@Override             
	    		public void onClick(View v) {
	    			try{
	    				if(TextUtils.isEmpty(txtInicio.getText().toString()) == true){        		 
	    					Funcoes.Mensagem(Context, "Campo inicio é obrigatório!");       	    	   
	    					txtInicio.requestFocus(); 
	    					return;
		        	  	}	    				
	    				if(TextUtils.isEmpty(txtFim.getText().toString()) == true){        		 
	    					Funcoes.Mensagem(Context, "Campo fim é obrigatório!");       	    	   
	    					txtFim.requestFocus(); 
	    					return;
		        	  	}  
	    				
	    				int ini = Integer.valueOf(txtInicio.getText().toString().trim());
	    				int fim = Integer.valueOf(txtFim.getText().toString().trim());
	    				
	    				Funcoes.hideKeyboard(Context, txtInicio);	
	    				Funcoes.hideKeyboard(Context, txtFim);		    				
	    				
	    				if(ini > fim){
	    					Funcoes.Alerta(Context, "Valor inicial não pode ser maior que o valor final!");
	    					return;
	    				}
	    				
	    				Gerar(ini, fim);	    				
	    			}catch(Exception e){	    			    				
						Funcoes.Alerta(Context, e.toString());				    			
					}   			    				    			
	    		}    		
	   	    });				
		}catch(Exception e){
			Funcoes.Alerta(this, e.toString());
		}
	}
}
