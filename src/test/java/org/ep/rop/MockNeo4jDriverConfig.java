package org.ep.rop;

import org.neo4j.driver.Driver;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.mockito.Mockito;
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider;

@TestConfiguration
public class MockNeo4jDriverConfig {

    @Bean
    public Driver neo4jDriver() {
        return Mockito.mock(Driver.class);
    }

    @Bean
    public ReactiveDatabaseSelectionProvider reactiveDatabaseSelectionProvider() {
        return ReactiveDatabaseSelectionProvider.getDefaultSelectionProvider();
    }
}
