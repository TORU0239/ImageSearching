package io.toru.imagesearching.utility;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by toru on 2016. 8. 4..
 */
public class Util {
    public static final String API_KEY = "0fe27a3739407cb2ba22e0cf0a698a6d";

    public static void hideKeyboard(Context ctx, EditText editText) {
        InputMethodManager imm = (InputMethodManager)ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
    }
}