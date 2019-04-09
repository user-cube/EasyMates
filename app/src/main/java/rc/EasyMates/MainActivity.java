package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * Set actual view.
     *
     * @param savedInstanceState instance of the
     *                           actual view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * When login button is pressed
     * change to login page.
     *
     * @param view actual view.
     */
    public void changeToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    /**
     * When sign in button is
     * pressed change to
     * sign in page.
     *
     * @param view actual view.
     */
    public void changeToRegister(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
