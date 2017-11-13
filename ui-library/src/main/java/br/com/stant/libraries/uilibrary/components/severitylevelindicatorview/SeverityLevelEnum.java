package br.com.stant.libraries.uilibrary.components.severitylevelindicatorview;

/**
 * Created by gabrielrosa on 13/02/17.
 */

public enum SeverityLevelEnum {
    VERY_LIGHT(1), LIGHT(2), NORMAL(3), SERIOUS(4), GRAVE(5);

    private final int mValue;

    SeverityLevelEnum(int value) {
        mValue = value;
    }

    public int getValue(){
        return mValue;
    }

    public static SeverityLevelEnum getEnum(int value) {
        switch (value){
            case 1:
                return SeverityLevelEnum.VERY_LIGHT;
            case 2:
                return SeverityLevelEnum.LIGHT;
            case 3:
                return SeverityLevelEnum.NORMAL;
            case 4:
                return SeverityLevelEnum.SERIOUS;
            case 5:
                return SeverityLevelEnum.GRAVE;
        }
        return null;
    }
}
