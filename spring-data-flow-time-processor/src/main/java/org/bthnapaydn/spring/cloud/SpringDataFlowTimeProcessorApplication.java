package org.bthnapaydn.spring.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
@EnableBinding(Processor.class)
public class SpringDataFlowTimeProcessorApplication {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Transformer(inputChannel = Processor.INPUT,
            outputChannel = Processor.OUTPUT)
    public Object transform(Long timestamp) {
        LOG.info("Now processing data!!!");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:yy");
        return dateFormat.format(timestamp);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataFlowTimeProcessorApplication.class, args);
    }
}
