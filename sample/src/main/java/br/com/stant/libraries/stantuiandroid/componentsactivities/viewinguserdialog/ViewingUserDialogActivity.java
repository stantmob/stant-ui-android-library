package br.com.stant.libraries.stantuiandroid.componentsactivities.viewinguserdialog;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.ActionButtonViewTestActBinding;
import br.com.stant.libraries.uilibrary.components.viewinguserdialog.ViewingUserDto;
import br.com.stant.libraries.uilibrary.components.viewinguserdialog.ViewingUsersDialog;

public class ViewingUserDialogActivity extends AppCompatActivity {

    private ActionButtonViewTestActBinding mActionButtonViewTestActBinding;
    private ViewingUsersDialog mViewingUsersDialog;
    private List<ViewingUserDto> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewingUsersDialog = new ViewingUsersDialog(this);

        mActionButtonViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.action_button_view_test_act);

        mActionButtonViewTestActBinding.actionButtonViewHorizontalComponent.setOnClickActionButtonListener(
                () -> mViewingUsersDialog.show()
        );

    }

    public void setUsers(ViewingUserDto user1, ViewingUserDto user2) {
        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        mViewingUsersDialog.setViewingUsers(users);
    }


}
