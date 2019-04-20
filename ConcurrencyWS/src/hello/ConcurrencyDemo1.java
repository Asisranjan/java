package hello;

import java.util.concurrent.*;
public class ConcurrencyDemo1{
     // count number of attempt
     private int counter = 0;
     private int heartbeattimer = 0;
     public static void main(String []args){
        ConcurrencyDemo1 h = new ConcurrencyDemo1();
        h.start();
     }

     public void start()
     {
        CountDownLatch latch = new CountDownLatch(1);
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> handle = exec.scheduleAtFixedRate(this.new Task(latch), 1, 5, TimeUnit.SECONDS);

        try {
            // block till registration success
            latch.await();
            handle.cancel(true);
            exec.shutdownNow();
            System.out.println(handle.isDone());
            System.out.println(handle.isCancelled());


            scheduleHeartbeatRequest();

            initiateLookupOnAnyChangeOnConfig();

        } catch (Throwable e) {
             //Exception rootException = e.getCause();
        }
     }

     public void initiateLookupOnAnyChangeOnConfig()
     {

     }

     public void scheduleHeartbeatRequest()
     {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> handle = exec.scheduleAtFixedRate(this.new HeartbeatHandler(), heartbeattimer, heartbeattimer, TimeUnit.SECONDS);
     }

     class Task implements Runnable
     {
        CountDownLatch latch;
        public Task(CountDownLatch latch){
                this.latch = latch;
        }
        public void run()
        {
           counter ++;
           System.out.println("Hello World -"+System.currentTimeMillis()+"-"+counter);
           // Lets say registation success in 4th attempt
           if (counter == 4){
              try {
                  heartbeattimer = 5;
                  latch.countDown();
              } catch (Throwable e) {
                  //Exception rootException = e.getCause();
              }
           }
        }
    }

   class HeartbeatHandler implements Runnable
   {
      public void run()
        {
           System.out.println("Send heart beat message - "+System.currentTimeMillis());
        }
   }
}
