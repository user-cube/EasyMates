package rc.EasyMates;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class changeHouseData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_house_data);
        onLoad();
    }

    public void onLoad(){
        TextView house = (TextView) findViewById(R.id.textView2);
        house.setText("Nome atual: " +GlobalClass.defaultLocation);
    }

    public void save(View view){
        try{
        TextView name = (TextView) findViewById(R.id.editText3);
        GlobalClass.defaultLocation = name.getText().toString();
        Intent intent = new Intent(this, manageHouse.class);
        Toast.makeText(changeHouseData.this,"Nome guardado",Toast.LENGTH_LONG).show();
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
}
