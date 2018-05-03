package com.koriah.study_kasus_yayu;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Context context;
    private AppCompatButton buttonLogin;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_login);
        context = Login.this;

        progressDialog = new ProgressDialog(context);
        editTextEmail = (EditText) findViewById(R.id.editTestEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (AppCompatButton) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }

        });

    }
    private void login() {
        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        progressDialog.setMessage("Login Progress");
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains(Server.LOGIN_SUCCESS)){
                            hideDialog();
                            gotoActivity_listpilihtenda();
                        } else {
                            hideDialog();
                            Toast.makeText(context, "Invalis Username and Password", Toast.LENGTH_LONG).show();
                        }
                    }
                },
        new Response.ErrorListener() {
            @Override
                    public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(context, "the Server Unreacheble", Toast.LENGTH_LONG).show();
            }
                }) {
    @Override
            protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put(Server.KEY_EMAIL, email);
        params.put(Server.KEY_PASSWORD, password);
        return params;
            }
        };
Volley.newRequestQueue (this).add(stringRequest);
    }
    private void gotoActivity_listpilihtenda() {
        Intent intent = new Intent(context, Activity_listpilihtenda.class);
        startActivity(intent);
        finish();
    }
    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
