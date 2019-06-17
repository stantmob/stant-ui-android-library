package br.com.stant.libraries.uilibrary.components.userinformationcardview;

import android.graphics.drawable.Drawable;

/**
 * Created by stant02 on 25/06/18.
 */

public interface UserInformationCardViewContract {

    void setUserName(String name);

    void setUserRole(String role);

    void setUserType(String type);

    void setUserPhoto(String photo);

    void setBadgeDisable();

    void setBadgeEnable(Drawable badgeIcon);

    void showDoubleBadge();

    void hideDoubleBadge();


}
