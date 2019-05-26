package rc.EasyMates;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
            GlobalClass.defaultLocation = location.getText().toString();
            GlobalClass.defaultUUID = uuid;
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
            GlobalClass.member1 = null;
            GlobalClass.member2 = null;
            Intent intent = new Intent(this, SuccessGroupCreation.class);
            startActivity(intent);
        } else{
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Os campos não estão preenchidos!");
            alertDialogBuilder.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    }

}
