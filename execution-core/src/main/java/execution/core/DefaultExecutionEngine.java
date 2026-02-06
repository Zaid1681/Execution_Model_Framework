package execution.core;

import execution.api.*;

public class DefaultExecutionEngine implements ExecutionEngine{
    @Override
    public <T> ExecutionResult<T> run(Task<T> task) {
        try{
            return new Success<>(task.execute());
        }catch(Exception e){
            return new Failure<>(new ExecutionError("EXECUTION_FAILED",e.getMessage(),e));
        }
    }
}
