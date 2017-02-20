package dx168.com.demo.activity;

import android.os.Bundle;
import android.view.View;

import dx168.com.demo.R;
import dx168.com.demo.view.CircleMenuLayout;

/**
 * Created by lxj on 17/2/20.
 */

public class CCBCircleActivity extends BaseActivity {

    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[] { "安全中心 ", "特色服务", "投资理财",
            "转账汇款", "我的账户", "信用卡" };
    private int[] mItemImgs = new int[] { R.drawable.home_mbank_1_normal,
            R.drawable.home_mbank_2_normal, R.drawable.home_mbank_3_normal,
            R.drawable.home_mbank_4_normal, R.drawable.home_mbank_5_normal,
            R.drawable.home_mbank_6_normal };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //自已切换布局文件看效果
		setContentView(R.layout.activity_circle);
//        setContentView(R.layout.activity_circle_ccb);

        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);



        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {

            @Override
            public void itemClick(View view, int pos) {
                showLongToast(mItemTexts[pos]);
            }

            @Override
            public void itemCenterClick(View view) {
                showLongToast("you can do something just like ccb  ");
            }
        });

    }

}
