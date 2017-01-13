package com.example.martindalby.gruppeawesome.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.example.martindalby.gruppeawesome.DAL.DatabaseController;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;
import com.example.martindalby.gruppeawesome.R;
import com.example.martindalby.gruppeawesome.Activities.WorkoutList_act;

import java.util.ArrayList;

/**
 * Created by frederik on 07-11-2016.
 */

public class Workout_frag extends Fragment implements AdapterView.OnItemClickListener {

    TextView GnsWorkout, talgns;
    TextView workoutgoal, talgoal;
    TextView antalworkouts, talantal;
    ListView workoutlist;
    MainController datafiles;
    DatabaseController db;
    TraeningsPlanData traeningsPlanData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.workout_list_frag, container, false);
        int[] i = {R.drawable.pizzalistepic, R.drawable.grafbb};

        datafiles = MainController.getInstans();
        traeningsPlanData = datafiles.bruger.getTræningsPlan();
        WorkoutAdapter adapter = new WorkoutAdapter(getActivity());



        double[] toptal = {datafiles.bruger.træningsPlan.traeningerDenneUge,
                datafiles.bruger.træningsPlan.getTraeningsGennemsnit(),
                datafiles.bruger.træningsPlan.getTraeningsMål()};

        talgns = (TextView) rod.findViewById(R.id.TalGns);
        talgns.setText("" + toptal[0]);

        GnsWorkout = (TextView) rod.findViewById(R.id.GnsWorkout);
        GnsWorkout.setText("Gns. per uge");

        talgoal = (TextView) rod.findViewById(R.id.TalGoal);
        talgoal.setText("" + (int) toptal[1]);

        workoutgoal = (TextView) rod.findViewById(R.id.WorkoutGoal);
        workoutgoal.setText("Træningsmål denne uge");

        talantal = (TextView) rod.findViewById(R.id.TalAntal);
        talantal.setText("" + (int) toptal[2]);

        antalworkouts = (TextView) rod.findViewById(R.id.AntalWorkouts);
        antalworkouts.setText("Træninger denne uge");

        workoutlist = (ListView) rod.findViewById(R.id.workoutList);
        workoutlist.setOnItemClickListener(this);
        workoutlist.setAdapter(adapter);

        return rod;

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getActivity(), WorkoutList_act.class);
        i.putExtra("workout", position);
        startActivity(i);

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
                workoutbeskrivelser.setText("sup");

                System.out.println(workoutoverskrift.getId());


            return view;
        }



    }
}
