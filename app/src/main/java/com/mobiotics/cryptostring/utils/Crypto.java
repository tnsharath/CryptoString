package com.mobiotics.cryptostring.utils;

import java.util.HashMap;

public class Crypto {
    public String encrypt(String text){
        char[] charText = text.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < charText.length; i ++){
            if (hm.containsKey(charText[i])){
                int count = hm.get(charText[i]) + 1;
                hm.remove(charText[i]);
                hm.put(charText[i], count);
            } else {
                hm.put(charText[i], 1);
                if (i > 0 && i <= charText.length - 1) {
                    res.append(charText[i - 1]);
                    res.append(hm.get(charText[i - 1]));
                    hm.remove(charText[i - 1]);
                }
            }
            if (i == charText.length - 1){
                res.append(charText[i]);
                res.append(hm.get(charText[i]));
                hm.remove(charText[i]);
            }
        }
        return res.toString();
    }

    public String decrypt(String text){
        char[] charText = text.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < charText.length; i += 2){
            int j = 1;
            while (j <= Character.getNumericValue(charText[i])){
                res.append(charText[i - 1]);
                j++;
            }
        }
        return res.toString();
    }
}
