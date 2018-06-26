package br.com.stant.libraries.stantuiandroid.componentsactivities.severitylevelindicatorlateralsideview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SeverityLevelIndicatorLateralSideViewTestActBinding;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorlateralsideview.SeverityLevelEnum;

public class SeverityLevelndicatorLateralSideViewActivity extends AppCompatActivity {

    private SeverityLevelIndicatorLateralSideViewTestActBinding mSeverityLevelIndicatorLateralSideViewTestActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSeverityLevelIndicatorLateralSideViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.severity_level_indicator_lateral_side_view_test_act);

    }

    public void setSeverityLevel(SeverityLevelEnum level) {
        mSeverityLevelIndicatorLateralSideViewTestActBinding.severityLevelIndicatorLateralSideView.setSeverityLevel(level);
    }

}
