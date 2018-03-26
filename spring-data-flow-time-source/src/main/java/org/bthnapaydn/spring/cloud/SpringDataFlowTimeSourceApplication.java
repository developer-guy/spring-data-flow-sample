package org.bthnapaydn.spring.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;

@SpringBootApplication
@EnableBinding(Source.class)
public class SpringDataFlowTimeSourceApplication {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Bean
    @InboundChannelAdapter(
            value = Source.OUTPUT,
            poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1")
    )
    public MessageSource<Long> timeMessageSource() {
        LOG.info("Now sending  data from source!!!");
        return () -> MessageBuilder.withPayload(new Date().getTime()).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataFlowTimeSourceApplication.class, args);
    }
}
