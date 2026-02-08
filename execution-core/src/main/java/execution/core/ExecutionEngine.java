package execution.core;

import execution.api.AsyncResult;
import execution.api.ExecutionResult;
import execution.api.Task;

import java.util.concurrent.CompletableFuture;

public interface ExecutionEngine {

    <T> ExecutionResult<T> executeSync(ExecutionPlan<T> plan);
    <T> AsyncResult<T> executeAsync(ExecutionPlan<T> plan);
}
/*
* Why need of 3 <T>
* 1st <T> : “For each call to run, there is a type T.”
* 2nd <T> : “The result contains the same type that the task produces.”
* 3rd <T> : “The task you give me produces a T.”
* */