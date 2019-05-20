package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);
        onLoad();
    }

    public void addMember(View view){
        Intent intent = new Intent(this, SuccessMember.class);
        startActivity(intent);
    }

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. textView11);
        textView.setText(GlobalClass.defaultLocation);
    }
}
