package br.com.stant.libraries.stantuiandroid.componentsactivities.userinformationcardview;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.stant.libraries.stantuiandroid.R;
import br.com.stant.libraries.stantuiandroid.databinding.UserInformationCardViewTestActBinding;

/**
 * Created by stant02 on 25/06/18.
 */

public class UserInformationCardViewActivity extends AppCompatActivity {

    private UserInformationCardViewTestActBinding mUserInformationCardViewTestActBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserInformationCardViewTestActBinding = DataBindingUtil.setContentView(this, R.layout.user_information_card_view_test_act);

    }

    public void setCardWithBadgeEnable(String name, String role, String type, String photo, Drawable badgeIcon) {
        setCardInformation(name, role, type, photo);
        mUserInformationCardViewTestActBinding.userInformationCardView.setBadgeEnable(badgeIcon);
    }

    public void setCardWithBadgeDisable(String name, String role, String type, String photo) {
        setCardInformation(name, role, type, photo);
        mUserInformationCardViewTestActBinding.userInformationCardView.setBadgeDisable();
    }

    private void setCardInformation(String name, String role, String type, String photo) {
        mUserInformationCardViewTestActBinding.userInformationCardView.setUserName(name);
        mUserInformationCardViewTestActBinding.userInformationCardView.setUserRole(role);
        mUserInformationCardViewTestActBinding.userInformationCardView.setUserType(type);
        mUserInformationCardViewTestActBinding.userInformationCardView.setUserPhoto(photo);
    }
}
