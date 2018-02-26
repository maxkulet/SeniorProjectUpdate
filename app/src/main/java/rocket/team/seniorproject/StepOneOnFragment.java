package rocket.team.seniorproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepOneOnFragment extends Fragment {

ImageButton step1NextOn;
RadioButton step1_yes_radio,step1_no_radio;
String myDNA;
   // HomeFragment fragment = new HomeFragment();

    public StepOneOnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_one_on, container, false);
        getActivity().setTitle("Power On");
        step1NextOn = (ImageButton) view.findViewById(R.id.step1NextOn);
        step1_yes_radio = (RadioButton) view.findViewById(R.id.step1_yes_radio);
        step1_no_radio = (RadioButton) view.findViewById(R.id.step1_no_radio);






        step1NextOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (step1_yes_radio.isChecked()) {
                    MainActivity.myDeviceDNA = getString(R.string.content4_summary_on);
                    AlertDialog.Builder alert= new AlertDialog.Builder(
                            getActivity ());
                    // set title
                    alert.setTitle(Html.fromHtml(getString(R.string.warn_message)));
                    // set dialog message
                    alert
                            .setIcon(R.drawable.warning)
                            .setMessage(Html.fromHtml(getString(R.string.content2_step1_on) + "\n"
                                    + getString(R.string.content3_step1_on)))
                            .setCancelable(false)
                            .setPositiveButton("GOT IT",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    StepTwoOnFragment stepTwoOn = new StepTwoOnFragment();

                                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.flContent, stepTwoOn);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alert.create();

                    // show it
                    alertDialog.show();

                } else if (step1_no_radio.isChecked()){
                    MainActivity.myDeviceDNA = getString(R.string.content5_summary_on);
                    StepTwoOnFragment stepTwoOn = new StepTwoOnFragment();
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flContent, stepTwoOn);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } else {
                    AlertDialog.Builder alertCheck = new AlertDialog.Builder(
                            getActivity ());
                    alertCheck.setTitle(Html.fromHtml(getString(R.string.warn_message)));

                    // set dialog message
                    alertCheck
                            .setIcon(R.drawable.warning)
                            .setMessage(Html.fromHtml(getString(R.string.warning3)))
                            .setCancelable(false)
                            .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });
                    // create alert dialog
                    AlertDialog alertDialogCheck = alertCheck.create();

                    // show it
                    alertDialogCheck.show();
                }




            }
        });
        return view;
    }


}
