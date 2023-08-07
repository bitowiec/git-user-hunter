package com.empik.interview.app.counter;

//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
//import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

public class R2DBCConfig {
    @Value(value = "${spring.datasource.url}")
    private String reactivDBUrl;
//    @Bean
//    public ConnectionFactoryInitializer initDB(){
//        ConnectionFactoryInitializer init = new ConnectionFactoryInitializer();
//        ConnectionFactory connFactory = ConnectionFactories.get(reactivDBUrl);
//        init.setConnectionFactory(connFactory);
//        init.setDatabasePopulator(new ResourceDatabasePopulator());
//        return init;
//    }
}
