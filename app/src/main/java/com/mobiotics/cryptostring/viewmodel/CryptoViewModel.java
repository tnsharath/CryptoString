package com.mobiotics.cryptostring.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mobiotics.cryptostring.utils.AppConstants;
import com.mobiotics.cryptostring.utils.Crypto;

public class CryptoViewModel extends AndroidViewModel {

    private String result;
    private final Crypto crypto;

    private final MutableLiveData<String> res = new MutableLiveData<>();

    public CryptoViewModel(@NonNull Application application) {
        super(application);
        crypto = new Crypto();
        this.result = "";
    }

    /**
     * Get the result of encrypted or decrypted text.
     * @return resulted live string
     */
    public LiveData<String> getResultText() {
        return res;
    }

    /**
     * perform either encryption or decryption based on functionEncDec
     *
     * @param text to be encrypted or decrypted.
     * @param functionEncDec int to decide its encryption or decryption.
     */
    public void submitText(String text, int functionEncDec) {
        if (functionEncDec == 0) {
            result = crypto.encrypt(text);
        } else {
            if (text.matches(AppConstants.RE_DECRYPT_TEXT)) {
                result = crypto.decrypt(text);
            } else {
                result = "Invalid text, Try different text";
            }
        }
        res.setValue(result);
    }
}
