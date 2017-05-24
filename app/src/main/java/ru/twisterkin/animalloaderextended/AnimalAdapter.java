package ru.twisterkin.animalloaderextended;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nesterkin Alexander
 */

public class AnimalAdapter extends BaseAdapter {

    private List<Animal> mAnimalList ;

    public void setAnimals(List<Animal> mAnimalListSet){
        mAnimalList.clear();
        mAnimalList.addAll(mAnimalListSet);
        notifyDataSetChanged();
    }
    
    public AnimalAdapter () {
        mAnimalList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mAnimalList.size();
    }

    @Override
    public Animal getItem(int position) {
        return mAnimalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
            view = mLayoutInflater.inflate(R.layout.animal_item, parent, false);
            ViewHolder mViewHolder = new ViewHolder();

            mViewHolder.mSpeciesTextView = (TextView) view.findViewById(R.id.species_text_view);
            mViewHolder.mNameTextView = (TextView) view.findViewById(R.id.name_text_view);
            mViewHolder.mAgeTextView = (TextView) view.findViewById(R.id.age_text_view);

            view.setTag(mViewHolder);
        }

        ViewHolder mViewHolder = (ViewHolder) view.getTag();
        mViewHolder.mSpeciesTextView.setText(mAnimalList.get(position).getSpecies());
        mViewHolder.mNameTextView.setText(mAnimalList.get(position).getName());
        mViewHolder.mAgeTextView.setText(mAnimalList.get(position).getAge());
        return view;
    }

    private static class ViewHolder {
        private TextView mSpeciesTextView;
        private TextView mNameTextView;
        private TextView mAgeTextView;
    }
}
