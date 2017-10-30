package br.com.stant.libraries.stantuiandroid.samplecomponentdetail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SampleComponentDetailActBinding;
import br.com.stant.libraries.stantuiandroid.entities.UiComponent;

/**
 * Created by denisvieira on 29/10/17.
 */

public class SampleComponentDetailActivity extends AppCompatActivity {

    public static final String KEY_COMPONENT_OBJECT = "key-COMPONENT";
    private SampleComponentDetailActBinding mSampleComponentDetailActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSampleComponentDetailActBinding = DataBindingUtil.setContentView(this, R.layout.sample_component_detail_act);


        UiComponent component = (UiComponent) getIntent().getSerializableExtra(SampleComponentDetailActivity.KEY_COMPONENT_OBJECT);

        mSampleComponentDetailActBinding.sampleComponentDetailMainContainerMarkdownView
                .loadMarkdownFile(component.getMarkdownDocUrl());
        mSampleComponentDetailActBinding.setComponentName(component.getName());


        if (mSampleComponentDetailActBinding.sampleComponentDetailMainToolbar != null) {
            setSupportActionBar(mSampleComponentDetailActBinding.sampleComponentDetailMainToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
           getSupportActionBar().setDisplayShowTitleEnabled(false);
            mSampleComponentDetailActBinding.sampleComponentDetailMainToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mSampleComponentDetailActBinding.sampleComponentDetailMainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }


    }
}
