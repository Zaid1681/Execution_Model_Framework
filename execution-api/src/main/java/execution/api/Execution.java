package execution.api;


import execution.core.DefaultExecutionEngine;
import execution.core.ExecutionEngine;

public final class Execution {
    private static final ExecutionEngine ENGINE = new DefaultExecutionEngine();
    public Execution() {
    }
    public static <T> ExecutionResult<T> run(Task<T> task){
        return ENGINE.run(task);
    }
}
