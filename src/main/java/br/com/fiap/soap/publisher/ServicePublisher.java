package br.com.fiap.soap.publisher;

import br.com.fiap.soap.config.FlywayConfig;
import br.com.fiap.soap.repository.ConvocationRepository;
import br.com.fiap.soap.repository.PlayerRepository;
import br.com.fiap.soap.service.ConvocationService;

import javax.xml.ws.Endpoint;

public class ServicePublisher {
    public static void main(String[] args) {

        FlywayConfig.migrate();

        PlayerRepository playerRepository = new PlayerRepository();
        ConvocationRepository convocationRepository = new ConvocationRepository();

        ConvocationService service =
                new ConvocationService(playerRepository, convocationRepository);

        Endpoint.publish("http://localhost:8080/convocation", service);

        System.out.println("Service running at:");
        System.out.println("http://localhost:8080/convocation?wsdl");
    }
}