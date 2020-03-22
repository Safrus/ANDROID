package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;

public class Calculator extends AppCompatActivity {
    TextView text;
    String string ="";
    Double res = null;
    String lastOperation = "";
    String output = "";

    public boolean isNumeric(String number){
        if(number ==null)
            return false;
        try{
            double d = Double.parseDouble(number);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
    }

    protected void onSaveInstanceState(Bundle outState){
        outState.putString("OPERATION", lastOperation);
        outState.putString("TEXT", text.getText().toString());
        if(res !=null){
            outState.putDouble("RESULT", res);
        }

        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String temp = savedInstanceState.getString("TEXT");

        lastOperation = savedInstanceState.getString("OPERATION");
        if(isNumeric(temp)){
            if(lastOperation.equals("=") || lastOperation.equals("sin") || lastOperation.equals("cos") || lastOperation.equals("tan") || lastOperation.equals("ln") || lastOperation.equals("!")){
                res = Double.parseDouble(temp);
                text.setText(res.toString());
            }else{
                if(!lastOperation.isEmpty()){
                    res = savedInstanceState.getDouble("RESULT");
                }
                string = temp;
                text.setText(string);
            }
        }
        else{
            res = savedInstanceState.getDouble("RESULT");
            if(!lastOperation.equals("=") && !lastOperation.equals("sin") && !lastOperation.equals("C") && !lastOperation.equals("cos") && !lastOperation.equals("tan") && !lastOperation.equals("ln") && !lastOperation.equals("!")) {
                text.setText(lastOperation);
            }
        }
    }


    public void onNumberClick(View v){
        text.setTextSize(40);
        if(lastOperation.equals("=") && res !=null ||  lastOperation.equals("x²") && res !=null ||
                lastOperation.equals("sin")  && res !=null || lastOperation.equals("cos") && res !=null || lastOperation.equals("tan")  && res !=null || lastOperation.equals("ln") && res !=null || lastOperation.equals("!") && res !=null) {
            res = null;
        }
        if(lastOperation.equals("C")){
            lastOperation="";
            res = null;
        }

        Button btn = (Button)v;
        if(btn.getText().equals(".")){
            if(string.contains(".") || string.length()==0){
                string +="";
            }
            else
                string +=".";
        }
        else{
            if(btn.getText().equals("DEL")){

                if(string.length()>0)
                    string = string.substring(0, string.length()-1);
            }
            else{
                if(string.equals("0")){
                    string ="";
                    string +=btn.getText().toString();
                }
                else{
                    string +=btn.getText().toString();
                }
            }

        }

        text.setText(string);

    }



    public void onOperationClick(View v){
        text.setTextSize(40);
        Button btn = (Button)v;
        String operation = btn.getText().toString();
        if(operation.equals("x²") || operation.equals("C") || operation.equals("sin") || operation.equals("cos") || operation.equals("tan") || operation.equals("ln") || operation.equals("!")){
            if(res !=null){
                try{
                    performOperation(res,operation);
                }catch (NumberFormatException ex){
                    text.setText("");
                }
            }
            else {
                try{
                    performOperation(Double.parseDouble(string),operation);
                }catch (NumberFormatException ex){
                    text.setText("");
                }
            }
        }
        if(!operation.equals("=") && !operation.equals("x²") && !operation.equals("C") && !operation.equals("sin") && !operation.equals("cos") && !operation .equals("tan") && !operation.equals("ln") && !operation.equals("!")){
            text.setText(operation);
        }

        if(string.length()>0){
            string = string.replace(',','.');
            try{
                performOperation(Double.parseDouble(string),operation);
            }catch (NumberFormatException ex){
                text.setText("");
            }
        }

        lastOperation = operation;
    }


    public void performOperation(Double a, String operation){
        if(a==0.0 && lastOperation.equals("÷")){
            text.setTextSize(20);
            text.setText("IT'S NOT POSSIBLE TO DIVIDE BY 0!");
            res = 0.0;
            lastOperation = "";
        }
        else{
            if(operation.equals("x²")){
                res = a*a;

                if(Math.round(res)== res){
                    output = String.format("%.0f", res);
                    text.setText(output.toString());
                }
                else{
                    output = String.format("%.5f", res);
                    text.setText(output.toString());
                }
            }

            else if (operation.equals("!")){
                double temp = a;
                res = 1.0;
                for (int i = 2; i<=temp; i++){
                    res *=i;
                }
                text.setText(res.toString());
            }
            else if (operation.equals("sin")){
                double temp = Math.toRadians(a);
                res = Math.sin(temp);
                text.setText(res.toString());
            }
            else if (operation.equals("cos")){
                double temp = Math.toRadians(a);
                res = Math.cos(temp);
                text.setText(res.toString());
            }
            else if (operation.equals("tan")){
                double temp = Math.toRadians(a);
                res = Math.tan(temp);
                text.setText(res.toString());
            }
            else if(operation.equals("ln")){
                if(a==0){
                    text.setTextSize(40);
                    text.setText("Incorrect Argument!");
                }
                else {
                    res = Math.log(a);
                    text.setText(res.toString());
                }
            }
            else if(operation.equals("C")){
                res = 0.0;
                text.setText("");
            }


            else {
                if(res == null){
                    res = a;
                }
                else{
                    if(operation.equals("=")){
                        switch(lastOperation) {
                            case "+":
                                res += a;
                                break;
                            case "−":
                                res -= a;
                                break;
                            case "×":
                                res *= a;
                                break;
                            case "÷":
                                res /= a;
                                break;

                            case "%":
                                res = (res *a)/100;
                                break;
                            case "^":
                                res = Math.pow(res,a);
                                break;
                            case "√":
                                res = Math.pow(res,1.0/a);
                                break;
                            case "log":
                                res = Math.log(res)/Math.log(a);
                                break;
                        }

                        if(Math.round(res)== res){
                            output = String.format("%.0f", res);
                            text.setText(output.toString());
                        }
                        else{
                            output = String.format("%.5f", res);
                            text.setText(output.toString());
                        }
                    }
                    else{
                        switch(lastOperation) {
                            case "+":
                                res += a;
                                break;
                            case "−":
                                res -= a;
                                break;
                            case "×":
                                res *= a;
                                break;
                            case "÷":
                                res /= a;
                                break;
                        }
                    }


                }
            }
        }
        string ="";
    }

}