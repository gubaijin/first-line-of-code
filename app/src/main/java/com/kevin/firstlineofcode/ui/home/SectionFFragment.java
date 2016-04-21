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
 * {@link SectionFFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionFFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionFFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;

    private ListView mListView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static SectionFFragment newInstance() {
        SectionFFragment fragment = new SectionFFragment();
        return fragment;
    }

    public SectionFFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_section_6, null);
        init(root);
        return root;
    }

    private void init(View root) {
        mListView = (ListView) root.findViewById(R.id.section_6_lv);
        List<String> list = new ArrayList<String>();
        list.add("6.1:三种方式用于简单地实现数据持久化功能，\n" +
                "即文件存储、SharedPreference 存储以及数据库存储");
        list.add("6.2.1:将数据存储到文件中：Context 类中提供了一个openFileOutput ()方法，可以用于将数据存储到指定的文件中。\n" +
                "这个方法接收两个参数，第一个参数是文件名，在文件创建的时候使用的就是这个名称，注\n" +
                "意这里指定的文件名不可以包含路径，因为所有的文件都是默认存储到/data/data/<package\n" +
                "name>/files/ 目录下的。第二个参数是文件的操作模式， 主要有两种模式可选，\n" +
                "MODE_PRIVATE 和MODE_APPEND。其中MODE_PRIVATE 是默认的操作模式，表示当指\n" +
                "定同样文件名的时候，所写入的内容将会覆盖原文件中的内容，而MODE_APPEND 则表示\n" +
                "如果该文件已存在就往文件里面追加内容，不存在就创建新文件。");
        list.add("public void save() {\n" +
                "String data = \"Data to save\";\n" +
                "FileOutputStream out = null;\n" +
                "BufferedWriter writer = null;\n" +
                "try {\n" +
                "out = openFileOutput(\"data\", Context.MODE_PRIVATE);\n" +
                "writer = new BufferedWriter(new OutputStreamWriter(out));\n" +
                "writer.write(data);\n" +
                "} catch (IOException e) {\n" +
                "e.printStackTrace();\n" +
                "} finally {\n" +
                "try {\n" +
                "if (writer != null) {\n" +
                "writer.close();\n" +
                "}\n" +
                "} catch (IOException e) {\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "}\n" +
                "}");
        list.add("6.2.2:从文件中读取数据：Context 类中还提供了一个openFileInput()方法，用于从文\n" +
                "件中读取数据。这个方法要比openFileOutput()简单一些，它只接收一个参数，即要读取的文\n" +
                "件名，然后系统会自动到/data/data/<package name>/files/目录下去加载这个文件，并返回一个\n" +
                "FileInputStream 对象，得到了这个对象之后再通过Java 流的方式就可以将数据读取出来了。");
        list.add("public String load() {\n" +
                "FileInputStream in = null;\n" +
                "BufferedReader reader = null;\n" +
                "StringBuilder content = new StringBuilder();\n" +
                "try {\n" +
                "in = openFileInput(\"data\");\n" +
                "reader = new BufferedReader(new InputStreamReader(in));\n" +
                "String line = \"\";\n" +
                "while ((line = reader.readLine()) != null) {\n" +
                "content.append(line);\n" +
                "}\n" +
                "} catch (IOException e) {\n" +
                "e.printStackTrace();\n" +
                "} finally {\n" +
                "if (reader != null) {\n" +
                "try {\n" +
                "reader.close();\n" +
                "} catch (IOException e) {\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "return content.toString();\n" +
                "}");
        list.add("6.3.1 将数据存储到SharedPreferences 中：1. Context 类中的getSharedPreferences()方法" +
                "2. Activity 类中的getPreferences()方法" +
                "3. PreferenceManager 类中的getDefaultSharedPreferences()方法\n" +
                "主要可以分为三步实现。\n" +
                "1. 调用SharedPreferences 对象的edit()方法来获取一个SharedPreferences.Editor 对象。\n" +
                "2. 向SharedPreferences.Editor 对象中添加数据，比如添加一个布尔型数据就使用\n" +
                "putBoolean 方法，添加一个字符串则使用putString()方法，以此类推。\n" +
                "3. 调用commit()方法将添加的数据提交，从而完成数据存储操作。");
        list.add("6.3.2从SharedPreferences 中读取数据:SharedPreferences pref = getSharedPreferences(\"data\",\n" +
                "MODE_PRIVATE);\n" +
                "String name = pref.getString(\"name\", \"\");\n" +
                "int age = pref.getInt(\"age\", 0);\n" +
                "boolean married = pref.getBoolean(\"married\", false);");
        list.add("6.4 SQLite 数据库存储;6.4.1 创建数据库 提供了一个SQLiteOpenHelper 帮\n" +
                "助类，有两个抽象方法，分别是\n" +
                "onCreate()和onUpgrade()，我们必须在自己的帮助类里面重写这两个方法，然后分别在这两\n" +
                "个方法中去实现创建、升级数据库的逻辑。SQLiteOpenHelper 中还有两个非常重要的实例方法， getReadableDatabase() 和\n" +
                "getWritableDatabase()。这两个方法都可以创建或打开一个现有的数据库（如果数据库已存在\n" +
                "则直接打开，否则创建一个新的数据库），并返回一个可对数据库进行读写操作的对象。不\n" +
                "同的是，当数据库不可写入的时候（如磁盘空间已满）getReadableDatabase()方法返回的对\n" +
                "象将以只读的方式去打开数据库，而getWritableDatabase()方法则将出现异常。");
        list.add("public class MyDatabaseHelper extends SQLiteOpenHelper {\n" +
                "public static final String CREATE_BOOK = \"create table Book (\"\n" +
                "+ \"id integer primary key autoincrement, \"\n" +
                "+ \"author text, \"\n" +
                "+ \"price real, \"\n" +
                "+ \"pages integer, \"\n" +
                "+ \"name text)\";\n" +
                "public static final String CREATE_CATEGORY = \"create table Category (\"\n" +
                "+ \"id integer primary key autoincrement, \"\n" +
                "+ \"category_name text, \"\n" +
                "+ \"category_code integer)\";\n" +
                "private Context mContext;\n" +
                "public MyDatabaseHelper(Context context, String name,\n" +
                "CursorFactory factory, int version) {\n" +
                "super(context, name, factory, version);\n" +
                "mContext = context;\n" +
                "}\n" +
                "@Override\n" +
                "public void onCreate(SQLiteDatabase db) {\n" +
                "db.execSQL(CREATE_BOOK);\n" +
                "db.execSQL(CREATE_CATEGORY);\n" +
                "Toast.makeText(mContext, \"Create succeeded\", Toast.LENGTH_SHORT).\n" +
                "show();\n" +
                "}\n" +
                "@Override\n" +
                "public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {\n" +
                "db.execSQL(\"drop table if exists Book\");\n" +
                "db.execSQL(\"drop table if exists Category\");\n" +
                "onCreate(db);}\n" +
                "}");
        list.add("升级数据库(次方法非最佳方法，最佳方法继续往下)：将new MyDatabaseHelper(this, \"BookStore.db\", null, 1);" +
                "改为new MyDatabaseHelper(this, \"BookStore.db\", null, 2);");
        list.add("执行操作：public class MainActivity extends Activity {\n" +
                "private MyDatabaseHelper dbHelper;\n" +
                "@Override\n" +
                "protected void onCreate(Bundle savedInstanceState) {\n" +
                "super.onCreate(savedInstanceState);\n" +
                "setContentView(R.layout.activity_main);\n" +
                "dbHelper = new MyDatabaseHelper(this, \"BookStore.db\", null, 1);\n" +
                "Button createDatabase = (Button) findViewById(R.id.create_database);\n" +
                "createDatabase.setOnClickListener(new OnClickListener() {\n" +
                "@Override\n" +
                "public void onClick(View v) {\n" +
                "dbHelper.getWritableDatabase();\n" +
                "}\n" +
                "});\n" +
                "}\n" +
                "}");
        list.add("添加数据:public void onClick(View v) {\n" +
                "SQLiteDatabase db = dbHelper.getWritableDatabase();\n" +
                "ContentValues values = new ContentValues();\n" +
                "// 开始组装第一条数据\n" +
                "values.put(\"name\", \"The Da Vinci Code\");\n" +
                "values.put(\"author\", \"Dan Brown\");\n" +
                "values.put(\"pages\", 454);\n" +
                "values.put(\"price\", 16.96);\n" +
                "db.insert(\"Book\", null, values); // 插入第一条数据\n" +
                "values.clear();\n" +
                "// 开始组装第二条数据\n" +
                "values.put(\"name\", \"The Lost Symbol\");\n" +
                "values.put(\"author\", \"Dan Brown\");\n" +
                "values.put(\"pages\", 510);\n" +
                "values.put(\"price\", 19.95);\n" +
                "db.insert(\"Book\", null, values); // 插入第二条数据\n" +
                "}");
        list.add("更新数据:SQLiteDatabase db = dbHelper.getWritableDatabase();\n" +
                "ContentValues values = new ContentValues();\n" +
                "values.put(\"price\", 10.99);\n" +
                "db.update(\"Book\", values, \"name = ?\", new String[] { \"The Da\n" +
                "Vinci Code\" });这里使用了第三、第四个参数来指定具\n" +
                "体更新哪几行。第三个参数对应的是SQL 语句的where 部分，表示去更新所有name 等于?\n" +
                "的行，而?是一个占位符，可以通过第四个参数提供的一个字符串数组为第三个参数中的每\n" +
                "个占位符指定相应的内容。因此上述代码想表达的意图就是，将名字是The Da Vinci Code\n" +
                "的这本书的价格改成10.99。");
        list.add("删除数据：SQLiteDatabase db = dbHelper.getWritableDatabase();\n" +
                "db.delete(\"Book\", \"pages > ?\", new String[] { \"500\" });");
        list.add("查询数据：query()方法参数对应SQL 部分描述\n" +
                "table from table_name 指定查询的表名\n" +
                "columns select column1, column2 指定查询的列名\n" +
                "selection where column = value 指定where 的约束条件\n" +
                "selectionArgs - 为where 中的占位符提供具体的值\n" +
                "groupBy group by column 指定需要group by 的列\n" +
                "having having column = value 对group by 后的结果进一步约束\n" +
                "orderBy order by column1, column2 指定查询结果的排序方式");
        list.add("查询数据使用：public void onClick(View v) {\n" +
                "SQLiteDatabase db = dbHelper.getWritableDatabase();\n" +
                "// 查询Book表中所有的数据\n" +
                "Cursor cursor = db.query(\"Book\", null, null, null, null, null, null);\n" +
                "if (cursor.moveToFirst()) {\n" +
                "do {\n" +
                "// 遍历Cursor对象，取出数据并打印\n" +
                "String name = cursor.getString(cursor.\n" +
                "getColumnIndex(\"name\"));\n" +
                "String author = cursor.getString(cursor.\n" +
                "getColumnIndex(\"author\"));\n" +
                "int pages = cursor.getInt(cursor.getColumnIndex\n" +
                "(\"pages\"));\n" +
                "double price = cursor.getDouble(cursor.\n" +
                "getColumnIndex(\"price\"));\n" +
                "} while (cursor.moveToNext());\n" +
                "}\n" +
                "cursor.close();\n" +
                "}");
        list.add("使用SQL 操作数据库:添加数据的方法如下：\n" +
                "db.execSQL(\"insert into Book (name, author, pages, price) values(?, ?, ?, ?)\",\n" +
                "new String[] { \"The Da Vinci Code\", \"Dan Brown\", \"454\", \"16.96\" });\n" +
                "db.execSQL(\"insert into Book (name, author, pages, price) values(?, ?, ?, ?)\",\n" +
                "new String[] { \"The Lost Symbol\", \"Dan Brown\", \"510\", \"19.95\" });\n" +
                "更新数据的方法如下：\n" +
                "db.execSQL(\"update Book set price = ? where name = ?\", new String[] { \"10.99\",\n" +
                "\"The Da Vinci Code\" });\n" +
                "删除数据的方法如下：\n" +
                "db.execSQL(\"delete from Book where pages > ?\", new String[] { \"500\" });\n" +
                "查询数据的方法如下：\n" +
                "db.rawQuery(\"select * from Book\", null);");
        list.add("SQLite 数据库是支持事务的:public void onClick(View v) {\n" +
                "SQLiteDatabase db = dbHelper.getWritableDatabase();\n" +
                "db.beginTransaction(); // 开启事务\n" +
                "try {\n" +
                "db.delete(\"Book\", null, null);\n" +
                "if (true) {\n" +
                "// 在这里手动抛出一个异常，让事务失败\n" +
                "throw new NullPointerException();\n" +
                "}\n" +
                "ContentValues values = new ContentValues();\n" +
                "values.put(\"name\", \"Game of Thrones\");\n" +
                "values.put(\"author\", \"George Martin\");\n" +
                "values.put(\"pages\", 720);\n" +
                "values.put(\"price\", 20.85);\n" +
                "db.insert(\"Book\", null, values);\n" +
                "db.setTransactionSuccessful(); // 事务已经执行成功\n" +
                "} catch (Exception e) {\n" +
                "e.printStackTrace();\n" +
                "} finally {\n" +
                "db.endTransaction(); // 结束事务\n" +
                "}\n" +
                "}");
        list.add("6.5.2 升级数据库的最佳写法:public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {\n" +
                "switch (oldVersion) {\n" +
                "case 1:\n" +
                "db.execSQL(CREATE_CATEGORY);\n" +
                "case 2:\n" +
                "db.execSQL(\"alter table Book add column category_id integer\");\n" +
                "default:\n" +
                "}\n" +
                "}这里请注意一个非常重要的细节，switch 中每一个case 的最后都是没有使用break 的，\n" +
                "为什么要这么做呢？这是为了保证在跨版本升级的时候，每一次的数据库修改都能被全部执\n" +
                "行到。比如用户当前是从第二版程序升级到第三版程序的，那么case 2 中的逻辑就会执行。\n" +
                "而如果用户是直接从第一版程序升级到第三版程序的，那么case 1 和case 2 中的逻辑都会执\n" +
                "行。使用这种方式来维护数据库的升级，不管版本怎样更新，都可以保证数据库的表结构是\n" +
                "最新的，而且表中的数据也完全不会丢失了");
        mListView.setAdapter(new MyAdapter6(getContext(),R.layout.listview_layout,list));
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

    class MyAdapter6 extends ArrayAdapter<String> {

        private int resource;
        public MyAdapter6(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String content = getItem(position);
            View view;
            ViewHolder viewHolder;
            if (null == convertView) {
                view = LayoutInflater.from(getContext()).inflate(resource, null);

                viewHolder = new ViewHolder();
                viewHolder.mTextView = (TextView) view.findViewById(R.id.listview_layout_tv);
                view.setTag(viewHolder);
            } else {
                view = convertView;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.mTextView.setText(content);
            return view;
        }

        class ViewHolder {
            TextView mTextView;
        }
    }
}
