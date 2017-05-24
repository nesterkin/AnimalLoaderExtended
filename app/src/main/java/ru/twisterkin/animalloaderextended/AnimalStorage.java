package ru.twisterkin.animalloaderextended;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nesterkin Alexander
 */

public class AnimalStorage {

    private final static List<Animal> sAnimalList = init();
    private final List<Animal> mAnimalList;
    private List<OnContentChangeListener> mOnContentChangeListener = new ArrayList<>();

    private static List<Animal> init() {
        List<Animal> mAnimalListInit = new ArrayList<>();

        mAnimalListInit.add(new Animal("Lion", "Egor", 17));
        mAnimalListInit.add(new Animal("Cat", "Maxim", 12));
        mAnimalListInit.add(new Animal("Wolf", "Sergey", 4));
        mAnimalListInit.add(new Animal("Dog", "Alexey", 11));
        mAnimalListInit.add(new Animal("Hawk", "Mihail", 18));

        mAnimalListInit.add(new Animal("Shark", "Dmitry", 7));
        mAnimalListInit.add(new Animal("Falcon", "Artem", 21));
        mAnimalListInit.add(new Animal("Penguin", "Fedor", 45));
        mAnimalListInit.add(new Animal("Gorilla", "Nickolay", 8));
        mAnimalListInit.add(new Animal("Kangaroo", "Konstantin", 2));

        return Collections.unmodifiableList(mAnimalListInit);
    }

    public AnimalStorage() {
        mAnimalList = new ArrayList<>(sAnimalList);
        mOnContentChangeListener = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        mAnimalList.add(animal);
        for (OnContentChangeListener listener : mOnContentChangeListener) {
            listener.onAnimalAdded(this, animal);
        }
    }

    public List<Animal> getAnimalList() {
        return new ArrayList<>(mAnimalList);
    }

    public void addOnContentChangeListener(OnContentChangeListener listener) {
        mOnContentChangeListener.add(listener);
    }

    public void removeOnContentChangeListener(OnContentChangeListener listener) {
        mOnContentChangeListener.remove(listener);
    }
}
