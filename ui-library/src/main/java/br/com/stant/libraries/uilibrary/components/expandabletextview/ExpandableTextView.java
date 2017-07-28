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
    private ExpandableTextViewBinding mExpandableTextViewBinding;

    public ExpandableTextView(Context context) {
        super(context);
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mExpandableTextViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.expandable_text_view, this, true);

    }

    @Override
    public void setExpandableTextState() {

    }

    @Override
    public void setHiddenTextState() {

    }

//    public ExpandableTextView(Context context) {
//        this(context);
//        ExpandableTextViewBinding expandableTextViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.expandable_text_view, this, true);
//    }
//
//    public ExpandableTextView(Context context, AttributeSet attrs) {
//        this(context, attrs, R.attr.ExpandableTextView);
//    }
//
//    public ExpandableTextView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        init(context, attrs, defStyle);
//    }
//    private void init(Context context, AttributeSet attrs, int defStyle) {
//    }

}
