package br.com.stant.libraries.stantuiandroid.componentsactivities.basictoolbarview;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.BasicToolbarViewTestActBinding;

public class BasicToolbarViewActivity extends AppCompatActivity {

    private BasicToolbarViewTestActBinding mBasicToolbarViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBasicToolbarViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.basic_toolbar_view_test_act);

    }

    public void setTitleAndSubtittle(String title, String subtitle) {
        mBasicToolbarViewTestActBinding.basicToolbar.setTitle(title);
        mBasicToolbarViewTestActBinding.basicToolbar.setSubtitle(subtitle);
    }


}
