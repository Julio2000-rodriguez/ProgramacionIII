package com.example.prueba;

import android.app.Activity;
import android.net.wifi.aware.PublishConfig;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar(view);
            }
        });
    }
    public void procesar(View vista){
        try {
            RadioGroup optOperaciones = (RadioGroup) findViewById(R.id.optOperaciones);
            Spinner cboOperaciones = (Spinner)findViewById(R.id.cboOperaciones);

            TextView tempVal = (TextView) findViewById(R.id.txtnum1);
            double num1 = Double.parseDouble(tempVal.getText().toString());

            tempVal = (TextView) findViewById(R.id.txtnum2);
            double num2 = Double.parseDouble(tempVal.getText().toString());

            double respuesta = 0;
            //Este es para el radiogroup y los radiobuttons
            switch (optOperaciones.getCheckedRadioButtonId()) {
                case R.id.optSuma:
                    respuesta = num1 + num2;
                    break;
                case R.id.optResta:
                    respuesta = num1 - num2;
                    break;
                case R.id.optMultiplicar:
                    respuesta = num1 * num2;
                    break;

                case R.id.optDivision:
                    respuesta = num1 / num2;
                    break;

                case R.id.optporcentaje:
                    respuesta = (num1 * num2) / 100;
                    break;

                case R.id.optexpo:
                    respuesta = Math.pow(num1,num2);
                    break;

                case R.id.optmodulo:
                    respuesta = num1 % num2;
                    break;

                case R.id.optfactoreal:

                    int facto = 1;

                    for (int i = 2; i<= num1; i++)

                    {
                        facto = facto * i;

                        respuesta = facto;
                    }
                    break;
            }
            //Este es para el spinner... -> Combobox.
            switch (cboOperaciones.getSelectedItemPosition()){

                case 1: //suma
                    respuesta = num1 + num2;
                    break;

                case 2: //resta
                    respuesta = num1 - num2;
                    break;

                case 3: //multiplicacion
                    respuesta = num1 * num2;
                    break;

                case 4: //division
                    respuesta = num1 / num2;
                    break;

                case 5: //porcentaje
                    respuesta = (num1 * num2) / 100;
                    break;

                case 6: //exponenciacion
                    respuesta = Math.pow(num1,num2);
                    break;

                case 7: //modulo
                    respuesta = num1 % num2;
                    break;

                case 8:

                    int Facto = 1;

                    for (int x = 2; x <= num1; x++)

                    {
                        Facto = Facto * x;

                        respuesta = Facto;
                    }

                    break;
            }

            tempVal = (TextView) findViewById(R.id.lblRespuesta);
            tempVal.setText("Respuesta: " + respuesta);
        }catch (Exception err){
            TextView temp = (TextView) findViewById(R.id.lblRespuesta);
            temp.setText("Por favor ingrese los numeros correspondientes.");

            Toast.makeText(getApplicationContext(),"Por favor ingrese los numeros.",Toast.LENGTH_LONG).show();
        }
    }
}