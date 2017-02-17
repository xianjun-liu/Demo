package dx168.com.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.alertview.AlertView;

import dx168.com.demo.R;
import dx168.com.demo.view.TitleView;

/**
 * Created by lxj on 17/2/15.
 */

public class BaseActivity extends FragmentActivity {

    private Toast mToast;
    public Handler mHandler = new Handler();
    private TitleView mTitleView;
    protected AlertView alertView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        TitleView view = getTitleView();
        String title = null;
        if (view != null) {
            title = view.getTitleText();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getTitleView() != null) {
            getTitleView().setRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRightClick();
                }
            });
        }
    }

    public TitleView getTitleView() {
        if (mTitleView == null) {
            mTitleView = (TitleView) findViewById(R.id.view_title);
        }
        return mTitleView;
    }

    /**
     * 点击标题栏右侧按钮时调用
     */
    protected void onRightClick() {

    }

    /**
     * 点击返回键或者标题栏的返回时调用
     * @param isSystem 是否是来自系统返回键
     * @return
     */
    protected boolean onBack(boolean isSystem) {
        if (getTitleView() != null && getTitleView().isTitleArrayViewShowing()) {
            getTitleView().closeTitleArrayView();
            return true;
        }
        if (alertView != null && alertView.isShowing()) {
            alertView.dismiss();
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return (keyCode == KeyEvent.KEYCODE_BACK && onBack(true)) || super.onKeyUp(keyCode, event);
    }

    public BaseActivity getActivity() {
        return this;
    }

    public BaseActivity getContext() {
        return this;
    }

    public void startActivity(Class<? extends Activity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void showLongToast(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
