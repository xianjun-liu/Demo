package dx168.com.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import dx168.com.demo.R;
import dx168.com.demo.bean.Student;
import dx168.com.demo.dao.StudentDao;

/**
 * Created by lxj on 17/2/16.
 */

public class DataBaseActivity extends BaseActivity {
    private List<Student> list = new ArrayList<>();
    private StudentDao studentDao;
    private int count = 0;
    private int deleteCount = 5;
    private int updateCount = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        init();
    }

    private void init() {
        for (int i = 0; i < 30; i++) {
            Student student = new Student();
            student.setName("刘贤俊" + i);
            student.setId(i);
            student.setAge(1000l + i * 10);
            list.add(student);
        }
        studentDao = new StudentDao(this);
    }

    public void add(View view) {
        studentDao.add(count,"刘贤俊" + count,100+count);
        count++;
    }

    public void delete(View view) {
        boolean isDelete = studentDao.delete(deleteCount);
        if (isDelete) {
            showLongToast("删除了第" +deleteCount+ "个数据");
        } else {
            showLongToast("删除失败");
        }
        deleteCount++;
    }

    public void clear(View view) {
        boolean isClear = studentDao.clear();
        if (isClear) {
            showLongToast("清空数据成功");
        } else {
            showLongToast("删除失败");
        }
    }

    public void update(View view) {
        boolean isUpdate = studentDao.update("刘贤俊" + updateCount, 101000000l);
        if (isUpdate) {
            showLongToast("修改第"+updateCount+"成功");
        } else {
            showLongToast("修改"+updateCount+"失败");
        }
        updateCount++;
    }

    public void query(View view) {
        List<Student> query = studentDao.query();
        showLongToast(query.toString());
    }
}
