package com.customview;

/**
 * Created by suresh on 3/1/17.
 */

public class AppSingleton {

    private MainActivity mainActivity;
    private static AppSingleton appSingleton;

    public void initMainActivity(MainActivity mainActivity) {

        this.mainActivity = mainActivity;

    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public static AppSingleton getSingleton() {
        if (appSingleton == null) {
            appSingleton = new AppSingleton();
        }
        return appSingleton;
    }
}
