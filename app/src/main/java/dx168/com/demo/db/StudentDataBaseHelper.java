package dx168.com.demo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 16/7/6.
 */
public class StudentDataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "orm.db"; //数据库名称
    public static final String TABLE_NAME = "student"; //表名
    private static final int  VERSON = 1;//默认的数据库版本

    public StudentDataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSON);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table student(_id integer primary key autoincrement,id integer,name varchar(20),age de);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
