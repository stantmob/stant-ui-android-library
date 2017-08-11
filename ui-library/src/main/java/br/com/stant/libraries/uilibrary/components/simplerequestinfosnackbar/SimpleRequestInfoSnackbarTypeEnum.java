package br.com.stant.libraries.uilibrary.components.simplerequestinfosnackbar;

/**
 * Created by denisvieira on 26/06/17.
 */

public enum SimpleRequestInfoSnackbarTypeEnum {
    SUCCESS(0),FAILED(1);

    private final int mValue;

    SimpleRequestInfoSnackbarTypeEnum(int value) {
        mValue = value;
    }

    public int getValue(){
        return mValue;
    }
}
