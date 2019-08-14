import org.junit.Test;
import org.junit.runner.RunWith;

import static com.heiyu.platform.device.common.IdGenerator.getId;

/**
 * 雪花ID生成器，异步测试。
 * @author WangYi
 * @date 16:38 2019/8/9
 * @version 1.0
 **/

public class IdTest {

    @Test
    public void idtest() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(getId());
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(getId());
                }
            }
        };
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(getId());
                }
            }
        };
        Runnable runnable4 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(getId());
                }
            }
        };
        Runnable runnable5 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(getId());
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);
        Thread t4 = new Thread(runnable4);
        Thread t5 = new Thread(runnable5);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");
        t5.setName("t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();

    }
}
