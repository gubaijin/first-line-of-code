package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseBarActivity;
import com.kevin.firstlineofcode.ui.base.EmptyActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionHFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionHFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionHFragment extends Fragment implements AdapterView.OnItemClickListener {
    //    private OnFragmentInteractionListener mListener;
    private ListView listView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static SectionHFragment newInstance() {
        SectionHFragment fragment = new SectionHFragment();
        return fragment;
    }

    public SectionHFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_8, null);
        init(root);
        return root;
    }

    private void init(View root) {
        listView = (ListView) root.findViewById(R.id.section_8_lv);
        List<String> list = new ArrayList<String>();
        list.add("8.1 使用通知：NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);\n" +
                "接下来需要创建一个Notification 对象，这个对象用于存储通知所需的各种信息，我们\n" +
                "可以使用它的有参构造函数来进行创建。Notification 的有参构造函数接收三个参数，第一个\n" +
                "参数用于指定通知的图标，比如项目的res/drawable 目录下有一张icon.png 图片，那么这里\n" +
                "就可以传入R.drawable.icon。第二个参数用于指定通知的ticker 内容，当通知刚被创建的时\n" +
                "候，它会在系统的状态栏一闪而过，属于一种瞬时的提示信息。第三个参数用于指定通知被\n" +
                "创建的时间，以毫秒为单位，当下拉系统状态栏时，这里指定的时间会显示在相应的通知上。\n" +
                "因此，创建一个Notification 对象就可以写成：\n" +
                "Notification notification = new Notification(R.drawable.icon, \"This is ticker text\",\n" +
                "System.currentTimeMillis());\n" +
                "创建好了Notification 对象后，我们还需要对通知的布局进行设定，这里只需要调用\n" +
                "Notification 的setLatestEventInfo()方法就可以给通知设置一个标准的布局。这个方法接收四\n" +
                "个参数，第一个参数是Context，这个没什么好解释的。第二个参数用于指定通知的标题内\n" +
                "容，下拉系统状态栏就可以看到这部分内容。第三个参数用于指定通知的正文内容，同样下\n" +
                "拉系统状态栏就可以看到这部分内容。第四个参数我们暂时还用不到，可以先传入null。因\n" +
                "此，对通知的布局进行设定就可以写成：\n" +
                "notification.setLatestEventInfo(context, \"This is content title\", \"This is\n" +
                "content text\", null);\n" +
                "以上工作都完成之后，只需要调用NotificationManager 的notify()方法就可以让通知显示\n" +
                "出来了。notify()方法接收两个参数，第一个参数是id，要保证为每个通知所指定的id 都是\n" +
                "不同的。第二个参数则是Notification 对象，这里直接将我们刚刚创建好的Notification 对象\n" +
                "传入即可。因此，显示一个通知就可以写成：\n" +
                "manager.notify(1, notification);\n" +
                "到这里就已经把创建通知的每一个步骤都分析完了.\n");
        list.add("上面的方法已经过时，其实是使用如下方法实现的：NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);\n" +
                "NotificationCompat.Builder ncb = new NotificationCompat.Builder(getContext());\n" +
                "ncb.setTicker(\"ticker:这是第一个Notifiy例子。\");\n" +
                "ncb.setContentText(\"contentText:这是Notifiy内容。\");\n" +
                "ncb.setContentTitle(\"contentTitle:这是Notifiy标题。\");\n" +
                "ncb.setSmallIcon(R.mipmap.ic_launcher);\n" +
                "ncb.setAutoCancel(true);\n" +
                "ncb.setDefaults(Notification.DEFAULT_ALL);\n" +
                "Intent intent = new Intent(getContext(), EmptyActivity.class);\n" +
                "PendingIntent pi = PendingIntent.getActivity(getContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);\n" +
                "ncb.setContentIntent(pi);\n" +
                "notificationManager.notify(1, ncb.build());");
        list.add("，如果我们没有在代码中对该\n" +
                "通知进行取消，它就会一直显示在系统的状态栏上显示.\n" +
                "NotificationManager manager = (NotificationManager)\n" +
                "getSystemService(NOTIFICATION_SERVICE);\n" +
                "manager.cancel(1);");
        list.add("8.2.1 接收短信 public class MainActivity extends Activity {\n" +
                "private TextView sender;\n" +
                "private TextView content;\n" +
                "private IntentFilter receiveFilter;\n" +
                "private MessageReceiver messageReceiver;\n" +
                "@Override\n" +
                "protected void onCreate(Bundle savedInstanceState) {\n" +
                "super.onCreate(savedInstanceState);\n" +
                "setContentView(R.layout.activity_main);\n" +
                "sender = (TextView) findViewById(R.id.sender);\n" +
                "content = (TextView) findViewById(R.id.content);\n" +
                "receiveFilter = new IntentFilter();\n" +
                "receiveFilter.addAction(\"android.provider.Telephony.SMS_RECEIVED\");\n" +
                "messageReceiver = new MessageReceiver();\n" +
                "registerReceiver(messageReceiver, receiveFilter);\n" +
                "}\n" +
                "@Override\n" +
                "protected void onDestroy() {\n" +
                "super.onDestroy();\n" +
                "unregisterReceiver(messageReceiver);\n" +
                "}" +
                "class MessageReceiver extends BroadcastReceiver {\n" +
                "@Override\n" +
                "public void onReceive(Context context, Intent intent) {\n" +
                "Bundle bundle = intent.getExtras();\n" +
                "Object[] pdus = (Object[]) bundle.get(\"pdus\"); // 提取短信消息\n" +
                "SmsMessage[] messages = new SmsMessage[pdus.length];\n" +
                "for (int i = 0; i < messages.length; i++) {\n" +
                "messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);\n" +
                "}\n" +
                "String address = messages[0].getOriginatingAddress(); // 获取发\n" +
                "送方号码\n" +
                "String fullMessage = \"\";\n" +
                "for (SmsMessage message : messages) {\n" +
                "fullMessage += message.getMessageBody(); // 获取短信内容\n" +
                "}\n" +
                "sender.setText(address);\n" +
                "content.setText(fullMessage);\n" +
                "}\n" +
                "}\n" +
                "}");
        list.add("8.3.2 调用摄像头拍照 public class MainActivity extends Activity {\n" +
                "public static final int TAKE_PHOTO = 1;\n" +
                "public static final int CROP_PHOTO = 2;\n" +
                "private Button takePhoto;\n" +
                "private ImageView picture;\n" +
                "private Uri imageUri;\n" +
                "@Override\n" +
                "protected void onCreate(Bundle savedInstanceState) {\n" +
                "super.onCreate(savedInstanceState);\n" +
                "setContentView(R.layout.activity_main);\n" +
                "takePhoto = (Button) findViewById(R.id.take_photo);\n" +
                "picture = (ImageView) findViewById(R.id.picture);\n" +
                "takePhoto.setOnClickListener(new OnClickListener() {\n" +
                "@Override\n" +
                "public void onClick(View v) {\n" +
                "// 创建File对象，用于存储拍照后的图片\n" +
                "File outputImage = new File(Environment.\n" +
                "getExternalStorageDirectory(), \"tempImage.jpg\");\n" +
                "try {\n" +
                "if (outputImage.exists()) {\n" +
                "outputImage.delete();\n" +
                "}\n" +
                "outputImage.createNewFile();\n" +
                "} catch (IOException e) {\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "imageUri = Uri.fromFile(outputImage);\n" +
                "Intent intent = new Intent(\"android.media.action. IMAGE_CAPTURE\");\n" +
                "intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);\n" +
                "startActivityForResult(intent, TAKE_PHOTO); // 启动相机程序\n" +
                "}\n" +
                "});\n" +
                "}\n" +
                "@Override\n" +
                "protected void onActivityResult(int requestCode, int resultCode, Intent data) {\n" +
                "switch (requestCode) {\n" +
                "case TAKE_PHOTO:\n" +
                "if (resultCode == RESULT_OK) {\n" +
                "Intent intent = new Intent(\"com.android.camera.action.CROP\");\n" +
                "intent.setDataAndType(imageUri, \"image/*\");\n" +
                "intent.putExtra(\"scale\", true);\n" +
                "intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);\n" +
                "startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序\n" +
                "}\n" +
                "break;\n" +
                "case CROP_PHOTO:\n" +
                "if (resultCode == RESULT_OK) {\n" +
                "try {\n" +
                "Bitmap bitmap = BitmapFactory.decodeStream\n" +
                "(getContentResolver()\n" +
                ".openInputStream(imageUri));\n" +
                "picture.setImageBitmap(bitmap); // 将裁剪后的照片显示出来\n" +
                "} catch (FileNotFoundException e) {\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "}\n" +
                "break;\n" +
                "default:\n" +
                "break;\n" +
                "}");
        list.add("8.3.3 从相册中选择照片\n" +
                "public void onClick(View v) {\n" +
                "// 创建File对象，用于存储选择的照片\n" +
                "File outputImage = new File(Environment.\n" +
                "getExternalStorageDirectory(), \"output_image.jpg\");\n" +
                "try {\n" +
                "if (outputImage.exists()) {\n" +
                "outputImage.delete();\n" +
                "}\n" +
                "outputImage.createNewFile();\n" +
                "} catch (IOException e) {\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "imageUri = Uri.fromFile(outputImage);\n" +
                "Intent intent = new Intent(\"android.intent.action.GET_CONTENT\");\n" +
                "intent.setType(\"image/*\");\n" +
                "intent.putExtra(\"crop\", true);\n" +
                "intent.putExtra(\"scale\", true);\n" +
                "intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);");
        list.add("8.4 播放多媒体文件 \n" +
                "8.4.1 播放音频:MediaPlayer\n" +
                "方法名 功能描述"+
                "setDataSource() 设置要播放的音频文件的位置。\n" +
                "prepare() 在开始播放之前调用这个方法完成准备工作。\n" +
                "start() 开始或继续播放音频。\n" +
                "pause() 暂停播放音频。\n" +
                "reset() 将MediaPlayer 对象重置到刚刚创建的状态。\n" +
                "seekTo() 从指定的位置开始播放音频。\n" +
                "stop() 停止播放音频。调用这个方法后的MediaPlayer 对象无法再播放音频。\n" +
                "release() 释放掉与MediaPlayer 对象相关的资源。\n" +
                "isPlaying() 判断当前MediaPlayer 是否正在播放音频。\n" +
                "getDuration() 获取载入的音频文件的时长。");
        list.add("8.4.2 播放视频:VideoView\n" +
                "方法名功能描述\n" +
                "setVideoPath() 设置要播放的视频文件的位置。\n" +
                "start() 开始或继续播放视频。\n" +
                "pause() 暂停播放视频。\n" +
                "resume() 将视频重头开始播放。\n" +
                "seekTo() 从指定的位置开始播放视频。\n" +
                "isPlaying() 判断当前是否正在播放视频。\n" +
                "suspend() 将所占用的资源释放掉。\n" +
                "getDuration() 获取载入的视频文件的时长。\n" +
                "注意：VideoView 并不是一\n" +
                "个万能的视频播放工具类，它在视频格式的支持以及播放效率方面都存在着较大的不足。所\n" +
                "以，如果想要仅仅使用VideoView 就编写出一个功能非常强大的视频播放器是不太现实的。\n" +
                "但是如果只是用于播放一些游戏的片头动画，或者某个应用的视频宣传，使用VideoView 还\n" +
                "是绰绰有余的。");
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
        switch (position) {
            case 0:
                NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder ncb = new NotificationCompat.Builder(getContext());
                ncb.setTicker("ticker:这是第一个Notifiy例子。");
                ncb.setContentText("contentText:这是Notifiy内容。");
                ncb.setContentTitle("contentTitle:这是Notifiy标题。");
                ncb.setSmallIcon(R.mipmap.ic_launcher);
                ncb.setAutoCancel(true);
                ncb.setDefaults(Notification.DEFAULT_ALL);
                Intent intent = new Intent(getContext(), EmptyActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                ncb.setContentIntent(pi);
                notificationManager.notify(1, ncb.build());
                break;
            //消除状态栏的通知
            case 3:
                NotificationManager manager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                manager.cancel(1);
                break;
            //启动摄像头
            case 4:
                ((BaseBarActivity)getContext()).openActivity(EmptyActivity.class, "toPhoto");
                break;
            //相册中选择图片
            case 5:
                ((BaseBarActivity)getContext()).openActivity(EmptyActivity.class, "toPhotoAlbum");
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
