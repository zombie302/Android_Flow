package kr.hs.dgsw.flow.network.Model.NoticeModel;

public class NoticeFiles {
    private int idx;
    private String uploadName;
    private String uploadDir;
    private int noticeIdx;

    public NoticeFiles(int idx, String uploadName, String uploadDir, int noticeIdx) {
        this.idx = idx;
        this.uploadName = uploadName;
        this.uploadDir = uploadDir;
        this.noticeIdx = noticeIdx;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUploadName() {
        return uploadName;
    }

    public void setUploadName(String uploadName) {
        this.uploadName = uploadName;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public int getNoticeIdx() {
        return noticeIdx;
    }

    public void setNoticeIdx(int noticeIdx) {
        this.noticeIdx = noticeIdx;
    }
}
