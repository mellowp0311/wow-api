package com.wow.api.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "joongna")
public class JnDomainProperties {

    Map<String, String> domain = new HashMap<>();

    public String get(String apiId) {
        return domain.get(apiId);
    }

    Map<String, String> serviceUrl = new HashMap<>();

    public String getService(String serviceId) {
        return serviceUrl.get(serviceId);
    }
}
