package rocket.team.seniorproject;


import android.app.Activity;
import android.content.Intent;
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
public class StepNineOnFragment extends Fragment {


    public StepNineOnFragment() {
        // Required empty public constructor
    }

    ImageButton nextStep9On;
    TextView text_step9;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_nine, container, false);

        text_step9 = (TextView) view.findViewById(R.id.text_step9);
        text_step9.setText(Html.fromHtml(  getString(R.string.content4_step9_on) + " " +
                getString(R.string.content2_step9_on) +  getString(R.string.content3_step9_on)));
        nextStep9On = (ImageButton) view.findViewById(R.id.nextStep9On);


        nextStep9On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SummaryOnFragment sumOn = new SummaryOnFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, sumOn, "sumOn");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });







        return view;
    }

}
