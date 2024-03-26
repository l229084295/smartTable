package com.bin.david.smarttable;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.form.IForm;
import com.bin.david.form.data.format.IFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.format.draw.MultiLineDrawFormat;
import com.bin.david.form.data.format.grid.BaseGridFormat;
import com.bin.david.form.data.format.grid.ColorGridFormat;
import com.bin.david.form.data.format.selected.BaseSelectFormat;
import com.bin.david.form.data.table.FormTableData;
import com.bin.david.form.data.table.TableData;
import com.bin.david.form.utils.DensityUtils;
import com.bin.david.smarttable.bean.Form;

/**
 * Created by huang on 2018/4/10.
 */

public class FormModeActivity extends AppCompatActivity {

    private SmartTable<Form> table;
    private Form selectForm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_table);
        table = (SmartTable<Form>) findViewById(R.id.table);
        int dp5 = DensityUtils.dp2px(this, 10);
        table.getConfig().setVerticalPadding(0)
                .setHorizontalPadding(0)
                .setColumnTitleVerticalPadding(0)
                .setColumnTitleHorizontalPadding(0)
                .setTextLeftOffset(dp5);
        Form[][] forms = {
                {
                        new Form("姓名", Paint.Align.LEFT, Color.parseColor("#D9000000"), Color.parseColor("#ECFFF5"), true), Form.Empty,
                        new Form("性别", Paint.Align.LEFT), Form.Empty,
                        new Form("出生日期", Paint.Align.LEFT), Form.Empty,
                        new Form("民族", Paint.Align.LEFT), Form.Empty,
                        new Form("婚否", Paint.Align.LEFT), Form.Empty,
                        new Form(1, 4, "照片")
                },
                {
                        new Form("学历", Paint.Align.LEFT), Form.Empty,
                        new Form("专业", Paint.Align.LEFT), new Form(3, 1, ""),
                        new Form("何种语言", Paint.Align.LEFT), new Form(3, 1, "")
                },
                {
                        new Form("籍贯", Paint.Align.LEFT), Form.Empty,
                        new Form(2, 1, "户口所在地", Paint.Align.LEFT), new Form(3, 1, ""),
                        Form.Empty, new Form(2, 1, "")
                },
                {
                        new Form(2, 1, "现住址电话", Paint.Align.LEFT), new Form(8, 1, "")

                },
                {
                        new Form(2, 1, "身份证号码", Paint.Align.LEFT), new Form(4, 1, "")
                        , new Form(2, 1, "暂住证号码", Paint.Align.LEFT), new Form(3, 1, "")
                },
                {
                        new Form(2, 1, "应急联系人及电话", Paint.Align.LEFT), new Form(4, 1, "")
                        , new Form(2, 1, "联系人电话号码", Paint.Align.LEFT), new Form(3, 1, "")
                },
                {
                        new Form(2, 1, "申请职位", Paint.Align.LEFT), new Form(4, 1, "")
                        , new Form(2, 1, "本人要求待遇", Paint.Align.LEFT), new Form(3, 1, "")
                },
                {
                        new Form(11, 1, "家庭成员及主要社会关系")
                },

                {
                        new Form(2, 1, "姓名"),
                        new Form(2, 1, "与本人关系"),
                        new Form(7, 1, "单位及职务"),
                },
                {
                        new Form(2, 1, ""),
                        new Form(2, 1, ""),
                        new Form(7, 1, ""),
                },
                {
                        new Form(2, 1, ""),
                        new Form(2, 1, ""),
                        new Form(7, 1, ""),
                },
                {
                        new Form(2, 1, ""),
                        new Form(2, 1, ""),
                        new Form(7, 1, ""),
                },
                {
                        new Form(2, 1, ""),
                        new Form(2, 1, ""),
                        new Form(7, 1, ""),
                },
                {
                        new Form(2, 1, ""),
                        new Form(2, 1, ""),
                        new Form(7, 1, ""),
                },
                {
                        new Form(2, 1, ""),
                        new Form(2, 1, ""),
                        new Form(7, 1, ""),
                },
                {
                        new Form(11, 1, "工作经历")
                },
                {
                        new Form(4, 1, "起止时间"),
                        new Form(6, 1, "单位"),
                        new Form(1, 1, ""),
                },
                {
                        new Form(4, 1, ""),
                        new Form(6, 1, ""),
                        new Form(1, 1, ""),
                },
                {
                        new Form(4, 1, ""),
                        new Form(6, 1, ""),
                        new Form(1, 1, ""),
                },
                {
                        new Form(4, 1, ""),
                        new Form(6, 1, ""),
                        new Form(1, 1, ""),
                },
                {
                        new Form(11, 1, "本人保证以下资料全部属实，否则本人愿意承担由此造成的一切后果")
                },
                {
                        new Form(2, 1, "申请人签名"), new Form(4, 1, "")
                        , new Form(2, 1, "日期"), new Form(3, 1, "")
                }

        };
        final FormTableData<Form> tableData = FormTableData.create(table, "登记表", 11, forms);
        tableData.setFormat(new IFormat<Form>() {
            @Override
            public String format(Form form) {
                if (form != null) {
                    return form.getName();
                } else {
                    return "";
                }
            }
        });
        table.getConfig().setTableGridFormat(new BaseGridFormat() {
            @Override
            protected boolean isShowHorizontalLine(int col, int row, CellInfo cellInfo) {
                if (row == tableData.getLineSize() - 1) {
                    return false;
                }
                return true;
            }

            @Override
            protected boolean isShowVerticalLine(int col, int row, CellInfo cellInfo) {
                if (row == tableData.getLineSize() - 1) {
                    return false;
                }
                return true;
            }
        });
        table.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.data instanceof IForm) {
                    return ((IForm) cellInfo.data).getBackgroundColor();
                }
                return Color.WHITE;
            }
        });
        table.getConfig().setTableGridFormat(new ColorGridFormat(Color.parseColor("#03954C")));
        table.setTableData(tableData);
        table.setZoom(false);
    }
}
