package kr.hs.dgsw.flow.network.Model.NoticeModel;

public class NoticeList {
    private int idx;
    private String content;
    private String writer;
    private String writeDate;
    private String modifyDate;
    private NoticeFiles[] NoticeFiles;

    public NoticeList(int idx, String content, String writer, String writeDate, String modifyDate, NoticeFiles[] noticeFiles) {
        this.idx = idx;
        this.content = content;
        this.writer = writer;
        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
        NoticeFiles = noticeFiles;
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

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public kr.hs.dgsw.flow.network.Model.NoticeModel.NoticeFiles[] getNoticeFiles() {
        return NoticeFiles;
    }

    public void setNoticeFiles(kr.hs.dgsw.flow.network.Model.NoticeModel.NoticeFiles[] noticeFiles) {
        NoticeFiles = noticeFiles;
    }
}
