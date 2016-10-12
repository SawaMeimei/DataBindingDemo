package com.example.hasee.mvvm.bean;

import android.app.Activity;
import android.view.View;

import com.example.hasee.mvvm.annoation.BindText;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by hasee on 2016/10/12.
 */
public class BindObtain {

    private Activity $activity;
    public void Bind(Activity activity){
        this.$activity = activity;
    }

    public void notifyUI(){
        if($activity==null){
            throw new RuntimeException("plz bind first");
        }
        try{
            Field[] fields = this.getClass().getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                Field field = fields[i];
                BindText annotation = field.getAnnotation(BindText.class);
                if(annotation!=null){
                    int viewId = annotation.value();
                    View view = $activity.findViewById(viewId);
                    Field fieldSetText = view.getClass().getField("setText");
                    fieldSetText.set($activity,field.get(this));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
