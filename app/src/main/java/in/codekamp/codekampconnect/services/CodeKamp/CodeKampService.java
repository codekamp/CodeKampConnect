package in.codekamp.codekampconnect.services.CodeKamp;

import android.util.Log;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import in.codekamp.codekampconnect.models.*;
import in.codekamp.codekampconnect.models.Error;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by cerebro on 30/04/16.
 */
public class CodeKampService {

    private final String BASE_URL = "http://api.codekamp.in/";
    private final String BEARER = "bearer";

    private String accessToken;
    private CodeKampServiceInterface service;
    private Retrofit retrofit;

    public CodeKampService() {
        this(null);
    }

    public CodeKampService(String accessToken) {
        this.accessToken = accessToken;

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(CodeKampServiceInterface.class);
    }


    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    private String getAccessTokenHeader() {
        if(this.accessToken == null) {
            throw new RuntimeException("Access token not set on CodeKampService");
        }
        return BEARER + " " + this.accessToken;
    }

    public void listContacts(int page, Callback<ListResponse<Contact>> callback) {
        service.listContacts(getAccessTokenHeader(), page).enqueue(new CallbackHandler<ListResponse<Contact>>(retrofit, callback));
    }

    public void getContact(int contactId, Callback<ItemResponse<Contact>> callback) {
        service.getContact(getAccessTokenHeader(), contactId).enqueue(new CallbackHandler<ItemResponse<Contact>>(retrofit, callback));
    }

    public void createContact(String firstName, Callback<ItemResponse<Contact>> callback) {
        service.createContact(getAccessTokenHeader(), firstName).enqueue(new CallbackHandler<ItemResponse<Contact>>(retrofit, callback));
    }




























    private class CallbackHandler<T> implements retrofit2.Callback<T> {

        private Retrofit retrofit;
        private Callback callback;

        public CallbackHandler(Retrofit retrofit, Callback callback) {
            this.retrofit = retrofit;
            this.callback = callback;
        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if(response.isSuccessful()) {
                callback.onSuccess(response.body());
            } else {
                Log.d("codekamp", "response not isSuccessful");

                Converter<ResponseBody, Error> errorConverter =
                        retrofit.responseBodyConverter(Error.class, new Annotation[0]);
                try {
                    Error error = errorConverter.convert(response.errorBody());
                    callback.onFailure(error);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            Log.d("codekamp", "response onFailure");

            Error error = new Error(t.getMessage(), Error.ERROR_CODE_NETWORK_ERROR);

            callback.onFailure(error);
        }
    }
}
