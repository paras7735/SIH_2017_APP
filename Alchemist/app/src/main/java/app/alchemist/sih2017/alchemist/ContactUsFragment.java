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

public class ContactUsFragment extends Fragment {


    TextView fname;
    TextView lname;
    TextView username;
    TextView phone;
    TextView email;
    TextView address;
    TextView title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_user_details, container, false);
        fname = (TextView)rootView.findViewById(R.id.tv_fname);
        lname = (TextView)rootView.findViewById(R.id.tv_Lname);
        username = (TextView)rootView.findViewById(R.id.tv_Username);
        phone = (TextView)rootView.findViewById(R.id.tv_Phone);
        email = (TextView)rootView.findViewById(R.id.tv_Email);
        address = (TextView)rootView.findViewById(R.id.tv_Address);
        title = (TextView)rootView.findViewById(R.id.textView9);
        title.setText("Supplier Details");

        return rootView;
    }
}
