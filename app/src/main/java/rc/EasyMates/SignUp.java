package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SignUp extends AppCompatActivity {
    public ArrayList<String> database;
    public String path = "/storage/1250-ACFD/database.txt";

    /**
     * Set the actual view.
     *
     * @param savedInstanceState instance of
     *                           the actual class.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    /**
     * Function that verifies if the user
     * is stored into the database or not.
     *
     * @param email form user.
     *
     * @return true if the user is already
     * stored, otherwise false.
     */
    public boolean isStored(String email){
        database = new ArrayList<>();
        Log.d("t", "t"+path);
        File db = new File(path);

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
                return true;
            }
        }
        return false;
    }

    /**
     * Stores the new users into the
     * database.
     *
     * @param name the user name.
     * @param email the user email.
     * @param password the user password.
     * @param phone the user phone.
     *
     * @return if the user was added,
     * otherwise false.
     */
    public boolean store(String name, String email, String password, String phone){

        File db = new File(path);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(db);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            writer.append(email);
            writer.append(password);
            writer.append("0");
            writer.append(name);
            writer.append(phone);
            writer.close();
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            Log.d("Erro", "File not found");
            return false;
        } catch (IOException e) {
            //e.printStackTrace();
            Log.d("Erro", "IO");
            return false;
        }
    }

    /**
     * Function that allow users to
     * sign up into the app.
     *
     * @param view actual view.
     */
    public void register(View view){
        EditText name = (EditText) findViewById(R.id.nameSU);
        EditText email = (EditText) findViewById(R.id.emailSU);
        EditText password = (EditText) findViewById(R.id.passSU);
        EditText phone = (EditText) findViewById(R.id.phoneNumber);

        try{
            boolean isUserStored = isStored(email.getText().toString());
            if (isUserStored){
                boolean stored = store(name.getText().toString(), email.getText().toString(), password.getText().toString(), phone.getText().toString());
                if (stored){
                    Intent intent = new Intent(this, UserSucess.class);
                    startActivity(intent);
                } else {
                    Log.d("store", "false");
                }
            } else {
                Log.d("isStored", "false");
            }
        } catch (Exception e){
            Log.d("Registo", "Entrada falhada.");
        }
    }
}
