package execution.api;

public final class Success<T> implements ExecutionResult<T> {
    private final T value;

    public Success(T value) {
        this.value = value;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public T value() {
        return this.value;
    }

    @Override
    public ExecutionError error() {
        return null;
    }
}
