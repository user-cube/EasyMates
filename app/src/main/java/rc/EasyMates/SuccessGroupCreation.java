package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Success Message View when group is created.
 *
 * @author rc
 */
public class SuccessGroupCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_group_creation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * Send us to manage group view.
     *
     * @param view actual view.
     */
    public void manageGroup(View view){
        Intent intent = new Intent(this, manageHouse.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {}
}

