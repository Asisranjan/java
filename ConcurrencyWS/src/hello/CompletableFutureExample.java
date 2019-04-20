package hello;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ExecutorService executor = Executors.newScheduledThreadPool(2);
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
		    return "Hello";
		}).thenApplyAsync(value-> value.toUpperCase(), executor);

		System.out.println("Value- " + cf.get());
		executor.shutdown();
	}

}
