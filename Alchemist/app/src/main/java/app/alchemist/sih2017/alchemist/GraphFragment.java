package app.alchemist.sih2017.alchemist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class GraphFragment extends Fragment{
    public GraphFragment(){

    }
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth auth;
    String userId;
    Integer i;
    LineChart chart;
    LineDataSet dataSet;
    List<Entry> entries;
    LineData lineData ;
    LineDataSet dataSet2;
    LineData lineData2;

    LineGraphSeries<DataPoint> series;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_graph, container, false);
        i=0;
        auth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        userId=auth.getCurrentUser().getUid().toString();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("dailyusage").child(userId);
        mFirebaseDatabase.keepSynced(true);

        chart = (LineChart)rootView.findViewById(R.id.graph_dusage);
        entries = new ArrayList<>();
        /*series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(5, 6)
        });*/
        lineData = new LineData();
        dataSet = new LineDataSet(entries, "Label");
        //lineData2 = new LineData();
        //dataSet2 = new LineDataSet(entries, "Label");

        mFirebaseDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Long data = (Long) dataSnapshot.getValue();
                Log.e("ese",dataSnapshot+"");
                dataSet.addEntry(new Entry(i, data));
                //dataSet2.addEntry(new Entry(i, 13));

                dataSet.notifyDataSetChanged();
                i++;
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
        mFirebaseDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("Sdsd",""+dataSet+"####sdjasdg");
                dataSet.setColor(R.color.nav_background);
                dataSet.setLineWidth(6);
                dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                lineData.addDataSet(dataSet);
                //lineData.addDataSet(dataSet2);
                chart.setData(lineData);
                chart.invalidate();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }
}
