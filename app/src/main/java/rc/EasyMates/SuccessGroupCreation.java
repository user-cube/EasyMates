package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SuccessGroupCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_group_creation);
    }

    public void manageGroup(View view){
        Intent intent = new Intent(this, manageGroup.class);
        startActivity(intent);
    }
}
