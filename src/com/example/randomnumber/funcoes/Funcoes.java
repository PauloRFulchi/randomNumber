package com.example.randomnumber.funcoes;

import java.util.ArrayList;
import java.util.Random;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Funcoes {
	
	public static AlertDialog Alerta(Context Context, String Mensagem){
    	AlertDialog alertDialog;
 		alertDialog = new AlertDialog.Builder(Context).create();
 		alertDialog.setTitle("");
 		alertDialog.setMessage(Mensagem);
 		alertDialog.show();
		
 		return alertDialog;
    }
	
	public static void Mensagem(Context Context, String Mensagem){		
		Toast.makeText(Context, Mensagem, Toast.LENGTH_SHORT).show();		
    }

	public static void hideKeyboard(Context context, View editText) {
	    InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
	    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
	}
	
	public static int getRandomInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    public static ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min, int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (numbers.size() < size) {
            int random = getRandomInt(min, max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }
	
}
