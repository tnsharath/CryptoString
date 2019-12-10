package com.mobiotics.cryptostring.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mobiotics.cryptostring.utils.Crypto;

public class CryptoViewModel extends AndroidViewModel {

    private String result;
    private Crypto crypto;

    public CryptoViewModel(@NonNull Application application) {
        super(application);
        crypto = new Crypto();
        this.result = "";
    }

    private MutableLiveData<String> res = new MutableLiveData<>();

    public LiveData<String> getResultText() {
        return res;
    }

    //TODO validate decrypt text
    public void submitText(String text, int functionEncDec) {
        if (functionEncDec == 0) {
            result = crypto.encrypt(text);
        } else {
            result = crypto.decrypt(text);
        }
        res.setValue(result);
    }
}
