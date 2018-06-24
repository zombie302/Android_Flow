package kr.hs.dgsw.flow.network;

import kr.hs.dgsw.flow.network.Model.GoOutModel.GoOutRequestBody;
import kr.hs.dgsw.flow.network.Model.GoOutModel.GoOutResponseBody;
import kr.hs.dgsw.flow.network.Model.LoginModel.LoginRequestBody;
import kr.hs.dgsw.flow.network.Model.LoginModel.LoginResponseBody;
import kr.hs.dgsw.flow.network.Model.NoticeModel.NoticeResponse;
import kr.hs.dgsw.flow.network.Model.RegisterModel.RegisterRequestBody;
import kr.hs.dgsw.flow.network.Model.RegisterModel.RegisterResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkService {

    @Headers({"Content-Type: application/json"})

    @POST("auth/signin")
    Call<LoginResponseBody> signin(@Body LoginRequestBody loginRequestBody);

    @POST("auth/signup")
    Call<RegisterResponseBody> signup(@Body RegisterRequestBody registerRequestBody);

    @POST("out/go")
    Call<GoOutResponseBody> goOut(@Header("x-access-token") String token, @Body GoOutRequestBody goOutRequestBody);

    @GET("notice")
    Call<NoticeResponse> notice(@Header("x-access-token") String token);

}
