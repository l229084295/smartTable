package com.bin.david.smarttable.bean;

import android.graphics.Color;
import android.graphics.Paint;

import com.bin.david.form.data.form.IForm;

/**
 * Created by huang on 2018/4/10.
 */

public class Form implements IForm {

    private int spanWidthSize =1;
    private int spanHeightSize = 1;
    private String name;
    public static Form  Empty = new Form("");
    private Paint.Align align;

    private int textColor = Color.parseColor("#B2000000");
    private int backgroundColor = Color.WHITE;
    private boolean isBold;

    public Form(int spanWidthSize, int spanHeightSize, String name) {
        this.spanWidthSize = spanWidthSize;
        this.spanHeightSize = spanHeightSize;
        this.name = name;
    }

    public Form(int spanWidthSize, int spanHeightSize, String name, Paint.Align align) {
        this.spanWidthSize = spanWidthSize;
        this.spanHeightSize = spanHeightSize;
        this.name = name;
        this.align = align;
    }

    public Form(String name) {
        this.name = name;
    }

    public Form(String name, Paint.Align align) {
        this.name = name;
        this.align = align;
    }

    public Form(String name, Paint.Align align,int textColor,int backgroundColor,boolean isBold){
        this(name, align,textColor,backgroundColor,isBold,1,1);
    }

    public Form(String name, Paint.Align align,int textColor,int backgroundColor,boolean isBold,int spanWidthSize, int spanHeightSize){
        this.name = name;
        this.align = align;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.isBold = isBold;
        this.spanWidthSize = spanWidthSize;
        this.spanHeightSize = spanHeightSize;
    }

    public void setAlign(Paint.Align align) {
        this.align = align;
    }

    public void setSpanWidthSize(int spanWidthSize) {
        this.spanWidthSize = spanWidthSize;
    }

    public void setSpanHeightSize(int spanHeightSize) {
        this.spanHeightSize = spanHeightSize;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSpanWidthSize() {
        return spanWidthSize;
    }

    @Override
    public int getSpanHeightSize() {
        return spanHeightSize;
    }

    @Override
    public Paint.Align getAlign() {
        if(align == null) {
            return Paint.Align.CENTER;
        }else {
            return align;
        }
    }

    @Override
    public int getTextColor() {
        return textColor;
    }

    @Override
    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public boolean isBold() {
        return isBold;
    }
}
