package in.codekamp.codekampconnect.services;

import java.util.List;

import in.codekamp.codekampconnect.models.Contact;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cerebro on 22/04/16.
 */
public interface CodeKampService {
    @GET("contacts")
    Call<List<Contact>> listContacts();
}
