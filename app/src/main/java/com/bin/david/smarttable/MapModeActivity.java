package com.bin.david.smarttable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.format.draw.MultiLineDrawFormat;
import com.bin.david.form.data.format.grid.BaseGridFormat;
import com.bin.david.form.data.format.grid.ColorGridFormat;
import com.bin.david.form.data.format.title.MultiLineTitleDrawFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.style.LineStyle;
import com.bin.david.form.data.table.MapTableData;
import com.bin.david.form.utils.DensityUtils;
import com.bin.david.smarttable.utils.JsonHelper;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.bin.david.smarttable.utils.JsonHelper.reflect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapModeActivity extends AppCompatActivity {

    public SmartTable table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_table);
        FontStyle.setDefaultTextSize(DensityUtils.sp2px(this, 15));
        table = findViewById(R.id.table);
        TableConfig config = table.getConfig();
        //设置content style
        //设置横向padding
        config.setHorizontalPadding(0);
        //设置纵向padding
        config.setVerticalPadding(0);
        //设置标题栏padding
        config.setColumnTitleHorizontalPadding(0);
        config.setColumnTitleVerticalPadding(0);

        //设置表格线颜色
        config.setTableGridFormat(new ColorGridFormat(ContextCompat.getColor(MapModeActivity.this, R.color.github_con_1)));
        config.setShowXSequence(false);//隐藏x轴标签
        config.setShowYSequence(false);//隐藏Y轴数字
        //隐藏表名称
        config.setShowTableTitle(false);
        //设置标题栏背景颜色
        config.setColumnTitleBackground(new BaseBackgroundFormat(ContextCompat.getColor(MapModeActivity.this, R.color.github_con_2)));
        //设置内容格子背景颜色
        config.setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                return ContextCompat.getColor(MapModeActivity.this, R.color.white);
            }
        });
        getData();

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, AnnotationModeActivity.class);
        startActivity(intent);
    }

    public void getData() {
        //直接设置Map
        List<Object> list = new ArrayList<>();
        Map<String, Object> objectMap = new LinkedHashMap<>();

        for (int i = 0; i < 8; i++) {
            Map<String, Object> map = getStringObjectMap();
            list.add(map);
        }
        List<Object> data = new ArrayList<>();
        objectMap.put("村（社区）", "古井村");
        objectMap.put("data", list);
        data.add(objectMap);
        MapTableData tableData = MapTableData.create("测试", data);
        //设置内容宽度并自动换行
        tableData.setDrawFormat(new MultiLineDrawFormat(50));
        //设置栏目标题宽度并自动换行
        tableData.setTitleDrawFormat(new MultiLineTitleDrawFormat(50));
        table.setTableData(tableData);

        //Json
//        String json="{\"name\":\"BeJson\",\"url\":\"http://\",\"page\":88,\"isNonProfit\":true,\"links\":[{\"name\":\"Google\",\"url\":\"http://\"},{\"name\":\"Baidu\",\"url\":\"http://\"},{\"name\":\"SoSo\",\"url\":\"http://\"},{\"name\":\"Google\",\"url\":\"http://\"},{\"name\":\"Baidu\",\"url\":\"http://\"},{\"name\":\"SoSo\",\"url\":\"http://\"},{\"name\":\"Google\",\"url\":\"http://\"},{\"name\":\"Baidu\",\"url\":\"http://\"},{\"name\":\"SoSo\",\"url\":\"http://\"},{\"name\":\"Google\",\"url\":\"http://\"},{\"name\":\"Baidu\",\"url\":\"http://\"},{\"name\":\"SoSo\",\"url\":\"http://\"}]}";
//        MapTableData tableData = MapTableData.create("",JsonHelper.jsonToMapList(json));
//        table.setTableData(tableData);
    }

    private static Map<String, Object> getStringObjectMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("产品类别", "农户小额信用贷款余额（万元）");
        map.put("户数", 158);
        map.put("建档数", 87);
        map.put("授信数", "87");
        map.put("用信数", "87");
        map.put("当前完成值", "96.5");
        map.put("市场边界余额测算值", "216.22");
        map.put("增量贷款空间", "119.72");
        map.put("取值说明", "农户户籍数15户");
        return map;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
