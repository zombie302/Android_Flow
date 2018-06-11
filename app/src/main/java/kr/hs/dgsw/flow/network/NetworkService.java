package kr.hs.dgsw.flow.network;

import kr.hs.dgsw.flow.network.Model.LoginModel.LoginRequestBody;
import kr.hs.dgsw.flow.network.Model.LoginModel.LoginResponseBody;
import kr.hs.dgsw.flow.network.Model.RegisterModel.RegisterRequestBody;
import kr.hs.dgsw.flow.network.Model.RegisterModel.RegisterResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkService {

    @Headers("content-type: application/json")
    @POST("auth/signin")
    Call<LoginResponseBody> signin(@Body LoginRequestBody loginRequestBody);

    @POST("auth/signup")
    Call<RegisterResponseBody> signup(@Body RegisterRequestBody registerRequestBody);

}
