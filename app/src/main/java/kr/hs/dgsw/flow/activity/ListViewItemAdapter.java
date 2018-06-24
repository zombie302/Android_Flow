package kr.hs.dgsw.flow.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ListViewItemAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> items = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public ListViewItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(ListViewItem item) {
        items.add(item);
    }

    @Override
    public ListViewItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListViewItemView listView = new ListViewItemView(context);
        ListViewItem item = items.get(position);
        listView.setTextIdx(item.getTextIdx());
        listView.setTextContent(item.getTextContent());
        listView.setTextWrite(item.getTextWrite());


        return listView;
    }
}
