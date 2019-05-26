package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        onLoad();
    }

    public void onLoad(){
        TextView name, email, phone, password;

        name = (TextView) findViewById(R.id.textView8);
        email = (TextView) findViewById(R.id.textView3);
        phone = (TextView) findViewById(R.id.textView10);
        password = (TextView) findViewById(R.id.textView12);

        name.setText(GlobalClass.userName);
        email.setText(GlobalClass.email);
        phone.setText(GlobalClass.phone);
        password.setText(GlobalClass.password);
    }

    public void send(View view){
        Intent intent = new Intent(this, Profile_Change.class);
        startActivity(intent);
    }
}
