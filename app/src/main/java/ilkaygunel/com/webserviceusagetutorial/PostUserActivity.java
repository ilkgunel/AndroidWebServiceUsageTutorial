package ilkaygunel.com.webserviceusagetutorial;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import webserviceusage.operations.PersonAPI;
import webserviceusage.pojo.Address;
import webserviceusage.pojo.Person;


public class PostUserActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_user_activity);
    }

    public void postPersonToWebService(View view){
        Person person = new Person();

        EditText idEditText = (EditText) findViewById(R.id.idField);
        EditText nameEditText = (EditText) findViewById(R.id.nameField);
        EditText surnameEditText = (EditText) findViewById(R.id.surnameField);

        person.setId(idEditText.getText().toString());
        person.setName(nameEditText.getText().toString());
        person.setSurname(surnameEditText.getText().toString());

        Address address = new Address();
        address.setNeighborhood("Cennet Mahallesi");
        address.setBorough("Küçükçekmece");
        address.setCity("İstanbul");
        address.setCountry("Türkiye");

        person.setAddress(address);

        PersonAPI personAPI = RetroClient.getClient().create(PersonAPI.class);
        Call<Person> call = personAPI.postPerson(person);
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                System.out.println("Response Satus Code:"+response.code());
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                System.out.println("Bir Hata Meydana Geldi! "+t.toString());
            }
        });
    }
}
