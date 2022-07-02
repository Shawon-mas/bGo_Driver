package com.app.bgodriver.view.theme;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;

import com.app.bgodriver.R;

public class GetTheme {
    public void getTheme(Activity activity){
        SharedPreferences sharedPreferences = activity.getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        String theme = sharedPreferences.getString("theme", "light");
        activity.setTheme(theme.equals("light") ? R.style.Theme_BGoDriver_White : R.style.Theme_BGoDriver_Dark);
    }
}
