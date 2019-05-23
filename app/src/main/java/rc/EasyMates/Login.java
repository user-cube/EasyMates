package rc.EasyMates;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that allows user to
 * get into the platform.
 *
 * @author rc
 */
public class Login extends AppCompatActivity {
    /**
     * Array that stores users information.
     */
    public ArrayList<String> database;
    /**
     * Gets the path to sdcard.
     */
    public File sdcard = Environment.getExternalStorageDirectory();

    /**
     * Set actual view.
     *
     * @param savedInstanceState instance of
     *                           the actual view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * Function that allow us
     * to get the user password
     * using the given email.
     *
     * @param email given by user.
     *
     * @return the user password.
     */
    public String getPasswordWithEmail(String email){

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

        for (int i = 0; i<database.size(); i++){
            if (database.get(i).equals(email)){
                return database.get(i+1).toString();
            }
        }
        return "";
    }

    /**
     * Checks if the given email
     * and password is valid.
     *
     * @param password given by user.
     * @param email given by user.
     *
     * @return true - if is valid
     * otherwise false.
     */
    public boolean isValid(String password, String email) {
        if (getPasswordWithEmail(email).equals("")){
            Log.d("Login", "Email inválido");
            return false;
        } else {
            Log.d("Login", "Done");
            return true;
        }
    }

    /**
     * Checks if it is the
     * first time that user is
     * doing the login.
     *
     * @param email given by user.
     *
     * @return true if it's the first
     * time, otherwise false.
     */
    public boolean isFirst(String email){
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

        for (int i = 0; i<database.size(); i++){
            if (database.get(i).equals(email)){
                if (database.get(i+2).equals("0")){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Function that allows
     * user to enter on dashboard
     * if the login is valid.
     *
     * @param view actual view.
     */
    public void login(View view){

        EditText email = (EditText) findViewById(R.id.emailLog);
        EditText password = (EditText) findViewById(R.id.passwordLog);


        try {

            boolean val = isValid(password.getText().toString(), email.getText().toString());
            boolean val2 = isFirst(email.getText().toString());

            if (val) {
                if (val2) { //first login
                    GlobalClass.email= email.getText().toString();
                    Toast.makeText(Login.this,"Login efetuado com sucesso!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, DashboardInit.class);
                    startActivity(intent);

                } else { //not first login
                    GlobalClass.email= email.getText().toString();
                    Intent intent = new Intent(this, manageHouse.class);
                    Toast.makeText(Login.this,"Login efetuado com sucesso!",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            } else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Username ou password errados!");
                alertDialogBuilder.setPositiveButton("Tentar novamente",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

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
