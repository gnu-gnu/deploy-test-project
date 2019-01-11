package com.gnu.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class DeployTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeployTestApplication.class, args);
	}
	
	@Bean
	public RouterFunction<ServerResponse> testRouter(){
		return route(GET("/echo/{name}"), request->ServerResponse.ok().body(Mono.just(request.pathVariable("name")), String.class))
				.andRoute(GET("/hello/{name}"), request->ServerResponse.ok().body(Mono.just("Hello, "+request.pathVariable("name")), String.class));
	}
}

