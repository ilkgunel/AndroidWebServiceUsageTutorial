package ilkaygunel.com.webserviceusagetutorial;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import webserviceusage.operations.PersonAPI;
import webserviceusage.pojo.Person;

public class ListUsersActivity extends ListActivity {
    private List<Person> personList = new ArrayList<>();
    CustomAdapter customAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_people);


        final PersonAPI personAPI = RetroClient.getClient().create(PersonAPI.class);
        final Call<Person[]> call = personAPI.getSonValues();
        call.enqueue(new Callback<Person[]>() {
            @Override
            public void onResponse(Call<Person[]> call, Response<Person[]> response) {
                for (Person p : response.body()){
                    personList.add(p);
                }
            }

            @Override
            public void onFailure(Call<Person[]> call, Throwable t) {
                Log.e("MainActivit Class:", "HATA: " + t.toString());
            }
        });

        ListView listView = (ListView) findViewById(android.R.id.list);
        customAdapter = new CustomAdapter(this, personList);
        listView.setAdapter(customAdapter);
    }
}
