package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SuccessJoin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_join);
    }

    public void manageHouse(){
        Intent intent = new Intent(this, manageHouse.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {}
}
