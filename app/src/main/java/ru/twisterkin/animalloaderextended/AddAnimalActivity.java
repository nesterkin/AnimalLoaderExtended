package ru.twisterkin.animalloaderextended;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nesterkin Alexander
 */

public class AddAnimalActivity extends AppCompatActivity {

    private AnimalStorage mAnimalStorage;

    private EditText mSpeciesEditText;
    private EditText mNameEditText;
    private EditText mAgeEditText;
    private Button mAddAnimalButton;
    private EditText mEditTexts[];

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimalStorageProvider mProvider = (AnimalStorageProvider) getApplication();
        mAnimalStorage = mProvider.getAnimalStorage();

        setContentView(R.layout.add_animal_activity);
        mSpeciesEditText = (EditText) findViewById(R.id.add_species);
        mNameEditText = (EditText) findViewById(R.id.add_name);
        mAgeEditText = (EditText) findViewById(R.id.add_age);
        mAddAnimalButton = (Button) findViewById(R.id.add_animal_button);

        mEditTexts = new EditText[] {mSpeciesEditText, mAgeEditText, mNameEditText};
        for (EditText editText : mEditTexts) {
            editText.addTextChangedListener(new TextWatcherImpl());
        }

        mAddAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAnimal();
            }
        });
    }

    private void createAnimal() {
        String mSpecies = mSpeciesEditText.getText().toString();
        String mName = mNameEditText.getText().toString();
        int mAge = Integer.valueOf(mAgeEditText.getText().toString());
        Animal mAnimal = new Animal(mSpecies, mName, mAge);
        mAnimalStorage.addAnimal(mAnimal);
        finish();
    }

    private class TextWatcherImpl implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean buttonEnabled = true;
            for (EditText editText : mEditTexts) {
                if (TextUtils.isEmpty(editText.getText())) {
                    buttonEnabled = false;
                    break;
                }
            }
            mAddAnimalButton.setEnabled(buttonEnabled);
        }
    }
}
