package rocket.team.seniorproject;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    Button startButton;
    RadioGroup group_button;
    RadioButton onButton, offButton;
   // TextView display;


   // Context context = this;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        startButton = (Button) view.findViewById(R.id.startButton);
        onButton = (RadioButton) view.findViewById(R.id.onButton);
        offButton = (RadioButton) view.findViewById(R.id.offButton);
       // display = (TextView) view.findViewById(R.id.display);
        group_button = (RadioGroup) view.findViewById(R.id.group_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (onButton.isChecked()) {

                    MainActivity.myDeviceStatus = getString(R.string.content2_summary_on);

                    AlertDialog.Builder alert= new AlertDialog.Builder(
                            getActivity ());
                    // set title
                    alert.setTitle(Html.fromHtml(getString(R.string.warn_message)));
                    // set dialog message
                    alert
                            .setIcon(R.drawable.warning)
                            .setMessage(Html.fromHtml(getString(R.string.warning1)))
                            .setCancelable(false)
                            .setPositiveButton("GOT IT",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    StepOneOnFragment stepOneOn = new StepOneOnFragment();
                                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.flContent, stepOneOn, "StepOneOn");
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alert.create();

                    // show it
                    alertDialog.show();

                } else if (offButton.isChecked()) {

                    MainActivity.myDeviceStatus = getString(R.string.content3_summary_on);

                    AlertDialog.Builder alert= new AlertDialog.Builder(
                            getActivity ());
                    // set title
                    alert.setTitle(Html.fromHtml(getString(R.string.warn_message)));
                    // set dialog message
                    alert
                            .setIcon(R.drawable.warning)
                            .setMessage(Html.fromHtml(getString(R.string.warning1)))
                            .setCancelable(false)
                            .setPositiveButton("GOT IT",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    StepOneOffFragment stepOneOff = new StepOneOffFragment();
                                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.flContent, stepOneOff, "StepOneOff");
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alert.create();

                    // show it
                    alertDialog.show();

                }

                else {
                    AlertDialog.Builder alertCheck = new AlertDialog.Builder(
                            getActivity ());
                    alertCheck.setTitle(Html.fromHtml(getString(R.string.warn_message)));

                    // set dialog message
                    alertCheck
                            .setIcon(R.drawable.warning)
                            .setMessage(Html.fromHtml(getString(R.string.warning2)))
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
                    //display.setText("Hello");
                }

            }
        });









        return view;
    }


}