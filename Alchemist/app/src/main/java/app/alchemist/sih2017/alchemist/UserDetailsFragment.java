package app.alchemist.sih2017.alchemist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Prasanna on 4/1/2017.
 */

public class UserDetailsFragment extends Fragment {


    TextView fname;
    TextView lname;
    TextView username;
    TextView phone;
    TextView email;
    TextView address;
    TextView birthdate;
    TextView gender;
    TextView department;
    TextView year;
    TextView institute;
    TextView state;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_user_details, container, false);
        fname = (TextView)rootView.findViewById(R.id.tv_fname);
        lname = (TextView)rootView.findViewById(R.id.tv_Lname);
        username = (TextView)rootView.findViewById(R.id.tv_Username);
        phone = (TextView)rootView.findViewById(R.id.tv_Phone);
        email = (TextView)rootView.findViewById(R.id.tv_Email);
        address = (TextView)rootView.findViewById(R.id.tv_Address);
        birthdate = (TextView)rootView.findViewById(R.id.tv_Bdate);
        gender = (TextView)rootView.findViewById(R.id.tv_Gender);
        institute = (TextView)rootView.findViewById(R.id.tv_Institute);
        state = (TextView)rootView.findViewById(R.id.tv_State);
        department = (TextView)rootView.findViewById(R.id.tv_Department);
        year = (TextView)rootView.findViewById(R.id.tv_Year);

        return rootView;
    }
}
