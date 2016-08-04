package io.toru.imagesearching.Utility;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by toru on 2016. 8. 4..
 */
public class Util {

    private static final String API_KEY = "b3b23c05a30783b9751b1b322d898718";

    public static void hideKeyboard(Context ctx, EditText editText) {
        InputMethodManager imm = (InputMethodManager)ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
    }
}
