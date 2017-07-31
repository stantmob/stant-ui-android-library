package br.com.stant.libraries.uilibrary.components.infoactioncardview;

import android.view.View;

/**
 * Created by stant on 26/07/17.
 */

public interface InfoActionCardViewContract {

    void setOnClickActionCardListener(OnClickActionCardListener onClickActionCardListener);
    void onClickActionCard(View view);
    void setActionActiveTextColor(int color);

    interface OnClickActionCardListener {
        void onClick();
    }
}
