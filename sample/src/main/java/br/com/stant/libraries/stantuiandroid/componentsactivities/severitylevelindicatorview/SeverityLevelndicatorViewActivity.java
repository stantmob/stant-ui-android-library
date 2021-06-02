package br.com.stant.libraries.stantuiandroid.componentsactivities.severitylevelindicatorview;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SeverityLevelIndicatorViewTestActBinding;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorview.SeverityLevelEnum;

public class SeverityLevelndicatorViewActivity extends AppCompatActivity {

    private SeverityLevelIndicatorViewTestActBinding mSeverityLevelIndicatorViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSeverityLevelIndicatorViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.severity_level_indicator_view_test_act);
    }

    public void setSeverityLevel(SeverityLevelEnum level) {
        mSeverityLevelIndicatorViewTestActBinding.severityLevelIndicatorView.setSeverityLevel(level);
    }


}
