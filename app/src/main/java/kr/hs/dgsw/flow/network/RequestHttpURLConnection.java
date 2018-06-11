package kr.hs.dgsw.flow.network;

import android.util.Log;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kr.hs.dgsw.flow.network.Model.RegisterModel.RegisterRequestBody;
import kr.hs.dgsw.flow.network.Model.RegisterModel.RegisterResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestHttpURLConnection {
    private String urlStr = "http://flow.cafe24app.com/";
    Retrofit retrofit;
    NetworkService networkService;
    JSONObject jsonObject;

    public RequestHttpURLConnection() {
        retrofit = new Retrofit.Builder()
                .baseUrl(urlStr)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkService = retrofit.create(NetworkService.class);
    }

    public JSONObject signup(String email, String pw, String name, String gender, String mobile, String class_idx, String class_number){
        try {

            pw = getHashCodeFromString(pw);

            RegisterRequestBody registerRequestBody = new RegisterRequestBody(email, pw, name, gender, mobile, Integer.parseInt(class_idx), Integer.parseInt(class_number));

            Call<RegisterResponseBody> call = networkService.signup(registerRequestBody);

            call.enqueue(new Callback<RegisterResponseBody>() {

                @Override
                public void onResponse(Call<RegisterResponseBody> call, Response<RegisterResponseBody> response) {
                    Log.i("register", response.toString());
                }

                @Override
                public void onFailure(Call<RegisterResponseBody> call, Throwable t) {

                }
            });

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public String signin(String email, String pw){
        try {
            pw = getHashCodeFromString(pw);
//            response = networkService.signin(email, pw);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return /*response.toString()*/ "";
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
