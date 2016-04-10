package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseActivity;

public class MainActivity extends BaseActivity
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
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
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
            int sectionNumber = this.getArguments().getInt(ARG_SECTION_NUMBER);
            int layoutId = 0;
            switch (sectionNumber) {
                case 1:
                    layoutId = R.layout.fragment_main;
                    break;
                case 2:
                    layoutId = R.layout.fragment_section_1;
                    break;
                case 3:
                    layoutId = R.layout.fragment_section_2;
                    break;
                case 4:
                    layoutId = R.layout.fragment_section_3;
                    break;
                case 5:
                    layoutId = R.layout.fragment_section_4;
                    break;
                case 6:
                    layoutId = R.layout.fragment_section_5;
                    break;
                case 7:
                    layoutId = R.layout.fragment_section_6;
                    break;
                case 8:
                    layoutId = R.layout.fragment_section_7;
                    break;
                case 9:
                    layoutId = R.layout.fragment_section_8;
                    break;
                case 10:
                    layoutId = R.layout.fragment_section_9;
                    break;
                case 11:
                    layoutId = R.layout.fragment_section_10;
                    break;
                case 12:
                    layoutId = R.layout.fragment_section_11;
                    break;
                case 13:
                    layoutId = R.layout.fragment_section_12;
                    break;
                case 14:
                    layoutId = R.layout.fragment_section_13;
                    break;
                case 15:
                    layoutId = R.layout.fragment_section_14;
                    break;
                case 16:
                    layoutId = R.layout.fragment_section_15;
                    break;
            }
            View rootView = inflater.inflate(layoutId, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
