package br.com.stant.libraries.uilibrary.components.informationcardview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.InformationCardViewBinding;

/**
 * Created by stant02 on 25/06/18.
 */

public class InformationCardView extends CardView implements InformationCardViewContract {

    private InformationCardViewBinding mInformationCardViewBinding;

    public InformationCardView(Context context) {
        super(context);
        mInformationCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.information_card_view, this, true);
    }

    @Override
    public void setTitle(String title) {
        mInformationCardViewBinding.setTitle(title);
    }

    @Override
    public void setType(String type) {
        mInformationCardViewBinding.setTitle(type);
    }

    @Override
    public void setDeadline(String deadline) {
        mInformationCardViewBinding.setDeadline(deadline);
    }

    @Override
    public void setActions(String actions) {
        mInformationCardViewBinding.setActions(actions);
    }

    @Override
    public void setCreatedAt(String createdAt) {
        mInformationCardViewBinding.setCreatedAt(createdAt);
    }

}
