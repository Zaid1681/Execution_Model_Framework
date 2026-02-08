package execution.api;

import java.util.function.Consumer;
import java.util.function.Function;

public interface AsyncResult<T> {

    AsyncResult<T> onSuccess(Consumer<T> consumer);

    AsyncResult<T> onFailure(Consumer<ExecutionError> consumer);

    <U> AsyncResult<U> map(Function<T, U> mapper);
}
