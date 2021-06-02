package br.com.stant.libraries.stantuiandroid.componentsactivities.expandabletextview;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ExpandableTextViewTestActBinding;

public class ExpandableTextViewActivity extends AppCompatActivity {

    private ExpandableTextViewTestActBinding mExpandableTextViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String EXPANDABLE_TEXT = this.getResources().getString(R.string.expandable_text);

        mExpandableTextViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.expandable_text_view_test_act);
        setExpandableText(EXPANDABLE_TEXT);
    }

    private void setExpandableText(String text) {
        mExpandableTextViewTestActBinding.expandableTextView.setExpandableText(text);
    }


}
