package android.example.com.notification.RestApi;


import android.example.com.notification.BuildConfig;

public class UtilsApi {
    public static final String BASE_URL_API = BuildConfig.URL;

    public static ApiInterface getAPIService(){
        return ApiClient.getClient(BASE_URL_API).create(ApiInterface.class);
    }

}
