package in.codekamp.codekampconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.codekamp.codekampconnect.models.*;
import in.codekamp.codekampconnect.models.Error;
import in.codekamp.codekampconnect.services.CodeKamp.Callback;
import in.codekamp.codekampconnect.services.CodeKamp.CodeKampService;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hello_text_view) TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        helloTextView.setText("ButterKnife rocks!");


        CodeKampService service = new CodeKampService("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6XC9cL2FwaS5jb2Rla2FtcC5pblwvYXV0aGVudGljYXRlIiwiaWF0IjoxNDYxNzcxNDcxLCJleHAiOjE0NjI5ODEwNzEsIm5iZiI6MTQ2MTc3MTQ3MSwianRpIjoiMzFjYzcwMjJmZmM2MTM5Y2Y5YzhmMjkwM2YxMjlmYmQifQ.dMdaFF0KIy7Qe4dVEDWG_82Pwq6MOBcshO3f-TakH3w");

        service.listContacts(1, new Callback<ListResponse<Contact>>() {
            @Override
            public void onSuccess(ListResponse<Contact> response) {
                List<Contact> contacts = response.getData();
                Log.d("codekamp", contacts.get(0).getFirstName());
                response.getMeta();

            }

            @Override
            public void onFailure(Error error) {
                Log.d("codekamp", error.getMessage());
            }
        });

        service.getContact(2000, new Callback<ItemResponse<Contact>>() {
            @Override
            public void onSuccess(ItemResponse<Contact> response) {
                Contact contact = response.getData();

                Log.d("codekamp", contact.getFirstName() + contact.getEmail());
            }

            @Override
            public void onFailure(Error error) {
                Log.d("codekamp", error.getMessage());
            }
        });


        service.createContact("Prashant", new Callback<ItemResponse<Contact>>() {
            @Override
            public void onSuccess(ItemResponse<Contact> response) {

            }

            @Override
            public void onFailure(Error error) {

            }
        });
    }
}
