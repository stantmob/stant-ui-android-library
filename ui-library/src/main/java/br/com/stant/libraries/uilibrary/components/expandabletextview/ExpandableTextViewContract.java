package br.com.stant.libraries.uilibrary.components.expandabletextview;

import android.view.View;

/**
 * Created by denisvieira on 26/07/17.
 */

public interface ExpandableTextViewContract {

    void showExpandableTextState(View view);
    void showHiddenTextState(View view);
    void setNoLongTextState();
    void setActiveLongTextState();
    void setExpandableText(String expandableText);

}
