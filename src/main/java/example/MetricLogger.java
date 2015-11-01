package example;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MetricLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricLogger.class);

    @Scheduled(fixedRate = 1000)
    public void something() {
        final HystrixCommandMetrics metrics = HystrixCommandMetrics.getInstance(HystrixCommandKey.Factory.asKey("request"));

        if (metrics != null) { // metrics will be null until command is first used
            LOGGER.info("command [{}]: execTime [{}] errors [{}]/[{}]", metrics.getCommandKey().name(),
                    metrics.getExecutionTimeMean(),
                    metrics.getHealthCounts().getErrorCount(),
                    metrics.getHealthCounts().getTotalRequests());
        }
    }
}
