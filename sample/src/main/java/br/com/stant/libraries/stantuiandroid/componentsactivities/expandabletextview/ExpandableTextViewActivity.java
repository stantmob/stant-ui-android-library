package br.com.stant.libraries.stantuiandroid.componentsactivities.expandabletextview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ExecutedPercentBarViewTestActBinding;
import br.com.stant.libraries.stantuiandroid.databinding.ExpandableTextViewTestActBinding;

public class ExpandableTextViewActivity extends AppCompatActivity {

    private ExpandableTextViewTestActBinding mExpandableTextViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mExpandableTextViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.expandable_text_view_test_act);
    }

    public void setExpandableText(String text) {
        mExpandableTextViewTestActBinding.setExpandableText(text);

    }
}
