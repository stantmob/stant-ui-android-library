package br.com.stant.libraries.uilibrary.components.headerentitycardview;

/**
 * Created by stant02 on 25/06/18.
 */

public interface HeaderEntityCardViewContract {

    void setTitle(String title);
    void setEndAt(String endAt);
    void setStartAt(String startAt);
    void setFirstQuantity(String firstQuantity);
    void setSecondQuantity(String secondQuantity);
    void setThirdQuantity(String thirdQuantity);
    void setCardCritical();
    void setEndAtVisibility(Integer visibility);
    void setArrowVisibility(Integer visibility);

}

