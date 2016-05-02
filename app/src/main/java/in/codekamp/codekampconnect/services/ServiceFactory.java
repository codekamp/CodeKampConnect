package in.codekamp.codekampconnect.services;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cerebro on 22/04/16.
 */
public class ServiceFactory {

    public static final String BASE_URL_CODEKAMP_API = "http://api.codekamp.in/";

    public static <T> T create(final Class<T> service, String baseURL) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(service);
    }
}
