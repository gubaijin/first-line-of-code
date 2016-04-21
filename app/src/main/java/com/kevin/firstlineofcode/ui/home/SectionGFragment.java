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
 * {@link SectionGFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionGFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionGFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;

    private ListView listView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static SectionGFragment newInstance() {
        SectionGFragment fragment = new SectionGFragment();
        return fragment;
    }

    public SectionGFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_7, null);
        init(root);
        return root;
    }

    private void init(View root) {
        listView = (ListView) root.findViewById(R.id.section_7_lv);
        List<String> list = new ArrayList<String>();
        list.add("7.2 内容提供器:\n" +
                "7.2.1 ContentResolver 的基本用法:Uri uri = Uri.parse(\"content://com.example.app.provider/table1\")\n" +
                "协议声明://权限/路径" +
                "Cursor cursor = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);\n" +
                "query()方法参数对应SQL 部分描述\n" +
                "uri from table_name 指定查询某个应用程序下的某一张表\n" +
                "projection select column1, column2 指定查询的列名\n" +
                "selection where column = value 指定where 的约束条件\n" +
                "selectionArgs - 为where 中的占位符提供具体的值\n" +
                "orderBy order by column1, column2 指定查询结果的排序方式\n" +
                "遍历Cursor：if (cursor != null) {\n" +
                "while (cursor.moveToNext()) {\n" +
                "String column1 = cursor.getString(cursor.getColumnIndex(\"column1\"));\n" +
                "int column2 = cursor.getInt(cursor.getColumnIndex(\"column2\"));\n" +
                "}\n" +
                "cursor.close();\n" +
                "}");
        list.add("insert:\n" +
                "ContentValues values = new ContentValues();\n" +
                "values.put(\"column1\", \"text\");\n" +
                "values.put(\"column2\", 1);\n" +
                "getContentResolver().insert(uri, values);\n" +
                "update:\n" +
                "ContentValues values = new ContentValues();\n" +
                "values.put(\"column1\", \"\");\n" +
                "getContentResolver().update(uri, values, \"column1 = ? and column2 = ?\", new\n" +
                "String[] {\"text\", \"1\"});\n" +
                "delete:\n" +
                "getContentResolver().delete(uri, \"column2 = ?\", new String[] { \"1\" });");
        list.add("查询手机联系人：private void readContacts() {\n" +
                "Cursor cursor = null;\n" +
                "try {\n" +
                "// 查询联系人数据\n" +
                "cursor = getContentResolver().query(\n" +
                "ContactsContract.CommonDataKinds.Phone.CONTENT_URI,\n" +
                "null, null, null, null);\n" +
                "while (cursor.moveToNext()) {\n" +
                "// 获取联系人姓名\n" +
                "String displayName = cursor.getString(cursor.getColumnIndex(\n" +
                "ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));\n" +
                "// 获取联系人手机号\n" +
                "String number = cursor.getString(cursor.getColumnIndex(\n" +
                "ContactsContract.CommonDataKinds.Phone.NUMBER));\n" +
                "contactsList.add(displayName + \"\\n\" + number);\n" +
                "}\n" +
                "} catch (Exception e) {\n" +
                "e.printStackTrace();\n" +
                "} finally {\n" +
                "if (cursor != null) {\n" +
                "cursor.close();\n" +
                "}\n" +
                "}\n" +
                "}");
        list.add("7.3.创建自己的内容提供器：1. *：表示匹配任意长度的任意字符\n" +
                "2. #：表示匹配任意长度的数字\n" +
                "所以，一个能够匹配任意表的内容URI 格式就可以写成：\n" +
                "content://com.example.app.provider/*\n" +
                "而一个能够匹配table1 表中任意一行数据的内容URI 格式就可以写成：\n" +
                "content://com.example.app.provider/table1/#\n" +
                "以query为例：public class MyProvider extends ContentProvider {\n" +
                "public static final int TABLE1_DIR = 0;\n" +
                "public static final int TABLE1_ITEM = 1;\n" +
                "public static final int TABLE2_DIR = 2;\n" +
                "public static final int TABLE2_ITEM = 3;\n" +
                "private static UriMatcher uriMatcher;\n" +
                "static {\n" +
                "uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);\n" +
                "uriMatcher.addURI(\"com.example.app.provider\", \"table1\", TABLE1_DIR);\n" +
                "uriMatcher.addURI(\"com.example.app.provider \", \"table1/#\", TABLE1_ITEM);\n" +
                "uriMatcher.addURI(\"com.example.app.provider \", \"table2\", TABLE2_ITEM);\n" +
                "uriMatcher.addURI(\"com.example.app.provider \", \"table2/#\", TABLE2_ITEM);\n" +
                "}\n" +
                "@Override\n" +
                "public Cursor query(Uri uri, String[] projection, String selection,\n" +
                "String[] selectionArgs, String sortOrder) {\n" +
                "switch (uriMatcher.match(uri)) {\n" +
                "case TABLE1_DIR:\n" +
                "// 查询table1表中的所有数据\n" +
                "break;\n" +
                "case TABLE1_ITEM:\n" +
                "// 查询table1表中的单条数据\n" +
                "break;\n" +
                "case TABLE2_DIR:\n" +
                "// 查询table2表中的所有数据\n" +
                "break;\n" +
                "case TABLE2_ITEM:\n" +
                "// 查询table2表中的单条数据\n" +
                "break;\n" +
                "default:\n" +
                "break;\n" +
                "}\n" +
                "}\n" +
                "@Override\n" +
                        "public String getType(Uri uri) {\n" +
                        "switch (uriMatcher.match(uri)) {\n" +
                        "case TABLE1_DIR:\n" +
                        "return \"vnd.android.cursor.dir/vnd.com.example.app.provider.\n" +
                        "table1\";\n" +
                        "case TABLE1_ITEM:\n" +
                        "return \"vnd.android.cursor.item/vnd.com.example.app.provider.\n" +
                        "table1\";\n" +
                        "case TABLE2_DIR:\n" +
                        "return \"vnd.android.cursor.dir/vnd.com.example.app.provider.\n" +
                        "table2\";\n" +
                        "case TABLE2_ITEM:\n" +
                        "return \"vnd.android.cursor.item/vnd.com.example.app.provider.\n" +
                        "table2\";\n" +
                        "default:\n" +
                        "break;\n" +
                        "}\n" +
                        "return null;\n" +
                        "}\n"+
                "}");
        list.add("uri.getPathSegments():它会将内容URI 权限之后的部分以“/”符号进行分割，并把分割后\n" +
                "的结果放入到一个字符串列表中，那这个列表的第0 个位置存放的就是路径，第1 个位置存\n" +
                "放的就是id 了。得到了id 之后，再通过selection 和selectionArgs 参数进行约束，就实现了\n" +
                "查询单条数据的功能。\n" +
                "String categoryId = uri.getPathSegments().get(1);\n" +
                "deletedRows = db.delete(\"Category\", \"id = ?\", new String[]\n" +
                "{ categoryId });");
        list.add("getType()方法:。它是所有的内容提供器都必\n" +
                "须提供的一个方法，用于获取Uri 对象所对应的MIME 类型。一个内容URI 所对应的MIME\n" +
                "字符串主要由三部分组分，Android 对这三个部分做了如下格式规定。\n" +
                "1. 必须以vnd 开头。\n" +
                "2. 如果内容URI 以路径结尾，则后接android.cursor.dir/，如果内容URI 以id 结尾，\n" +
                "则后接android.cursor.item/。\n" +
                "3. 最后接上vnd.<authority>.<path>。\n" +
                "所以，对于content://com.example.app.provider/table1 这个内容URI，它所对应的MIME\n" +
                "类型就可以写成：\n" +
                "vnd.android.cursor.dir/vnd.com.example.app.provider.table1\n" +
                "对于content://com.example.app.provider/table1/1 这个内容URI，它所对应的MIME 类型\n" +
                "就可以写成：\n" +
                "vnd.android.cursor.item/vnd. com.example.app.provider.table1");
        list.add("使用了<provider>标签来对DatabaseProvider 这个内容提供器进行注\n" +
                "册，在android:name 属性中指定了该类的全名，又在android:authorities 属性中指定了该内容\n" +
                "提供器的权限。\n" +
                "<provider android:name=\"com.example.databasetest.DatabaseProvider\"\n" +
                "android:authorities=\"com.example.databasetest.provider\" >\n" +
                "</provider>\n" +
                "</application>");
        listView.setAdapter(new MyAdapter7(getContext(), R.layout.listview_layout, list));
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

    class MyAdapter7 extends ArrayAdapter<String>{
        private int resource;
        public MyAdapter7(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String content = getItem(position);
            View view;
            ViewHolder viewHolder;
            if(null == convertView){
                view = LayoutInflater.from(getContext()).inflate(resource, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) view.findViewById(R.id.listview_layout_tv);
                view.setTag(viewHolder);
            }else{
                view = convertView;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.textView.setText(content);
            return view;
        }

        class ViewHolder{
            public TextView textView;
        }
    }
}
