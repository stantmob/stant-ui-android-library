package br.com.stant.libraries.uilibrary.components.actionbuttonview;

/**
 * Created by denisvieira on 01/08/17.
 */

public enum ActionButtonCardStyleEnum {
    VERTICAL(1), HORIZONTAL(2);

    private final int mValue;

    ActionButtonCardStyleEnum(int value) {
        mValue = value;
    }

    public int getValue(){
        return mValue;
    }
}
