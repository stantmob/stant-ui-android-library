package br.com.stant.libraries.uilibrary.components.expandabletextview;

/**
 * Created by denisvieira on 01/08/17.
 */

public enum ExpandableTextViewStyleEnum {
    EXPANDABLE(1), HIDDEN(2);

    private final int mValue;

    ExpandableTextViewStyleEnum(int value) {
        mValue = value;
    }

    public int getValue(){
        return mValue;
    }
}
