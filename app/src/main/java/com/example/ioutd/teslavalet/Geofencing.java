package com.example.ioutd.teslavalet;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import org.json.JSONObject;

/**
 * Created by ioutd on 1/20/2018.
 */

public class Geofencing extends IntentService{

    private static final String TAG = Geofencing.class.getSimpleName();

    public Geofencing(){super(TAG);}

    public Geofencing(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        // TODO: 1/21/2018 send exrta to intent with method value
        if (geofencingEvent != null && geofencingEvent.hasError()) {
            int errorCode = geofencingEvent.getErrorCode();
            Log.d(TAG, "onHandleIntent: errorCode= " + errorCode);
        }

        // Get the transition type
        if(geofencingEvent != null){
            int geofenceTransition = geofencingEvent.getGeofenceTransition();

            // Make sure the transition is the one desired
            if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER) {
                // TODO: 1/21/2018 send an HTTP REQUEST to open doors/trunk
                openTrunk();
                openFrontDriverDoor();
            }
        }
    }






    public void openTrunk() {
        AndroidNetworking.post("http://hackathon.intrepidcs.com/api/data")
                .addHeaders("Authorization", "Bearer c367b9df3ed900f462b2fc8dea1b73c26d5bd798d0fd732019133f8cb9ee7671")
                .addBodyParameter("command", "trunk")
                .setTag("trunk_test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Log.d("Trunk_test", "response " + response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("Trunk_test", "response_error " + error.getErrorBody());
                    }
                });
        Toast.makeText(this, "Open Trunk", Toast.LENGTH_LONG).show();
    }

    public void openFrunk() {
        AndroidNetworking.post("http://hackathon.intrepidcs.com/api/data")
                .addHeaders("Authorization", "Bearer c367b9df3ed900f462b2fc8dea1b73c26d5bd798d0fd732019133f8cb9ee7671")
                .addBodyParameter("command", "frunk")
                .setTag("trunk_test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Log.d("Trunk_test", "response " + response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("Trunk_test", "response_error " + error.getErrorBody());
                    }
                });
        Toast.makeText(this, "Open Trunk", Toast.LENGTH_LONG).show();
    }

    public void openFrontDriverDoor() {
        AndroidNetworking.post("http://hackathon.intrepidcs.com/api/data")
                .addHeaders("Authorization", "Bearer c367b9df3ed900f462b2fc8dea1b73c26d5bd798d0fd732019133f8cb9ee7671")
                .addBodyParameter("command", "openFrontDriverDoor")
                .setTag("trunk_test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Log.d("Trunk_test", "response " + response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("Trunk_test", "response_error " + error.getErrorBody());
                    }
                });
    }

    public void openFrontPassengerDoor() {
        AndroidNetworking.post("http://hackathon.intrepidcs.com/api/data")
                .addHeaders("Authorization", "Bearer c367b9df3ed900f462b2fc8dea1b73c26d5bd798d0fd732019133f8cb9ee7671")
                .addBodyParameter("command", "openFrontPassengerDoor")
                .setTag("trunk_test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Log.d("Trunk_test", "response " + response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("Trunk_test", "response_error " + error.getErrorBody());
                    }
                });
    }

    public void openBackPassengerDoor() {
        AndroidNetworking.post("http://hackathon.intrepidcs.com/api/data")
                .addHeaders("Authorization", "Bearer c367b9df3ed900f462b2fc8dea1b73c26d5bd798d0fd732019133f8cb9ee7671")
                .addBodyParameter("command", "openBackPassengerDoor")
                .setTag("trunk_test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Log.d("Trunk_test", "response " + response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("Trunk_test", "response_error " + error.getErrorBody());
                    }
                });
    }

    public void openBackDriverDoor() {
        AndroidNetworking.post("http://hackathon.intrepidcs.com/api/data")
                .addHeaders("Authorization", "Bearer c367b9df3ed900f462b2fc8dea1b73c26d5bd798d0fd732019133f8cb9ee7671")
                .addBodyParameter("command", "openBackDriverDoor")
                .setTag("trunk_test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Log.d("Trunk_test", "response " + response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("Trunk_test", "response_error " + error.getErrorBody());
                    }
                });
    }

}
