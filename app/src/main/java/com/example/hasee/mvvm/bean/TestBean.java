package com.example.hasee.mvvm.bean;

import com.example.hasee.mvvm.R;
import com.example.hasee.mvvm.annoation.BindText;

/**
 * Created by hasee on 2016/10/12.
 */
public class TestBean extends BindObtain {

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
        notifyUI();
    }

    @BindText(R.id.tv_content)
    private String textContent;
}
