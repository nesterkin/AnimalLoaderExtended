package ru.twisterkin.animalloaderextended;

import java.util.Objects;

/**
 * Created by Nesterkin Alexander
 */

public class Animal {
    private String mSpecies;
    private String mName;
    private int mAge;

    public Animal(String mSpecies, String mName, int mAge) {
        this.mSpecies = mSpecies;
        this.mName = mName;
        this.mAge = mAge;
    }

    public String getSpecies() {
        return mSpecies;
    }

    public String getName() {
        return mName;
    }

    public String getAge() {
        return String.valueOf(mAge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (mAge != animal.mAge) return false;
        if (mSpecies != null ? !mSpecies.equals(animal.mSpecies) : animal.mSpecies != null)
            return false;
        return mName != null ? mName.equals(animal.mName) : animal.mName == null;

    }

    @Override
    public int hashCode() {
        int result = mSpecies != null ? mSpecies.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + mAge;
        return result;
    }
}
