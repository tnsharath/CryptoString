package com.mobiotics.cryptostring.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobiotics.cryptostring.R;
import com.mobiotics.cryptostring.utils.AppConstants;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, EncryptDecryptActivity.class);
    }

    /**
     * on Encrypt button clicked do the function of encryption in next activity
     *
     * @param view ButtonView
     */
    @SuppressWarnings("unused")
    public void encrypt(View view) {
        intent.putExtra(AppConstants.ACTIVITY_FUNCTION, 0);
        startActivity(intent);
    }

    /**
     * on Decryption button clicked do the function of decryption in next activity
     *
     * @param view ButtonView
     */
    @SuppressWarnings("unused")
    public void decrypt(View view) {
        intent.putExtra(AppConstants.ACTIVITY_FUNCTION, 1);
        startActivity(intent);
    }
}
