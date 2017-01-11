package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 17-11-2016.
 */

public class WorkoutList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] ovelser;
    int[] setsArray;
    WorkoutListAdapter adapter;
    ListView listView;
    private Toolbar toolbar;
    MainController datafiles;
    WorkoutData workoutData;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        datafiles = MainController.getInstans();
        workoutData = datafiles.bruger.getTræningsPlan().getWorkout(getIntent().getIntExtra("workout", 0));
        adapter = new WorkoutListAdapter(this);
        int i = getIntent().getIntExtra("workout", 0);
        listView = (ListView) findViewById(R.id.Ovelselistview);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        System.out.println("1 check");


        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(workoutData.getWorkoutname());
        setSupportActionBar(toolbar);


    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Ovelse.class);
        i.putExtra("titles",ovelser);
        i.putExtra("sets",setsArray);
        i.putExtra("pos", position);
        i.putExtra("workout", getIntent().getIntExtra("workout", 0));

        startActivity(i);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.workoutlistmenu, menu);

        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)

    {    if(item.getItemId() == R.id.ooknap){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.MyDialogTheme);

        //LayoutInflater li = LayoutInflater.from(this);
        //View dialogView = li.inflate(R.layout.opretworkoutdialog, null);

        final EditText editText = new EditText(this);
        //dialog.setView(dialogView);
        dialog.setMessage("Hvad skal din øvelse hedde?");
        dialog.setTitle("Opret opretøvelse");
        dialog.setView(editText);
        editText.setHint("Navn");

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String workoutNavn = editText.getText().toString();
                OvelseData data;
                try {
                    data = new OvelseData(workoutData.getOvelser().size(), workoutNavn, 0, 3);
                }
                catch(Exception e){
                    data = new OvelseData(0, workoutNavn, 0, 3);
                }
                try {
                    workoutData.getOvelser().add(data);
                }
                catch(NullPointerException e){
                    ArrayList<OvelseData> out = new ArrayList<OvelseData>();
                    out.add(data);
                    workoutData.setOvelser(out);
                }
                datafiles.pushUser(datafiles.bruger);
                listView.invalidateViews();
                listView.refreshDrawableState();



            }
        });

        dialog.setNegativeButton("Anullér", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });

        dialog.show();





    }
        return true;
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
            try {
                return workoutData.getOvelser().size();
            }
            catch(Exception e){
                return 0;
            }
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
            view = inflter.inflate(R.layout.ovelselist_element, null);

            TextView exerciseName = (TextView) view.findViewById(R.id.exercisename);
            exerciseName.setText(workoutData.getOvelser().get(position).getNavn());

            ImageView img = (ImageView) view.findViewById(R.id.ovelsebutton);
            if(workoutData.getOvelser().get(position).isDone() != 1){
                img.setImageResource(R.drawable.fluebengraa);
            }
            else{
                img.setImageResource(R.drawable.fluebenhvid);
            }
            return view;
        }
    }
}