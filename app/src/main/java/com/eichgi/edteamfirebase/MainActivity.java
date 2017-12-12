package com.eichgi.edteamfirebase;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Usuario usuario;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;
    String email, nombre, uuid;
    TextInputEditText tiEmail, tiNombre, tiUUID;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        uuid = mAuth.getCurrentUser().getUid();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("usuarios");

        tiEmail = findViewById(R.id.tiEmail);
        tiNombre = findViewById(R.id.tiNombre);
        tiUUID = findViewById(R.id.tiUUID);
        tiUUID.setText(uuid);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = tiEmail.getText().toString();
                nombre = tiNombre.getText().toString();
                Usuario usuario = new Usuario(nombre, email, uuid);
                reference.child(uuid).setValue(usuario);
                Toast.makeText(getApplicationContext(), "Usuario actualizado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
