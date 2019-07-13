package com.example.xykf.dingwei;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.xykf.dingwei.JDConst.INDEX_INVALID;

public class ListViewApater extends BaseAdapter {
    private final Context context;
    private final String[] sheng;

    private int districtIndex;
    private int INDEX_INVALID=-1;

    public ListViewApater(Context context, String[] sheng) {
        this.context = context;
        this.sheng = sheng;
    }


    public int getSelectedPosition() {
        return this.districtIndex;
    }

    public void updateSelectedPosition(int index) {
        this.districtIndex = index;
    }

    @Override
    public int getCount() {
        return sheng.length;
    }

    @Override
    public Object getItem(int i) {
        return sheng[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Holder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);

            holder = new Holder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.selectImg = (ImageView) convertView.findViewById(R.id.selectImg);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.name.setText(sheng[i]);
       /* Log.d("zzz","jskfj"+districtIndex);
        boolean checked = districtIndex != INDEX_INVALID&&districtIndex==i;
        Log.d("zzz","jskfj"+checked);
        holder.name.setEnabled(!checked);
        holder.selectImg.setVisibility(checked ? View.VISIBLE : View.GONE);*/


        return convertView;
    }

    class Holder {
        TextView name;
        ImageView selectImg;
    }
}
