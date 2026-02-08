package execution.core;

import execution.api.*;
import execution.integration.ExecutorProvider;

import java.util.concurrent.CompletableFuture;

public class DefaultExecutionEngine implements ExecutionEngine {

    @Override
    public <T> ExecutionResult<T> executeSync(ExecutionPlan<T> plan) {
        try {
            return new Success<>(plan.task().execute());
        } catch (Exception e) {
            return new Failure<>(
                    new ExecutionError("EXECUTION_FAILED", e.getMessage(), e)
            );
        }
    }

    @Override
    public <T> AsyncResult<T> executeAsync(ExecutionPlan<T> plan) {
        var future = CompletableFuture.supplyAsync(() -> {
            try {
                return new Success<>(plan.task().execute());
            } catch (Exception e) {
                return new Failure<T>(
                        new ExecutionError("EXECUTION_FAILED", e.getMessage(), e)
                );
            }
        }, ExecutorProvider.defaultExecutor());

        return new DefaultAsyncResult<>(future);
    }
}
