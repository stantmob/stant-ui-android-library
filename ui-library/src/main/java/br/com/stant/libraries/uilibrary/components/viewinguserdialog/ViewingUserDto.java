package br.com.stant.libraries.uilibrary.components.viewinguserdialog;

/**
 * Created by denisvieira on 04/08/17.
 */

public class ViewingUserDto {

    private final String mUserName;
    private final String mUserPhoto;
    private final String mUserFunction;

    public ViewingUserDto(String userName, String userPhoto, String userFunction) {
        this.mUserName = userName;
        this.mUserPhoto = userPhoto;
        this.mUserFunction = userFunction;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getUserPhoto() {
        return mUserPhoto;
    }

    public String getUserFunction() {
        return mUserFunction;
    }

    public boolean hasUserPhoto(){
        if(getUserPhoto() != null)
            return true;

        return false;
    }
}
