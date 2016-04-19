package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kevin.firstlineofcode.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionDFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionDFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionDFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;

    private ListView mListView;
    public List<String> list;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static SectionDFragment newInstance() {
        SectionDFragment fragment = new SectionDFragment();
        return fragment;
    }

    public SectionDFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_4, null);
        mListView = (ListView) root.findViewById(R.id.section_4_lv);
        initData();
        return root;
    }

    private void initData() {
        list = new ArrayList<String>();
        list.add("建议使用android.app.Fragment，面向Android4.0以上系统");
        list.add("动态添加Fragment：AnotherRightFragment fragment = new AnotherRightFragment();\n" +
                "FragmentManager fragmentManager = getFragmentManager();\n" +
                "FragmentTransaction transaction = fragmentManager.\n" +
                "beginTransaction();\n" +
                "transaction.replace(R.id.right_layout, fragment);\n" +
                "transaction.commit();");
        list.add("在碎片中模拟返回栈：使用addToBackStack():transaction.replace(R.id.right_layout, fragment);\n" +
                "transaction.addToBackStack(null);\n" +
                "transaction.commit();");
        list.add("碎片的状态和回调:" +
                "1. onAttach()\n" +
                "当碎片和活动建立关联的时候调用。\n" +
                "2. onCreateView()\n" +
                "为碎片创建视图（加载布局）时调用。\n" +
                "3. onActivityCreated()\n" +
                "确保与碎片相关联的活动一定已经创建完毕的时候调用。\n" +
                "4. onDestroyView()\n" +
                "当与碎片关联的视图被移除的时候调用。\n" +
                "5. onDetach()\n" +
                "当碎片和活动解除关联的时候调用。");
        list.add("使用限定符：" +
                "layout/activity_main 布局只包含了一个碎片，即单页模式，而layout-large/\n" +
                "activity_main 布局包含了两个碎片，即双页模式。其中large 就是一个限定符，那些屏幕被认\n" +
                "为是large 的设备就会自动加载layout-large 文件夹下的布局，而小屏幕的设备则还是会加载\n" +
                "layout 文件夹下的布局。");
        list.add("屏幕特征限定符描述\n" +
                "大小\n" +
                "small 提供给小屏幕设备的资源\n" +
                "normal 提供给中等屏幕设备的资源\n" +
                "large 提供给大屏幕设备的资源\n" +
                "xlarge 提供给超大屏幕设备的资源\n" +
                "分辨率\n" +
                "ldpi 提供给低分辨率设备的资源（120dpi 以下）\n" +
                "mdpi 提供给中等分辨率设备的资源（120dpi 到160dpi）\n" +
                "hdpi 提供给高分辨率设备的资源（160dpi 到240dpi）\n" +
                "xhdpi 提供给超高分辨率设备的资源（240dpi 到320dpi）\n" +
                "方向\n" +
                "land 提供给横屏设备的资源\n" +
                "port 提供给竖屏设备的资源");
        list.add("最小宽度限定符：" +
                "当程序运行在屏幕宽度大于600dp 的设备上时，会加载layout-sw600dp/\n" +
                "activity_main 布局，当程序运行在屏幕宽度小于600dp 的设备上时，则仍然加载默认的\n" +
                "layout/activity_main 布局。\n" +
                "需要注意一点，最小宽度限定符是在Android 3.2 版本引入的，由于这里我们最低兼容\n" +
                "的系统版本是4.0，所以可以放心地使用它。");
        mListView.setAdapter(new MyAdapter(getActivity(), 0, list));
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

}

class MyAdapter extends ArrayAdapter<String>{

    public MyAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String content = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.listview_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.content_tv = (TextView) view.findViewById(R.id.listview_layout_tv);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.content_tv.setText(content);
        return view;
    }

    class ViewHolder{
        TextView content_tv;
    }
}