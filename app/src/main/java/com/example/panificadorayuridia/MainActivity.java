package com.example.panificadorayuridia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.panificadorayuridia.DataBase.DBHelper;

import org.jetbrains.annotations.Nullable;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {
    //Variables
    EditText edUser, edPwd;
    Button btnReg;
    //Cursor
    private Cursor fila;
    /*Variable tipo string con iniciación de texto
    * título de la app*/
    String Title = "Inicio de Sesión";

    //1, 2, 3, 4, 5, 6, 7

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se pinta el título
        this.setTitle(Title);
        //Visualización del ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Imagen para el ActionBar
        getSupportActionBar().setIcon(R.drawable.Panificadora);
        //Manejo de varibles con doc.xml
        edUser=(EditText)findViewById(R.id.edituser);
        edPwd=(EditText)findViewById(R.id.editpwd);

        btnReg = (Button) findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val lanzar = Intent(this, )
                setContentView(R.layout.activity_registro);
            }
        });
    }

    //Método de ingreso
    public void InicioSesion(View v) {
        //Objeto com.example.panificadorayuridia.MainActivity.com.example.panificadorayuridia.DataBase.DBHelper e instancia del constructor, base de datos y versión
        DBHelper admin = new DBHelper(this,"Panificadora",null,1);

        SQLiteDatabase db=admin.getWritableDatabase();

        String usuario=edUser.getText().toString();
        String contrasena=edPwd.getText().toString();

        fila.db.rawQuery("select username,clave_user from userstable where username='"+
                usuario+"' and clave_usaer='"+contrasena+"'", null);

        try {
            if (fila.moveToFirst()) {
                String.usua = fila.getString(0);
                String.pass = fila.getString(1);

                if (usuario.equals(usua) && contrasena.equals(pass)) {
                    Intent ven = new Intent(this, MainActivity.class);
                    ven.putExtra("usuario", usuario);
                    startActivityForResult(ven, 1234);
                    startActivity(ven);

                    edUser.setText("");
                    edPwd.setText("");
                }
            }
            else {
                Toast toast = Toast.makeText(this, "Los datos no concuerdan", Toast.LENGTH_LONG);
                toast.show();
            }
        } catch (Exception e) {
            Toast toast = Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void RegisData(View v) {
        Intent rdata = new Intent(this, RegisData.class);
        startActivity(rdata);
    }
}
