package rc.EasyMates;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.provider.Settings;
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

public class Add_AddDespesas extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_add_despesas);
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
            Intent searchIntent = new Intent(Add_AddDespesas.this, ShopList.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_expenses) {
            Intent searchIntent = new Intent(Add_AddDespesas.this, Add_AddDespesas.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_group) {
            Intent searchIntent = new Intent(Add_AddDespesas.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.logout) {
            Intent searchIntent = new Intent(Add_AddDespesas.this, Login.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_house) {
            Intent searchIntent = new Intent(Add_AddDespesas.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.profile){
            Intent searchIntent = new Intent(Add_AddDespesas.this, Profile.class);
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
        TextView element3 = (TextView) findViewById(R.id.element9);
        TextView element4 = (TextView) findViewById(R.id.element3);
        TextView element2 = (TextView) findViewById(R.id.element7);

        if (GlobalClass.despesa1 != null){
            elementOne.setText(GlobalClass.despesa1);
        }
        if (GlobalClass.despesa2 != null){
            elementTwo2.setText(GlobalClass.despesa2);
        }
        if (GlobalClass.despesa3 != null){
            element.setText(GlobalClass.despesa3);
        }
        if (GlobalClass.despesa4 != null){
            element3.setText(GlobalClass.despesa4);
        }
        if (GlobalClass.despesa5 != null){
            element4.setText(GlobalClass.despesa5);
        }
        if (GlobalClass.despesa6 != null){
            element2.setText(GlobalClass.despesa6);
        }

    }

    public void addDespesa(View view){
        Intent intent = new Intent(this, AddDespesas.class);
        startActivity(intent);
    }

    public void editDespesa(View view){
        Intent intent = new Intent(this, AddDespesas.class);
        startActivity(intent);
    }

}
