package com.reserva;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

    TextView usuario, pasword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (TextView)  findViewById(R.id.editTextUser);
        pasword = (TextView)  findViewById(R.id.editTextPasw);


    }

    public void enviar(View v) {

            Intent envia = new Intent(this, MainActivity.class);
            Bundle dato = new Bundle();
        //if (usuario.getText().toString().trim() == "Vania" && pasword.getText().toString().trim() == "Nubia") {
            dato.putString("user", usuario.getText().toString().trim());
            dato.putString("pasword", pasword.getText().toString().trim());
            envia.putExtras(dato);
            finish();
            startActivity(envia);
       /* }
        else{
            System.out.println("error" );
        }*/

    }
}
