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
public class StepNineOffFragment extends Fragment {

    ImageButton nextStep9Off;
    TextView text_step9;
    public StepNineOffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_nine_off, container, false);
        text_step9 = (TextView) view.findViewById(R.id.text_step9);
        text_step9.setText(Html.fromHtml(  getString(R.string.content1_step9_off) + " "  +getString(R.string.content4_step9_on) + " " +
                getString(R.string.content2_step9_on) +  getString(R.string.content3_step9_on)));
        nextStep9Off = (ImageButton) view.findViewById(R.id.nextStep9Off);


        nextStep9Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SummaryOnFragment sum = new SummaryOnFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, sum, "sum");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;
    }

}
