package ru.twisterkin.animalloaderextended;

import android.content.Intent;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Nesterkin Alexander
 */

public class MainActivity extends AppCompatActivity {

    private static final int ANIMALS_LOADER_ID = 1;

    private AnimalStorage mAnimalStorage;
    private AnimalAdapter mAnimalAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_listview);

        AnimalStorageProvider mProvider = (AnimalStorageProvider) getApplication();
        mAnimalStorage = mProvider.getAnimalStorage();

        mListView = (ListView) findViewById(R.id.animal_list_view);
        mAnimalAdapter = new AnimalAdapter();
        mListView.setAdapter(mAnimalAdapter);

        getSupportLoaderManager().initLoader(ANIMALS_LOADER_ID, null, new AnimalLoaderCallbacks());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.add_animal_menu_item): {
                startActivity(new Intent(MainActivity.this, AddAnimalActivity.class));
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private class AnimalLoaderCallbacks implements LoaderManager.LoaderCallbacks<List<Animal>> {

        @Override
        public Loader<List<Animal>> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainActivity.this, mAnimalStorage);
        }

        @Override
        public void onLoadFinished(Loader<List<Animal>> loader, List<Animal> data) {
            mAnimalAdapter.setAnimals(data);
        }

        @Override
        public void onLoaderReset(Loader<List<Animal>> loader) {
        }
    }
}
