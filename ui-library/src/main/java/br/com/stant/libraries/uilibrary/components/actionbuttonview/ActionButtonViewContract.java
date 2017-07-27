package br.com.stant.libraries.uilibrary.components.actionbuttonview;

import android.view.View;

/**
 * Created by denisvieira on 26/07/17.
 */

public interface ActionButtonViewContract {

    void setOnClickActionButtonListener(OnClickActionButtonListener onClickActionButtonListener);
    void onClickActionButton(View view);

    interface OnClickActionButtonListener {
        void onClick();
    }
}
