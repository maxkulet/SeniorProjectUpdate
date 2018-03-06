package rocket.team.seniorproject;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepTwoOnFragment extends Fragment {
    private int mShortAnimationDuration;
    private Animator mCurrentAnimator;
    ImageButton step2NextOn, step2_on_imagebtn1, step2_on_imagebtn2, step2_on_imagebtn3,
                 step2_on_imagebtn4, step2_on_imagebtn5, step2_on_imagebtn6, step2_on_imagebtn7;
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
        step2_on_imagebtn1 = (ImageButton) view.findViewById(R.id.step2_on_imagebtn1);
        step2_on_imagebtn2 = (ImageButton) view.findViewById(R.id.step2_on_imagebtn2);
        step2_on_imagebtn3 = (ImageButton) view.findViewById(R.id.step2_on_imagebtn3);
        step2_on_imagebtn4 = (ImageButton) view.findViewById(R.id.step2_on_imagebtn4);
        step2_on_imagebtn5 = (ImageButton) view.findViewById(R.id.step2_on_imagebtn5);
        step2_on_imagebtn6 = (ImageButton) view.findViewById(R.id.step2_on_imagebtn6);
        step2_on_imagebtn7 = (ImageButton) view.findViewById(R.id.step2_on_imagebtn7);


        step2_yes_radio = (RadioButton) view.findViewById(R.id.step2_yes_radio);
        step2_no_radio = (RadioButton) view.findViewById(R.id.step2_no_radio);
        step2_yes_radio.setChecked(false);
        step2_no_radio.setChecked(false);
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
                step2_on_imagebtn1.setVisibility(View.VISIBLE);
                step2_on_imagebtn2.setVisibility(View.VISIBLE);
                step2_on_imagebtn3.setVisibility(View.VISIBLE);
                step2_on_imagebtn4.setVisibility(View.VISIBLE);
                step2_on_imagebtn5.setVisibility(View.VISIBLE);
                step2_on_imagebtn6.setVisibility(View.VISIBLE);
                step2_on_imagebtn7.setVisibility(View.VISIBLE);
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
                step2_on_imagebtn1.setVisibility(View.INVISIBLE);
                step2_on_imagebtn2.setVisibility(View.INVISIBLE);
                step2_on_imagebtn3.setVisibility(View.INVISIBLE);
                step2_on_imagebtn4.setVisibility(View.INVISIBLE);
                step2_on_imagebtn5.setVisibility(View.INVISIBLE);
                step2_on_imagebtn6.setVisibility(View.INVISIBLE);
                step2_on_imagebtn7.setVisibility(View.INVISIBLE);
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
                                        fragmentTransaction.replace(R.id.flContent, stepThreeOn, "stepThreeOn");
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
                        fragmentTransaction.replace(R.id.flContent, stepThreeOn, "stepThreeOn");
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
        final View thumb1View = view.findViewById(R.id.step2_on_imagebtn1);
        final View thumb2View = view.findViewById(R.id.step2_on_imagebtn2);
        final View thumb3View = view.findViewById(R.id.step2_on_imagebtn3);
        final View thumb4View = view.findViewById(R.id.step2_on_imagebtn4);
        final View thumb5View = view.findViewById(R.id.step2_on_imagebtn5);
        final View thumb6View = view.findViewById(R.id.step2_on_imagebtn6);
        final View thumb7View = view.findViewById(R.id.step2_on_imagebtn7);
        thumb1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(thumb1View, R.drawable.android_sim,  R.id.step2_on_expanded1, R.id.step2_on_layout);
            }
        });
        thumb2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(thumb2View, R.drawable.live_on_off_step2android,  R.id.step2_on_expanded2, R.id.step2_on_layout);
            }
        });
        thumb5View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(thumb5View, R.drawable.live_on_off_step2,  R.id.step2_on_expanded5, R.id.step2_on_layout);
            }
        });
        thumb3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(thumb3View, R.drawable.apple_sim, R.id.step2_on_expanded3, R.id.step2_on_layout);
            }
        });
        thumb4View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(thumb4View, R.drawable.android_sim,  R.id.step2_on_expanded4, R.id.step2_on_layout);
            }
        });
        thumb6View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(thumb6View, R.drawable.airplan_iphone,  R.id.step2_on_expanded6, R.id.step2_on_layout);
            }
        });
        thumb7View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(thumb7View, R.drawable.airplane_android,  R.id.step2_on_expanded7, R.id.step2_on_layout);
            }
        });
        // Retrieve and cache the system's default "short" animation time.
        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);





        return view;
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
