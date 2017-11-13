package br.com.stant.libraries.uilibrary.components.severitylevelindicatorview;

import android.view.View;

/**
 * Created by denisvieira on 24/10/17.
 */

public interface SeverityLevelIndicatorViewContract {
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
