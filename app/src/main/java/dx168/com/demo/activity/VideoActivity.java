package dx168.com.demo.activity;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dx168.com.demo.R;
import dx168.com.demo.view.MyVideoView;

/**
 * Created by lxj on 17/1/17.
 */

public class VideoActivity extends BaseActivity {

    @Bind(R.id.sv_video) MyVideoView sv_video;
    @Bind(R.id.btn_jump) TextView btn_jump;
    private int totalTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        sv_video = (MyVideoView) findViewById(R.id.sv_video);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splish_video);
        sv_video.setVideoURI(uri);
        sv_video.start();
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(this, uri);
        String duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        totalTime = Integer.parseInt(duration);
        TimeCount timer = new TimeCount(totalTime, 1000);
        timer.start();
        sv_video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer player) {
                finish();
            }
        });
    }


    @OnClick(R.id.btn_jump)
    public void jump(View view) {
        finish();
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }
        @Override
        public void onFinish() {//计时完毕时触发
            VideoActivity.this.finish();
        }
        @Override
        public void onTick(long millisUntilFinished){//计时过程显示
            btn_jump.setText( millisUntilFinished / 1000+" 秒后跳过");
        }
    }


}
