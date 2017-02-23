package dx168.com.demo.dagger2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Named;
import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liuxianjun on 17/2/22.
 */

@Module
public class FlowerModule {
//    @Provides
//    Flower providerRose1() {
//        return new Rose1();
//    }

    //使用name限定符
//    @Provides
//    @Named("Rose")
//    Flower providerRose1() {
//        return new Rose1();
//    }
//
//    @Provides
//    @Named("Lily")
//    Flower providerLily() {
//        return new Lily();
//    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RoseFlower {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LilyFlower {}

    @Provides
    @RoseFlower
    Flower providerRose1() {
        return new Rose1();
    }

    @Provides
    @LilyFlower
    Flower providerLily() {
        return new Lily();
    }
}
