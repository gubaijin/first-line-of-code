package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseBarActivity;
import com.kevin.firstlineofcode.ui.base.EmptyActivity;
import com.kevin.firstlineofcode.ui.sectionB.SectionBaActivity;
import com.kevin.firstlineofcode.ui.util.ActivityCollector;
import com.kevin.firstlineofcode.ui.util.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionBFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionBFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionBFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;

    private BaseBarActivity baseActivity;
    private Button mBtn_1;
    private Button mBtn_2;
    private Button mBtn_3, mBtn_4, mBtn_5, mBtn_6, mBtn_7, mBtn_8, mBtn_9;
    private Button mBtn_10, mBtn_11;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static SectionBFragment newInstance() {
        SectionBFragment fragment = new SectionBFragment();
        return fragment;
    }

    public SectionBFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_2, null);
        baseActivity = (BaseBarActivity)getActivity();
        initViews(root);
        return root;
    }

    private void initViews(View root) {
        mBtn_1 = (Button) root.findViewById(R.id.section_b_btn1);
        mBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.kevin.firstlineofcode.ACTION_START");
                intent.putExtra("toEmpty", "intent1");
                startActivity(intent);
            }
        });

        mBtn_2 = (Button) root.findViewById(R.id.section_b_btn2);
        mBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.openActivity(EmptyActivity.class, "intent2");
            }
        });

        mBtn_3 = (Button) root.findViewById(R.id.section_b_btn3);
        mBtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        mBtn_4 = (Button) root.findViewById(R.id.section_b_btn4);
        mBtn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18516091008"));
                startActivity(intent);
            }
        });

        mBtn_5 = (Button) root.findViewById(R.id.section_b_btn5);
        mBtn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EmptyActivity.class);
                intent.putExtra(Constants.INTENT_KEY_NAME_ONE, "intent5");
                getActivity().startActivityForResult(intent, 1);
            }
        });

        mBtn_6 = (Button) root.findViewById(R.id.section_b_btn6);
        mBtn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.openActivity(SectionBaActivity.class);
            }
        });

        mBtn_7 = (Button) root.findViewById(R.id.section_b_btn7);
        mBtn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.openActivity(SectionBaActivity.class, "saveInstanceState");
            }
        });

        mBtn_8 = (Button) root.findViewById(R.id.section_b_btn8);
        mBtn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.openActivity(SectionBaActivity.class, "lanuchMode");
            }
        });

        mBtn_9 = (Button) root.findViewById(R.id.section_b_btn9);
        mBtn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.showToast(getActivity().getClass().getSimpleName());
            }
        });

        mBtn_10 = (Button) root.findViewById(R.id.section_b_btn10);
        mBtn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
            }
        });

        mBtn_11 = (Button) root.findViewById(R.id.section_b_btn11);
        mBtn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SectionBaActivity.actionStart(getActivity(), "actionStart", null);
            }
        });
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == -1) {
                    String returnedData = data.getStringExtra("data_return");
                    baseActivity.showToast(returnedData);
                }
                break;
            default:
        }
    }
}
