package dx168.com.demo.dagger2;

import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dx168.com.demo.R;
import dx168.com.demo.activity.BaseActivity;

/**
 * Created by liuxianjun on 17/2/22.
 */

public class Dagger2Activity extends BaseActivity {
    @Inject
    Pot pot;  //属性注入 属性不能被private修饰,否则无法注入
    private Pot1 pot1;  //属性被private修饰的话只能通过方法注入,给属性赋值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        ButterKnife.bind(this);

        //需要重新build一下才会生成DaggerDagger2ActivityComponent
        DaggerDagger2ActivityComponent.create().inject(this);
    }

    @OnClick(R.id.tv_1)
    public void injectComponent() {
        String show = pot.show();
        showLongToast(show);
    }

    @OnClick(R.id.tv_2)
    public void moduleProvides() {
        String show = pot1.show();
        showLongToast(show);
    }

    @Inject  //方法注入  在构造器之后执行
    public void setPot(Pot1 pot) {
        this.pot1 = pot;
    }
}
