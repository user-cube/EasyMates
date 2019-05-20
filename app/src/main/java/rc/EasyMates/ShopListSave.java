package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopListSave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_save);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onLoad();
    }

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. nameHouse);
        textView.setText(GlobalClass.defaultLocation);

    }

    public void store(View view) {

        TextView textView = (TextView)findViewById(R. id. itemName);
        if (GlobalClass.item5 == null) {
            GlobalClass.item5 = textView.getText().toString();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        }else{
            GlobalClass.item7 = textView.getText().toString();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        }

    }
}
