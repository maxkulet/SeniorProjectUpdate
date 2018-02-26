package rocket.team.seniorproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryOnFragment extends Fragment {


    public SummaryOnFragment() {
        // Required empty public constructor
    }

    TextView  text1, text2, text3, text4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summary_on, container, false);

        text1 = (TextView) view.findViewById(R.id.text1);
        text2 = (TextView) view.findViewById(R.id.text2);
        text3 = (TextView) view.findViewById(R.id.text3);
        text4 = (TextView) view.findViewById(R.id.text4);


        text1.setText(Html.fromHtml(getString(R.string.content1_summary_on) + " " + MainActivity.myDeviceStatus)) ;
        text2.setText(Html.fromHtml(getString(R.string.content1_step1_on) + " " + MainActivity.myDeviceDNA)) ;
        text3.setText(Html.fromHtml(getString(R.string.content1_step2_on) + " " + MainActivity.myDeviceSecurity)) ;
        text4.setText(Html.fromHtml(getString(R.string.content6_summary_on) + " " + MainActivity.myDeviceOS)) ;


        return view;
    }

}
