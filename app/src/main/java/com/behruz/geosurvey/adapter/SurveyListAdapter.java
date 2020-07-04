package com.behruz.geosurvey.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.behruz.geosurvey.R;
import com.behruz.geosurvey.databinding.ItemListSurveyBinding;
import com.behruz.geosurvey.model.SurveysItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Gideon on 27/08/19.
 */

public class SurveyListAdapter extends RecyclerView.Adapter<SurveyListAdapter.SurveyViewHolder> {

    private List<SurveysItem> dataList;
    private Context context;
    int selected_position = -1;
    private Activity acttivitys;
    private ClickListner clickListner;

    public SurveyListAdapter(Context context, ClickListner listner) {
        this.context = context;
        dataList = new ArrayList<>();
        this.clickListner = listner;
    }

    private void add(SurveysItem item) {
        dataList.add(item);
        notifyItemInserted(dataList.size() - 1);
    }

    public void addAll(List<SurveysItem> movieDatas) {
        for (SurveysItem movieData : movieDatas) {
            add(movieData);
        }
    }

    public void remove(SurveysItem item) {
        int position = dataList.indexOf(item);
        if (position > -1) {
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public SurveysItem getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public SurveyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListSurveyBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_survey, parent, false);

        final SurveyViewHolder viewHolder = new SurveyViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SurveyViewHolder holder, final int position) {
        final SurveysItem model = dataList.get(position);
        holder.bind(model,position);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class SurveyViewHolder extends RecyclerView.ViewHolder {
        private ItemListSurveyBinding binding;
        public SurveyViewHolder(ItemListSurveyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final SurveysItem model,int position) {
            binding.txtSurveyName.setText(model.getTitle());
            binding.txtSurveyUrl.setText(model.getSurveyUrl());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListner.onItemClick(model,position);
                }
            });

        }


    }

    public interface ClickListner {
        void onItemClick(SurveysItem model, int position);
    }

}
