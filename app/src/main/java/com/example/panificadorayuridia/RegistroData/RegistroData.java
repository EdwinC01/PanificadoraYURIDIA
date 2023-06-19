package com.example.panificadorayuridia.RegistroData;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.panificadorayuridia.DataBase.DBHelper;
import com.example.panificadorayuridia.MainActivity;
import com.example.panificadorayuridia.R;

public class RegistroData extends AppCompatActivity {
    String Title = "Regsitro de Usuarios";
    EditText us, pas;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        this.setTitle(Title);

        us = (EditText) findViewById(R.id.usrname);
        pas = (EditText) findViewById(R.id.pwrd);
    }

    public void RegistrarDataUser(View v) {
        DBHelper admin = new DBHelper(this, "Panificadora", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String UserName = us.getText().toString();
        String PassUser = pas.getText().toString();

        ContentValues values = new ContentValues();

        //Usuario y Nombre
        values.put("username", UserName);
        values.put("clave_User", PassUser);

        db.insert("userstable", null, values);
        db.close();

        Toast ToastMens = Toast.makeText(this, "¡Usuario Registrado con éxito!", Toast.LENGTH_SHORT);
        ToastMens.show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
