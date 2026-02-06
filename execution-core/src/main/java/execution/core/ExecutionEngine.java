package execution.core;

import execution.api.ExecutionResult;
import execution.api.Task;

public interface ExecutionEngine {
    <T>ExecutionResult <T> run(Task<T> task);
}
/*
* Why need of 3 <T>
* 1st <T> : “For each call to run, there is a type T.”
* 2nd <T> : “The result contains the same type that the task produces.”
* 3rd <T> : “The task you give me produces a T.”
* */