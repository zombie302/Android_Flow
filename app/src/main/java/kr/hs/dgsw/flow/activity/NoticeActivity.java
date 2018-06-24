package kr.hs.dgsw.flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import kr.hs.dgsw.flow.NoticeInterface;
import kr.hs.dgsw.flow.R;
import kr.hs.dgsw.flow.network.Model.NoticeModel.NoticeResponse;
import kr.hs.dgsw.flow.network.RequestHttpURLConnection;

public class NoticeActivity extends AppCompatActivity implements NoticeInterface{

    ListView listView;
    ListViewItemAdapter listViewItemAdapter;
    RequestHttpURLConnection rhc = new RequestHttpURLConnection(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        listView = findViewById(R.id.notice_listview);
        listViewItemAdapter = new ListViewItemAdapter(this);
        listView.setAdapter(listViewItemAdapter);
        rhc.notice(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(NoticeActivity.this, NoticeDetailActivity.class);
                i.putExtra("idx", listViewItemAdapter.getItem(position).getTextIdx());
                startActivity(i);
            }
        });
    }

    @Override
    public void notice(NoticeResponse noticeResponse) {
        if(noticeResponse.getStatus() == 200){
            for(int i = 0; i<noticeResponse.getData().getList().length; i++){
                if(noticeResponse.getData().getList()[i].getContent().length() < 10){
                    ListViewItem listViewItem = new ListViewItem(
                            String.valueOf(noticeResponse.getData().getList()[i].getIdx()),
                            noticeResponse.getData().getList()[i].getContent(),
                            noticeResponse.getData().getList()[i].getWriter().split("@")[0]);
                    listViewItemAdapter.addItem(listViewItem);
                } else {
                    ListViewItem listViewItem = new ListViewItem(
                            String.valueOf(noticeResponse.getData().getList()[i].getIdx()),
                            noticeResponse.getData().getList()[i].getContent().substring(0,10),
                            noticeResponse.getData().getList()[i].getWriter().split("@")[0]);
                    listViewItemAdapter.addItem(listViewItem);
                }
            }
            listViewItemAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "공지 못불러옴", Toast.LENGTH_SHORT).show();
        }
    }
}
