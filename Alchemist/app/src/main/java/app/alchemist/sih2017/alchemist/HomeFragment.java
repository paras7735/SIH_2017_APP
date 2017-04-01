package app.alchemist.sih2017.alchemist;

/**
 * Created by Prasanna on 3/20/2017.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }


    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private DatabaseReference mFirebaseDatabase2;
    private FirebaseAuth auth;
    PieChart chart;
    String userId;
    PieDataSet dataSet;
    List<PieEntry> entries;
    PieData pieData ;
    Integer sum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//        txtDetails = (TextView) rootView.findViewById(R.id.txt_user);
        final TextView daily = (TextView) rootView.findViewById(R.id.daily);
        final TextView cost = (TextView)rootView.findViewById(R.id.tv_price);

        auth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();


        userId=auth.getCurrentUser().getUid().toString();
        // get reference to 'users' node
        mFirebaseDatabase2 = mFirebaseInstance.getReference("table").child("nodes");
        mFirebaseInstance.getReference("dailyusage").child(userId).keepSynced(true);
        mFirebaseDatabase = mFirebaseInstance.getReference("dailyusage").child(userId);
        mFirebaseDatabase.keepSynced(true);

        mFirebaseDatabase2.orderByChild("userId").equalTo(userId).keepSynced(true);
        //addUserChangeListener()
        chart = (PieChart) rootView.findViewById(R.id.charthome);
        entries = new ArrayList<>();

        pieData = new PieData();
        dataSet = new PieDataSet(entries, "");
        sum = 0;
        mFirebaseDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Long data = (Long) dataSnapshot.getValue();
                daily.setText("Daily usage :-  "+data);
                sum+=data.intValue()*4;
                cost.setText("Estimated cost :-  "+sum);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        final Integer[] ias = {0};
        mFirebaseDatabase2.orderByChild("userId").equalTo(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.e("meter data",dataSnapshot+"");

                DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                MeterData data = firstChild.getValue(MeterData.class);
                Float fl= Float.parseFloat(data.quality);
                Log.e("jhhg",fl+"");
                dataSet.clear();
                dataSet.addEntry(new PieEntry(fl));
                dataSet.addEntry(new PieEntry(10-fl));
                dataSet.setDrawValues(false);
                chart.setCenterText(data.quality);
                chart.setCenterTextSize(80);
                dataSet.setColors(new int[]{R.color.nav_background,R.color.input_login_hint},rootView.getContext());
                chart.setHoleRadius(90);
                if (ias[0]==0) {
                    pieData.addDataSet(dataSet);
                    chart.setData(pieData);

                }else{
                    pieData.notifyDataChanged();
                    chart.notifyDataSetChanged();
                    chart.invalidate();
                }
                if((fl>5)&&(ias[0]!=0)){
                    Notification n = new Notification.Builder(rootView.getContext()).setContentTitle("Water Quality").setContentText("Please Dont use water because the quality of water is very low currently").setSmallIcon(R.drawable.logo).build();
                    NotificationManager notificationManager =(NotificationManager)rootView.getContext().getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(0, n);
                }

                ias[0] =1;
//                txtDetails.setText("Quality\n"+data.quality);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        chart.getLegend().setEnabled(false);


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