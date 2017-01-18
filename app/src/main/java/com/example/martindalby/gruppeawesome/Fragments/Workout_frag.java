package com.example.martindalby.gruppeawesome.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.preference.PreferenceManager;

import com.example.martindalby.gruppeawesome.DataFiles.BrugerData;
import com.example.martindalby.gruppeawesome.Database.DatabaseController;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;
import com.example.martindalby.gruppeawesome.R;
import com.example.martindalby.gruppeawesome.Activities.WorkoutList_act;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

import static android.R.attr.data;
import static android.R.attr.version;

/**
 * Created by frederik on 07-11-2016.
 */

public class Workout_frag extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    TextView GnsWorkout, talgns;
    TextView workoutgoal, talgoal;
    TextView antalworkouts, talantal;
    ListView workoutlist;
    MainController datafiles;
    DatabaseController db;
    TraeningsPlanData traeningsPlanData;
    FloatingActionButton fb;
    WorkoutAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.workout_list_frag, container, false);
        int[] i = {R.drawable.pizzalistepic, R.drawable.grafbb};

        datafiles = MainController.getInstans();
        traeningsPlanData = datafiles.bruger.getTræningsPlan();
        try {
            traeningsPlanData.setWorkouts(datafiles.sortByDate(traeningsPlanData.getWorkouts()));
            datafiles.bruger.setTræningsPlan(traeningsPlanData);
            datafiles.pushUser();
        } catch (NullPointerException e) {
            //Fejlen er forventet når en ny bruger oprettes
            e.printStackTrace();
        }

        adapter = new WorkoutAdapter(getActivity());



        double[] toptal = {datafiles.bruger.træningsPlan.traeningerDenneUge,
                datafiles.bruger.træningsPlan.getTraeningsGennemsnit(),
                datafiles.bruger.træningsPlan.getTraeningsMål()};

        fb=(FloatingActionButton)rod.findViewById(R.id.opretworkout);
        //OnClick for floating actionbutton
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == fb){

                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);


                    final EditText editText = new EditText(getActivity());
                    dialog.setMessage(R.string.newworkoutname);
                    dialog.setTitle(R.string.addworkout);
                    dialog.setView(editText);
                    editText.setHint(R.string.newWorkoutHint);


                    dialog.setPositiveButton(R.string.newWorkoutAccept, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int whichButton) {
                            Editable workoutNavn = editText.getText();

                            traeningsPlanData.addWorkout(new WorkoutData(traeningsPlanData.getWorkouts().size(), workoutNavn.toString(), new ArrayList<OvelseData>(), Calendar.getInstance().getTime()));
                            datafiles.bruger.setTræningsPlan(traeningsPlanData);
                            datafiles.pushUser(datafiles.bruger);
                            workoutlist.invalidateViews();
                            workoutlist.refreshDrawableState();
                        }

                    });

                    dialog.setNegativeButton(R.string.newWorkoutNotAccept, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int whichButton) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();

                }


            }
        });

        talgns = (TextView) rod.findViewById(R.id.TalGns);
        //talgns.setText("" + toptal[0]);
        talgns.setText("" + traeningsPlanData.getTraeningsGennemsnit());

        GnsWorkout = (TextView) rod.findViewById(R.id.GnsWorkout);
        GnsWorkout.setText(R.string.averagePerWeek);

        talgoal = (TextView) rod.findViewById(R.id.TalGoal);
        //talgoal.setText("" + (int) toptal[1]);
        talgoal.setText("" + traeningsPlanData.getTraeningsMål());

        workoutgoal = (TextView) rod.findViewById(R.id.WorkoutGoal);
        workoutgoal.setText(R.string.goalThisWeek);

        talantal = (TextView) rod.findViewById(R.id.TalAntal);
        //talantal.setText("" + (int) toptal[2]);
        talantal.setText("" + traeningsPlanData.getTraeningerDenneUge());

        antalworkouts = (TextView) rod.findViewById(R.id.AntalWorkouts);
        antalworkouts.setText(R.string.workoutsThisWeek);

        workoutlist = (ListView) rod.findViewById(R.id.workoutList);
        workoutlist.setOnItemClickListener(this);
        workoutlist.setOnItemLongClickListener(this);
        workoutlist.setAdapter(adapter);

        return rod;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getActivity(), WorkoutList_act.class);
        i.putExtra("workout", position);
        startActivityForResult(i, 1);

    }



    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);

        final EditText editText = new EditText(getActivity());
        dialog.setMessage(R.string.editOrDeleteWorkout);
        dialog.setTitle(R.string.EditDeleteWorkout);
        dialog.setView(editText);
        editText.setHint(R.string.EditWorkoutHint);


        dialog.setPositiveButton(R.string.EditWorkoutOKText, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                Editable workoutNavn = editText.getText();
                traeningsPlanData.getWorkouts().get(position).setWorkoutname(workoutNavn.toString());
                datafiles.bruger.getTræningsPlan().getWorkouts().set(position, traeningsPlanData.getWorkout(position));
                datafiles.pushUser(datafiles.bruger);
                workoutlist.invalidateViews();
                workoutlist.refreshDrawableState();
            }

        });

                dialog.setNegativeButton(R.string.EditWorkoutDeleteText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                traeningsPlanData.getWorkouts().remove(position);
                datafiles.bruger.getTræningsPlan().getWorkouts().remove(position);
                datafiles.pushUser(datafiles.bruger);
                workoutlist.invalidateViews();
                workoutlist.refreshDrawableState();
                adapter.notifyDataSetChanged();
            }
        });

        adapter.notifyDataSetChanged();
        workoutlist.invalidateViews();
        workoutlist.refreshDrawableState();
        dialog.show();
    return true;
    }


    public class WorkoutAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflter;

        public WorkoutAdapter(Context applicationContext) {

            this.context = applicationContext;
            inflter = (LayoutInflater.from(applicationContext));

        }

        @Override
        public int getCount() {
            try {
                return traeningsPlanData.getWorkouts().size();
            }
            catch(NullPointerException e){
                traeningsPlanData.setWorkouts(new ArrayList<WorkoutData>());
                return traeningsPlanData.getWorkouts().size();
            }
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view = inflter.inflate(R.layout.workout_listeelement, null);

                TextView workoutoverskrift = (TextView) view.findViewById(R.id.WorkoutOverskrift);
                workoutoverskrift.setText(traeningsPlanData.getWorkout(position).getWorkoutname());

                TextView workoutbeskrivelser = (TextView) view.findViewById(R.id.WorkoutBeskrivelse);
                try {
                    workoutbeskrivelser.setText(traeningsPlanData.getWorkout(position).getLastDate().toString().substring(0, 10));
                }
                catch(NullPointerException e){
                    e.printStackTrace();
                    workoutbeskrivelser.setText(R.string.WorkoutNeverCompletedText);
                }
                System.out.println(workoutoverskrift.getId());


            return view;
        }
    }
}
