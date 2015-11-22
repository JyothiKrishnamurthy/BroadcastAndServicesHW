package com.example.jyothikrishnamurthy.broadcastandservices;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SmsAndPhoneCallBR extends BroadcastReceiver {
    public SmsAndPhoneCallBR() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //throw new UnsupportedOperationException("Not yet implemented");
        if ("android.android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
            Intent i = new Intent(context, FileService.class);
            context.startService(i);
        }
        if ("android.intent.action.NEW_OUTGOING_CALL".equals(intent.getAction())) {
            String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.i("Outgoing call", "Outgoing call happened : " + intent.getAction());
            Toast.makeText(context, "Outgoing number : " + number, Toast.LENGTH_LONG).show();
        }
    }
}
