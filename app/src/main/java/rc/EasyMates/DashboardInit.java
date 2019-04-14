package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardInit extends AppCompatActivity {

    /**
     * Set the actual view.
     *
     * @param savedInstanceState instance of
     *                           the actual class.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_init);
    }

    /**
     * Function that allow us
     * to join a group.
     *
     * @param view actual view.
     */
    public void joinGroup(View view){
        Intent intent = new Intent(this, JoinGroup.class);
        startActivity(intent);
    }

    /**
     * Function that allow us
     * to create a new group.
     *
     * @param view actual view.
     */
    public void createGroup(View view){
        Intent intent = new Intent(this, NewGroup.class);
        startActivity(intent);
    }
}
