package br.com.stant.libraries.stantuiandroid;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.stant.libraries.stantuiandroid.databinding.SampleComponenentsListItemBinding;

/**
 * Created by denisvieira on 29/10/17.
 */

public class SampleComponentsListAdapter extends RecyclerView.Adapter<SampleComponentsListAdapter.ViewHolder> {

    private final Context mContext;
    private List<String> mComponents;

    public SampleComponentsListAdapter(Context context, List<String> components) {
        mContext  = context;
        mComponents = components;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SampleComponenentsListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.sample_componenents_list_item,
                parent,
                false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        String component = mComponents.get(position);

        viewHolder.mSampleComponenentsListItemBinding.setComponentName(component);
        viewHolder.mSampleComponenentsListItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    public void replaceData(List list) {
        mComponents = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SampleComponenentsListItemBinding mSampleComponenentsListItemBinding;

        public ViewHolder(SampleComponenentsListItemBinding sampleComponenentsListItemBinding) {
            super(sampleComponenentsListItemBinding.getRoot());

            this.mSampleComponenentsListItemBinding = sampleComponenentsListItemBinding;
        }
    }
}
