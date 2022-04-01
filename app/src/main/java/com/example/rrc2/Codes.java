package com.example.rrc2;

import android.content.Context;
import android.text.TextUtils;

import java.util.ArrayList;

public class Codes {
    private ArrayList<String> aAllCodes;

    public Codes(Context c){
        try {
            String strRawCodes = c.getString(R.string.codes);
            aAllCodes = splitCodes(strRawCodes);
        } catch (Exception e) {
            aAllCodes = new ArrayList<String>();
            aAllCodes.add(e.getMessage());
        }
    }

    private ArrayList<String> splitCodes(String strCodesToSplit){
        ArrayList<String> aCodes = new ArrayList<String>();

        // Once
        TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter('\n');

        // Once per string to split
        try {
            splitter.setString(strCodesToSplit);
            while (splitter.hasNext()) {
                aCodes.add(splitter.next());
            }
        } catch (Exception e){
            aCodes.add(e.getMessage());
        }

        return aCodes;
    }

    public ArrayList<String> searchCodes(String s) {
        ArrayList<String> aCodes = new ArrayList<String>();

        try {
            for (String strCode :
                    aAllCodes) {
                if (strCode.toLowerCase().contains((CharSequence) s.toLowerCase()) || s.length() == 0) {
                    aCodes.add(strCode);
                }
            }
        } catch (Exception e) {
            aCodes.add(e.getMessage());
        }

        return aCodes;
    }
}
