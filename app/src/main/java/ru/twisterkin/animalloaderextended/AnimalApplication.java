package ru.twisterkin.animalloaderextended;

import android.app.Application;

/**
 * Created by Nesterkin Alexander
 */

public class AnimalApplication extends Application implements AnimalStorageProvider {

    private final static String TAG = AnimalApplication.class.getName();
    private AnimalStorage mAnimalStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        mAnimalStorage = new AnimalStorage();
    }

    @Override
    public AnimalStorage getAnimalStorage() {
        return mAnimalStorage;
    }
}
