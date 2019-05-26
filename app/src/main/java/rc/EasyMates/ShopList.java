package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
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

public class ShopList extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        onLoad();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.shopping_list) {
            Intent searchIntent = new Intent(ShopList.this, ShopList.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_expenses) {
            Intent searchIntent = new Intent(ShopList.this, AddDespesas.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_group) {
            Intent searchIntent = new Intent(ShopList.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.logout) {
            Intent searchIntent = new Intent(ShopList.this, Login.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_house) {
            Intent searchIntent = new Intent(ShopList.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onLoad(){
        TextView elementOne = (TextView) findViewById(R.id.elementOne);
        TextView elementTwo2 = (TextView) findViewById(R.id.elementTwo2);
        TextView element = (TextView) findViewById(R.id.element);
        TextView element3 = (TextView) findViewById(R.id.element3);
        TextView element4 = (TextView) findViewById(R.id.element4);
        TextView element2 = (TextView) findViewById(R.id.element2);
        TextView element5 = (TextView) findViewById(R.id.element5);
        TextView element6 = (TextView) findViewById(R.id.element6);
        TextView element8 = (TextView) findViewById(R.id.element8);

        if (GlobalClass.item1 != null){
            elementOne.setText(GlobalClass.item1);
        }
        if (GlobalClass.item2 != null){
            elementTwo2.setText(GlobalClass.item2);
        }
        if (GlobalClass.item3 != null){
            element.setText(GlobalClass.item3);
        }
        if (GlobalClass.item4 != null){
            element3.setText(GlobalClass.item4);
        }
        if (GlobalClass.item5 != null){
            element4.setText(GlobalClass.item5);
        }
        if (GlobalClass.item6 != null){
            element2.setText(GlobalClass.item6);
        }
        if (GlobalClass.item7 != null){
            element5.setText(GlobalClass.item7);
        }
        if (GlobalClass.item8 != null){
            element6.setText(GlobalClass.item8);
        }
        if (GlobalClass.item9 != null){
            element8.setText(GlobalClass.item9);
        }
    }

    public void addElements(View view){
        Intent intent = new Intent(this, ShopListSave.class);
        startActivity(intent);
    }
}
