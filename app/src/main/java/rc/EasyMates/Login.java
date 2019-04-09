package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Login extends AppCompatActivity {
    public ArrayList<String> database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public String getPasswordWithEmail(String email){

        database = new ArrayList<>();


        try {
            BufferedReader br = new BufferedReader(new FileReader("/storage/self/primary/database.txt"));
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
                Log.d("Nice", "Teste" + database.get(i).toString());
                return database.get(i+1).toString();
            }
        }
        return "";
    }

    public boolean isValid(String password, String email) {
        if (getPasswordWithEmail(email).equals("")){
            Log.d("Login", "Email inválido");
            return false;
        } else {
            Log.d("Login", "Done");
            return true;
        }
    }

    public void login(View view){
        EditText email = (EditText) findViewById(R.id.emailLog);
        EditText password = (EditText) findViewById(R.id.passwordLog);
        Log.d("Login", "Done" + password.getText().toString());
        Log.d("Login", "Done" + email.getText().toString());
        try {
            boolean val = isValid(password.getText().toString(), email.getText().toString());
            Log.d("Login", "Done" + val);
            if (val == true) {
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
            }
        } catch (Exception e){
            //
        }
    }
}
