package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddCompras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compras);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onLoad();
    }
    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. textView8);
        textView.setText(GlobalClass.defaultLocation);
    }

    public void storeCompras(View view){
        TextView valorCompras = (TextView)findViewById(R. id. valorCompras);
        TextView descCompras = (TextView)findViewById(R. id. descCompras);
        String valor = valorCompras.getText().toString();
        String desc =descCompras.getText().toString();

        String finalValue = valor + " / " + desc;
        if(GlobalClass.compras1 == null) {
            GlobalClass.compras1 = finalValue;
            Intent intent = new Intent(this, AddDespesas.class);
            startActivity(intent);
        }else{
            GlobalClass.compras2 = finalValue;
            Intent intent = new Intent(this, AddDespesas.class);
            startActivity(intent);
        }
    }
}
