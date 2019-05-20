package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddDespesas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_despesas);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onLoad();
    }

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. idCasa);
        textView.setText(GlobalClass.defaultLocation);

        TextView aguaCasa = (TextView)findViewById(R. id. idAgua1);
        TextView idCompras1 = (TextView)findViewById(R. id. idCompras1);
        TextView idCompras2 = (TextView)findViewById(R. id. idCompras2);
        TextView idLuz1 = (TextView)findViewById(R. id. idLuz1);

        if(GlobalClass.agua != null){
            aguaCasa.setText(GlobalClass.agua);
        }

        if(GlobalClass.compras1 !=null){
            idCompras1.setText(GlobalClass.compras1);
        }

        if(GlobalClass.compras2 !=null){
            idCompras2.setText(GlobalClass.compras2);
        }

        if(GlobalClass.luz !=null){
            idLuz1.setText(GlobalClass.luz);
        }

    }

    public void addAgua(View view){
        Intent intent = new Intent(this, AddAgua.class);
        startActivity(intent);
    }

    public void addCompras(View view){
        Intent intent = new Intent(this, AddCompras.class);
        startActivity(intent);
    }

    public void addLuz(View view){
        Intent intent = new Intent(this, AddLuz.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, manageHouse.class);
        startActivity(intent);
    }
}
