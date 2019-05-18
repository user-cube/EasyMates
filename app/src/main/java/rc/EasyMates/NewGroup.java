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

public class NewGroup extends AppCompatActivity {

    /**
     * Array that stores users information.
     */
    public ArrayList<String> database;
    /**
     * Gets the path to sdcard.
     */
    public File sdcard = Environment.getExternalStorageDirectory();

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

        String email = GlobalClass.email;

        database = new ArrayList<>();
        File db = new File(sdcard,"database.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(db));
            String line;

            while ((line = br.readLine()) != null) {
                database.add(line);
            }
            br.close();
        }
        catch (IOException e) {
            Log.d("File", "IOException");
        }

        int linenumber = 0;

        for (int i = 0; i<database.size(); i++){
            if (database.get(i).equals(email)){
               linenumber = i+2;
            }
        }
        Path path = Paths.get("database.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.set(linenumber, uuid);
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }

    /**
     * Function that allow us to generate
     * the new group and send us to another
     * screen.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
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
