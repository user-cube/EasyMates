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
import android.widget.Toolbar;

public class AddDespesas extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_despesas);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            onLoad();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onLoad(){
        /*TextView textView = (TextView)findViewById(R. id. idCasa);
        textView.setText(GlobalClass.defaultLocation);

        TextView aguaCasa = (TextView)findViewById(R. id. idAgua1);
        TextView idCompras1 = (TextView)findViewById(R. id. idCompras1);
        TextView idCompras2 = (TextView)findViewById(R. id. idCompras2);
        TextView idLuz1 = (TextView)findViewById(R. id. idLuz1);
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*if(GlobalClass.agua != null){
           // aguaCasa.setText(GlobalClass.agua);
        }

        if(GlobalClass.compras1 !=null){
          //  idCompras1.setText(GlobalClass.compras1);
        }

        if(GlobalClass.compras2 !=null){
            idCompras2.setText(GlobalClass.compras2);
        }

        if(GlobalClass.luz !=null){
            idLuz1.setText(GlobalClass.luz);
        }*/

    }

    public void addAgua(View view){
        Intent intent = new Intent(this, AddAgua.class);
        startActivity(intent);
    }

    public void addCompras(View view){
        Intent intent = new Intent(this, AddCompras.class);
        startActivity(intent);
    }

    public void addLuz(View view){
        Intent intent = new Intent(this, AddLuz.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, manageHouse.class);
        startActivity(intent);

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
            Intent searchIntent = new Intent(AddDespesas.this, ShopList.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_expenses) {
            Intent searchIntent = new Intent(AddDespesas.this, AddDespesas.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_group) {
            Intent searchIntent = new Intent(AddDespesas.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
