package dx168.com.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import dx168.com.demo.R;

/**
 * Created by lxj on 17/2/16.
 */

public class MultipleRecyclerViewActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);
        ButterKnife.bind(this);
    }
}
