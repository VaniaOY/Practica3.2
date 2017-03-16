package com.reserva;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Actividad2 extends Activity {

	String nombre = "", fecha = "", hora = "";
	int personas = 0;
	TextView muestraDatos;

    TextView correo, contraseña, telefono, motivo;
    RadioButton si, no;
    String antes="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad2);

		muestraDatos = (TextView) findViewById(R.id.muestraDatos);

		Bundle recibe = new Bundle();
		recibe = this.getIntent().getExtras();

		nombre = recibe.getString("nombre");
		personas = recibe.getInt("personas");
		fecha = recibe.getString("fecha");
		hora = recibe.getString("hora");

		muestraDatos.setText("Reservacion a nombre de:\n" + nombre + "\n" + personas
				+ " personas\nFecha: " + fecha + "\nHora: " + hora + "\n");

        correo = (TextView) findViewById(R.id.editTextEmail);
        contraseña = (TextView) findViewById(R.id.editTextPassword);
        telefono = (TextView) findViewById(R.id.editTextTelefono);
        motivo = (TextView) findViewById(R.id.editTextMotivo);
        si = (RadioButton) findViewById(R.id.radioButtonSi);
        no = (RadioButton) findViewById(R.id.radioButtonNo);
        if (si.isActivated()){
            antes="si";
        }else
            if (no.isActivated()){
                antes = "no";
            }

    }

    public void hacerOtraReserva(View v) {
        Intent envia = new Intent(this, MainActivity.class);
	    finish();
        startActivity(envia);
    }
    public void reenviar(View v) {
        Intent envia = new Intent(this, MainActivity.class);
        Bundle dato = new Bundle();
        dato.putString("correo", correo.getText().toString().trim());
        dato.putString("contraseña", contraseña.getText().toString().trim());
        dato.putString("telefono", telefono.getText().toString().trim());
        dato.putString("motivo", motivo.getText().toString().trim());
        dato.putString("visitaAnterior", antes);
        envia.putExtras(dato);
        finish();
        startActivity(envia);
    }

}
