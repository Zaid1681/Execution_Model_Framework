package execution.api;

import execution.core.ExecutionEngine;
import execution.core.ExecutionPlan;

public final class ExecutionBuilder<T> {

    private final Task<T> task;
    private final ExecutionEngine engine;

    ExecutionBuilder(Task<T> task, ExecutionEngine engine) {
        this.task = task;
        this.engine = engine;
    }

    public ExecutionResult<T> sync() {
        return engine.executeSync(
                new ExecutionPlan<>(task, ExecutionType.SYNC)
        );
    }

    public AsyncResult<T> async() {
        return engine.executeAsync(
                new ExecutionPlan<>(task, ExecutionType.ASYNC)
        );
    }
}
