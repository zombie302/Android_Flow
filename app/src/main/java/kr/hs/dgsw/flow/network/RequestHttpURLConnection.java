package kr.hs.dgsw.flow.network;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public JSONObject signup(String email, String pw, String name, String gender, String mobile, String class_idx, String class_number, final RetroCallBack retroCallBack){
        try {

            pw = getHashCodeFromString(pw);

            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", email);
            jsonObject.put("pw", pw);
            jsonObject.put("name", name);
            jsonObject.put("gender", gender);
            jsonObject.put("mobile", mobile);
            jsonObject.put("class_idx", class_idx);
            jsonObject.put("class_number", class_number);

            Call<JSONObject> call = networkService.signup(jsonObject);

            call.enqueue(new Callback<JSONObject>() {
                @Override
                public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                    JSONObject jsonObjects = response.body();
                    Log.i("network Test", jsonObjects.toString());
                }

                @Override
                public void onFailure(Call<JSONObject> call, Throwable t) {
                    Log.i("network Test", "실패");
                }
            });

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (JSONException e) {
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
