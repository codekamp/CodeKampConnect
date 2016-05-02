package in.codekamp.codekampconnect.services.CodeKamp;

import in.codekamp.codekampconnect.models.Contact;
import in.codekamp.codekampconnect.models.ItemResponse;
import in.codekamp.codekampconnect.models.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by cerebro on 22/04/16.
 */
public interface CodeKampServiceInterface {
    @GET("contacts")
    Call<ListResponse<Contact>> listContacts(@Header("Authorization") String authToken);

    @GET("contacts/{id}")
    Call<ItemResponse<Contact>> getContact(@Header("Authorization") String authToken, @Path("id") int contactId);
}
