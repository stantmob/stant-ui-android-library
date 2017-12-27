package br.com.stant.libraries.stantuiandroid.workspace;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SampleWorkspaceActBinding;

/**
 * Created by denisvieira on 29/10/17.
 */

public class WorkspaceActivity extends AppCompatActivity {

    private  SampleWorkspaceActBinding mSampleWorkspaceActBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSampleWorkspaceActBinding = DataBindingUtil.setContentView(this, R.layout.sample_workspace_act);
        mSampleWorkspaceActBinding.setExecutedPercent(50f);
        mSampleWorkspaceActBinding.setSelectedPercent(25.5f);

        mSampleWorkspaceActBinding.buttonComponent.setButtonText();
        mSampleWorkspaceActBinding.buttonComponent.setButtonShape();
        mSampleWorkspaceActBinding.buttonComponent.setButtonShadowShape();


    }
}
