package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.sectionI.MyService;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionIFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionIFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionIFragment extends Fragment implements AdapterView.OnItemClickListener{
    //    private OnFragmentInteractionListener mListener;
    private ListView listView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static SectionIFragment newInstance() {
        SectionIFragment fragment = new SectionIFragment();
        return fragment;
    }

    public SectionIFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_9, null);
        init(root);
        return root;
    }

    private void init(View root) {
        listView = (ListView) root.findViewById(R.id.section_9_lv);
        List<String> list = new ArrayList<String>();
        list.add("9.1 服务是什么：服务并不是运行在一个独立的进程当中的，而是依赖于创建服务\n" +
                "时所在的应用程序进程。当某个应用程序进程被杀掉时，所有依赖于该进程的服务也会停\n" +
                "止运行。\n" +
                "另外，也不要被服务的后台概念所迷惑，实际上服务并不会自动开启线程，所有的代码\n" +
                "都是默认运行在主线程当中的。也就是说，我们需要在服务的内部手动创建子线程，并在这\n" +
                "里执行具体的任务，否则就有可能出现主线程被阻塞住的情况");
        list.add("9.2.4 使用AsyncTask 在继承时我们可以为AsyncTask 类指定三个泛型\n" +
                "参数，这三个参数的用途如下（class DownloadTask extends AsyncTask<Void, Integer, Boolean>{}）：\n" +
                "1. Params在执行AsyncTask 时需要传入的参数，可用于在后台任务中使用。\n" +
                "2. Progress后台任务执行时，如果需要在界面上显示当前的进度，则使用这里指定的泛型作为进度单位。\n" +
                "3. Result当任务执行完毕后，如果需要对结果进行返回，则使用这里指定的泛型作为返回值类型。\n" +
                "使用AsyncTask 的诀窍就是，在doInBackground()方法中去执行具体的耗时\n" +
                "任务，在onProgressUpdate()方法中进行UI 操作，在onPostExecute()方法中执行一些任务的\n" +
                "收尾工作。");
        list.add("9.3.1 定义一个服务 其中onCreate()方法会在服务创建的时候调用，\n" +
                "onStartCommand()方法会在每次服务启动的时候调用，onDestroy()方法会在服务销毁的时候调用。\n" +
                "注册<service android:name=\".MyService\" >\n" +
                "</service>\n" +
                "</application>" +
                "public class MyService extends Service {\n" +
                "@Override\n" +
                "public IBinder onBind(Intent intent) {\n" +
                "return null;\n" +
                "}\n" +
                "@Override\n" +
                "public void onCreate() {\n" +
                "super.onCreate();\n" +
                "}\n" +
                "@Override\n" +
                "public int onStartCommand(Intent intent, int flags, int startId) {\n" +
                "return super.onStartCommand(intent, flags, startId);\n" +
                "}\n" +
                "@Override\n" +
                "public void onDestroy() {\n" +
                "super.onDestroy();\n" +
                "}\n" +
                "}");
        list.add("服务的开启与停止 ： Intent startIntent = new Intent(this, MyService.class);\n" +
                "startService(startIntent); // 启动服务\n" +
                "Intent stopIntent = new Intent(this, MyService.class);\n" +
                "stopService(stopIntent); // 停止服务");
        list.add("9.3.3 活动和服务进行通信 \n" +
                "创建一个专门的Binder 对象来对下载功能进行管理:\n" +
                "public class MyService extends Service {\n" +
                "private DownloadBinder mBinder = new DownloadBinder();\n" +
                "class DownloadBinder extends Binder {\n" +
                "public void startDownload() {\n" +
                "Log.d(\"MyService\", \"startDownload executed\");\n" +
                "}\n" +
                "public int getProgress() {\n" +
                "Log.d(\"MyService\", \"getProgress executed\");\n" +
                "return 0;\n" +
                "}\n" +
                "}\n" +
                "@Override\n" +
                "public IBinder onBind(Intent intent) {\n" +
                "return mBinder;\n" +
                "}\n" +
                "}\n" +
                "活动中如何去调用服务里的这些方法:\n" +
                "public class MainActivity extends Activity implements OnClickListener {\n" +
                "private Button startService;\n" +
                "private Button stopService;\n" +
                "private Button bindService;\n" +
                "private Button unbindService;\n" +
                "private MyService.DownloadBinder downloadBinder;\n" +
                "private ServiceConnection connection = new ServiceConnection() {\n" +
                "@Override\n" +
                "public void onServiceDisconnected(ComponentName name) {\n" +
                "}\n" +
                "@Override\n" +
                "public void onServiceConnected(ComponentName name, IBinder service) {\n" +
                "downloadBinder = (MyService.DownloadBinder) service;\n" +
                "downloadBinder.startDownload();\n" +
                "downloadBinder.getProgress();\n" +
                "}\n" +
                "};\n" +
                "@Override\n" +
                "protected void onCreate(Bundle savedInstanceState) {\n" +
                "super.onCreate(savedInstanceState);\n" +
                "setContentView(R.layout.activity_main);\n" +
                "……\n" +
                "bindService = (Button) findViewById(R.id.bind_service);\n" +
                "unbindService = (Button) findViewById(R.id.unbind_service);\n" +
                "bindService.setOnClickListener(this);\n" +
                "unbindService.setOnClickListener(this);\n" +
                "}\n" +
                "@Override\n" +
                "public void onClick(View v) {\n" +
                "switch (v.getId()) {\n" +
                "case R.id.bind_service:\n" +
                "Intent bindIntent = new Intent(this, MyService.class);\n" +
                "bindService(bindIntent, connection, BIND_AUTO_CREATE); // 绑定服务\n" +
                "break;\n" +
                "case R.id.unbind_service:\n" +
                "unbindService(connection); // 解绑服务\n" +
                "break;\n" +
                "default:\n" +
                "break;\n" +
                "}\n" +
                "}");
        list.add("9.4 服务的生命周期\n" +
                "一旦在项目的任何位置调用了Context 的startService()方法，相应的服务就会启动起来，\n" +
                "并回调onStartCommand()方法。如果这个服务之前还没有创建过，onCreate()方法会先于\n" +
                "onStartCommand()方法执行。服务启动了之后会一直保持运行状态，直到stopService()或\n" +
                "stopSelf()方法被调用。注意虽然每调用一次startService()方法，onStartCommand()就会执行\n" +
                "一次，但实际上每个服务都只会存在一个实例。所以不管你调用了多少次startService()方法，\n" +
                "只需调用一次stopService()或stopSelf()方法，服务就会停止下来了。\n" +
                "另外，还可以调用Context 的bindService()来获取一个服务的持久连接，这时就会回调\n" +
                "服务中的onBind()方法。类似地，如果这个服务之前还没有创建过，onCreate()方法会先于\n" +
                "onBind()方法执行。之后，调用方可以获取到onBind()方法里返回的IBinder 对象的实例，这\n" +
                "样就能自由地和服务进行通信了。只要调用方和服务之间的连接没有断开，服务就会一直保\n" +
                "持运行状态。\n" +
                "当调用了startService()方法后，又去调用stopService()方法，这时服务中的onDestroy()\n" +
                "方法就会执行，表示服务已经销毁了。类似地，当调用了bindService()方法后，又去调用\n" +
                "unbindService()方法，onDestroy()方法也会执行，这两种情况都很好理解。但是需要注意，\n" +
                "我们是完全有可能对一个服务既调用了startService()方法，又调用了bindService()方法的，\n" +
                "这种情况下该如何才能让服务销毁掉呢？根据Android 系统的机制，一个服务只要被启动或\n" +
                "者被绑定了之后，就会一直处于运行状态，必须要让以上两种条件同时不满足，服务才能被\n" +
                "销毁。所以，这种情况下要同时调用stopService()和unbindService()方法，onDestroy()方法才\n" +
                "会执行。");
        list.add("9.5.1 使用前台服务（，当系统出现内存不足的情况时，就有可能会回收掉正在后台运行的服务）" +
                "MyService中notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);\n" +
                "        Notification.Builder ncb = new Notification.Builder(getApplicationContext());\n" +
                "        ncb.setTicker(\"测试前台服务\");\n" +
                "        ncb.setContentTitle(\"拉开后的title\");\n" +
                "        ncb.setContentText(\"我们正在进行前台服务测试。\");\n" +
                "        ncb.setSmallIcon(R.mipmap.ic_launcher);\n" +
                "        Intent intent = new Intent(getApplicationContext(), EmptyActivity.class);\n" +
                "        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);\n" +
                "        /*ncb.setDeleteIntent(pendingIntent);*/\n" +
                "        ncb.setContentIntent(pendingIntent);\n" +
                "        /*ncb.setFullScreenIntent(pendingIntent,true);*/\n" +
                "        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {\n" +
                "            startForeground(1, ncb.build());\n" +
                "        }else{\n" +
                "            startForeground(1, ncb.getNotification());\n" +
                "        }");
        list.add("9.5.2 使用IntentService \n" +
                "public class MyService extends Service {\n" +
                "@Override\n" +
                "public IBinder onBind(Intent intent) {\n" +
                "return null;\n" +
                "}\n" +
                "@Override\n" +
                "public int onStartCommand(Intent intent, int flags, int startId) {\n" +
                "new Thread(new Runnable() {\n" +
                "@Override\n" +
                "public void run() {\n" +
                "// 处理具体的逻辑\n" +
                "stopSelf();\n" +
                "}\n" +
                "}).start();\n" +
                "return super.onStartCommand(intent, flags, startId);\n" +
                "}\n" +
                "}\n" +
                "上面的方法可能会忘记开启线程（造成ANR）或者服务一直运行，android提供了现成的方法IntentService来避免这个问题：\n" +
                "public class MyIntentService extends IntentService {\n" +
                "public MyIntentService() {\n" +
                "super(\"MyIntentService\"); // 调用父类的有参构造函数\n" +
                "}\n" +
                "@Override\n" +
                "protected void onHandleIntent(Intent intent) {\n" +
                "// 打印当前线程的id\n" +
                "Log.d(\"MyIntentService\", \"Thread id is \" + Thread.currentThread().\n" +
                "getId());\n" +
                "}\n" +
                "@Override\n" +
                "public void onDestroy() {\n" +
                "super.onDestroy();\n" +
                "Log.d(\"MyIntentService\", \"onDestroy executed\");\n" +
                "}\n" +
                "}");
        list.add("Android 中的定时任务一般有两种实现方式，一种是使用Java API 里提供的Timer 类，\n" +
                "一种是使用Android 的Alarm 机制。AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);\n" +
                "int anHour = 60 * 60 * 1000; // 这是一小时的毫秒数\n" +
                "long triggerAtTime = SystemClock.elapsedRealtime() + anHour;\n" +
                "Intent i = new Intent(this, AlarmReceiver.class);\n" +
                "PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);\n" +
                "manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);\n" +
                "注意：另外需要注意的是，从Android 4.4 版本开始，Alarm 任务的触发时间将会变得不准确，\n" +
                "有可能会延迟一段时间后任务才能得到执行。这并不是个bug，而是系统在耗电性方面进行\n" +
                "的优化。系统会自动检测目前有多少Alarm 任务存在，然后将触发时间将近的几个任务放在\n" +
                "一起执行，这就可以大幅度地减少CPU 被唤醒的次数，从而有效延长电池的使用时间。\n" +
                "当然，如果你要求Alarm 任务的执行时间必须准备无误，Android 仍然提供了解决方案。\n" +
                "使用AlarmManager 的setExact()方法来替代set()方法，就可以保证任务准时执行了。");
        listView.setAdapter(new MyAdapter5(getContext(), R.layout.listview_layout, list));
        listView.setOnItemClickListener(this);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 6://前台服务
                Intent intent = new Intent(getContext(), MyService.class);
                getContext().startService(intent);
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
