package sample.github.nisrulz.demolibrary;

import android.content.Context;
import android.widget.Toast;

public class ShowToast {
    private static ShowToast ourInstance = new ShowToast();

    public static ShowToast getInstance() {
        return ourInstance;
    }

    private ShowToast() {
    }

    public void toast(Context context, String data) {
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }
}
