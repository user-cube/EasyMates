package rc.EasyMates;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that allow users to
 * choose if the want login in
 * or sign up.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * List of permissions to be asked.
     */
    String[] permissions = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };

    /**
     * Check the permissions we need
     * are satisfied, if not, asks the
     * user to give permissions.
     *
     * @return the user feedback.
     */
    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 100);
            return false;
        }
        return true;
    }

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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        checkPermissions();
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
