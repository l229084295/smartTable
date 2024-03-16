package com.bin.david.form.data.format.title;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.table.TableData;
import com.bin.david.form.utils.DrawUtils;

public class MultiLineTitleDrawFormat<T> extends TitleDrawFormat<T> {

    private int width;

    private TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    public MultiLineTitleDrawFormat(int width) {
        this.width = width;
    }

    @Override
    public int measureWidth(Column column, TableConfig config) {
        return width;
    }

    @Override
    public int measureHeight(TableData<T> tableData, TableConfig config) {
        int maxHeight = 0;
        config.getContentStyle().fillPaint(textPaint);
        for (Column column: tableData.getChildColumns()){
            StaticLayout sl = new StaticLayout(column.getColumnName(), textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            int height = sl.getHeight();
            height = Math.max(column.getMinHeight(), height);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    @Override
    public void draw(Canvas c, TableData<T> tableData, Column column, Rect rect, TableConfig config) {
        setTextPaint(c, column, rect, config);
        if (column.getTextAlign() != null) {
            textPaint.setTextAlign(column.getTextAlign());
        }
        int hPadding = (int) (config.getHorizontalPadding() * config.getZoom());
        int realWidth = rect.width() - 2 * hPadding;
        StaticLayout staticLayout = new StaticLayout(column.getColumnName(), textPaint, realWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        c.save();
        c.translate(DrawUtils.getTextCenterX(rect.left + hPadding, rect.right - hPadding, textPaint), rect.top + (rect.height() - staticLayout.getHeight()) / 2);
        staticLayout.draw(c);
        c.restore();
    }

    public void setTextPaint(Canvas c, Column column, Rect rect, TableConfig config) {
        Paint paint = config.getPaint();
        boolean isDrawBg = drawBackground(c, column, rect, config);
        config.getColumnTitleStyle().fillPaint(paint);
        ICellBackgroundFormat<Column> backgroundFormat = config.getColumnCellBackgroundFormat();

        paint.setTextSize(paint.getTextSize() * config.getZoom());
        if (isDrawBg && backgroundFormat.getTextColor(column) != TableConfig.INVALID_COLOR) {
            paint.setColor(backgroundFormat.getTextColor(column));
        }
    }

}
