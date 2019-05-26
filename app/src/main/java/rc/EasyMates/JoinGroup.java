package rc.EasyMates;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Allow users to join a group.
 *
 * @author rc
 */
public class JoinGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public boolean checker(){
        TextView id = (TextView) findViewById(R.id.uuidSet);
        String nid = id.getText().toString();
        return nid.trim().length() > 0;
    }

    public void joinGroup(View view){
        if (checker()) {
            Intent intent = new Intent(this, SuccessJoin.class);
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
