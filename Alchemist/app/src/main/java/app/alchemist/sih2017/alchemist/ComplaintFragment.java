package app.alchemist.sih2017.alchemist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Prasanna on 4/1/2017.
 */

public class ComplaintFragment extends Fragment {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth auth;
    EditText message;
    EditText phone;
    Button submit;
    Spinner lv;
    String userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_complaint, container, false);

        auth = FirebaseAuth.getInstance();
        final String email = auth.getCurrentUser().getEmail().toString();
        userId = auth.getCurrentUser().getUid();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("complaints").child(userId);


        lv = (Spinner)rootView.findViewById(R.id.spinner1);
        message=(EditText)rootView.findViewById(R.id.et_message);
        phone = (EditText)rootView.findViewById(R.id.et_phone);
        submit = (Button)rootView.findViewById(R.id.btn_submitComplaint);

        String[] data = {"Billing Problem","Water Quality Problem","New Connection Required","Meter Problem"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, data);
        lv.setAdapter(adapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("email",email);
                Log.e("message",message.getText().toString());
                Log.e("phone",phone.getText().toString());
                Log.e("spinner",lv.getSelectedItem().toString());
                Complaint complaint = new Complaint(phone.getText().toString(),email,message.getText().toString(),lv.getSelectedItem().toString());
                mFirebaseDatabase.setValue(complaint);
                Toast.makeText(rootView.getContext(),"Complaint Registered!! Action will be taken soon..",Toast.LENGTH_LONG).show();
            }
        });




        return rootView;
    }
}
