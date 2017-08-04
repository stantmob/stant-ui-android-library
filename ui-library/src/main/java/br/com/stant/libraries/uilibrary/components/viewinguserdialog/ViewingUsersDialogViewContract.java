package br.com.stant.libraries.uilibrary.components.viewinguserdialog;

import android.view.View;

import java.util.List;

/**
 * Created by denisvieira on 04/08/17.
 */

public interface ViewingUsersDialogViewContract {
    void setViewingUsers(List<ViewingUserDto> viewingUsers);
    void closeDialog(View view);
}
