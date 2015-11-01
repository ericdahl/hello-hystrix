package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    private final HystrixEnabledService service;

    @Autowired
    public AppController(HystrixEnabledService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", produces = "application/json")
    public String something(@RequestParam(value = "wait", defaultValue = "4") int wait) {
        LOGGER.info("received request");
        return service.request(wait);
    }
}
