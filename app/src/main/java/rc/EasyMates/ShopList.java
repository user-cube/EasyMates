package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onLoad();
    }

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. casaName);
        TextView item1 = (TextView)findViewById(R. id. item1);
        TextView item2 = (TextView)findViewById(R. id.item2);
        TextView item4 = (TextView)findViewById(R. id.item4);
        TextView item3 = (TextView)findViewById(R. id.item3);
        TextView item6 = (TextView)findViewById(R. id.item6);

        textView.setText(GlobalClass.defaultLocation);
        item1.setText(GlobalClass.item1);
        item2.setText(GlobalClass.item2);
        item4.setText(GlobalClass.item4);
        item3.setText(GlobalClass.item3);
        item6.setText(GlobalClass.item6);
        if(GlobalClass.item5 != null){
            TextView item5 = (TextView)findViewById(R. id.item5);
            item5.setText(GlobalClass.item5);
        }
        if(GlobalClass.item7 != null){
            TextView item7 = (TextView)findViewById(R. id. item7);
            item7.setText(GlobalClass.item7);
        }
    }

    public void saveShopList(View view){
        Intent intent = new Intent(this, ShopListSave.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, manageHouse.class);
        startActivity(intent);
    }
}
