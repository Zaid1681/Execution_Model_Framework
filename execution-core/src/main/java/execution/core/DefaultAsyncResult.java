package execution.core;

import execution.api.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

final class DefaultAsyncResult<T> implements AsyncResult<T> {

    private final CompletableFuture<ExecutionResult<T>> future;

    DefaultAsyncResult(CompletableFuture<ExecutionResult<T>> future) {
        this.future = future;
    }

    @Override
    public AsyncResult<T> onSuccess(Consumer<T> consumer) {
        future.thenAccept(result -> {
            if (result instanceof Success<T> s) {
                consumer.accept(s.value());
            }
        });
        return this;
    }

    @Override
    public AsyncResult<T> onFailure(Consumer<ExecutionError> consumer) {
        future.thenAccept(result -> {
            if (result instanceof Failure<T> f) {
                consumer.accept(f.error());
            }
        });
        return this;
    }

    @Override
    public <U> AsyncResult<U> map(Function<T, U> mapper) {
        CompletableFuture<ExecutionResult<U>> mapped =
                future.thenApply(result -> {
                    if (result instanceof Success<T> s) {
                        return new Success<>(mapper.apply(s.value()));
                    }
                    Failure<T> f = (Failure<T>) result;
                    return new Failure<>(f.error());
                });

        return new DefaultAsyncResult<>(mapped);
    }
}
