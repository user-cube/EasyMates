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

/**
 * Main page of House Management.
 *
 * @author rc
 */
public class manageHouse extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_group);
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
            Intent searchIntent = new Intent(manageHouse.this, ShopList.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_expenses) {
            Intent searchIntent = new Intent(manageHouse.this, AddDespesas.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_group) {
            Intent searchIntent = new Intent(manageHouse.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.logout) {
            Intent searchIntent = new Intent(manageHouse.this, Login.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_house) {
            Intent searchIntent = new Intent(manageHouse.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onLoad(){

        TextView textView = (TextView)findViewById(R. id. HouseName);

        textView.setText("Casa: " + GlobalClass.defaultLocation);

        TextView houseId = (TextView) findViewById(R.id.houseID);
        houseId.setText("Id da casa: " + GlobalClass.defaultUUID);

        TextView member1, member2, member3;

        member1 = (TextView) findViewById(R.id.textView6);
        member2 = (TextView) findViewById(R.id.textView7);
        member3 = (TextView) findViewById(R.id.textView5);

        member1.setText(GlobalClass.member1);
        member2.setText(GlobalClass.member2);
        if (GlobalClass.member3 != null){
            member3.setText(GlobalClass.member3);
        }

    }

    public void share(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Group ID: " + GlobalClass.defaultUUID);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void addMember(View view){
        Intent intent = new Intent(this, AddMembers.class);
        startActivity(intent);
    }

}
