package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        textView.setText("Casa " + GlobalClass.defaultLocation);

    }

    public void store(View view) {

        TextView textView = (TextView)findViewById(R. id. itemName);
        if (GlobalClass.item5 == null) {
            GlobalClass.item5 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else if (GlobalClass.item6 == null){
            GlobalClass.item6 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else if (GlobalClass.item7 == null){
            GlobalClass.item7 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else if (GlobalClass.item8 == null){
            GlobalClass.item8 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else if (GlobalClass.item9 == null){
            GlobalClass.item9 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else {
            Toast.makeText(ShopListSave.this, "Item não adicionado!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        }

    }
}
