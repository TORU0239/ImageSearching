package io.toru.imagesearching.utility;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by toru on 2016. 8. 4..
 */
public class Util {

    public static final String API_KEY = "b3b23c05a30783b9751b1b322d898718";
    public static final String SEARCH_URL = "https://apis.daum.net/search/image";
    public static final String API_KEY_PARAM = "apikey";
    public static final String QUERY_PARAM = "q";
    public static final String OUTPUT_PARAM= "output";

//    https://apis.daum.net/search/image?apikey=b3b23c05a30783b9751b1b322d898718&q=다음카카오&output=json


    public static void hideKeyboard(Context ctx, EditText editText) {
        InputMethodManager imm = (InputMethodManager)ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
    }
}
