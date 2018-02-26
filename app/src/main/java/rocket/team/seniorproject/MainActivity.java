package rocket.team.seniorproject;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment = null;
    private BottomNavigationView mBottomNav;
    public static ArrayList<String> arrList = new ArrayList<String>();
    public static String myDeviceStatus = "";
    public static String myDeviceDNA = "";
    public static String myDeviceSecurity = "";
    public static String myDeviceOS = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setTitle(currentFragment.getClass().getSimpleName());
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment = new HomeFragment();
        ft.replace(R.id.flContent, fragment);
       ft.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return false;
            }
        });

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
    }



    @Override
    public void onBackPressed() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        MenuItem homeItem = navigationView.getMenu().getItem(0);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.flContent);
        int selectMenu = 0;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else if ((selectMenu != homeItem.getItemId())) {
            homeItem.setChecked(homeItem.getItemId()== 0);
            selectFragment(homeItem);
            if (currentFragment instanceof HomeFragment) {
                finish();
            }
        } else {
                super.onBackPressed();
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
       // resetAllMenuItemsTextColor(navigationView);


        selectFragment(item);
        return true;
    }

    private void selectFragment(MenuItem item) {
        int id = item.getItemId();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        BottomNavigationView mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //resetAllMenuItemsTextColor(navigationView);
       // setTextColorForMenuItem(item, R.color.textPrimary);

        if (id == R.id.home) {
            fragment = new HomeFragment();

            // navigationView.setItemBackgroundResource(R.drawable.getstarted);.
        } else if (id == R.id.step1_on) {
            fragment = new StepOneOnFragment();
            //setTextColorForMenuItem(item, R.color.home);
           // resetAllMenuItemsTextColor(navigationView);

        }  else if (id == R.id.step2_on) {
            fragment = new StepTwoOnFragment();
          //  resetAllMenuItemsTextColor(navigationView);

        } else if (id == R.id.step3_on) {
            fragment = new StepThreeOnFragment();

        } else if (id == R.id.step4_on) {
            fragment = new StepFourOnFragment();

        }
        else if (id == R.id.step5_on) {
            fragment = new StepFiveOnFragment();

        }
        else if (id == R.id.step6_on) {
            fragment = new StepSixOnFragment();

        }
        else if (id == R.id.step7_on) {
            fragment = new StepSevenOnFragment();

        }
        else if (id == R.id.step8_on) {
            fragment = new StepEightOnFragment();

        }
        else if (id == R.id.step9_on) {
            fragment = new StepNineOnFragment();


        } else if (id == R.id.step1_off) {
            fragment = new StepOneOffFragment();
            // setTextColorForMenuItem(item, R.color.step1);
        } else if (id == R.id.step2_off) {
            fragment = new StepTwoOffFragment();
            // setTextColorForMenuItem(item, R.color.step2);
        } else if (id == R.id.step3_off) {
            fragment = new StepThreeOffFragment();
            // setTextColorForMenuItem(item, R.color.step3);
        } else if (id == R.id.step4_off) {
            fragment = new StepFourOffFragment();
            // setTextColorForMenuItem(item, R.color.step4);
        } else if (id == R.id.step5_off) {
            fragment = new StepFiveOffFragment();
            // setTextColorForMenuItem(item, R.color.step5);
        } else if (id == R.id.step6_off) {
            fragment = new StepSixOffFragment();
            // setTextColorForMenuItem(item, R.color.step6);
        } else if (id == R.id.step7_off) {
            fragment = new StepSevenOffFragment();
            // setTextColorForMenuItem(item, R.color.step7);
        } else if (id == R.id.step8_off) {
            fragment = new StepEightOffFragment();
            // setTextColorForMenuItem(item, R.color.step8);
        } else if (id == R.id.step9_off) {
            fragment = new StepNineOffFragment();
            // setTextColorForMenuItem(item, R.color.step9);
        }


        if (fragment!= null) {
            ft.replace(R.id.flContent, fragment);
            // ft.addToBackStack(null);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

   /* private void setTextColorForMenuItem(MenuItem menuItem, @ColorRes int color) {
        SpannableString spanString = new SpannableString(menuItem.getTitle().toString());
        spanString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, color)),
                0, spanString.length(), 0);
        menuItem.setTitle(spanString);
    }



    private void resetAllMenuItemsTextColor(NavigationView navigationView) {
        for (int i = 0; i < navigationView.getMenu().size(); i++)
            setTextColorForMenuItem(navigationView.getMenu().getItem(i), R.color.textPrimary);

    }*/
}
