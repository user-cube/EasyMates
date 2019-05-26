package rc.EasyMates;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void saveChange(View view){
        TextView name, email, phone, password;

        name = (TextView) findViewById(R.id.editText4);
        email = (TextView) findViewById(R.id.editText5);
        phone = (TextView) findViewById(R.id.editText7);
        password = (TextView) findViewById(R.id.editText6);

        if ( GlobalClass.userName != name.getText().toString()){
            GlobalClass.userName = name.getText().toString();
        }

        if ( GlobalClass.email != email.getText().toString()){
            GlobalClass.email = email.getText().toString();
        }

        if ( GlobalClass.password != password.getText().toString()){
            GlobalClass.password = password.getText().toString();
        }

        if ( GlobalClass.phone != phone.getText().toString()){
            GlobalClass.phone = phone.getText().toString();
        }

        Intent intent = new Intent(this, Profile.class);
        Toast.makeText(Profile.this,"Alterações guardadas",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
