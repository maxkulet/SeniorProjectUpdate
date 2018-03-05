package rocket.team.seniorproject;


import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class StepEightOffFragment extends Fragment {

    ImageButton nextStep8Off;
    TextView text_step8_off;
    public StepEightOffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_eight_off, container, false);

        nextStep8Off = (ImageButton) view.findViewById(R.id.nextStep8Off);

        text_step8_off = (TextView) view.findViewById(R.id.text_step8_off);
        text_step8_off.setText(Html.fromHtml(  getString(R.string.content1_step8_on) + " " +
                getString(R.string.content7_step8_on) +  getString(R.string.content2_step8_on)));
        nextStep8Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)

            {

                                StepNineOffFragment stepNineOff = new StepNineOffFragment();
                                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.flContent, stepNineOff, "StepNineOff");
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();



            }
        });
        return view;
    }

}
