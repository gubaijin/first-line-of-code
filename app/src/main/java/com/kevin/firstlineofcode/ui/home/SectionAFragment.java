package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseBarActivity;
import com.kevin.firstlineofcode.ui.sectionA.SectionAaActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionAFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionAFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionAFragment extends Fragment implements View.OnClickListener{
//    private OnFragmentInteractionListener mListener;

    private Button btn1;    //隐藏标题栏
    private BaseBarActivity baseActivity;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static SectionAFragment newInstance() {
        SectionAFragment fragment = new SectionAFragment();
        return fragment;
    }

    public SectionAFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_1, null);
        initViews(root);
        baseActivity = (BaseBarActivity)getActivity();
        return root;
    }

    private void initViews(View view) {
        btn1 = (Button) view.findViewById(R.id.section_a_btn1);
        btn1.setOnClickListener(this);
    }

    // TODO: Rename method, update argument and hook method into UI event
/*    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
/*        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.section_a_btn1:
                baseActivity.openActivity(SectionAaActivity.class);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
