package dx168.com.demo.dagger2;

/**
 * Created by liuxianjun on 17/2/22.
 */

public class Rose1 extends Flower {
//    @Inject
//    public Rose1() {}  //Flower是抽象类 不能通过inject进行注入,

    @Override
    public String whisper() {
        return "热恋2";
    }
}
