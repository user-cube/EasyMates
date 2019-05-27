package rc.EasyMates;

import android.annotation.TargetApi;
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

public class ShopListSave extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String CHANNEL_ID = "CHANNEL1" ;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_save);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void store(View view) {

        TextView textView = (TextView)findViewById(R. id. itemName);
        if (GlobalClass.item5 == null) {
            GlobalClass.item5 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else if (GlobalClass.item6 == null){
            GlobalClass.item6 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else if (GlobalClass.item7 == null){
            GlobalClass.item7 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else if (GlobalClass.item8 == null){
            GlobalClass.item8 = textView.getText().toString();
            Toast.makeText(ShopListSave.this, "Item adicionado!", Toast.LENGTH_LONG).show();
            showNotification();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        } else {
            Toast.makeText(ShopListSave.this, "Item não adicionado!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ShopList.class);
            startActivity(intent);
        }

    }


    private void showNotification() {
        String NOTIFICATION_CHANNEL_ID = "my_channel_01";
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("Lista de compras")
                        .setContentText(GlobalClass.userName + " adicionou itens à lista de compras");
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
            Intent searchIntent = new Intent(ShopListSave.this, ShopList.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_expenses) {
            Intent searchIntent = new Intent(ShopListSave.this, Add_AddDespesas.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_group) {
            Intent searchIntent = new Intent(ShopListSave.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.logout) {
            Intent searchIntent = new Intent(ShopListSave.this, Login.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.profile){
            Intent searchIntent = new Intent(ShopListSave.this, Profile.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.dashboard){
            Intent searchIntent = new Intent(ShopListSave.this, Dashboard.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
