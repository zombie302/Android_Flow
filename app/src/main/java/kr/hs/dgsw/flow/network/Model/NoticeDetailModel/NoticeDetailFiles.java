package kr.hs.dgsw.flow.network.Model.NoticeDetailModel;

public class NoticeDetailFiles {
    int idx;
    String upload_name;
    String upload_dir;
    int notice_idx;

    public NoticeDetailFiles(int idx, String upload_name, String upload_dir, int notice_idx) {
        this.idx = idx;
        this.upload_name = upload_name;
        this.upload_dir = upload_dir;
        this.notice_idx = notice_idx;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUpload_name() {
        return upload_name;
    }

    public void setUpload_name(String upload_name) {
        this.upload_name = upload_name;
    }

    public String getUpload_dir() {
        return upload_dir;
    }

    public void setUpload_dir(String upload_dir) {
        this.upload_dir = upload_dir;
    }

    public int getNotice_idx() {
        return notice_idx;
    }

    public void setNotice_idx(int notice_idx) {
        this.notice_idx = notice_idx;
    }
}
