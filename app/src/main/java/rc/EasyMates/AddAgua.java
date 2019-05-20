package rc.EasyMates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddAgua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_agua);
        onLoad();
    }

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. textView2);
        textView.setText(GlobalClass.defaultLocation);
    }

    public void storeAgua(View view){
        TextView valorAgua = (TextView)findViewById(R. id. valorAgua);
        TextView descAgua = (TextView)findViewById(R. id. descAgua);
        String valor = valorAgua.getText().toString();
        String desc =descAgua.getText().toString();

        String finalValue = valor + " / " + desc;

        GlobalClass.agua=finalValue;

        Intent intent = new Intent(this, AddDespesas.class);
        startActivity(intent);
    }
}
