package execution.core;

import execution.api.ExecutionType;
import execution.api.Task;

public class ExecutionPlan <T>{
    private final Task<T> task;
    private final ExecutionType executionType;

    public ExecutionPlan(Task<T> task, ExecutionType executionType) {
        this.task = task;
        this.executionType = executionType;
    }
    public Task<T> task(){
        return this.task;
    }
    public ExecutionType executionType(){
        return this.executionType;
    }
}
