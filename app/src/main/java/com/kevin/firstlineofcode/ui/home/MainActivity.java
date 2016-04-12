package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseBarActivity;

public class MainActivity extends BaseBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        showGlobalContextActionBar("Hello");
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
//        PlaceholderFragment placeholderFragment = PlaceholderFragment.newInstance(position + 1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, chooseFragment(position))
                .commit();
    }

    public Fragment chooseFragment(int position) {
        Fragment mFragment = null;
        switch (position) {
            case 0:
                mFragment = PlaceholderFragment.newInstance(position);
                break;
            case 1:
                mFragment = SectionAFragment.newInstance();
                break;
            case 2:
                mFragment = SectionBFragment.newInstance();
                break;
            case 3:
                mFragment = SectionCFragment.newInstance();
                break;
            case 4:
                mFragment = SectionDFragment.newInstance();
                break;
            case 5:
                mFragment = SectionEFragment.newInstance();
                break;
            case 6:
                mFragment = SectionFFragment.newInstance();
                break;
            case 7:
                mFragment = SectionGFragment.newInstance();
                break;
            case 8:
                mFragment = SectionHFragment.newInstance();
                break;
            case 9:
                mFragment = SectionIFragment.newInstance();
                break;
            case 10:
                mFragment = SectionJFragment.newInstance();
                break;
            case 11:
                mFragment = SectionKFragment.newInstance();
                break;
            case 12:
                mFragment = SectionLFragment.newInstance();
                break;
            case 13:
                mFragment = SectionMFragment.newInstance();
                break;
            case 14:
                mFragment = SectionNFragment.newInstance();
                break;
            case 15:
                mFragment = SectionOFragment.newInstance();
                break;
        }
        return mFragment;
    }

    public void onSectionAttached(int number) {
        String[] strs = getResources().getStringArray(R.array.title_list);
        if (number > 0) {
            mTitle = strs[number - 1];
        }
/*        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }*/
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         *
         * @param sectionNumber
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
