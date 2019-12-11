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

import java.util.Objects;

public class EncryptDecryptActivity extends AppCompatActivity {

    private int functionEncDec = 0;
    private EditText editText;
    private TextView tvResult;
    private CryptoViewModel cryptoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_decrypt);

        functionEncDec = Objects.requireNonNull(getIntent().getExtras()).getInt(AppConstants.ACTIVITY_FUNCTION);
        cryptoViewModel = ViewModelProviders.of(this).get(CryptoViewModel.class);
        initializeView();
        setResult();
    }

    /**
     * Set the Result in textView
     */
    private void setResult() {
        cryptoViewModel.getResultText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvResult.setText(s);
            }
        });
    }

    /**
     * Initialize activity view
     */
    private void initializeView() {
        if (functionEncDec == 0) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Encryption");
        } else {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Decryption");
        }
        editText = findViewById(R.id.editText);
        tvResult = findViewById(R.id.tvResult);
    }

    /**
     * onClick of Submit button perform encryption or decryption.
     *
     * @param view ButtonView
     */
    @SuppressWarnings("unused")
    public void submit(View view) {
        String text = editText.getText().toString();
        if (text.length() != 0) {
            cryptoViewModel.submitText(text, functionEncDec);
        } else {
            Toast.makeText(this, "Enter a Text", Toast.LENGTH_LONG).show();
        }
    }
}
