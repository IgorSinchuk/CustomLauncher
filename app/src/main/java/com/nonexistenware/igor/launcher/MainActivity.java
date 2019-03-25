package com.nonexistenware.igor.launcher;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    boolean run = true;

    //time
    private TextView time_txt, date_txt, ram_txt, cpu_txt, speed_txt, freq_txt;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    private long startRX = 0;
    private long startTX = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_txt = findViewById(R.id.time_txt);
        date_txt = findViewById(R.id.date_txt);
        ram_txt = findViewById(R.id.ram_txt);
        cpu_txt = findViewById(R.id.cpu_txt);
        speed_txt = findViewById(R.id.speed_txt);
        freq_txt = findViewById(R.id.freq_txt);

        calendar = Calendar.getInstance();

        dateTime();
        cpuUsageRun();
        connectionSpeed();

    }

    public void connectionSpeed() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            speed_txt.setText("S: " +wifiInfo.getLinkSpeed() + wifiInfo.LINK_SPEED_UNITS);
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
               freq_txt.setText("F: "+ wifiInfo.getFrequency() + wifiInfo.FREQUENCY_UNITS);
           }
        }
    }

    private void dateTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    try {
                        Thread.sleep(1000);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Calendar time_date = Calendar.getInstance();
                                long update = System.currentTimeMillis();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                                String dateString = dateFormat.format(update);
                                String timeString = timeFormat.format(update);
                                time_txt.setText(timeString);
                                date_txt.setText(dateString);

                            }
                        });
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }

    public void cpuUsageRun() {
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                cpu_txt.setText(" "+cpuUsage());
                handler.postDelayed(this,1000);
            }
        };

        handler.postDelayed(r, 1000);
    }

    private float cpuUsage() {
        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            String load = reader.readLine();

            String[] toks = load.split(" ");

            long idle1 = Long.parseLong(toks[5]);
            long cpu1 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

            try {
                Thread.sleep(360);
            } catch (Exception e) {}

            reader.seek(0);
            load = reader.readLine();
            reader.close();

            toks = load.split(" ");

            long idle2 = Long.parseLong(toks[5]);
            long cpu2 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

            return (float) (cpu2 - cpu1) /((cpu2 + idle2) - (cpu1 + idle1));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
