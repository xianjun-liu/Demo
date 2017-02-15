package dx168.com.demo.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dx168.com.demo.R;
import dx168.com.demo.view.MyVideoView;

/**
 * Created by lxj on 17/1/17.
 */

public class VideoActivity extends BaseActivity {

    private MyVideoView mSv_video;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        mSv_video = (MyVideoView) findViewById(R.id.sv_video);

        String uri = "android.resource://"+getPackageName()+"/" + R.raw.splish_video;
        mSv_video.setVideoURI(Uri.parse(uri));
        mSv_video.start();
        mSv_video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }});
    }

    @OnClick(R.id.btn_jump)
    public void jump(View view) {
        finish();
    }

}
