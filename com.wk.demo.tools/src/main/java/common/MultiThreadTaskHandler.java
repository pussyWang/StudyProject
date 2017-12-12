package common;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 任务数n 定长线程池m
 * PackageName com.bj58.spat.scf.server.test
 * Created by wangkang on 2017/12/12.
 */
public class MultiThreadTaskHandler {
    public static void main(String[] args)throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(20);
        ExecutorService fixedthreadpool = Executors.newFixedThreadPool(5);
        for (int i = 0;i<20;i++){
            fixedthreadpool.execute(new task(countDownLatch,i));
        }
        countDownLatch.await();
        System.out.println("complete!");
        System.exit(0);
    }
    static class task implements Runnable{
        private CountDownLatch countDownLatch;
        private int taskid;
        public task(CountDownLatch countDownLatch,int taskid) {
            this.countDownLatch = countDownLatch;
            this.taskid = taskid;
        }
        @Override
        public void run() {
            try {
                System.out.println("taskid: " + taskid + "   threadid: " + Thread.currentThread().getId());
                Random r = new Random();
                int sleeptime = r.nextInt(5);
                Thread.sleep(sleeptime*100);
                countDownLatch.countDown();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
