package kr.hs.dgsw.flow.network.Model.NoticeDetailModel;

public class NoticeDetailData {
    int idx;
    String content;
    String writer;
    String write_date;
    String modify_date;
    NoticeDetailFiles[] noticeDetailFiles;

    public NoticeDetailData(int idx, String content, String writer, String write_date, String modify_date, NoticeDetailFiles[] noticeDetailFiles) {
        this.idx = idx;
        this.content = content;
        this.writer = writer;
        this.write_date = write_date;
        this.modify_date = modify_date;
        this.noticeDetailFiles = noticeDetailFiles;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWrite_date() {
        return write_date;
    }

    public void setWrite_date(String write_date) {
        this.write_date = write_date;
    }

    public String getModify_date() {
        return modify_date;
    }

    public void setModify_date(String modify_date) {
        this.modify_date = modify_date;
    }

    public NoticeDetailFiles[] getNoticeDetailFiles() {
        return noticeDetailFiles;
    }

    public void setNoticeDetailFiles(NoticeDetailFiles[] noticeDetailFiles) {
        this.noticeDetailFiles = noticeDetailFiles;
    }
}
