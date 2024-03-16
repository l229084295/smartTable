package com.bin.david.form.data.format.title;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.bin.david.form.data.column.Column;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.table.TableData;

/**
 * Created by huang on 2017/11/6.
 */

public interface ITitleDrawFormat<T> {

    /**
     *测量宽
     */
    int measureWidth(Column column, TableConfig config);

    /**
     *测量高
     */
    int measureHeight(TableData<T> tableData,TableConfig config);

    /**
     * 绘制
     * @param c 画笔
     * @param column 列信息
     */
    void draw(Canvas c, TableData<T> tableData, Column column, Rect rect, TableConfig config);


}
