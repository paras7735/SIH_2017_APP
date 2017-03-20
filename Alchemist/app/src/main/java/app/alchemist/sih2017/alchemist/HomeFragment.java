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
    private FirebaseAuth auth;
    String userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        txtDetails = (TextView) rootView.findViewById(R.id.txt_user);
        btnSave = (Button) rootView.findViewById(R.id.btn_save);
        auth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();


        userId=auth.getCurrentUser().getUid().toString();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users").child(userId);
        mFirebaseDatabase.keepSynced(true);
        mFirebaseInstance.getReference("dailyusage").child(userId).keepSynced(true);
        addUserChangeListener();

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

    private void addUserChangeListener() {
        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                txtDetails.setText(user.password + ", " + user.email);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("HomeFragment", "Failed to read    user", error.toException());
            }
        });
    }

}