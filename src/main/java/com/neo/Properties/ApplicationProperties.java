package com.neo.Properties;

import com.neo.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix="commonproperties")
public class ApplicationProperties {
    private String schemaCrm;
    private Map<String,String> modelMap;
}
