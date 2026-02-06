package execution.api;

@FunctionalInterface
public interface Task<T> {
    T execute() throws Exception;
}
