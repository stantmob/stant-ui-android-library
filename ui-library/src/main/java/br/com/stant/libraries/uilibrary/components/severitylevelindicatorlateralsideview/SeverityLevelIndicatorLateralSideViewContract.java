package br.com.stant.libraries.uilibrary.components.severitylevelindicatorlateralsideview;

import android.view.View;

/**
 * Created by stant02 on 25/06/18.
 */
public interface SeverityLevelIndicatorLateralSideViewContract {
    void setSeverityLevel(SeverityLevelEnum severityLevelEnum);
    void setVeryLightSeverityLevelConfiguration(View view);
    void setLightSeverityLevelConfiguration(View view);
    void setNormalSeverityLevelConfiguration(View view);
    void setSeriousSeverityLevelConfiguration(View view);
    void setGraveSeverityLevelConfiguration(View view);
    void onChangeSeverityLevel(SeverityLevelEnum severityLevelEnum);
    void setOnChangeSeverityLevel(OnChangeSeverityLevel onChangeSeverityLevel);

    interface OnChangeSeverityLevel{
        void onChange(SeverityLevelEnum severityLevelEnum);
    }
}