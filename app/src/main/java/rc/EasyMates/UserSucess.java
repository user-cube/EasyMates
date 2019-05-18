package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Class that allow us to present a
 * message of successful register.
 *
 * Note: After that message appear
 * the user should login into the
 * popper page to that.
 *
 * @author rc
 */
public class UserSucess extends AppCompatActivity {

    /**
     * Set the actual view.
     *
     * @param savedInstanceState instance of the actual
     *                           view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sucess);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * Function that allows to
     * change to the login screen.
     *
     * @param view actual view.
     */
    public void goToLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
