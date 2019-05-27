package rc.EasyMates;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VerDespesa extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_despesa);
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
            Intent searchIntent = new Intent(VerDespesa.this, ShopList.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_expenses) {
            Intent searchIntent = new Intent(VerDespesa.this, Add_AddDespesas.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_group) {
            Intent searchIntent = new Intent(VerDespesa.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.logout) {
            Intent searchIntent = new Intent(VerDespesa.this, Login.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.manage_house) {
            Intent searchIntent = new Intent(VerDespesa.this, manageHouse.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.profile){
            Intent searchIntent = new Intent(VerDespesa.this, Profile.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.dashboard){
            Intent searchIntent = new Intent(VerDespesa.this, Dashboard.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onLoad(){
        TextView name = (TextView) findViewById(R.id.textView18);
        TextView valor = (TextView) findViewById(R.id.textView20);
        TextView desc = (TextView) findViewById(R.id.textView16);

        String desp;
        String [] despi;
        String chars = "";

        switch (GlobalClass.checker){
            case "despesa1":
                desp = GlobalClass.despesa1;
                despi = desp.split(" ");

                name.setText(despi[0]);
                valor.setText(despi[2]);

                for (int i = 4; i < despi.length; i++ ){
                    chars = chars + " " + despi[i];
                }

                desc.setText(chars);
                break;
            case "despesa2":
                desp = GlobalClass.despesa2;
                despi = desp.split(" ");

                name.setText(despi[0]);
                valor.setText(despi[2]);

                for (int i = 4; i < despi.length; i++ ){
                    chars = chars + " " + despi[i];
                }

                desc.setText(chars);
                break;
            case "despesa3":
                desp = GlobalClass.despesa3;
                despi = desp.split(" ");

                name.setText(despi[0]);
                valor.setText(despi[2]);

                for (int i = 4; i < despi.length; i++ ){
                    chars = chars + " " + despi[i];
                }

                desc.setText(chars);
                break;
            case "despesa4":
                desp = GlobalClass.despesa4;
                despi = desp.split(" ");

                name.setText(despi[0]);
                valor.setText(despi[2]);

                for (int i = 4; i < despi.length; i++ ){
                    chars = chars + " " + despi[i];
                }

                desc.setText(chars);
                break;
            case "despesa5":
                desp = GlobalClass.despesa5;
                despi = desp.split(" ");

                name.setText(despi[0]);
                valor.setText(despi[2]);

                for (int i = 4; i < despi.length; i++ ){
                    chars = chars + " " + despi[i];
                }

                desc.setText(chars);
                break;
            case "despesa6":
                desp = GlobalClass.despesa6;
                despi = desp.split(" ");

                name.setText(despi[0]);
                valor.setText(despi[2]);

                for (int i = 4; i < despi.length; i++ ){
                    chars = chars + " " + despi[i];
                }

                desc.setText(chars);
                break;
        }
    }

    public void checkDespesa(View view){
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        if (simpleSwitch.isChecked()){
            switch (GlobalClass.checker){
                case "despesa1":
                    GlobalClass.despesa1 = null;
                    showNotification();
                    break;
                case "despesa2":
                    GlobalClass.despesa2 = null;
                    showNotification();
                    break;
                case "despesa3":
                    GlobalClass.despesa3 = null;
                    showNotification();
                    break;
                case "despesa4":
                    GlobalClass.despesa4 = null;
                    showNotification();
                    break;
                case "despesa5":
                    GlobalClass.despesa5 = null;
                    showNotification();
                    break;
                case "despesa6":
                    GlobalClass.despesa6 = null;
                    showNotification();
                    break;
            }
        }
        Intent intent = new Intent(this, Add_AddDespesas.class);
        startActivity(intent);
    }

    private void showNotification() {
        String NOTIFICATION_CHANNEL_ID = "my_channel_03";
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("Despesas pagas")
                        .setContentText(GlobalClass.userName + " efetuou o pagamento das despesas");
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
