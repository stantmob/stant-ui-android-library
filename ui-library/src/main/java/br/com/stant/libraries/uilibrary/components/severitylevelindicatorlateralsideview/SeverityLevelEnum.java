package br.com.stant.libraries.uilibrary.components.severitylevelindicatorlateralsideview;

/**
 * Created by gabrielrosa on 13/02/17.
 */

public enum SeverityLevelEnum {
    VERY_LIGHT(0), LIGHT(1), NORMAL(2), SERIOUS(3), GRAVE(4);

    private final int mValue;

    SeverityLevelEnum(int value) {
        mValue = value;
    }

    public int getValue(){
        return mValue;
    }

    public static SeverityLevelEnum getEnum(int value) {
        switch (value){
            case 0:
                return SeverityLevelEnum.VERY_LIGHT;
            case 1:
                return SeverityLevelEnum.LIGHT;
            case 2:
                return SeverityLevelEnum.NORMAL;
            case 3:
                return SeverityLevelEnum.SERIOUS;
            case 4:
                return SeverityLevelEnum.GRAVE;
        }
        return null;
    }
}
