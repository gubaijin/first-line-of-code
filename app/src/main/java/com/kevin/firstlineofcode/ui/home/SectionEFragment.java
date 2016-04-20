package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseBarActivity;
import com.kevin.firstlineofcode.ui.sectionE.LocalBroadcastReceiver;
import com.kevin.firstlineofcode.ui.util.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionEFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionEFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionEFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;

    private ListView mListView;

    private BaseBarActivity mBaseActivity;

    private LocalBroadcastReceiver mLocalBroadcastReceiver;

    private LocalBroadcastManager mLocalBroadcastManager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static SectionEFragment newInstance() {
        SectionEFragment fragment = new SectionEFragment();
        return fragment;
    }

    public SectionEFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_5, null);
        mListView = (ListView) root.findViewById(R.id.section_5_lv);
        mBaseActivity = (BaseBarActivity) getContext();
        init();
        return root;
    }

    private void init() {
        List<String> list = new ArrayList<String>();
        list.add("广播接收器（Broadcast Receiver）:注册广播的方式一般有两种，在代\n" +
                "码中注册和在AndroidManifest.xml 中注册，其中前者也被称为动态注册，后者也被称为静态\n" +
                "注册。@Override\n" +
                "protected void onCreate(Bundle savedInstanceState) {\n" +
                "super.onCreate(savedInstanceState);\n" +
                "setContentView(R.layout.activity_main);\n" +
                "intentFilter = new IntentFilter();\n" +
                "intentFilter.addAction(\"android.net.conn.CONNECTIVITY_CHANGE\");\n" +
                "networkChangeReceiver = new NetworkChangeReceiver();\n" +
                "registerReceiver(networkChangeReceiver, intentFilter);\n" +
                "}\n" +
                "@Override\n" +
                "protected void onDestroy() {\n" +
                "super.onDestroy();\n" +
                "unregisterReceiver(networkChangeReceiver);\n" +
                "}");
        list.add("判断网络是否可用：ConnectivityManager connectionManager = (ConnectivityManager)\n" +
                "getSystemService(Context.CONNECTIVITY_SERVICE);\n" +
                "NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();\n" +
                "第2 章先从看得到的入手，探究活动\n" +
                "193\n" +
                "if (networkInfo != null && networkInfo.isAvailable()) {\n" +
                "Toast.makeText(context, \"network is available\",\n" +
                "Toast.LENGTH_SHORT).show();\n" +
                "} else {\n" +
                "Toast.makeText(context, \"network is unavailable\",\n" +
                "Toast.LENGTH_SHORT).show();\n" +
                "}");
        list.add("静态注册实现开机启动：动态注册的广播接收器可以自由地控制注册与注销，在灵活性方面有很大的优势，但是\n" +
                "它也存在着一个缺点，即必须要在程序启动之后才能接收到广播，因为注册的逻辑是写在\n" +
                "onCreate()方法中的");
        list.add("静态注册实现开机启动：<application\n" +
                "android:allowBackup=\"true\"\n" +
                "android:icon=\"@drawable/ic_launcher\"\n" +
                "android:label=\"@string/app_name\"\n" +
                "android:theme=\"@style/AppTheme\" >\n" +
                "<receiver android:name=\".BootCompleteReceiver\" >\n" +
                "<intent-filter>\n" +
                "<action android:name=\"android.intent.action.BOOT_COMPLETED\" />\n" +
                "</intent-filter>\n" +
                "</receiver>");
        list.add("注意:不要在onReceive()方法中添加过多的逻辑或者进行任何的耗时操作，因为在广播接收\n" +
                "器中是不允许开启线程的，当onReceive()方法运行了较长时间而没有结束时，程序就会报错。\n" +
                "因此广播接收器更多的是扮演一种打开程序其他组件的角色，比如创建一条状态栏通知，或\n" +
                "者启动一个服务等");
        //index:5
        list.add("发送一条标准广播");
        //index:6
        list.add("发送一条有序广播：只需要改动一行代码， 即将sendBroadcast() 方法改成\n" +
                "sendOrderedBroadcast()方法" +
                "通过android:priority 属性给广播接收器设置了优先级" +
                "在onReceive()方法中调用了abortBroadcast()方法，就表示将这条广播截断");
        //index:7
        list.add("使用本地广播：简单地解决广播的安全性问题，主要就是使用了一个LocalBroadcastManager 来对广播进行\n" +
                "管理。注意：本地广播是无法通过静态注册的方式来接收的：1. 可以明确地知道正在发送的广播不会离开我们的程序，因此不需要担心机密数据泄\n" +
                "漏的问题。\n" +
                "2. 其他的程序无法将广播发送到我们程序的内部，因此不需要担心会有安全漏洞的隐\n" +
                "患。\n" +
                "3. 发送本地广播比起发送系统全局广播将会更加高效。");
        mListView.setAdapter(new MyAdapter5(getActivity(), R.layout.listview_layout, list));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 5:
                        Intent intent5 = new Intent("com.kevin.MY_BROADCAST");
                        intent5.putExtra("isAbort", false);
                        mBaseActivity.sendBroadcast(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent("com.kevin.MY_BROADCAST");
                        intent6.putExtra("isAbort", true);
                        mBaseActivity.sendOrderedBroadcast(intent6, null);
                        break;
                    case 7:
                        mLocalBroadcastManager = LocalBroadcastManager.getInstance(MyApplication.getmContext());
                        //注册本地广播监听器
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("com.kevin.LOCAL_BROADCAST");
                        mLocalBroadcastReceiver = new LocalBroadcastReceiver();
                        mLocalBroadcastManager.registerReceiver(mLocalBroadcastReceiver, intentFilter);

                        Intent intent7 = new Intent("com.kevin.LOCAL_BROADCAST");
                        mLocalBroadcastManager.sendBroadcast(intent7);
                        break;
                }
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
    public void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mLocalBroadcastReceiver);
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

class MyAdapter5 extends ArrayAdapter<String> {

    public MyAdapter5(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String content = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.listview_layout, null);
            viewHolder = new  ViewHolder();
            viewHolder.content_tv = (TextView) view.findViewById(R.id.listview_layout_tv);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.content_tv.setText(content);
        return view;
    }

    class ViewHolder {
        TextView content_tv;
    }
}