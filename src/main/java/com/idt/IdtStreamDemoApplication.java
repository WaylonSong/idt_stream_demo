package com.idt;

import com.idt.channel.Consumer;
import com.idt.channel.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IdtStreamDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(IdtStreamDemoApplication.class, args);
	}
}
