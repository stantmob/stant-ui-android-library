package br.com.stant.libraries.uilibrary.components.expandabletextview;

import android.view.View;

/**
 * Created by denisvieira on 26/07/17.
 */

public interface ExpandableTextViewContract {

    void setExpandableTextState(View view);
    void setHiddenTextState(View view);
    void setNoLongTextState();
    void setExpandableText(String expandableText);

}
