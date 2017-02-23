package dx168.com.demo.dagger2;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;

/**
 * Created by liuxianjun on 17/2/22.
 */

public class Pot1 {
    private Flower flower;

//    @Inject
//    public Pot1(Flower flower) {
//        this.flower = flower;
//    }

//    @Inject
//    public Pot1(@Named("Lily") Flower flower) {
//        this.flower = flower;
//    }

    @Inject
    public Pot1(@FlowerModule.LilyFlower Flower flower) {
        this.flower = flower;
    }

    public String show() {
        return flower.whisper();
    }
}
