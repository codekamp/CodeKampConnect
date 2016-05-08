package in.codekamp.codekampconnect.services.CodeKamp;

import in.codekamp.codekampconnect.models.Contact;
import in.codekamp.codekampconnect.models.ItemResponse;
import in.codekamp.codekampconnect.models.ListResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by cerebro on 22/04/16.
 */
public interface CodeKampServiceInterface {
    @GET("contacts")
    Call<ListResponse<Contact>> listContacts(@Header("Authorization") String accessToken, @Query("page") int page);

    @GET("contacts/{id}")
    Call<ItemResponse<Contact>> getContact(@Header("Authorization") String Token, @Path("id") int contactId);

    @POST("contacts")
    Call<ItemResponse<Contact>> createContact(@Header("Authorization") String Token, @Field("first_name") String FirstName);
}
