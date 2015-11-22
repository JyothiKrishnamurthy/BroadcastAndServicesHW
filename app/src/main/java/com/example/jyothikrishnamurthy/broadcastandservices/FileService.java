package com.example.jyothikrishnamurthy.broadcastandservices;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileService extends Service {
    public FileService() {
    }

    public void onCreate(){
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       new BackgroundAsyncTask().execute();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }


     public class BackgroundAsyncTask extends AsyncTask<Void, Void, Void> {

         protected void onPreExecute() {
             super.onPreExecute();
         }


         @Override
         public Void doInBackground(Void... params) {
             // TODO Auto-generated method stub
             try {
                 File myFile = new File("/sdcard/mysdfile.txt");
                 myFile.createNewFile();
                 FileOutputStream fOut = new FileOutputStream(myFile);
                 OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                 myOutWriter.append("service was started");
                 myOutWriter.close();
                 fOut.close();
                 Log.v("Debug", "File created");
             } catch (Exception e) {
                 Log.v("Debug", "Inside exception" + e.getMessage());
             }

    return null;
         }

         protected void onPostExecute(Void result) {
             super.onPostExecute(result);
         }
     }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
