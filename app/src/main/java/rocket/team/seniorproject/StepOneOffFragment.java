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
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepOneOffFragment extends Fragment {

    ImageButton step1NextOff;
    RadioButton step1_yes_radio_off,step1_no_radio_off;

    public StepOneOffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_one_off, container, false);
        getActivity().setTitle("Power Off");
        step1NextOff = (ImageButton) view.findViewById(R.id.step1NextOff);
        step1_yes_radio_off = (RadioButton) view.findViewById(R.id.step1_yes_radio_off);
        step1_no_radio_off = (RadioButton) view.findViewById(R.id.step1_no_radio_off);


        step1NextOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (step1_yes_radio_off.isChecked()) {
                    AlertDialog.Builder alert= new AlertDialog.Builder(
                            getActivity ());
                    // set title
                    alert.setTitle(Html.fromHtml(getString(R.string.warn_message)));
                    // set dialog message
                    alert
                            .setIcon(R.drawable.warning)
                            .setMessage(Html.fromHtml(getString(R.string.content2_step1_off) + "\n"
                                    + getString(R.string.content3_step1_off)))
                            .setCancelable(false)
                            .setPositiveButton("GOT IT",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    StepTwoOffFragment stepTwoOff = new StepTwoOffFragment();
                                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.flContent, stepTwoOff);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alert.create();

                    // show it
                    alertDialog.show();

                } else if (step1_no_radio_off.isChecked()){
                    StepTwoOffFragment stepTwoOff = new StepTwoOffFragment();
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flContent, stepTwoOff);
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