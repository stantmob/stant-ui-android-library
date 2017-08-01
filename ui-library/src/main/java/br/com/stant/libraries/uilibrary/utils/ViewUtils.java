package br.com.stant.libraries.uilibrary.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Created by denisvieira on 31/07/17.
 */

public class ViewUtils {

    public static Integer getColorFromTypedArray(Context context, int[] styleableView, AttributeSet attrs, int styleableAttribute){
        Integer valueFromTyped;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                styleableView,
                0, 0);
        try {
            valueFromTyped = typedArray.getColor(styleableAttribute,0);
        } finally {
            typedArray.recycle();
        }

        return valueFromTyped;
    }

    public static Drawable getDrawableFromTypedArray(Context context, int[] styleableView, AttributeSet attrs, int styleableAttribute){
        Drawable valueFromTyped;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                styleableView,
                0, 0);
        try {
            valueFromTyped = typedArray.getDrawable(styleableAttribute);
        } finally {
            typedArray.recycle();
        }

        return valueFromTyped;
    }

    public static String getStringFromTypedArray(Context context, int[] styleableView, AttributeSet attrs, int styleableAttribute){
        String valueFromTyped = "";
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                styleableView,
                0, 0);
        try {
            valueFromTyped = typedArray.getString(styleableAttribute);
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
}

