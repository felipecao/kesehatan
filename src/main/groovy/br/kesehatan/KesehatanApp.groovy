package br.kesehatan

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.orm.jpa.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
class KesehatanApp {

    public static void main(String[] args) {
        SpringApplication.run(KesehatanApp.class, args);
    }
}
