package rocket.team.seniorproject;


import android.support.test.rule.ActivityTestRule;
import android.test.ActivityUnitTestCase;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.support.v4.app.Fragment;
import android.widget.ScrollView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nhocw on 3/5/2018.
 */
public class HomeFragmentTest  {
    String text1Test;
    @Rule
    public ActivityTestRule<TestActivity> mActivityTestRule = new ActivityTestRule<TestActivity>(TestActivity.class);

    private TestActivity mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();
        text1Test = "text1";
    }
    @Test
    public void testLaunch() {
        RelativeLayout rltContanier  = (RelativeLayout) mActivity.findViewById(R.id.test_container);
        assertNotNull(rltContanier);
        ScrollView scrollLayout = (ScrollView) mActivity.findViewById(R.id.test_scrollview);
        assertNotNull(scrollLayout);
        LinearLayout linearLayout = (LinearLayout) mActivity.findViewById(R.id.test_linear);
        assertNotNull(linearLayout);
    }
    @Test
    public void textView() throws Exception {
        TextView text1 = (TextView) mActivity.findViewById(R.id.text1);
        assertEquals("Passed", text1, text1Test);
    }
    @After
    public void tearDown() throws Exception {
        mActivity = null;


    }

}