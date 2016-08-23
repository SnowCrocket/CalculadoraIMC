package com.example.rafael.calculadorabmi;

import com.example.rafael.calculadorabmi.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//Main Activity class start
public class MainActivity extends Activity {

    //Define Layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignar referencias a los widgets
        final EditText altura = (EditText) findViewById(R.id.altura);
        final EditText peso = (EditText) findViewById(R.id.peso);
        final TextView imc = (TextView) findViewById(R.id.imc);

        findViewById(R.id.calcbutton).setOnClickListener(new View.OnClickListener(){

            //Logica para validación
            @Override
            public void onClick(View v) {

                String str1 = altura.getText().toString();
                String str2 = peso.getText().toString();

                if (TextUtils.isEmpty(str1)) {
                    altura.setError("¡Por favor pon tu Altura!");
                    altura.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(str2)) {
                    peso.setError("¡Por favor pon tu Peso!");
                    peso.requestFocus();
                    return;
                }
                //Conseguir valores del usuario desde la interfaz del widget
                float altura = Float.parseFloat(str1) / 100;
                float peso = Float.parseFloat(str2);

                //Calcular valor IMC
                float valorimc = calcularIMC(altura, peso);

                //Definir significado del valor del imc
                String interpretacionimc = interpretarIMC(valorimc);

                imc.setText(String.valueOf(valorimc + "-" + interpretacionimc));
                }

                });
            }
            //Calcular IMC
            private float calcularIMC (float altura, float peso) {
                return (float) (peso / (altura * altura));
            }
            //Interpretar que significa el IMC
            private String interpretarIMC(float valorimc) {
                if (valorimc < 16) {
                    return "Severamente Bajo Peso";
                } else if (valorimc <18.5) {
                    return "Bajo Peso";
                } else if (valorimc <25) {
                    return "Normal";
                } else if (valorimc <30) {
                    return "Sobrepeso";
                } else {
                    return "Obeso";
        }
    }
}
