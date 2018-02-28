package rocket.team.seniorproject;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class StepFourOnFragment extends Fragment  {

    Spinner spOS;
    ImageView iconOS, img1, img2, img3, img4,img5,img6,img7,img8;
    TextView titleOS, txt1, txt2, txt3, txt4,txt5,txt6,txt7,txt8,txt9,step4TextView;
    ImageButton nextStep4On;

    public StepFourOnFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_step_four, container, false);


        spOS = (Spinner) view.findViewById(R.id.spOS);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                getActivity().getBaseContext(),
                R.array.OS_arrays,
                R.layout.spinner);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spOS.setAdapter(adapter);
        iconOS = (ImageView) view.findViewById(R.id.iconOS);
        img1 = (ImageView) view.findViewById(R.id.img1);
        img2 = (ImageView) view.findViewById(R.id.img2);
        img3 = (ImageView) view.findViewById(R.id.img3);
        img4 = (ImageView) view.findViewById(R.id.img4);
        img5 = (ImageView) view.findViewById(R.id.img5);
        img6 = (ImageView) view.findViewById(R.id.img6);
        img7 = (ImageView) view.findViewById(R.id.img7);
        img8 = (ImageView) view.findViewById(R.id.img8);


        titleOS = (TextView) view.findViewById(R.id.titleOS);
        txt1 = (TextView) view.findViewById(R.id.txt1);
        txt2 = (TextView) view.findViewById(R.id.txt2);
        txt3 = (TextView) view.findViewById(R.id.txt3);
        txt4 = (TextView) view.findViewById(R.id.txt4);
        txt5 = (TextView) view.findViewById(R.id.txt5);
        txt6 = (TextView) view.findViewById(R.id.txt6);
        txt7 = (TextView) view.findViewById(R.id.txt7);
        txt8 = (TextView) view.findViewById(R.id.txt8);





        spOS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // Create list of Spinners
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {

               // MainActivity.myDeviceOS = spOS.getSelectedItem().toString();

                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                inVisible();
               // visible();
                if (position == 1) {
                    MainActivity.myDeviceOS = getString(R.string.content7_summary_on);
                    iconOS.setImageResource(R.drawable.iphone);
                    titleOS.setText("iPhone");
                    iconOS.setVisibility(View.VISIBLE);
                    img2.setImageResource(R.drawable.check);
                    img3.setImageResource(R.drawable.check);
                    txt1.setText(R.string.content1_step4_on);
                    txt2.setText(R.string.content2_step4_on);
                    txt3.setText(R.string.content3_step4_on);
                } else
                if (position == 2) {
                    MainActivity.myDeviceOS = getString(R.string.content8_summary_on);
                    iconOS.setImageResource(R.drawable.android);
                    iconOS.setVisibility(View.VISIBLE);
                    titleOS.setText("Android OS");
                    img2.setImageResource(R.drawable.check);
                    img3.setImageResource(R.drawable.star);
                    visible();
                    txt1.setText(R.string.content4_step4_on);
                    txt2.setText(R.string.content5_step4_on);
                    txt3.setText(Html.fromHtml(getString(R.string.content10_step4_on)));
                    txt4.setText(R.string.content11_step4_on);
                    txt5.setText(R.string.content12_step4_on);
                    txt6.setText(R.string.content13_step4_on);
                    txt7.setText(R.string.content14_step4_on);
                    txt8.setText(R.string.content15_step4_on);
                }

                else  {
                    titleOS.setText("");
                    iconOS.setVisibility(View.GONE);
                    img2.setImageResource(R.drawable.help);
                    img2.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.GONE);
                    img3.setVisibility(View.GONE);
                    txt2.setText(Html.fromHtml(getString(R.string.content8_step4_on)));
                    txt1.setText("");
                    txt3.setText("");
                }

                HomeFragment fragment = new HomeFragment();


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
      //  titleOS.setText(spOS.getSelectedItem().toString());
        nextStep4On = (ImageButton) view.findViewById(R.id.nextStep4On);
        nextStep4On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StepFiveOnFragment stepFiveOn = new StepFiveOnFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, stepFiveOn);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });






        return view;
    }

    private void visible() {
        img8.setVisibility(View.VISIBLE);
        img4.setVisibility(View.VISIBLE);
        img5.setVisibility(View.VISIBLE);
        img6.setVisibility(View.VISIBLE);
        img7.setVisibility(View.VISIBLE);
    }
    private void inVisible() {
        img8.setVisibility(View.INVISIBLE);
        img4.setVisibility(View.INVISIBLE);
        img5.setVisibility(View.INVISIBLE);
        img6.setVisibility(View.INVISIBLE);
        img7.setVisibility(View.INVISIBLE);
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");

    }

}
