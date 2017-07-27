package br.com.stant.libraries.uilibrary.components.expandabletextview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.ExpandableTextViewBinding;

/**
 * Created by denisvieira on 26/07/17.
 */

public class ExpandableTextView extends LinearLayout implements ExpandableTextViewContract{

//    private Expa

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ExpandableTextViewBinding expandableTextViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.expandable_text_view, this, true);
        expandableTextViewBinding.setHandler(this);
    }

    @Override
    public void setExpandableTextState() {

    }

    @Override
    public void setHiddenTextState() {

    }
}
