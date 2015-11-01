package example;

import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandLogger extends HystrixCommandExecutionHook {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLogger.class);

    @Override
    public <T> void onStart(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onStart");
        super.onStart(commandInstance);
    }

    @Override
    public <T> T onEmit(HystrixInvokable<T> commandInstance, T value) {
        LOGGER.info("onEmit [{}] [{}]", commandInstance, value);
        return super.onEmit(commandInstance, value);
    }

    @Override
    public <T> Exception onError(HystrixInvokable<T> commandInstance, HystrixRuntimeException.FailureType failureType, Exception e) {
        LOGGER.info("onError");
        return super.onError(commandInstance, failureType, e);
    }

    @Override
    public <T> void onSuccess(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onSuccess [{}]", commandInstance);
        super.onSuccess(commandInstance);
    }

    @Override
    public <T> void onThreadStart(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onThreadStart");
        super.onThreadStart(commandInstance);
    }

    @Override
    public <T> void onThreadComplete(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onThreadComplete");
        super.onThreadComplete(commandInstance);
    }

    @Override
    public <T> void onExecutionStart(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onExecutionStart");
        super.onExecutionStart(commandInstance);
    }

    @Override
    public <T> T onExecutionEmit(HystrixInvokable<T> commandInstance, T value) {
        LOGGER.info("onExecutionEmit");
        return super.onExecutionEmit(commandInstance, value);
    }

    @Override
    public <T> Exception onExecutionError(HystrixInvokable<T> commandInstance, Exception e) {
        LOGGER.info("onExecutionError");
        return super.onExecutionError(commandInstance, e);
    }

    @Override
    public <T> void onExecutionSuccess(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onExecutionSuccess");
        super.onExecutionSuccess(commandInstance);
    }

    @Override
    public <T> void onFallbackStart(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onFallbackStart [{}]", commandInstance);
        super.onFallbackStart(commandInstance);
    }

    @Override
    public <T> T onFallbackEmit(HystrixInvokable<T> commandInstance, T value) {
        LOGGER.info("onFallbackEmit");
        return super.onFallbackEmit(commandInstance, value);
    }

    @Override
    public <T> Exception onFallbackError(HystrixInvokable<T> commandInstance, Exception e) {
        LOGGER.info("onFallbackError [{}]", commandInstance, e);
        return super.onFallbackError(commandInstance, e);
    }

    @Override
    public <T> void onFallbackSuccess(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onFallbackSuccess [{}]", commandInstance);
        super.onFallbackSuccess(commandInstance);
    }

    @Override
    public <T> void onCacheHit(HystrixInvokable<T> commandInstance) {
        LOGGER.info("onCacheHit");
        super.onCacheHit(commandInstance);
    }
}
