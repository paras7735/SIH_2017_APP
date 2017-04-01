package app.alchemist.sih2017.alchemist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Prasanna on 4/1/2017.
 */

public class ComplaintFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_complaint, container, false);
        Spinner lv = (Spinner)rootView.findViewById(R.id.spinner1);
        String[] data = {"a","b","c"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);




        return rootView;
    }
}
