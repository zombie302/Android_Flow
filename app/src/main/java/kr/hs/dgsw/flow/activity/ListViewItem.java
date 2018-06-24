package kr.hs.dgsw.flow.activity;

public class ListViewItem {
    private String textIdx;
    private String textContent;
    private String textWrite;

    public ListViewItem(String textIdx, String textContent, String textWrite) {
        this.textIdx = textIdx;
        this.textContent = textContent;
        this.textWrite = textWrite;
    }

    public String getTextIdx() {
        return textIdx;
    }

    public void setTextIdx(String textIdx) {
        this.textIdx = textIdx;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getTextWrite() {
        return textWrite;
    }

    public void setTextWrite(String textWrite) {
        this.textWrite = textWrite;
    }
}
