package com.springcamel.demo;

import org.springframework.boot.SpringApplication;

import javax.jms.JMSException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springcamel4Application {

	public static void main(String[] args) {
		SpringApplication.run(Springcamel4Application.class, args);
	}
	
	@Bean
	public JmsComponent jmsComponent() throws JMSException
	{
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
		cf.setBrokerURL("tcp://localhost:61616");
		cf.setUser("admin");
		cf.setPassword("admin");
		
		JmsComponent jms = new JmsComponent();
		jms.setConnectionFactory(cf);
		return jms;
	}

}
