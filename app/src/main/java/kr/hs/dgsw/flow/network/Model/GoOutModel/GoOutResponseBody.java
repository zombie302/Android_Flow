package kr.hs.dgsw.flow.network.Model.GoOutModel;

import kr.hs.dgsw.flow.network.Model.ResponseBody;

public class GoOutResponseBody extends ResponseBody{
    private ResponseData responseData;

    public GoOutResponseBody(String status, String message, ResponseData responseData) {
        super(status, message);
        this.responseData = responseData;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
}
