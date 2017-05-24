package ru.twisterkin.animalloaderextended;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Nesterkin Alexander
 */

public class AnimalLoader extends AsyncTaskLoader<List<Animal>> implements OnContentChangeListener {

    private final AnimalStorage mAnimalStorage;
    private List<Animal> mCachedResult;

    public AnimalLoader(Context context, AnimalStorage animalStorage) {
        super(context);
        mAnimalStorage = animalStorage;
        mAnimalStorage.addOnContentChangeListener(this);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mCachedResult == null || takeContentChanged()) {
            forceLoad();
        }
    }

    @Override
    public void deliverResult(List<Animal> data) {
        super.deliverResult(data);
        mCachedResult = data;
    }

    @Override
    public List<Animal> loadInBackground() {
        return mAnimalStorage.getAnimalList();
    }

    @Override
    protected void onReset() {
        super.onReset();
        mAnimalStorage.removeOnContentChangeListener(this);
    }

    @Override
    public void onAnimalAdded(AnimalStorage storage, Animal animal) {
        onContentChanged();
    }
}
