package utez.edu.mx.gmuback.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConnection {
    @Value("${db.name}")
    public String name;

    @Value("${db.host}")
    public String host;

    @Value("${db.port}")
    public String port;

    @Value("${db.pass}")
    public String pass;

    @Value("${db.user}")
    public String user;


    @Bean
    public DataSource getConneccion(){
        DriverManagerDataSource src = new DriverManagerDataSource();
        src.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //jdbc:mysql://localhost:3306/adj-demo
        src.setUrl(String.format("jdbc:mysql://%s:%s/%s", host, port,name));
        src.setPassword(pass);
        src.setUsername(user);

        return src;
    }
}
