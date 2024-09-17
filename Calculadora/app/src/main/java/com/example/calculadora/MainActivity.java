package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText tela;
    private EditText numero1;
    private EditText numero2;
    private RadioButton adicao;
    private RadioButton subtracao;
    private RadioButton multiplicacao;
    private RadioButton divisao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tela = findViewById(R.id.visor);
        this.numero1 = findViewById(R.id.num1);
        this.numero2 = findViewById(R.id.num2);
        this.adicao = findViewById(R.id.adicao);
        this.subtracao = findViewById(R.id.subtracao);
        this.multiplicacao = findViewById(R.id.multiplicacao);
        this.divisao = findViewById(R.id.divisao);
    }//FIM DO ONCREATE

    public void calcular(View v) {

        String n1 = numero1.getText().toString();
        String n2 = numero2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            mensagem("Digite os dois valores");
        }
        else{
            double v1 = Double.parseDouble(numero1.getText().toString());
            double v2 = Double.parseDouble(numero2.getText().toString());

            if (adicao.isChecked()) {
                double resultado = v1 + v2;
                tela.setText(resultado + "");
            }
            else if (subtracao.isChecked()) {
                double resultado = v1 - v2;
                tela.setText(resultado + "");
            }
            else if (multiplicacao.isChecked()) {
                double resultado = v1 * v2;
                tela.setText(resultado + "");
            }
            else if (divisao.isChecked()) {
                if (v2 != 0) {
                    double resultado = v1 / v2;
                    tela.setText(resultado + "");
                }
                else {
                    mensagem("Não é permitido divisão por zero");
                }
            }
            else{
                mensagem("Escolha uma operação");
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
