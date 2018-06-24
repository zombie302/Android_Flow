package kr.hs.dgsw.flow.network.Model.NoticeDetailModel;

public class NoticeDetailResponse {
    int status;
    String message;
    NoticeDetailData noticeDetailData;

    public NoticeDetailResponse(int status, String message, NoticeDetailData noticeDetailData) {
        this.status = status;
        this.message = message;
        this.noticeDetailData = noticeDetailData;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoticeDetailData getNoticeDetailData() {
        return noticeDetailData;
    }

    public void setNoticeDetailData(NoticeDetailData noticeDetailData) {
        this.noticeDetailData = noticeDetailData;
    }
}
