package br.edu.ibmec.cloud.ecommerce.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

@Configuration
@EnableConfigurationProperties(CosmosProperties.class)
@EnableCosmosRepositories(basePackages = "br.edu.ibmec.cloud.ecommerce.repository")
@PropertySource("classpath:application.properties")
public class CosmosConfiguration extends AbstractCosmosConfiguration {
    private CosmosProperties properties;
    
    CosmosConfiguration(CosmosProperties properties) {
        this.properties = properties;
    }

    @Override
    protected String getDatabaseName() {
        return this.properties.getDatabase();
    }

    @Bean
    public CosmosClientBuilder cosmosBuildClient() {
        return new CosmosClientBuilder()
                   .endpoint(this.properties.getEndpoint()) 
                   .key(this.properties.getKey())
                   .directMode(DirectConnectionConfig.getDefaultConfig());

    }

    @Override
    @Bean
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
                           .enableQueryMetrics(properties.isQueryMetricsEnabled())
                           .build();
    }
}