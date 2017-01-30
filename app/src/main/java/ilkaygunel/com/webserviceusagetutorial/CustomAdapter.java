package ilkaygunel.com.webserviceusagetutorial;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import webserviceusage.pojo.Person;
public class CustomAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Person> personList;

    public CustomAdapter(Activity activity,List<Person> personList){
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int i) {
        return personList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View satirView;

        satirView = layoutInflater.inflate(R.layout.list_layout, null);
        TextView idNumber =
                (TextView) satirView.findViewById(R.id.idNumber);

        TextView name =
                (TextView) satirView.findViewById(R.id.name);

        TextView surname =
                (TextView) satirView.findViewById(R.id.surname);

        TextView address =
                (TextView) satirView.findViewById(R.id.address);


        Person person = personList.get(i);

        idNumber.setText(person.getId());
        name.setText(person.getName());
        surname.setText(person.getSurname());
        address.setText(person.getAddress().toString());


        return satirView;
    }
}
