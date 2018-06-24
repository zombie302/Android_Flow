package kr.hs.dgsw.flow.activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import kr.hs.dgsw.flow.R;

public class ListViewItemView extends LinearLayout {

    TextView textIdx;
    TextView textContent;
    TextView textWrite;

    public ListViewItemView(Context context) {
        super(context);
        init(context);
    }

    public ListViewItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.notice_item, this, true);

        textIdx = findViewById(R.id.text_idx);
        textContent = findViewById(R.id.text_content);
        textWrite = findViewById(R.id.text_writer);
    }

    public void setTextIdx(String textIdx) {
        this.textIdx.setText(textIdx);
    }

    public void setTextContent(String textContent) {
        this.textContent.setText(textContent);
    }

    public void setTextWrite(String textWrite) {
        this.textWrite.setText(textWrite);
    }
}
