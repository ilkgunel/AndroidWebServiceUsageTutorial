package ilkaygunel.com.webserviceusagetutorial;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    public static final String BASE_URL = "http://10.0.2.2:8080/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()

                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient())
                    .build();
        }
        return retrofit;
    }
}
