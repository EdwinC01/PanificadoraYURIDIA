package com.example.panificadorayuridia.principal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.panificadorayuridia.R;

public class PrincipalMenu extends AppCompatActivity {
    TextView tvnomuslog;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.avtivity_principal_menu);

        String Title = "Panificadora YURIDIA";
        this.setTitle(Title);

        tvnomuslog = (TextView) findViewById(R.id.);

        Bundle extras = getIntent().getExtras();
        String s = extras.getString("usuario");
        s = s + ", ¡Bienvenido!";
        tvnomuslog.setText(s);
    }
}
