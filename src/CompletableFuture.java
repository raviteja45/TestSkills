

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.StopWatch;

public class ConcurrentCall {
	
	public void makeParallelCall() {
		ParallelCallOne one = new ParallelCallOne();
		ParallelCallTwo two = new ParallelCallTwo();
		List<Callable<Object>> list = new ArrayList<>();
		
		StopWatch st1 = new StopWatch();
		st1.start("Sequential");
		one.getOneMethod();
	        one.getOneMethod();
		one.getOneMethod();
		one.getOneMethod();
		st1.stop();
		System.out.println(st1.prettyPrint()); // Taking 1MS
		
		StopWatch st = new StopWatch();
		st.start("Parallel");
		list.add(()->one.getOneMethod());
		list.add(()->one.getOneMethod());
		list.add(()->one.getOneMethod());
		list.add(()->one.getOneMethod());
		list.add(()->two.getMethodTwo());
		ExecutorService ex = Executors.newFixedThreadPool(5);
		try {
			List<Future<Object>> f = ex.invokeAll(list);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		st.stop();
		System.out.println(st.prettyPrint()); // Taking 36 MS
		
		StopWatch st2 = new StopWatch();
		st2.start("Using completableFuture");
		
		//By default, CompletableFuture uses ForkJoin pool.
		//One Way
		List<CompletableFuture<Object>> futuresList = new ArrayList<>();
		futuresList.add(CompletableFuture.supplyAsync(()->one.getOneMethod()));
		futuresList.add(CompletableFuture.supplyAsync(()->one.getOneMethod()));
		futuresList.add(CompletableFuture.supplyAsync(()->one.getOneMethod()));
		futuresList.add(CompletableFuture.supplyAsync(()->two.getMethodTwo()));
		CompletableFuture<Void> all = CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
		CompletableFuture<List<Object>> allCompletableFuture = all.thenApply(future->{
			return futuresList.stream().map(temp->temp.join()).collect(Collectors.toList());
		});
		//End one way
		
		//Other way
		CompletableFuture<Object> f1 = CompletableFuture.supplyAsync(()->one.getOneMethod());
		CompletableFuture<Object> f2 = CompletableFuture.supplyAsync(()->one.getOneMethod());
		CompletableFuture<Object> f3 = CompletableFuture.supplyAsync(()->one.getOneMethod());
		CompletableFuture<Object> f4 = CompletableFuture.supplyAsync(()->one.getOneMethod());
		CompletableFuture<Object> f5 = CompletableFuture.supplyAsync(()->two.getMethodTwo());
		CompletableFuture<Void> allFuture = CompletableFuture.allOf(f1,f2,f3,f4,f5);
		CompletableFuture<List<Object>> allCompletableFutureOther = allFuture.thenApply(future->{
			return Stream.of(f1,f2,f3,f4,f5).map(temp->temp.join()).collect(Collectors.toList());
		});
		//End Other way
		
		st2.stop();
		System.out.println(st2.prettyPrint()); // Taking 8 MS
		try {
			List<Object> temp = allCompletableFutureOther.get();
			for(Object obj:temp) {
				System.out.println(obj);
			}
		} catch (ExecutionException | InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//Callback in completableFuture
		
		CompletableFuture<String> complete = CompletableFuture.supplyAsync(()->{
			return "World";
		});
		CompletableFuture<String> res = complete.thenApply(temp->{
			return "Hello "+temp;
		});
		try {
			System.out.println(res.get());// Hello World
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		CompletableFuture<DeviceDetailsResponse> completeOther = CompletableFuture.supplyAsync(()->one.getOneMethod());
		completeOther.thenApply(temp->{
			Map<String, String> map = new HashMap<>();
			map.put("Hello", "World");
			temp.setPerformanceLogMap(map);
			return temp;
		});
		try {
			System.out.println(completeOther.get().getPerformance()); //Hello=World
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		// thenCombine and thenCompose will be used when we have only 2 Completable Futures, 
		// But when we have more than 2 completable futures to be joined, we need to use allOf
		//thenCompose will be used when one future result is dependent on other
		CompletableFuture<String> result = complete.thenCompose(temp->{
			return res;
		});
		
		try {
			System.out.println(result.get());//Hello World
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		// When we have two completableFutures and We want to run both the futures independently and combine once we have the result
		// Then we need to use thenCombine	
		CompletableFuture<String> result1 = complete.thenCombine(res, (temp,temp1)->{
			return temp.concat(" ").concat(temp1);
		});
		try {
			System.out.println("Final "+result1.get()); //Final World Hello World
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
	
		// How exceptions will be thrown
		CompletableFuture<Object> completeException = CompletableFuture.supplyAsync(()->{
			throw new NullPointerException();
		}).exceptionally(ex1->{
			System.out.println("An exception occurred");
			return "";
		});
		
		try {
			System.out.println(completeException.get());//An exception occurred
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ConcurrentCall x = new ConcurrentCall();
		x.makeParallelCall(null);
	}
	

}
