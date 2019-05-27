package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onLoad();
    }

    public boolean isEmpty(){
        return GlobalClass.item1 != null ||
                GlobalClass.item2 != null ||
                GlobalClass.item3 != null ||
                GlobalClass.item4 != null ||
                GlobalClass.item5 != null ||
                GlobalClass.item6 != null ||
                GlobalClass.item7 != null ||
                GlobalClass.item8 != null ||
                GlobalClass.item9 != null;
    }

    public void onLoad(){
        boolean shop = isEmpty();

        if (!shop){
            TextView shopi = (TextView) findViewById(R.id.textView15);
            shopi.setText("É necessário fazer compras!");
        }
        TextView one, two;
        one = (TextView) findViewById(R.id.textView23);
        two = (TextView) findViewById(R.id.textView19);
        if (GlobalClass.despesa1 != null){
            one.setText(GlobalClass.despesa1);
        }
        if (GlobalClass.despesa2 != null){
            two.setText(GlobalClass.despesa2);
        }
    }

    public void addExp(View view){
        Intent intent = new Intent(this, Add_AddDespesas.class);
        startActivity(intent);
    }
}
