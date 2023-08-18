package project.client.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

	
	@Value("${Postgres.DATABASE_URL}")
    private String databaseUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
