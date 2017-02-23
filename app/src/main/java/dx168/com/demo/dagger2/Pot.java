package dx168.com.demo.dagger2;

import javax.inject.Inject;

/**
 * Created by liuxianjun on 17/2/22.
 */

public class Pot {
    private Rose rose;

    @Inject //注入构造器所需参数的依赖 rose对象就会被注入到pot构造参数中
    public Pot(Rose rose) {
        this.rose = rose;
    }

    public String show() {
        return rose.whisper();
    }
}
