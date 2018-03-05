package rocket.team.seniorproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepEightOnFragment extends Fragment {


    public StepEightOnFragment() {
        // Required empty public constructor
    }

    ImageButton nextStep8On;
    TextView text_step8;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_eight, container, false);

        text_step8 = (TextView) view.findViewById(R.id.text_step8);
        text_step8.setText(Html.fromHtml(  getString(R.string.content1_step8_on) + " " +
                getString(R.string.content7_step8_on) +  getString(R.string.content2_step8_on)));
        nextStep8On = (ImageButton) view.findViewById(R.id.nextStep8On);
        nextStep8On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StepNineOnFragment stepNineOn = new StepNineOnFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, stepNineOn, "stepNineOn");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });







        return view;
    }

}
