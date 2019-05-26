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
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShopListSave extends AppCompatActivity {

    private static final String CHANNEL_ID = "CHANNEL1" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_save);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onLoad();
    }

    public void onLoad(){
        TextView textView = (TextView)findViewById(R. id. nameHouse);
        textView.setText("Casa: " + GlobalClass.defaultLocation);

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
        } else if (GlobalClass.item9 == null){
            GlobalClass.item9 = textView.getText().toString();
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
                        .setSmallIcon(R.drawable.ic_launcher_background)
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


}
