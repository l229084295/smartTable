package com.bin.david.form.data.format.grid;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;


public class ColorGridFormat implements IGridFormat{

    private int lineColor;
    private float lineWidth;

    public ColorGridFormat(int lineColor){
        this(lineColor,0.1f);
    }

    public ColorGridFormat(int lineColor, float lineWidth){
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
    }

    @Override
    public void drawContentGrid(Canvas canvas, int col, int row, Rect rect, CellInfo cellInfo, Paint paint) {
        if(lineColor != TableConfig.INVALID_COLOR) {
            paint.setColor(lineColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(lineWidth);
            canvas.drawRect(rect, paint);
        }
    }

    @Override
    public void drawXSequenceGrid(Canvas canvas, int col, Rect rect, Paint paint) {
        if(lineColor != TableConfig.INVALID_COLOR) {
            paint.setColor(lineColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(lineWidth);
            canvas.drawRect(rect, paint);
        }
    }

    @Override
    public void drawYSequenceGrid(Canvas canvas, int row, Rect rect, Paint paint) {
        if(lineColor != TableConfig.INVALID_COLOR) {
            paint.setColor(lineColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(lineWidth);
            canvas.drawRect(rect, paint);
        }
    }

    @Override
    public void drawCountGrid(Canvas canvas, int col, Rect rect, Column column, Paint paint) {
        if(lineColor != TableConfig.INVALID_COLOR) {
            paint.setColor(lineColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(lineWidth);
            canvas.drawRect(rect, paint);
        }
    }

    @Override
    public void drawColumnTitleGrid(Canvas canvas, Rect rect, Column column, int col, Paint paint) {
        if(lineColor != TableConfig.INVALID_COLOR) {
            paint.setColor(lineColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(lineWidth);
            canvas.drawRect(rect, paint);
        }
    }

    @Override
    public void drawTableBorderGrid(Canvas canvas, int left, int top, int right, int bottom, Paint paint) {
        if(lineColor != TableConfig.INVALID_COLOR) {
            paint.setColor(lineColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(lineWidth);
            canvas.drawRect(left,top,right,bottom,paint);
        }
    }

    @Override
    public void drawLeftAndTopGrid(Canvas canvas, Rect rect, Paint paint) {
        if(lineColor != TableConfig.INVALID_COLOR) {
            paint.setColor(lineColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(lineWidth);
            canvas.drawRect(rect, paint);
        }
    }
}
