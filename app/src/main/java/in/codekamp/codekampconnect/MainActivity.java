package in.codekamp.codekampconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import in.codekamp.codekampconnect.models.Contact;
import in.codekamp.codekampconnect.services.CodeKampService;
import in.codekamp.codekampconnect.services.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);























        CodeKampService service = ServiceFactory.create(CodeKampService.class, ServiceFactory.BASE_URL_CODEKAMP_API);

        Call<List<Contact>> call = service.listContacts();

        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                List<Contact> list = response.body();

                Log.d("codekamp", response.message());
//                Log.d("codekamp", response.);
                Log.d("codekamp", Integer.toString(list.size()));
                Log.d("codekamp", list.get(0).getFirstName());
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Log.d("codekamp", t.getMessage());
            }
        });
    }
}
