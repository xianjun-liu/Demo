package dx168.com.demo.dagger2;

import javax.inject.Inject;

/**
 * Created by liuxianjun on 17/2/22.
 */

public class Rose {

    @Inject
    public Rose() {}  //构造器注入 告诉dagger2可以使用这个构造器构建对象

    public String whisper() {
        return "热恋";
    }
}
