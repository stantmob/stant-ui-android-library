package br.com.stant.libraries.uilibrary.components.informationcardview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorlateralsideview.SeverityLevelEnum;
import br.com.stant.libraries.uilibrary.components.severitylevelindicatorlateralsideview.SeverityLevelIndicatorLateralSideView;
import br.com.stant.libraries.uilibrary.databinding.InformationCardViewBinding;

/**
 * Created by stant02 on 25/06/18.
 */

public class InformationCardView extends CardView implements InformationCardViewContract {

    private InformationCardViewBinding mInformationCardViewBinding;
    private SeverityLevelIndicatorLateralSideView mSeverityLevelIndicatorLateralSideView;

    public InformationCardView(Context context) {
        super(context);
        init(context);
    }

    public InformationCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InformationCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mInformationCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.information_card_view, this, true);
        mInformationCardViewBinding.setHandler(this);
        mSeverityLevelIndicatorLateralSideView = mInformationCardViewBinding.informationCardViewSeverityLevel;
    }

    private void setWarningVisibility(Integer visibility) {
        mInformationCardViewBinding.informationCardViewWarningImageView.setVisibility(visibility);
    }

    @Override
    public void setTitle(String title) {
        mInformationCardViewBinding.setTitle(title);
    }

    @Override
    public void setType(String type) {
        mInformationCardViewBinding.setType(type);
    }

    @Override
    public void setOccurrenceID(String occurrenceID) {
        mInformationCardViewBinding.setOccurrenceID(occurrenceID);
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

    @Override
    public void setSeverityLevel(Integer level) {
        SeverityLevelEnum severityLevelEnum = SeverityLevelEnum.getEnum(level);
        mSeverityLevelIndicatorLateralSideView.setSeverityLevel(severityLevelEnum);
    }

    @Override
    public void setDarkCardStyle() {
        mInformationCardViewBinding.informationCard.setCardBackgroundColor(getResources().getColor(R.color.blue_02));
        mInformationCardViewBinding.informationCardViewTitleText.setTextColor(getResources().getColor(R.color.white));
        mInformationCardViewBinding.informationCardViewActions.setTextColor(getResources().getColor(R.color.white));
        mInformationCardViewBinding.informationCardDateCard.setBackground(getResources().getDrawable(R.drawable.shape_round_white));
        mInformationCardViewBinding.informationCardSecondDateCard.setBackground(getResources().getDrawable(R.drawable.shape_round_white));
        mInformationCardViewBinding.informationCardViewCreatedAtDate.setTextColor(getResources().getColor(R.color.blue_02));
        mInformationCardViewBinding.informationCardViewDeadlineDate.setTextColor(getResources().getColor(R.color.blue_02));
        mInformationCardViewBinding.informationCardViewWarningImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_warning_white));
    }

    @Override
    public void setDeadlineVisibility(Integer visibility) {
        mInformationCardViewBinding.informationCardSecondDateCard.setVisibility(visibility);
    }

    @Override
    public void setArrowVisibility(Integer visibility) {
        mInformationCardViewBinding.informationCardViewArrowImageView.setVisibility(visibility);
    }

    @Override
    public void setServiceInspectionFormFilledId(Long serviceInspectionFormFilledId) {
        if (serviceInspectionFormFilledId != null) {
            setWarningVisibility(View.VISIBLE);
        } else {
            setWarningVisibility(View.GONE);
        }
    }


}

