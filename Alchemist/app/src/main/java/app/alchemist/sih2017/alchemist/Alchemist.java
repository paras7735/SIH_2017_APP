package app.alchemist.sih2017.alchemist;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Prasanna on 3/20/2017.
 */

public class Alchemist extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}