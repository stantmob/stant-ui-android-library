package br.com.stant.libraries.stantuiandroid.samplecomponentdetail;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SampleComponentDetailActBinding;
import br.com.stant.libraries.stantuiandroid.entities.UiComponent;

import static com.annimon.stream.Optional.ofNullable;

/**
 * Created by denisvieira on 29/10/17.
 */

public class SampleComponentDetailActivity extends AppCompatActivity {

    public static final String KEY_COMPONENT_OBJECT = "key-COMPONENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SampleComponentDetailActBinding mSampleComponentDetailActBinding = DataBindingUtil.setContentView(this, R.layout.sample_component_detail_act);


        UiComponent component = (UiComponent) getIntent().getSerializableExtra(SampleComponentDetailActivity.KEY_COMPONENT_OBJECT);

        mSampleComponentDetailActBinding.sampleComponentDetailMainContainerMarkdownView
                .loadMarkdownFile(component.getMarkdownDocUrl());
        mSampleComponentDetailActBinding.setComponentName(component.getName());


        if (mSampleComponentDetailActBinding.sampleComponentDetailMainToolbar != null) {
            setSupportActionBar(mSampleComponentDetailActBinding.sampleComponentDetailMainToolbar);

            ofNullable(getSupportActionBar()).ifPresent(
                    (supportActionBar) -> {
                        supportActionBar.setDisplayHomeAsUpEnabled(true);
                        supportActionBar.setDisplayShowHomeEnabled(true);
                        supportActionBar.setDisplayShowTitleEnabled(false);
                    }
            );

            mSampleComponentDetailActBinding.sampleComponentDetailMainToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mSampleComponentDetailActBinding.sampleComponentDetailMainToolbar.setNavigationOnClickListener((view) -> onBackPressed());
        }
    }


}
