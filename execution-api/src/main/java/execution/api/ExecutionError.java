package execution.api;

/*
* ExecutionError is behaving like a data not a behaviour
* */
public record ExecutionError(
        String code,
        String message,
        Throwable cause
) {}
