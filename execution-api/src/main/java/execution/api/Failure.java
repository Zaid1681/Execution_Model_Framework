package execution.api;

public final class Failure<T> implements ExecutionResult<T> {
    private final ExecutionError error;

    public Failure(ExecutionError error) {
        this.error = error;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public T value() {
        return null;
    }

    @Override
    public ExecutionError error() {
        return this.error;
    }
}
