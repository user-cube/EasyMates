package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.UUID;

public class NewGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * Function that allows to generate and
     * store the new group.
     *
     * @return true if the new group was created
     * otherwise false.
     */
    public boolean generateGroup(){
        EditText groupName = (EditText) findViewById(R.id.groupName);
        EditText location = (EditText) findViewById(R.id.location);

        String uuid = UUID.randomUUID().toString();

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        final String email  = globalVariable.getEmail();

        





        return true;
    }

    /**
     * Function that allow us to generate
     * the new group and send us to another
     * screen.
     */
    public void createGroup(){
        if(generateGroup()){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        } else{
            Log.d(
                    "Group Genration",
                    "Fail to generate group"
            );
        }

    }
}
