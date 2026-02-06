package execution.api;

public sealed interface ExecutionResult<T> permits Success, Failure{
    boolean isSuccess();
    T value();
    ExecutionError error();
}
