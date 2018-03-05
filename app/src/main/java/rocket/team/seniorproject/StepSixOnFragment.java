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
public class StepSixOnFragment extends Fragment {


    public StepSixOnFragment() {
        // Required empty public constructor
    }

    ImageButton nextStep6On;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_step_six_on, container, false);
        nextStep6On = (ImageButton) view.findViewById(R.id.nextStep6On);
        nextStep6On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert= new AlertDialog.Builder(
                        getActivity ());
                // set title
                alert.setTitle(Html.fromHtml(getString(R.string.warn_message)));
                // set dialog message
                alert
                        .setIcon(R.drawable.warning)
                        .setMessage(Html.fromHtml(getString(R.string.warn_message4)))
                        .setCancelable(false)
                        .setPositiveButton("GOT IT",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                StepSevenOnFragment stepSevenOn = new StepSevenOnFragment();
                                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.flContent, stepSevenOn, "stepSevenOn");
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
