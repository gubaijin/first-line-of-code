package com.kevin.firstlineofcode.ui.home;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseBarActivity;
import com.kevin.firstlineofcode.ui.sectionJ.HttpURLConnActivity;
import com.kevin.firstlineofcode.ui.sectionJ.WebviewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionJFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionJFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionJFragment extends Fragment implements AdapterView.OnItemClickListener{
    //    private OnFragmentInteractionListener mListener;
    private ListView listView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static SectionJFragment newInstance() {
        SectionJFragment fragment = new SectionJFragment();
        return fragment;
    }

    public SectionJFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_10, null);
        init(root);
        return root;
    }

    private void init(View root) {
        listView = (ListView) root.findViewById(R.id.section_10_lv);
        List<String> list = new ArrayList<String>();
        list.add("10.1 WebView 的用法:protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_webview);\n" +
                "        webView = (WebView) findViewById(R.id.web_view);\n" +
                "        webView.getSettings().setJavaScriptEnabled(true);\n" +
                "        webView.setWebViewClient(new WebViewClient(){\n" +
                "            @Override\n" +
                "            public boolean shouldOverrideUrlLoading(WebView view, String url) {\n" +
                "                view.loadUrl(url);  //根据传入的参数再去加载新的网页\n" +
                "                return true;        //表示当前WebView可以处理打开新网页的请求，不用借助系统浏览器\n" +
                "            }\n" +
                "        });\n" +
                "        webView.loadUrl(\"http://www.baidu.com\");\n" +
                "    }");
        list.add("10.2.1 使用HttpURLConnection // 开启线程来发起网络请求\n" +
                "        new Thread(new Runnable() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                HttpURLConnection connection = null;\n" +
                "                try {\n" +
                "                    URL url = new URL(\"http://www.baidu.com\");\n" +
                "                    connection = (HttpURLConnection) url.openConnection();\n" +
                "                    connection.setRequestMethod(\"GET\");\n" +
                "                    connection.setConnectTimeout(8000);\n" +
                "                    connection.setReadTimeout(8000);\n" +
                "                    InputStream in = connection.getInputStream();\n" +
                "// 下面对获取到的输入流进行读取\n" +
                "                    BufferedReader reader = new BufferedReader(new\n" +
                "                            InputStreamReader(in));\n" +
                "                    StringBuilder response = new StringBuilder();\n" +
                "                    String line;\n" +
                "                    while ((line = reader.readLine()) != null) {\n" +
                "                        response.append(line);\n" +
                "                    }\n" +
                "                    Message message = new Message();\n" +
                "                    message.what = SHOW_RESPONSE;\n" +
                "// 将服务器返回的结果存放到Message中\n" +
                "                    message.obj = response.toString();\n" +
                "                    handler.sendMessage(message);\n" +
                "                } catch (Exception e) {\n" +
                "                    e.printStackTrace();\n" +
                "                } finally {\n" +
                "                    if (connection != null) {\n" +
                "                        connection.disconnect();\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }).start();");
        list.add("提交数据： connection.setRequestMethod(\"POST\");\n" +
                "DataOutputStream out = new DataOutputStream(connection.getOutputStream());\n" +
                "out.writeBytes(\"username=admin&password=123456\");");
        list.add("10.2.2 使用HttpClient 回的所有信息就会包\n" +
                "含在这里面。通常情况下我们都会先取出服务器返回的状态码，如果等于200 就说明请求和\n" +
                "响应都成功了，如下所示：\n" +
                "if (httpResponse.getStatusLine().getStatusCode() == 200) {\n" +
                "// 请求和响应都成功了\n" +
                "}\n" +
                "接下来在这个if 判断的内部取出服务返回的具体内容，可以调用getEntity()方法获取到\n" +
                "一个HttpEntity 实例，然后再用EntityUtils.toString()这个静态方法将HttpEntity 转换成字符串\n" +
                "即可，如下所示：\n" +
                "HttpEntity entity = httpResponse.getEntity();\n" +
                "String response = EntityUtils.toString(entity);\n" +
                "注意如果服务器返回的数据是带有中文的，直接调用EntityUtils.toString()方法进行转换\n" +
                "会有乱码的情况出现，这个时候只需要在转换的时候将字符集指定成utf-8 就可以了，如下\n" +
                "所示：\n" +
                "String response = EntityUtils.toString(entity, \"utf-8\");");
        list.add("10.3.1 XML-Pull解析方式  private void parseXMLWithPull(String xmlData) {\n" +
                "try {\n" +
                "XmlPullParserFactory factory = XmlPullParserFactory.newInstance();\n" +
                "XmlPullParser xmlPullParser = factory.newPullParser();\n" +
                "xmlPullParser.setInput(new StringReader(xmlData));\n" +
                "int eventType = xmlPullParser.getEventType();\n" +
                "String id = \"\";\n" +
                "String name = \"\";\n" +
                "String version = \"\";\n" +
                "while (eventType != XmlPullParser.END_DOCUMENT) {\n" +
                "String nodeName = xmlPullParser.getName();\n" +
                "switch (eventType) {\n" +
                "// 开始解析某个结点\n" +
                "case XmlPullParser.START_TAG: {\n" +
                "if (\"id\".equals(nodeName)) {\n" +
                "id = xmlPullParser.nextText();\n" +
                "} else if (\"name\".equals(nodeName)) {\n" +
                "name = xmlPullParser.nextText();\n" +
                "} else if (\"version\".equals(nodeName)) {\n" +
                "version = xmlPullParser.nextText();\n" +
                "}\n" +
                "break;\n" +
                "}\n" +
                "// 完成解析某个结点\n" +
                "case XmlPullParser.END_TAG: {\n" +
                "if (\"app\".equals(nodeName)) {\n" +
                "Log.d(\"MainActivity\", \"id is \" + id);\n" +
                "Log.d(\"MainActivity\", \"name is \" + name);\n" +
                "Log.d(\"MainActivity\", \"version is \" + version);\n" +
                "}\n" +
                "break;");
        list.add("10.3.2 XML-SAX解析方式  public class ContentHandler extends DefaultHandler {\n" +
                "private String nodeName;\n" +
                "private StringBuilder id;\n" +
                "private StringBuilder name;\n" +
                "private StringBuilder version;\n" +
                "@Override\n" +
                "public void startDocument() throws SAXException {\n" +
                "id = new StringBuilder();\n" +
                "name = new StringBuilder();\n" +
                "version = new StringBuilder();\n" +
                "}\n" +
                "@Override\n" +
                "public void startElement(String uri, String localName, String qName,\n" +
                "Attributes attributes) throws SAXException {\n" +
                "// 记录当前结点名\n" +
                "nodeName = localName;\n" +
                "}\n" +
                "@Override" +
                "public void characters(char[] ch, int start, int length) throws\n" +
                "SAXException {\n" +
                "// 根据当前的结点名判断将内容添加到哪一个StringBuilder对象中\n" +
                "if (\"id\".equals(nodeName)) {\n" +
                "id.append(ch, start, length);\n" +
                "} else if (\"name\".equals(nodeName)) {\n" +
                "name.append(ch, start, length);\n" +
                "} else if (\"version\".equals(nodeName)) {\n" +
                "version.append(ch, start, length);\n" +
                "}\n" +
                "}\n" +
                "@Override\n" +
                "public void endElement(String uri, String localName, String qName) throws\n" +
                "SAXException {\n" +
                "if (\"app\".equals(localName)) {\n" +
                "Log.d(\"ContentHandler\", \"id is \" + id.toString().trim());\n" +
                "Log.d(\"ContentHandler\", \"name is \" + name.toString().trim());\n" +
                "Log.d(\"ContentHandler\", \"version is \" + version.toString().trim());\n" +
                "// 最后要将StringBuilder清空掉\n" +
                "id.setLength(0);\n" +
                "name.setLength(0);\n" +
                "version.setLength(0);\n" +
                "}\n" +
                "}\n" +
                "@Override\n" +
                "public void endDocument() throws SAXException {\n" +
                "}\n" +
                "}" +
                "" +
                "private void parseXMLWithSAX(String xmlData) {\n" +
                "try {\n" +
                "SAXParserFactory factory = SAXParserFactory.newInstance();\n" +
                "XMLReader xmlReader = factory.newSAXParser().getXMLReader();\n" +
                "ContentHandler handler = new ContentHandler();\n" +
                "// 将ContentHandler的实例设置到XMLReader中\n" +
                "xmlReader.setContentHandler(handler);\n" +
                "// 开始执行解析\n" +
                "xmlReader.parse(new InputSource(new StringReader(xmlData)));");
        list.add("10.4.1 JSON-使用JSONObject  private void parseJSONWithJSONObject(String jsonData) {\n" +
                "try {\n" +
                "JSONArray jsonArray = new JSONArray(jsonData);\n" +
                "for (int i = 0; i < jsonArray.length(); i++) {\n" +
                "JSONObject jsonObject = jsonArray.getJSONObject(i);\n" +
                "String id = jsonObject.getString(\"id\");\n" +
                "String name = jsonObject.getString(\"name\");\n" +
                "String version = jsonObject.getString(\"version\");\n" +
                "Log.d(\"MainActivity\", \"id is \" + id);\n" +
                "Log.d(\"MainActivity\", \"name is \" + name);\n" +
                "Log.d(\"MainActivity\", \"version is \" + version);\n" +
                "}\n" +
                "} catch (Exception e) {\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "}");

        list.add("10.4.2 JSON-使用GSON  private void parseJSONWithGSON(String jsonData) {\n" +
                "Gson gson = new Gson();\n" +
                "List<App> appList = gson.fromJson(jsonData, new\n" +
                "TypeToken<List<App>>() {}.getType());\n" +
                "for (App app : appList) {\n" +
                "Log.d(\"MainActivity\", \"id is \" + app.getId());\n" +
                "Log.d(\"MainActivity\", \"name is \" + app.getName());\n" +
                "Log.d(\"MainActivity\", \"version is \" + app.getVersion());\n" +
                "}\n" +
                "}");
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
            case 0:
                ((BaseBarActivity)getContext()).openActivity(WebviewActivity.class);
            break;
            case 1:
                ((BaseBarActivity)getContext()).openActivity(HttpURLConnActivity.class);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
