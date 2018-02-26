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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepTwoOnFragment extends Fragment {

    ImageButton step2NextOn;
    ImageView step2_on_img1, step2_on_img2, step2_on_img3, step2_on_img4;
    RadioButton step2_yes_radio,step2_no_radio;
    TextView step2_on_txt1, step2_on_txt2, step2_on_txt3, step2_on_txt4, step2_on_txt5;
    public StepTwoOnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_step_two_on, container, false);
        getActivity().setTitle("Power On");
        step2NextOn = (ImageButton) view.findViewById(R.id.step1NextOn);
        step2_yes_radio = (RadioButton) view.findViewById(R.id.step2_yes_radio);
        step2_no_radio = (RadioButton) view.findViewById(R.id.step2_no_radio);
        step2_on_txt1 = (TextView) view.findViewById(R.id.step2_on_txt1);
        step2_on_txt2 = (TextView) view.findViewById(R.id.step2_on_txt2);
        step2_on_txt3 = (TextView) view.findViewById(R.id.step2_on_txt3);
        step2_on_txt4 = (TextView) view.findViewById(R.id.step2_on_txt4);
        step2_on_txt5 = (TextView) view.findViewById(R.id.step2_on_txt5);
        step2_on_img1 = (ImageView) view.findViewById(R.id.step2_on_img1);
        step2_on_img2 = (ImageView) view.findViewById(R.id.step2_on_img2);
        step2_on_img3 = (ImageView) view.findViewById(R.id.step2_on_img3);
        step2_on_img4 = (ImageView) view.findViewById(R.id.step2_on_img4);

        step2_yes_radio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                MainActivity.myDeviceSecurity = getString(R.string.content4_summary_on);
                step2_on_txt1.setText(R.string.content2_step2_on);
                step2_on_txt2.setText(R.string.content4_step2_on);
                step2_on_txt3.setText(R.string.content5_step2_on);
                step2_on_txt4.setText(R.string.content6_step2_on);
                step2_on_txt5.setText(R.string.content7_step2_on);
                step2_on_img1.setVisibility(View.VISIBLE);
                step2_on_img2.setVisibility(View.VISIBLE);
                step2_on_img3.setVisibility(View.VISIBLE);
                step2_on_img4.setVisibility(View.VISIBLE);
            }
        });

        step2_no_radio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                MainActivity.myDeviceSecurity = getString(R.string.content5_summary_on);

                step2_on_img1.setVisibility(View.INVISIBLE);
                step2_on_img2.setVisibility(View.INVISIBLE);
                step2_on_img3.setVisibility(View.INVISIBLE);
                step2_on_img4.setVisibility(View.INVISIBLE);
                step2_on_txt1.setText("Good News!");

                step2_on_txt2.setText(null);
                step2_on_txt3.setText(null);
                step2_on_txt4.setText(null);
                step2_on_txt5.setText(null);
            }

        });



        step2NextOn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (step2_yes_radio.isChecked()) {
                        AlertDialog.Builder alert= new AlertDialog.Builder(
                                getActivity ());
                        // set title
                        alert.setTitle(Html.fromHtml(getString(R.string.warn_message)));
                        // set dialog message
                        alert
                                .setIcon(R.drawable.warning)
                                .setMessage(Html.fromHtml(getString(R.string.content3_step2_on)))
                                .setCancelable(true)
                                .setNegativeButton("NOT YET", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                })
                                .setPositiveButton("GOT IT",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        StepThreeOnFragment stepThreeOn = new StepThreeOnFragment();
                                        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                        android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                                        fragmentTransaction.replace(R.id.flContent, stepThreeOn);
                                        fragmentTransaction.addToBackStack(null);
                                        fragmentTransaction.commit();
                                    }
                                });

                        // create alert dialog
                        AlertDialog alertDialog = alert.create();
                        // show it
                        alertDialog.show();

                    } else if (step2_no_radio.isChecked()) {


                        StepThreeOnFragment stepThreeOn = new StepThreeOnFragment();
                        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                        android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, stepThreeOn);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();


                    }


                    else {
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
