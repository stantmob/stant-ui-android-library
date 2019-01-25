package br.com.stant.libraries.stantuiandroid.samplecomponentslist;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SampleComponenentsListItemBinding;
import br.com.stant.libraries.stantuiandroid.entities.UiComponent;

/**
 * Created by denisvieira on 29/10/17.
 */

public class SampleComponentsListAdapter extends RecyclerView.Adapter<SampleComponentsListAdapter.ViewHolder> {

    private List<UiComponent> mComponents;
    private SampleComponentsListContract.View mView;

    SampleComponentsListAdapter(SampleComponentsListContract.View view) {
        mView       = view;
        mComponents = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SampleComponenentsListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.sample_componenents_list_item,
                parent,
                false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final UiComponent component = mComponents.get(position);

        viewHolder.mSampleComponenentsListItemBinding.setComponentName(component.getName());
        viewHolder.mSampleComponenentsListItemBinding.sampleComponentListItemRelativeLayout.setOnClickListener((view) -> mView.goToComponentDetail(component));
        viewHolder.mSampleComponenentsListItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    void replaceData(List<UiComponent>  list) {
        mComponents = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private SampleComponenentsListItemBinding mSampleComponenentsListItemBinding;

        ViewHolder(SampleComponenentsListItemBinding sampleComponenentsListItemBinding) {
            super(sampleComponenentsListItemBinding.getRoot());

            this.mSampleComponenentsListItemBinding = sampleComponenentsListItemBinding;
        }
    }


}
