package com.mobiotics.cryptostring.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobiotics.cryptostring.R;
import com.mobiotics.cryptostring.utils.AppConstants;
import com.mobiotics.cryptostring.viewmodel.CryptoViewModel;

public class EncryptDecryptActivity extends AppCompatActivity {

    int functionEncDec = 0;
    EditText editText;
    TextView tvResult;
    CryptoViewModel cryptoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_decrypt);

        functionEncDec = getIntent().getExtras().getInt(AppConstants.ACTIVITY_FUNCTION);
        cryptoViewModel = ViewModelProviders.of(this).get(CryptoViewModel.class);
        initializeView();
        cryptoViewModel.getResultText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvResult.setText(s);
            }
        });
    }

    private void initializeView(){
        if (functionEncDec == 0) {
            getSupportActionBar().setTitle("Encryption");
        } else {
            getSupportActionBar().setTitle("Decryption");
        }
        editText = findViewById(R.id.editText);
        tvResult = findViewById(R.id.tvResult);
       // tvResult.setText(cryptoViewModel.getResultText());
    }

    public void submit(View view) {
        String text = editText.getText().toString();
        if (text.length() != 0) {
            cryptoViewModel.submitText(text, functionEncDec);
        } else {
            Toast.makeText(this, "Enter a Text", Toast.LENGTH_LONG).show();
        }
    }
}
