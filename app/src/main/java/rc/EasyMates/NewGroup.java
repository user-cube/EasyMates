package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Allow us to create a new group.
 *
 * @author rc
 */
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
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean generateGroup() {

        EditText groupName = (EditText) findViewById(R.id.groupName);
        EditText location = (EditText) findViewById(R.id.location);

        String uuid = UUID.randomUUID().toString();


        if(groupName.getText().toString().trim().length() > 0 && location.getText().toString().trim().length() > 0){
            GlobalClass.groupName = groupName.getText().toString();
            GlobalClass.location = location.getText().toString();
            GlobalClass.uuid = uuid;
            return true;
        }

        return false;
    }

    /**
     * Function that allow us to generate
     * the new group and send us to another
     * screen.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createGroup(View view){
        if(generateGroup()){
            Intent intent = new Intent(this, SuccessGroupCreation.class);
            startActivity(intent);
        } else{
            Log.d(
                    "Group Generation",
                    "Fail to generate group"
            );
        }

    }

}
