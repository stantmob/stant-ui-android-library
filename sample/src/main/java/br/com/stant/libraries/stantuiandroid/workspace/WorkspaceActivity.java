package br.com.stant.libraries.stantuiandroid.workspace;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.SampleWorkspaceActBinding;
import br.com.stant.libraries.uilibrary.components.viewinguserdialog.ViewingUserDto;
import br.com.stant.libraries.uilibrary.components.viewinguserdialog.ViewingUsersDialog;

/**
 * Created by denisvieira on 29/10/17.
 */

public class WorkspaceActivity extends AppCompatActivity {

    private  SampleWorkspaceActBinding mSampleWorkspaceActBinding;
    private ViewingUsersDialog mViewingUsersDialog;
    private List<ViewingUserDto> users;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSampleWorkspaceActBinding = DataBindingUtil.setContentView(this, R.layout.sample_workspace_act);

        mSampleWorkspaceActBinding.setExecutedPercent(50f);
        mSampleWorkspaceActBinding.setSelectedPercent(25.5f);
        mSampleWorkspaceActBinding.setButtonText("Button Text");
        mSampleWorkspaceActBinding.setButtonShape(getResources().getDrawable(R.drawable.shape_round_blue));
        mSampleWorkspaceActBinding.setButtonShadowShape(getResources().getDrawable(R.drawable.shape_round_dark_blue));

        setUsers();
        mViewingUsersDialog = new ViewingUsersDialog(this);
        mViewingUsersDialog.setViewingUsers(users);

        mSampleWorkspaceActBinding.buttonComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mViewingUsersDialog.show();
            }
        });

    }

    private void setUsers() {
        List<ViewingUserDto> users;
        users = new ArrayList<>();
        users.add(new ViewingUserDto("User 1", null, "Role 1"));
        users.add(new ViewingUserDto("User 2", null, "Role 2"));
        users.add(new ViewingUserDto("User 3", null, "Role 3"));
    }

}
