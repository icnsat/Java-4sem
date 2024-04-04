package pract_4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService implements ExecutorService {
    private ExecutorService ex;
    public MyExecutorService(int count){
        this.ex = Executors.newFixedThreadPool(count);
    }
    @Override
    public void shutdown() {
        ex.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return ex.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return ex.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return ex.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return ex.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return ex.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return ex.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return ex.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return ex.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return ex.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return ex.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return ex.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        ex.execute(command);
    }
}
