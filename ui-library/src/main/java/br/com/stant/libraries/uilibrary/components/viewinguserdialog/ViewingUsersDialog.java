package br.com.stant.libraries.uilibrary.components.viewinguserdialog;

import android.app.Dialog;
import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ViewingUsersDialogBinding;

/**
 * Created by denisvieira on 04/08/17.
 */

public class ViewingUsersDialog extends Dialog implements ViewingUsersDialogViewContract{

    private ViewingUsersDialogBinding mViewingUsersDialogBinding;
    private ViewingUsersDialogAdapter mViewingUsersDialogAdapter;
    private List<ViewingUserDto> viewingUsersDto;

    public ViewingUsersDialog(@NonNull Context context) {
        super(context);
        init();
    }

    private void init(){
        mViewingUsersDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                        R.layout.viewing_users_dialog, null, false);

        this.setContentView(mViewingUsersDialogBinding.getRoot());
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        mViewingUsersDialogBinding.setHandler(this);
        configureViewingUsersAdapter();
        setDialogGravity();
    }

    @Override
    public void setViewingUsers(List<ViewingUserDto> viewingUsers) {
        viewingUsersDto = viewingUsers;
        mViewingUsersDialogAdapter.replaceData(viewingUsers);
    }

    @Override
    public void closeDialog(View view) {
        this.dismiss();
    }

    @Override
    public void show(){
        super.show();
    }

    private void configureViewingUsersAdapter(){
        mViewingUsersDialogAdapter = new ViewingUsersDialogAdapter(getContext(), new ArrayList<ViewingUserDto>(0), this);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mViewingUsersDialogBinding.viewingUsersDialogRecycler.setLayoutManager(layout);
        mViewingUsersDialogBinding.viewingUsersDialogRecycler.setAdapter(mViewingUsersDialogAdapter);
    }

    private void setDialogGravity(){
        Window window = this.getWindow();
        WindowManager.LayoutParams windowLayoutParams = window.getAttributes();
        windowLayoutParams.gravity = Gravity.TOP;
        window.setAttributes(windowLayoutParams);
    }

}
