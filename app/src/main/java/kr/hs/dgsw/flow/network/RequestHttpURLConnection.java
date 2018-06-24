package kr.hs.dgsw.flow.network;

import android.content.Context;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kr.hs.dgsw.flow.GoOutInterface;
import kr.hs.dgsw.flow.LoginInterface;
import kr.hs.dgsw.flow.NoticeInterface;
import kr.hs.dgsw.flow.RegisterInterface;
import kr.hs.dgsw.flow.network.Model.Databases;
import kr.hs.dgsw.flow.network.Model.GoOutModel.GoOutRequestBody;
import kr.hs.dgsw.flow.network.Model.GoOutModel.GoOutResponseBody;
import kr.hs.dgsw.flow.network.Model.LoginModel.LoginRequestBody;
import kr.hs.dgsw.flow.network.Model.LoginModel.LoginResponseBody;
import kr.hs.dgsw.flow.network.Model.NoticeModel.NoticeResponse;
import kr.hs.dgsw.flow.network.Model.RegisterModel.RegisterRequestBody;
import kr.hs.dgsw.flow.network.Model.RegisterModel.RegisterResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestHttpURLConnection {
    private String urlStr = "http://flow.cafe24app.com/";

    private Retrofit retrofit;
    private NetworkService networkService;
    private Context context;

    public RequestHttpURLConnection(Context context) {
        retrofit = new Retrofit.Builder()
                .baseUrl(urlStr)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkService = retrofit.create(NetworkService.class);
        this.context = context;
    }

    public void signup(String email, String pw, String name, String gender, String mobile, String class_idx, String class_number, final RegisterInterface registerInterface){
        try {
            pw = getHashCodeFromString(pw);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //Log.i("register pw", pw);
        RegisterRequestBody registerRequestBody = new RegisterRequestBody(email, pw, name, gender, mobile, Integer.parseInt(class_idx), Integer.parseInt(class_number));

        Call<RegisterResponseBody> call = networkService.signup(registerRequestBody);
        call.enqueue(new Callback<RegisterResponseBody>() {

            @Override
            public void onResponse(Call<RegisterResponseBody> call, Response<RegisterResponseBody> response) {
                registerInterface.register(response.body());
            }

            @Override
            public void onFailure(Call<RegisterResponseBody> call, Throwable t) {

            }
        });
    }

    public void signin(String email, String pw, final LoginInterface loginInterface){
        try {
            pw = getHashCodeFromString(pw);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Log.i("token", FirebaseInstanceId.getInstance().getToken());

        LoginRequestBody loginRequestBody = new LoginRequestBody(email, pw, FirebaseInstanceId.getInstance().getToken());

        Call<LoginResponseBody> call = networkService.signin(loginRequestBody);
        call.enqueue(new Callback<LoginResponseBody>() {
            @Override
            public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {
                loginInterface.Login(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponseBody> call, Throwable t) {

            }
        });
    }

    public void goOut(String start, String end, String reason, final GoOutInterface goOutInterface){
        Databases db = new Databases(context);
        GoOutRequestBody goOutRequestBody = new GoOutRequestBody(start, end, reason);

        Call<GoOutResponseBody> call = networkService.goOut(db.searchLastToken().getToken(), goOutRequestBody);
        call.enqueue(new Callback<GoOutResponseBody>() {
            @Override
            public void onResponse(Call<GoOutResponseBody> call, Response<GoOutResponseBody> response) {
                goOutInterface.goOut(response.body());
            }

            @Override
            public void onFailure(Call<GoOutResponseBody> call, Throwable t) {
                Log.i("fail", "실패");
            }
        });
    }

    public void notice(final NoticeInterface noticeInterface){

        Databases db = new Databases(context);

        Call<NoticeResponse> call = networkService.notice(db.searchLastToken().getToken());
        call.enqueue(new Callback<NoticeResponse>() {
            @Override
            public void onResponse(Call<NoticeResponse> call, Response<NoticeResponse> response) {
                noticeInterface.notice(response.body());
            }

            @Override
            public void onFailure(Call<NoticeResponse> call, Throwable t) {
                Log.i("fail", "실패");
            }
        });

    }

    private String getHashCodeFromString(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(str.getBytes());
        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer hashCodeBuffer = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            hashCodeBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return hashCodeBuffer.toString();
    }


}
