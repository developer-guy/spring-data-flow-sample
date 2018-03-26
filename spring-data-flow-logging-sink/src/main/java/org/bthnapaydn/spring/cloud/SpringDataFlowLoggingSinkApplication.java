package org.bthnapaydn.spring.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringDataFlowLoggingSinkApplication {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @StreamListener(Sink.INPUT)
    public void loggerSink(String date) {
        LOG.info("Received: " + date);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataFlowLoggingSinkApplication.class, args);
    }
}
