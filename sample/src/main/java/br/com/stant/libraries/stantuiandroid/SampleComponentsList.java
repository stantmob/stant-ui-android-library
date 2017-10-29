package br.com.stant.libraries.stantuiandroid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.stant.libraries.stantuiandroid.databinding.SampleComponentsListBinding;

public class SampleComponentsList extends AppCompatActivity {

    private SampleComponentsListBinding mSampleComponentsListBinding;
    private SampleComponentsListAdapter mSampleComponentsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSampleComponentsListBinding = DataBindingUtil.setContentView(this, R.layout.sample_components_list);
        configureComponentsListRecycle();
    }

    private void configureComponentsListRecycle(){
        mSampleComponentsListAdapter = new SampleComponentsListAdapter(getApplicationContext(), buildComponentsList());
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mSampleComponentsListBinding.sampleComponentsListMainRecyclerView.setLayoutManager(layout);
        mSampleComponentsListBinding.sampleComponentsListMainRecyclerView.setAdapter(mSampleComponentsListAdapter);

    }

    private List<String> buildComponentsList() {
        return new ArrayList<String>() {{
            add("Action Button View");
            add("Executed Percent Bar View");
            add("Expandable Text View");
            add("Expandable Toolbar View");
            add("Info Action Card View");
            add("Simple Informations Card View");
            add("Simple Percentage Bar View");
            add("Simple Request Info Snackbar");
            add("Viewing Users Dialog");
        }};
    }
}
