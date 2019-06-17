package br.com.stant.libraries.uilibrary.components.userinformationcardview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.squareup.picasso.Picasso;

import br.com.stant.libraries.uilibrary.R;
import br.com.stant.libraries.uilibrary.databinding.UserInformationCardViewBinding;

/**
 * Created by stant02 on 25/06/18.
 */

public class UserInformationCardView extends CardView implements UserInformationCardViewContract {

    private UserInformationCardViewBinding mUserInformationCardViewBinding;

    public UserInformationCardView(Context context) {
        super(context);
        init(context);
    }

    public UserInformationCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UserInformationCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mUserInformationCardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.user_information_card_view, this, true);
        mUserInformationCardViewBinding.setHandler(this);
    }

    @Override
    public void setUserName(String name) {
        mUserInformationCardViewBinding.setName(name);
    }

    @Override
    public void setUserRole(String role) {
        mUserInformationCardViewBinding.setRole(role);
    }

    @Override
    public void setUserType(String type) {
        mUserInformationCardViewBinding.setType(type);
    }

    @Override
    public void setUserPhoto(String photo) {
        mUserInformationCardViewBinding.setPhoto(photo);
    }

    @Override
    public void setBadgeDisable() {
        mUserInformationCardViewBinding.setVisibility(GONE);
    }

    @Override
    public void setBadgeEnable(Drawable badgeIcon) {
        mUserInformationCardViewBinding.setVisibility(VISIBLE);
        mUserInformationCardViewBinding.setBadgeIcon(badgeIcon);
    }

    @Override
    public void showDoubleBadge() {
        mUserInformationCardViewBinding.sameCreatorAndResponsibleBadge.setVisibility(VISIBLE);
    }

    @Override
    public void hideDoubleBadge() {
        mUserInformationCardViewBinding.sameCreatorAndResponsibleBadge.setVisibility(GONE);
    }


}

