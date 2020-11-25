package eu.macphail.kloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KloaderApplication {

	@Autowired
	KafkaLauncher launcher;

	public static void main(String[] args) {
		SpringApplication.run(KloaderApplication.class, args);
	}

}
