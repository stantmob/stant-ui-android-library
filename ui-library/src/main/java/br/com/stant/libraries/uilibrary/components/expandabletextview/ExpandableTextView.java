package br.com.stant.libraries.uilibrary.components.expandabletextview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
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
        mExpandableTextViewBinding.setHandler(this);
        hideLongText(this);
        hiddenArrowIconIfIsEllipsize();
    }


    @Override
    public void expandLongText(View view) {
        mExpandableTextViewBinding.setTextViewState(ExpandableTextViewStyleEnum.EXPANDABLE);
    }


    @Override
    public void hideLongText(View view) {
        mExpandableTextViewBinding.setTextViewState(ExpandableTextViewStyleEnum.HIDDEN);
    }

    @Override
    public void setNoLongTextState() {
        mExpandableTextViewBinding.expandableTextViewArrowContainerLinearLayout.setVisibility(View.GONE);
    }

    @Override
    public void setActiveLongTextState() {
        mExpandableTextViewBinding.expandableTextViewArrowContainerLinearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void setExpandableText(String expandableText) {
        mExpandableTextViewBinding.setExpandableText(expandableText);
    }

    private void hiddenArrowIconIfIsEllipsize(){
        ViewTreeObserver vto = mExpandableTextViewBinding.expandableTextViewHiddenTextView.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(() -> {
            Layout layout = mExpandableTextViewBinding.expandableTextViewHiddenTextView.getLayout();
            if(layout != null) {
                int lines = layout.getLineCount();
                int ellipsisCount = layout.getEllipsisCount(lines-1);
                if ( ellipsisCount == 0)
                    setNoLongTextState();
                else if(ellipsisCount > 0)
                    setActiveLongTextState();
            }
        });

    }
}
