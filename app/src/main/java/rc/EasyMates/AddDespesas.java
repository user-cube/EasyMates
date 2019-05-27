package rc.EasyMates;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddDespesas extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_despesas);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            Intent searchIntent = new Intent(AddDespesas.this, ShopList.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_expenses) {
            Intent searchIntent = new Intent(AddDespesas.this, Add_AddDespesas.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_group) {
            Intent searchIntent = new Intent(AddDespesas.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.logout) {
            Intent searchIntent = new Intent(AddDespesas.this, Login.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_house) {
            Intent searchIntent = new Intent(AddDespesas.this, Dashboard.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }else if (id == R.id.profile){
            Intent searchIntent = new Intent(AddDespesas.this, Profile.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.dashboard){
            Intent searchIntent = new Intent(AddDespesas.this, Dashboard.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void addDespesa(View view) {
        TextView valor, desc;

        valor = (TextView) findViewById(R.id.editText12);
        desc = (TextView) findViewById(R.id.editText11);

        String val = valor.getText().toString();
        String des = desc.getText().toString();

        if (GlobalClass.despesa1 == null){
            GlobalClass.despesa1 = GlobalClass.userName + " adicionou: " + val + "€ - " + des;
            Toast.makeText(AddDespesas.this,"Despesa adicionada",Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, Add_AddDespesas.class);
            startActivity(intent);
        } else if (GlobalClass.despesa2 == null){
            GlobalClass.despesa2 = GlobalClass.userName + " adicionou: " + val + "€ - " + des;
            Toast.makeText(AddDespesas.this,"Despesa adicionada",Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, Add_AddDespesas.class);
            startActivity(intent);
        } else if (GlobalClass.despesa3 == null){
            GlobalClass.despesa3 = GlobalClass.userName + " adicionou: " + val + "€ - " + des;
            Toast.makeText(AddDespesas.this,"Despesa adicionada",Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, Add_AddDespesas.class);
            startActivity(intent);
        } else if (GlobalClass.despesa4 == null){
            GlobalClass.despesa4 = GlobalClass.userName + " adicionou: " + val + "€ - " + des;
            Toast.makeText(AddDespesas.this,"Despesa adicionada",Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, Add_AddDespesas.class);
            startActivity(intent);
        } else if (GlobalClass.despesa5 == null){
            GlobalClass.despesa5 = GlobalClass.userName + " adicionou: " + val + "€ - " + des;
            Toast.makeText(AddDespesas.this,"Despesa adicionada",Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, Add_AddDespesas.class);
            startActivity(intent);
        } else if (GlobalClass.despesa6 == null){
            GlobalClass.despesa6 = GlobalClass.userName + " adicionou: " + val + "€ - " + des;
            Toast.makeText(AddDespesas.this,"Despesa adicionada",Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, Add_AddDespesas.class);
            startActivity(intent);
        }

    }

    private void showNotification() {
        String NOTIFICATION_CHANNEL_ID = "my_channel_02";
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("Despesas adicionadas")
                        .setContentText(GlobalClass.userName + " adicionou despesas");
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            NotificationChannel nChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", NotificationManager.IMPORTANCE_HIGH);
            nChannel.enableLights(true);
            assert manager != null;
            builder.setChannelId(NOTIFICATION_CHANNEL_ID);
            manager.createNotificationChannel(nChannel);
        }
        assert manager != null;
        manager.notify(0, builder.build());
    }
}
