package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddLuz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_luz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onLoad();
    }

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. textView6);
        textView.setText(GlobalClass.defaultLocation);
    }

    public void storeLuz(View view){
        TextView valorLuz = (TextView)findViewById(R. id. luzValor);
        TextView descLuz = (TextView)findViewById(R. id. descLuz);
        String valor = valorLuz.getText().toString();
        String desc =descLuz.getText().toString();

        String finalValue = valor + " / " + desc;

        GlobalClass.luz=finalValue;

        Intent intent = new Intent(this, AddDespesas.class);
        startActivity(intent);
    }
}
