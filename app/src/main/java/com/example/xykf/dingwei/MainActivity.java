package com.example.xykf.dingwei;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.xykf.dingwei.JDConst.INDEX_INVALID;

public class MainActivity extends AppCompatActivity {

    TextView close;
    TextView title;
    TextView province;
    TextView city;
    TextView area;
    String[] sheng = new String[]{"省1", "省2", "省3", "省4", "省5"};
    String[] shi = new String[]{"全部市", "市1", "市2", "市3", "市4", "市5"};
    String[] shi1 = new String[]{"市1", "市2", "市3", "市4", "市5"};
    String[] xian = new String[]{"全部县", "县1", "县2", "县3", "县4", "县5"};
    String[] xian1 = new String[]{"县1", "县2", "县3", "县4", "县5"};
    private ListView shenglistView;
    private ListView shilistView;
    private ListView xianlistView;
    private Button all;
    private Button esle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        all = findViewById(R.id.all);
        esle = findViewById(R.id.esle);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 以特定的风格创建一个dialog
                final Dialog dialog = new Dialog(MainActivity.this,R.style.MyDialog);
                // 加载dialog布局view
                View testView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
                // 设置外部点击 取消dialog
                dialog.setCancelable(true);
                // 获得窗体对象
                Window window = dialog.getWindow();
                // 设置窗体的对齐方式
                window.setGravity(Gravity.BOTTOM);
                // 设置窗体动画
                window.setWindowAnimations(R.style.AnimBottom);
                // 设置窗体的padding
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                //lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.height = 1200;
                window.setAttributes(lp);
                dialog.setContentView(testView);
                dialog.show();

                close = testView.findViewById(R.id.close_img);
                title = testView.findViewById(R.id.title);
                province = testView.findViewById(R.id.province_tv);
                city = testView.findViewById(R.id.city_tv);
                area = testView.findViewById(R.id.area_tv);
                shenglistView = testView.findViewById(R.id.sheng_listview);
                shilistView = testView.findViewById(R.id.shi_listview);
                xianlistView = testView.findViewById(R.id.xian_listview);

                ListViewApater listViewApater = new ListViewApater(MainActivity.this, sheng);
                shenglistView.setAdapter(listViewApater);

                shenglistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        province.setText(sheng[i]);
                        shenglistView.setVisibility(View.GONE);
                        city.setVisibility(View.VISIBLE);
                        ListViewApater listViewApater = new ListViewApater(MainActivity.this, shi1);
                        shilistView.setAdapter(listViewApater);
                    }
                });

                shilistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        city.setText(shi1[i]);
                        shilistView.setVisibility(View.GONE);
                        if (!city.getText().toString().equals("全部市")) {
                            area.setVisibility(View.VISIBLE);
                            ListViewApater listViewApater = new ListViewApater(MainActivity.this, xian1);
                            xianlistView.setAdapter(listViewApater);
                        }
                    }
                });
                xianlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        area.setText(xian1[i]);
                    }
                });

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!province.getText().toString().equals("请选择") && !city.getText().toString().equals("请选择") && !area.getText().toString().equals("请选择")) {
                            title.setText("省" + province.getText().toString() + ":市" + city.getText().toString() + ":县" + area.getText().toString());
                        } else {
                            Toast.makeText(MainActivity.this, "请全部选完", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });


        esle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 以特定的风格创建一个dialog
                final Dialog dialog = new Dialog(MainActivity.this,R.style.MyDialog);
                // 加载dialog布局view
                View testView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
                // 设置外部点击 取消dialog
                dialog.setCancelable(true);
                // 获得窗体对象
                Window window = dialog.getWindow();
                // 设置窗体的对齐方式
                window.setGravity(Gravity.BOTTOM);
                // 设置窗体动画
                window.setWindowAnimations(R.style.AnimBottom);
                // 设置窗体的padding
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                //lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.height = 1200;
                window.setAttributes(lp);
                dialog.setContentView(testView);
                dialog.show();

                close = testView.findViewById(R.id.close_img);
                title = testView.findViewById(R.id.title);
                province = testView.findViewById(R.id.province_tv);
                city = testView.findViewById(R.id.city_tv);
                area = testView.findViewById(R.id.area_tv);
                shenglistView = testView.findViewById(R.id.sheng_listview);
                shilistView = testView.findViewById(R.id.shi_listview);
                xianlistView = testView.findViewById(R.id.xian_listview);

                final ListViewApater listViewApater = new ListViewApater(MainActivity.this, sheng);
                shenglistView.setAdapter(listViewApater);

                shenglistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    private ListViewApater listViewApater;

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        province.setText(sheng[i]);
                        shenglistView.setVisibility(View.GONE);
                        city.setVisibility(View.VISIBLE);
                        listViewApater = new ListViewApater(MainActivity.this, shi);
                        shilistView.setAdapter(listViewApater);
                    }
                });

                shilistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        city.setText(shi[i]);
                        shilistView.setVisibility(View.GONE);
                        if (!city.getText().toString().equals("全部市")) {
                            area.setVisibility(View.VISIBLE);
                            ListViewApater listViewApater = new ListViewApater(MainActivity.this, xian);
                            xianlistView.setAdapter(listViewApater);
                        }
                    }
                });
                xianlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                       /* if (listViewApater.getSelectedPosition() != INDEX_INVALID) {
                            xianlistView.setSelection(listViewApater.getSelectedPosition());
                        }
                        listViewApater.updateSelectedPosition(i);
                        listViewApater.notifyDataSetChanged();*/
                        area.setText(xian[i]);
                        //listViewApater.updateSelectedPosition(i);
                    }
                });
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!province.getText().toString().equals("请选择")) {
                            title.setText(province.getText().toString());
                        }

                        if (city.getText().toString().equals("请选择")) {
                            title.setText(province.getText().toString());
                            Log.d("zzz","province.getText().toString()"+province.getText().toString());
                        } else {
                            if (city.getText().toString().equals("全部市")) {
                                title.setText(province.getText().toString());
                                Log.d("zzz1","province.getText().toString()"+province.getText().toString());
                            } else {
                                title.setText(city.getText().toString());
                            }
                        }

                        if (area.getText().toString().equals("请选择")&&city.getText().toString().equals("全部市")) {
                            title.setText(province.getText().toString());
                            Log.d("zzz3","city.getText().toString()"+city.getText().toString());
                        } else {
                            if (area.getText().toString().equals("全部县")) {
                                title.setText(city.getText().toString());
                                Log.d("zzz2","city.getText().toString()"+city.getText().toString());
                            } else {
                                title.setText(area.getText().toString());
                                Log.d("zzz","area.getText().toString()"+area.getText().toString());
                            }
                        }
                    }
                });

            }
        });


    }
}
