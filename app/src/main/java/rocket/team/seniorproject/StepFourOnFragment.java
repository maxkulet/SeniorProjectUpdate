package rocket.team.seniorproject;



import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.view.animation.DecelerateInterpolator;
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
    private int mShortAnimationDuration;
    private Animator mCurrentAnimator;
    Spinner spOS;
    ImageView iconOS, img1, img2, img3, img4,img5,img6,img7,img8;
    TextView titleOS, txt1, txt2, txt3, txt4,txt5,txt6,txt7,txt8,txt9,step4TextView;
    ImageButton nextStep4On, step4_on_imagebtn1;
    int myImage;
    public StepFourOnFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_step_four, container, false);

        step4_on_imagebtn1 = (ImageButton) view.findViewById(R.id.step4_on_imagebtn1);

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


        final View thumb1View = view.findViewById(R.id.step4_on_imagebtn1);

        thumb1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(thumb1View, myImage,  R.id.step4_on_expanded1, R.id.step4_on_layout);
            }
        });

        // Retrieve and cache the system's default "short" animation time.
        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);


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
                    myImage = R.drawable.iphone_step4;
                    MainActivity.myDeviceOS = getString(R.string.content7_summary_on);
                    step4_on_imagebtn1.setVisibility(View.VISIBLE);
                    step4_on_imagebtn1.setImageResource(R.drawable.iphone_step4);
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
                   myImage = R.drawable.airplan_iphone;
                    MainActivity.myDeviceOS = getString(R.string.content8_summary_on);
                    iconOS.setImageResource(R.drawable.android);
                    step4_on_imagebtn1.setImageResource(R.drawable.airplan_iphone);
                    step4_on_imagebtn1.setVisibility(View.VISIBLE);
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
                    step4_on_imagebtn1.setVisibility(View.INVISIBLE);
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
                fragmentTransaction.replace(R.id.flContent, stepFiveOn, "stepFiveOn");
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

    private void zoomImageFromThumb(final View thumbView, int imageResId, int layout, int imageTarget ) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = (ImageView) getView().findViewById(
                layout);
        expandedImageView.setImageResource(imageResId);

        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        getActivity().findViewById(imageTarget)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
                        startScale, 1f))
                .with(ObjectAnimator.ofFloat(expandedImageView,
                        View.SCALE_Y, startScale, 1f));
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator != null) {
                    mCurrentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(expandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.Y, startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(mShortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }
                });
                set.start();
                mCurrentAnimator = set;
            }
        });
    }
}
