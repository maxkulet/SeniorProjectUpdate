package rocket.team.seniorproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepFiveOnFragment extends Fragment {

    ImageButton nextStep5On;
    public StepFiveOnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_five_on, container, false);
        nextStep5On = (ImageButton) view.findViewById(R.id.nextStep5On);
        nextStep5On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StepSixOnFragment stepFiveOn = new StepSixOnFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, stepFiveOn);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });









        return view;
    }

}
