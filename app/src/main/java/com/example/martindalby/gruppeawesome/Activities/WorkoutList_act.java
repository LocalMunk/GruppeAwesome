package com.example.martindalby.gruppeawesome.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.preference.PreferenceManager.OnActivityResultListener;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.GrafData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.SetData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;
import com.example.martindalby.gruppeawesome.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Martin Dalby on 17-11-2016.
 */

public class WorkoutList_act extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener{

    String[] ovelser;
    int[] setsArray;
    WorkoutListAdapter adapter;
    ListView listView;
    private Toolbar toolbar;
    MainController datafiles;
    WorkoutData workoutData;
    SharedPreferences sharedPreferences;
    Button doneButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        datafiles = MainController.getInstans();
        int i = getIntent().getIntExtra("workout", 0);
        workoutData = datafiles.bruger.getTræningsPlan().getWorkout(i);
        adapter = new WorkoutListAdapter(this);

        listView = (ListView) findViewById(R.id.Ovelselistview);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        listView.setAdapter(adapter);
        System.out.println("1 check");

        doneButton = (Button) findViewById(R.id.doneworkout);
        doneButton.setOnClickListener(this);
        doneButton.setText("Færdiggør workout");


        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(workoutData.getWorkoutname());
        setSupportActionBar(toolbar);
    }

    public void onDestroy(){
        super.onDestroy();
        finishWorkout();
        datafiles.pushUser(datafiles.bruger);
    }

    @Override
    public void onClick(View v) {
        if(v == doneButton){
            workoutData.setLastDate(Calendar.getInstance().getTime());
            for (OvelseData data : workoutData.getOvelser()) {
                data.setDone(0);
            }
            finish();
        }
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Ovelse_act.class);
        i.putExtra("titles",ovelser);
        i.putExtra("sets",setsArray);
        i.putExtra("pos", position);
        i.putExtra("workout", getIntent().getIntExtra("workout", 0));

        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("inde i onActivityResult");
        System.out.println(workoutData.getOvelser());
        adapter.notifyDataSetChanged();
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

                ArrayList ny = new ArrayList<SetData>();
                data.setGraf(new GrafData(ny));


                try {
                    workoutData.getOvelser().add(data);
                }
                catch(NullPointerException e){
                    ArrayList<OvelseData> out = new ArrayList<OvelseData>();
                    out.add(data);
                    workoutData.setOvelser(out);
                }
                listView.invalidateViews();
                listView.refreshDrawableState();
                datafiles.bruger.getTræningsPlan().getWorkouts().set(getIntent().getIntExtra("workout", 0), workoutData);
                datafiles.pushUser(datafiles.bruger);
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

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.MyDialogTheme);

        final EditText editText = new EditText(this);
        dialog.setMessage("Vil du redigere eller slette denne øvelse?");
        dialog.setTitle("Redigér/slet");
        dialog.setView(editText);
        editText.setHint("Skriv det nye navn her:");


        dialog.setPositiveButton("Redigér", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                Editable ovelseNavn = editText.getText();
                workoutData.getOvelser().get(position).setNavn(ovelseNavn.toString());
                datafiles.bruger.getTræningsPlan().getWorkout(position).getOvelser().set(position,workoutData.getOvelser().get(position));
                datafiles.pushUser(datafiles.bruger);
                adapter.notifyDataSetChanged();
                listView.invalidateViews();
                listView.refreshDrawableState();
            }

        });

        dialog.setNegativeButton("Slet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                workoutData.getOvelser().remove(position);
                try{
                datafiles.bruger.getTræningsPlan().getWorkout(position).getOvelser().remove(position);
                }
                catch (IndexOutOfBoundsException e){
                    e.printStackTrace();
                }
                datafiles.pushUser(datafiles.bruger);
                listView.invalidateViews();
                listView.refreshDrawableState();
                adapter.notifyDataSetChanged();
            }
        });

        adapter.notifyDataSetChanged();

        dialog.show();
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
            } catch (Exception e) {
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
            if (workoutData.getOvelser().get(position).isDone() != 1) {
                img.setImageResource(R.drawable.fluebengraa);
            } else {
                img.setImageResource(R.drawable.fluebenhvid);
            }
            return view;
        }

    }

    public void finishWorkout(){
        try {
            int i = 0;
                for (OvelseData data : workoutData.getOvelser()) {
                if (data.isDone() == 1) {
                    i++;
                }
            }
            if (i == workoutData.getOvelser().size()) {
                workoutData.setLastDate(Calendar.getInstance().getTime());
                for (OvelseData data : workoutData.getOvelser()) {
                    data.setDone(0);
                }
            }
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}