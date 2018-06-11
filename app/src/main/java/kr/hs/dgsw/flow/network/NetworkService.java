package kr.hs.dgsw.flow.network;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkService {

    @Headers("content-type: application/json")
    @POST("auth/signin")
    Call<JSONObject> signin(JSONObject jsonObject);

    @POST("auth/signup")
    Call<JSONObject> signup(@Body JSONObject jsonObject);

}
