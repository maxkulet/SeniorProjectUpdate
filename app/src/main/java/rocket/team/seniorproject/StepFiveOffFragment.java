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


/**
 * A simple {@link Fragment} subclass.
 */
public class StepFiveOffFragment extends Fragment {

    ImageButton nextStep5Off;
    public StepFiveOffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_five_off, container, false);

        nextStep5Off = (ImageButton) view.findViewById(R.id.nextStep5Off);
        nextStep5Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)

            {
                AlertDialog.Builder alert= new AlertDialog.Builder(
                        getActivity ());
                // set title
                alert.setTitle(Html.fromHtml(getString(R.string.warn_message)));
                // set dialog message
                alert
                        .setIcon(R.drawable.warning)
                        .setMessage(Html.fromHtml(getString(R.string.content5_step5_off)))
                        .setCancelable(false)
                        .setPositiveButton("GOT IT",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                StepSixOffFragment stepSixOff = new StepSixOffFragment();
                                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.flContent, stepSixOff, "StepSixOff");
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alert.create();

                // show it
                alertDialog.show();


            }
        });
        return view;
    }

}
