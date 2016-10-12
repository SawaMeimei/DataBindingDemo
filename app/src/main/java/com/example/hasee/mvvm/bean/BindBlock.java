package com.example.hasee.mvvm.bean;

import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by hasee on 2016/10/12.
 */
public class BindBlock {

    public Field fieldSetText;
    public Field fieldValue;
    public View bindView;

    public BindBlock(Field fieldSetText, Field fieldValue, View bindView) {
        this.fieldSetText = fieldSetText;
        this.fieldValue = fieldValue;
        this.bindView = bindView;
    }
}
