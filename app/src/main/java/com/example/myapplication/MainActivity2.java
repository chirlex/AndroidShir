package com.example.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    private static final String CHANNEL_ID = "1000";
    private Button btnEstadoMoto, btnMantenimiento, btnInfoMotos, btnKilometraje, btnTipoMoto, btnInforUsuario, btnNotificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Vincular vistas
        btnEstadoMoto = findViewById(R.id.btnEstadoMoto);
        btnMantenimiento = findViewById(R.id.btnMantenimiento);
        btnInfoMotos = findViewById(R.id.btnInfoMotos);
        btnKilometraje = findViewById(R.id.btnKilometraje);
        btnTipoMoto = findViewById(R.id.btnTipoMoto);
        btnInforUsuario = findViewById(R.id.btnInforUsuario);
        btnNotificaciones = findViewById(R.id.btnSendNotification);

        // Configurar botones para redirigir a actividades específicas
        btnEstadoMoto.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, com.example.myapplication.EstadoMotoActivity.class)));
        btnMantenimiento.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, MantenimientoActivity.class)));
        btnKilometraje.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, com.example.myapplication.KilometrajeActivity.class)));
        btnTipoMoto.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, com.example.myapplication.TipoMotoActivity.class)));

        // Configurar el botón de notificaciones
        btnNotificaciones.setOnClickListener(v -> {
            createNotificationChannel(); // Crear el canal de notificación
            sendNotification();          // Enviar la notificación
        });
    }

    // Crear el canal de notificación (Android 8.0+)
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Canal de Notificaciones";
            String description = "Este es el canal de notificaciones para recordatorios";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    // Enviar la notificación
    private void sendNotification() {
        String message = "Recuerda mantener tu moto en buen estado.";

        // Verificar permisos para notificaciones (Android 13+)
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
        } else {
            // Intent para abrir MainActivity cuando se toque la notificación
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("notification_message", message);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE
            );

            // Crear la notificación
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_notifications_black_24dp) // Cambia este ícono por uno válido
                    .setContentTitle("Recordatorio de Mantenimiento")
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            // Mostrar la notificación
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(1, builder.build());
            Log.d("Notifications", "Notificación enviada");
        }
    }
}
