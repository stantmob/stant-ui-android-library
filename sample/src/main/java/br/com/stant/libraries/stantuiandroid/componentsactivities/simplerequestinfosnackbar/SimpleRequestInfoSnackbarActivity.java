package br.com.stant.libraries.stantuiandroid.componentsactivities.simplerequestinfosnackbar;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ActionButtonViewTestActBinding;
import br.com.stant.libraries.uilibrary.components.simplerequestinfosnackbar.SimpleRequestInfoSnackbar;
import br.com.stant.libraries.uilibrary.components.simplerequestinfosnackbar.SimpleRequestInfoSnackbarTypeEnum;

public class SimpleRequestInfoSnackbarActivity extends AppCompatActivity {

    private ActionButtonViewTestActBinding mActionButtonViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionButtonViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.action_button_view_test_act);

        mActionButtonViewTestActBinding.actionButtonViewHorizontalComponent.setOnClickActionButtonListener(
                () -> {
                    SimpleRequestInfoSnackbar snackbar = new SimpleRequestInfoSnackbar(SimpleRequestInfoSnackbarActivity.this,
                            mActionButtonViewTestActBinding.getRoot(), "Success message", SimpleRequestInfoSnackbarTypeEnum.SUCCESS);
                    snackbar.showSnackbar();
                });

        mActionButtonViewTestActBinding.actionButtonViewVerticalComponent.setOnClickActionButtonListener(
                () -> {
                    SimpleRequestInfoSnackbar snackbar = new SimpleRequestInfoSnackbar(SimpleRequestInfoSnackbarActivity.this,
                            mActionButtonViewTestActBinding.getRoot(), "Fail message", SimpleRequestInfoSnackbarTypeEnum.FAILED);
                    snackbar.showSnackbar();
                });
    }


}
