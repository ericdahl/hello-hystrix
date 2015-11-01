package example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixEnabledService {

    private final RestTemplate restTemplate = new RestTemplate();

    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="3"),
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value= "5000")
    })
    public String request(int wait) {

        if (wait < 0) {
            throw new IllegalArgumentException("nope");
        }

        return restTemplate.getForObject("http://httpbin.org/delay/" + wait, String.class);
    }

    public String fallbackMethod(int wait) {
        return "{\"response\": \"fallback method invoked\"}";
    }
}
