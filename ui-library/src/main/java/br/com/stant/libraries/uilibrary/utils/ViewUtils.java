package br.com.stant.libraries.uilibrary.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/**
 * Created by denisvieira on 31/07/17.
 */

public class ViewUtils {

    public static Integer getResourceFromTypedArray(Context context, int[] styleableView, AttributeSet attrs, int styleableAttribute){
        Integer valueFromTyped;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                styleableView,
                0, 0);
        try {
            valueFromTyped = typedArray.getResourceId(styleableAttribute,0);
        } finally {
            typedArray.recycle();
        }

        return valueFromTyped;
    }

    public static Integer getIntegerFromTypedArray(Context context, int[] styleableView, AttributeSet attrs, int styleableAttribute){
        Integer valueFromTyped;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                styleableView,
                0, 0);
        try {
            valueFromTyped = typedArray.getInteger(styleableAttribute,0);
        } finally {
            typedArray.recycle();
        }

        return valueFromTyped;
    }

    public static String getStringFromTypedArray(Context context, int[] styleableView, AttributeSet attrs, int styleableAttribute){
        String titleFromTyped = "";
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                styleableView,
                0, 0);
        try {
            titleFromTyped = typedArray.getString(styleableAttribute);
        } finally {
            typedArray.recycle();
        }
        return titleFromTyped;
    }

    public static boolean getBooleanFromTypedArray(Context context, int[] styleableView, AttributeSet attrs, int styleableAttribute){
        boolean booleanAttribute;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                styleableView,
                0, 0);
        try {
            booleanAttribute = typedArray.getBoolean(styleableAttribute,false);
        } finally {
            typedArray.recycle();
        }
        return booleanAttribute;
    }
}
