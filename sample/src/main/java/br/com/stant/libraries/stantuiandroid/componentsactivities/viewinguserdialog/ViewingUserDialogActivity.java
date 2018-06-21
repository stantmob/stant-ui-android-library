package br.com.stant.libraries.stantuiandroid.componentsactivities.viewinguserdialog;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ActionButtonViewTestActBinding;
import br.com.stant.libraries.uilibrary.components.actionbuttonview.ActionButtonViewContract.OnClickActionButtonListener;
import br.com.stant.libraries.uilibrary.components.simplerequestinfosnackbar.SimpleRequestInfoSnackbar;
import br.com.stant.libraries.uilibrary.components.simplerequestinfosnackbar.SimpleRequestInfoSnackbarTypeEnum;
import br.com.stant.libraries.uilibrary.components.viewinguserdialog.ViewingUserDto;
import br.com.stant.libraries.uilibrary.components.viewinguserdialog.ViewingUsersDialog;

public class ViewingUserDialogActivity extends AppCompatActivity {

    private ActionButtonViewTestActBinding mActionButtonViewTestActBinding;
    private ViewingUsersDialog mViewingUsersDialog;
    private List<ViewingUserDto> users;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionButtonViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.action_button_view_test_act);

        setUsers();
        mViewingUsersDialog = new ViewingUsersDialog(this);
        mViewingUsersDialog.setViewingUsers(users);

        mActionButtonViewTestActBinding.actionButtonViewHorizontalComponent.setOnClickActionButtonListener(new OnClickActionButtonListener() {
            @Override
            public void onClick() {
                mViewingUsersDialog.show();
            }
        });

    }

    private void setUsers() {
        users = new ArrayList<>();
        users.add(new ViewingUserDto("User 1", null, "Role 1"));
        users.add(new ViewingUserDto("User 2", null, "Role 2"));
        users.add(new ViewingUserDto("User 3", null, "Role 3"));
    }
}
