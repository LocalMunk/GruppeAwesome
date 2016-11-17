package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Martin Dalby on 17-11-2016.
 */

public class WorkoutList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TestDataOvelser data;
    WorkoutListAdapter adapter;
    ListView listView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        data = new TestDataOvelser();
        adapter = new WorkoutListAdapter(this);

        listView = (ListView) findViewById(R.id.Ovelselistview);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        System.out.println("1 check");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Ovelse.class);
        i.putExtra("title",data.getOvelser()[position].getOverskrift());
        i.putExtra("sets",data.getOvelser()[position].getsets());
        startActivity(i);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("WorkoutList Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public class WorkoutListAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflter;

        public WorkoutListAdapter(Context applicationContext) {

            this.context = applicationContext;
            //  this.listimg = ListImg;
            inflter = (LayoutInflater.from(applicationContext));
            System.out.println("check 2");


        }

        //Her afgøres længde på liste ud fra hvilken knap man trykker paa
        @Override
        public int getCount() {
            return data.getOvelser().length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        } //bruges ikke

        @Override
        public long getItemId(int position) {
            return 0;
        } //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflter.inflate(R.layout.workoutlist_list, null);

            TextView exerciseName = (TextView) view.findViewById(R.id.exercisename);
            exerciseName.setText(data.getOvelser()[position].getOverskrift());

            TextView sets = (TextView) view.findViewById(R.id.setsview);
            sets.setText(data.getOvelser()[position].getsets() + " sets");

            ImageView img = (ImageView) view.findViewById(R.id.ovelsebutton);
            return view;
        }

    }
}
