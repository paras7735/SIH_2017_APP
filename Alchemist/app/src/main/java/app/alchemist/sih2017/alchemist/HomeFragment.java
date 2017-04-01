package app.alchemist.sih2017.alchemist;

/**
 * Created by Prasanna on 3/20/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }


    private TextView txtDetails;
    private Button btnSave;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private DatabaseReference mFirebaseDatabase2;
    private FirebaseAuth auth;
    String userId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        txtDetails = (TextView) rootView.findViewById(R.id.txt_user);
        final TextView daily = (TextView) rootView.findViewById(R.id.daily);
        btnSave = (Button) rootView.findViewById(R.id.btn_save);

        auth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();


        userId=auth.getCurrentUser().getUid().toString();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users").child(userId);
        mFirebaseDatabase2 = mFirebaseInstance.getReference("table").child("nodes");
        mFirebaseDatabase.keepSynced(true);
        mFirebaseInstance.getReference("dailyusage").child(userId).keepSynced(true);
        mFirebaseDatabase = mFirebaseInstance.getReference("dailyusage").child(userId);

        mFirebaseDatabase2.orderByChild("userId").equalTo(userId).keepSynced(true);
        //addUserChangeListener()
        mFirebaseDatabase.orderByChild(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("meter datjnnonoa",dataSnapshot+"");
                String data = (String) dataSnapshot.getValue().toString();

                daily.setText("Daily Usage\n"+data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mFirebaseDatabase2.orderByChild("userId").equalTo(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("meter data",dataSnapshot+"");
                DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                MeterData data = firstChild.getValue(MeterData.class);

                txtDetails.setText("Quality\n"+data.quality);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent = new Intent(rootView.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });





        return rootView;
    }

    /*private void addUserChangeListener() {
        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("HomeFragment", "Failed to read    user", error.toException());
            }
        });
    }*/
}