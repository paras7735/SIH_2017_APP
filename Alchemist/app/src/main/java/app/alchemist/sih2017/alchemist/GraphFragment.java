package app.alchemist.sih2017.alchemist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by Prasanna on 3/21/2017.
 */

public class GraphFragment extends Fragment{
    public GraphFragment(){

    }
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth auth;
    String userId;
    Integer i;

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

        final GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        /*series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(5, 6)
        });*/
        series = new LineGraphSeries<>();
        mFirebaseDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                graph.addSeries(series);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mFirebaseDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Long data = (Long) dataSnapshot.getValue();
                series.appendData(new DataPoint(i++,data),false,20);
                Log.e("graph 0", dataSnapshot.getValue().toString()+" sdsd  "+data);
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
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(20);
        graph.getViewport().setMinY(0.0);
        graph.getViewport().setMaxY(20.0);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        return rootView;
    }
}
