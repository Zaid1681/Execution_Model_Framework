package execution.integration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorProvider {

    private static final ExecutorService DEFAULT_EXECUTOR =
            Executors.newFixedThreadPool(
                    Runtime.getRuntime().availableProcessors()
            );
    private ExecutorProvider() {
    }

    public static ExecutorService defaultExecutor(){
        return DEFAULT_EXECUTOR;
    }
}
