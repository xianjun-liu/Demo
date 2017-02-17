package dx168.com.demo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dx168.com.demo.bean.Student;
import dx168.com.demo.db.StudentDataBaseHelper;

/**
 * Created on 16/7/6.
 */
public class StudentDao {

    private StudentDataBaseHelper helper;

    public StudentDao() {
    }

    public StudentDao(Context context) {
        helper = new StudentDataBaseHelper(context);
    }

    public boolean add(int id, String name, long age) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("age", age);
        long rowId = db.insert(StudentDataBaseHelper.TABLE_NAME, null, values);
        db.close();
        if (rowId == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据id删除某个学生
     * @return
     */
    public boolean delete(int id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int rowNumber = db.delete(StudentDataBaseHelper.TABLE_NAME, "id <= ?", new String[]{id + ""});
        db.close();
        if (rowNumber == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getLastDataId() {
        int lastId = 0;
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(StudentDataBaseHelper.TABLE_NAME, null, null, null, null, null, null, null);
        return lastId;
    }

    public boolean clear() {
        SQLiteDatabase db = helper.getWritableDatabase();
        int rowNumber = db.delete(StudentDataBaseHelper.TABLE_NAME, null, null);
        db.close();
        if (rowNumber == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据姓名修改年龄
     * @param name
     * @param newAge
     * @return
     */
    public boolean update(String name, long newAge) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age",newAge);
        int rowNumber = db.update(StudentDataBaseHelper.TABLE_NAME,values,"name = ?",new String[]{name});
        db.close();
        if (rowNumber == 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<Student> query() {
        SQLiteDatabase db = helper.getWritableDatabase();
        ArrayList<Student> list = new ArrayList<>();
        Cursor cursor = db.query(StudentDataBaseHelper.TABLE_NAME, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.setAge(cursor.getLong(cursor.getColumnIndex("age")));
            student.setId(cursor.getInt(cursor.getColumnIndex("id")));
            student.setName(cursor.getString(cursor.getColumnIndex("name")));
            list.add(student);
        }
        cursor.close();
        db.close();
        return list;
    }

}
