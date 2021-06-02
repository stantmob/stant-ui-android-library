package br.com.stant.libraries.uilibrary.components.simplerequestinfosnackbar;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import br.com.stant.libraries.uilibrary.R;

/**
 * Created by denisvieira on 10/08/17.
 */

public class SimpleRequestInfoSnackbar implements SimpleRequestInfoSnackbarContract{

    private Context mContext;
    private View mView;
    private String mInfoText;
    private SimpleRequestInfoSnackbarTypeEnum mSimpleRequestInfoSnackbarTypeEnum;
    private Snackbar mSnackbar;

    public SimpleRequestInfoSnackbar(@NonNull Context context, View generalView, String infoText, SimpleRequestInfoSnackbarTypeEnum simpleRequestInfoSnackbarTypeEnum) {
        this.mContext = context;
        this.mView = generalView;
        this.mInfoText = infoText;
        this.mSimpleRequestInfoSnackbarTypeEnum = simpleRequestInfoSnackbarTypeEnum;

        makeSnackbar();
    }

    private void makeSnackbar(){
        Snackbar snackbar = Snackbar.make(mView, mInfoText, Snackbar.LENGTH_SHORT);

        View snackbarView = snackbar.getView();
        TextView tv = (TextView) snackbarView.findViewById(R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);

        snackbarView.setBackgroundColor(getBgColor());

        mSnackbar = snackbar;
    }

    private int getBgColor(){
        int bgColor;

        if(mSimpleRequestInfoSnackbarTypeEnum == SimpleRequestInfoSnackbarTypeEnum.SUCCESS){
            bgColor = ContextCompat.getColor(mContext,R.color.green_approved);
        }else{
            bgColor = ContextCompat.getColor(mContext,R.color.red_error);
        }

        return bgColor;
    }

    @Override
    public void showSnackbar() {
        mSnackbar.show();
    }
}
