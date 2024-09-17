package com.example.conversordetemperaturas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText tela, valor;
    private RadioButton kelvin, faremheint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tela = findViewById(R.id.resultado);
        this.valor = findViewById(R.id.valor);
        this.kelvin = findViewById(R.id.kelvin);
        this.faremheint = findViewById(R.id.faremheint);

    }//FIM DO ONCREATE
    public void converter (View v) {

        String  n1 = valor.getText().toString();

        if (n1.isEmpty()) {
            mensagem("Digite um Valor!");
        }

        else{
                try {
                    double v1 = Double.parseDouble(n1);

                    if (kelvin.isChecked()) {
                        double r = v1 + 273.15;
                        tela.setText(r + "" + " K");
                    } else if (faremheint.isChecked()) {
                        double r = v1 * 1.8 + 32;
                        tela.setText(r + "" + " °F");

                    }else {
                        mensagem("Escolha uma unidade de temperatura");
                    }
                } catch (NumberFormatException e) {
                    mensagem("Erro: Insira um valor numérico válido");
                }


        }
    }
    public void mensagem(String texto){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Atenção");
        msg.setMessage(texto);
        msg.setNeutralButton("Ok", null);
        msg.create();
        msg.show();
    }
}