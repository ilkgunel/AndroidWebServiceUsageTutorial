package ilkaygunel.com.webserviceusagetutorial;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startListActivity(View view){
        Intent intent = new Intent(this,ListUsersActivity.class);
        startActivity(intent);
    }

    public void startPostActivity(View view){
        Intent intent = new Intent(this,PostUserActivity.class);
        startActivity(intent);
    }
}
