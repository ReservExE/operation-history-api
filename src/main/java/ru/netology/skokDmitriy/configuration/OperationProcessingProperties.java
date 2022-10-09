package ru.netology.skokDmitriy.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "operation.processing")
@Component
public class OperationProcessingProperties {
    private int sleepMilliSeconds;
}
