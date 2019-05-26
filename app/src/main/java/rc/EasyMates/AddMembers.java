package rc.EasyMates;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);
        onLoad();
    }

    public void addMember(View view){
        TextView name = (TextView) findViewById(R.id.editText);
        TextView email = (TextView) findViewById(R.id.editText2);

        if (email.getText().toString().trim().length() > 0 && name.getText().toString().trim().length() > 0) {
            if (GlobalClass.member1 == null){
                GlobalClass.member1 = name.getText().toString();
                Toast.makeText(AddMembers.this, "Utilizador adicionado com sucesso!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, manageHouse.class);
                startActivity(intent);
            } else if (GlobalClass.member2 == null) {
                GlobalClass.member2 = name.getText().toString();
                Toast.makeText(AddMembers.this, "Utilizador adicionado com sucesso!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, manageHouse.class);
                startActivity(intent);
            } else if (GlobalClass.member3 == null) {
                GlobalClass.member3 = name.getText().toString();
                Toast.makeText(AddMembers.this, "Utilizador adicionado com sucesso!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, manageHouse.class);
                startActivity(intent);
            }
        }else{
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
