package rc.EasyMates;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);
        onLoad();
    }

    public void addMember(View view){
        try {
            TextView name = (TextView) findViewById(R.id.editText);
            GlobalClass.member3 = name.getText().toString();
            Intent intent = new Intent(this, SuccessMember.class);
            startActivity(intent);
        } catch (Exception e){
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

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. textView11);
        textView.setText(GlobalClass.defaultLocation);
    }
}
