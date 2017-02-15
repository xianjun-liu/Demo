package dx168.com.demo.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dx168.com.demo.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_video)
    public void playVideo() {
        startActivity(VideoActivity.class);
    }

    @OnClick(R.id.btn_calendar)
    public void calendar() {
        startActivity(CalendarActivity.class);
    }

    @OnClick(R.id.btn_recyclerview)
    public void recyclerView() {
        startActivity(RecyclerViewActivity.class);
    }

}
