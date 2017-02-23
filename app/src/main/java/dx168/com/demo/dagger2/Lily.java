package dx168.com.demo.dagger2;

import javax.inject.Inject;

/**
 * Created by liuxianjun on 17/2/22.
 */

public class Lily extends Flower {
//    @Inject
//    public Lily() {}

    @Override
    public String whisper() {
        return "纯洁";
    }
}
