package kr.hs.dgsw.flow.network.Model.NoticeModel;

public class NoticeData {
    private NoticeList[] list;

    public NoticeData(NoticeList[] list) {
        this.list = list;
    }

    public NoticeList[] getList() {
        return list;
    }

    public void setList(NoticeList[] list) {
        this.list = list;
    }
}
