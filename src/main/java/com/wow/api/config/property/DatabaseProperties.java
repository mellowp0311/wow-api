package com.wow.api.config.property;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}