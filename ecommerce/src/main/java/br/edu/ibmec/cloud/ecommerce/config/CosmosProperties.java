package br.edu.ibmec.cloud.ecommerce.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.cloud.azure.cosmos")
public class CosmosProperties {

    private String endpoint;
    private String key;
    private String database;
    private boolean queryMetricsEnabled;

}
