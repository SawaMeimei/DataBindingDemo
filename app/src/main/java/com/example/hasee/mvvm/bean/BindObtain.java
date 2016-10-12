package com.example.hasee.mvvm.bean;

import android.app.Activity;
import android.view.View;

import com.example.hasee.mvvm.annoation.BindText;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hasee on 2016/10/12.
 */
public class BindObtain {

    public ArrayList<BindBlock> arr = new ArrayList<>();
    public void Bind(Activity activity) {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                BindText annotation = field.getAnnotation(BindText.class);
                if (annotation != null) {
                    int viewId = annotation.value();
                    View view = activity.findViewById(viewId);
                    Field fieldSetText = view.getClass().getField("setText");
                    arr.add(new BindBlock(fieldSetText, field, view));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notifyUI() {
        try {
            for (BindBlock block : arr) {
                block.fieldSetText.set(block.bindView, block.fieldValue.get(this));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
