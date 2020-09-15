package com.wow.api.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "secure-config")
public class JnSecureConfigProperties {

    List<String> allowedDeeplinkDomains = new ArrayList<>();
}
