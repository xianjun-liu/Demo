package dx168.com.demo.dagger2;

import dagger.Component;

/**
 * Created by liuxianjun on 17/2/22.
 */

@Component(modules = FlowerModule.class)
public interface Dagger2ActivityComponent {  //Component 是由目标类 + component组成
    void inject(Dagger2Activity activity);
}
