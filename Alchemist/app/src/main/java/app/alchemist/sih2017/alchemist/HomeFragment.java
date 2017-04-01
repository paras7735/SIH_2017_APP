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
    PieChart chart_lastdusage;
    PieChart chart_cost;
    String userId;
    PieDataSet dataSet;
    PieDataSet dataSet2;
    PieDataSet dataSet3;
    List<PieEntry> entries;
    List<PieEntry> entries2;
    PieData pieData ;
    PieData pieData2 ;
    PieData pieData3 ;
    Integer sum;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//        txtDetails = (TextView) rootView.findViewById(R.id.txt_user);

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
        chart_lastdusage = (PieChart) rootView.findViewById(R.id.chart_lastdusage);
        chart_cost = (PieChart) rootView.findViewById(R.id.chart_cost);



        entries = new ArrayList<>();
        entries2 = new ArrayList<>();
        pieData = new PieData();
        pieData2 = new PieData();
        pieData3 = new PieData();
        dataSet = new PieDataSet(entries, "");
        dataSet2 = new PieDataSet(entries, "");
        sum = 0;
        final Integer[] first_time={0};

        mFirebaseDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Long data = (Long) dataSnapshot.getValue();
                sum+=data.intValue()*4;
                Log.e("sum+= ",sum+"");
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
        mFirebaseDatabase.limitToLast(1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                Float fl= Float.parseFloat(firstChild.getValue().toString());
                Log.e("sum in askd",sum+"");
                Double x =  (Math.floor(fl/5));
                Integer y = x.intValue()+1;
                float z = y*5;

                float a = z-fl;
                Integer b = 1000-sum;



                entries2.clear();
                entries2.add(new PieEntry(sum));
                entries2.add(new PieEntry(b));
                dataSet3= new PieDataSet(entries2,"sdd");
                dataSet3.setDrawValues(false);
                chart_cost.setCenterText("₹"+sum);
                chart_cost.setCenterTextSize(40);
                dataSet3.setColors(new int[]{R.color.piechart3,R.color.piechart_secondary},rootView.getContext());
                chart_cost.setHoleRadius(90);

                dataSet2.clear();
                dataSet2.addEntry(new PieEntry(fl));
                dataSet2.addEntry(new PieEntry(a));
                dataSet2.setDrawValues(false);
                chart_lastdusage.setCenterText(fl+"");
                chart_lastdusage.setCenterTextSize(40);
                dataSet2.setColors(new int[]{R.color.piechart2,R.color.piechart_secondary},rootView.getContext());
                chart_lastdusage.setHoleRadius(90);



                Log.e("15-fl and fl",a+" and "+fl);
                Log.e("10000-b and sum",b+" and "+sum);

                if (first_time[0]==0) {
                    pieData2.notifyDataChanged();
                    pieData2.addDataSet(dataSet2);
                    chart_lastdusage.setData(pieData2);
                    chart_lastdusage.invalidate();

                    pieData3.notifyDataChanged();
                    pieData3.addDataSet(dataSet3);
                    chart_cost.setData(pieData3);
                    chart_cost.invalidate();
                }else{
                    chart_lastdusage.notifyDataSetChanged();
                    chart_lastdusage.invalidate();

                    chart_cost.notifyDataSetChanged();
                    chart_cost.invalidate();

                }
                first_time[0]=1;
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
                dataSet.setColors(new int[]{R.color.piechart1,R.color.piechart_secondary},rootView.getContext());
                chart.setHoleRadius(90);
                if (ias[0]==0) {
                    pieData.notifyDataChanged();
                    pieData.addDataSet(dataSet);
                    pieData.setHighlightEnabled(true);
                    chart.setData(pieData);
                    pieData.setHighlightEnabled(true);
                    chart.invalidate();
                }else{
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
        chart_lastdusage.getLegend().setEnabled(false);
        chart_cost.getLegend().setEnabled(false);

        chart.getDescription().setText("");
        chart_lastdusage.getDescription().setText("");
        chart_cost.getDescription().setText("");

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