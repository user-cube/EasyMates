package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Main page of House Management.
 *
 * @author rc
 */
public class manageHouse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_group);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onLoad();
    }

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. HouseName);
        textView.setText(GlobalClass.defaultLocation);
    }

    public void addDespesa(View view){
        Intent intent = new Intent(this, AddDespesas.class);
        startActivity(intent);
    }

    public void addShopList(View view){
        Intent intent = new Intent(this, ShopList.class);
        startActivity(intent);
    }

    public void membros(View view){
        Intent intent = new Intent(this, AddMembers.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {}


}
