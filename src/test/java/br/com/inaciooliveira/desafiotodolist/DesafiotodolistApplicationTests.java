package br.com.inaciooliveira.desafiotodolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import br.com.inaciooliveira.desafiotodolist.entity.Todo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafiotodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("test 1", "task on test 1", false, 1) ;
		
		webTestClient
			.post()
			.uri("/todo")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isCreated()
			.expectBody()
			//.jsonPath("$").isArray()
			//.jsonPath("$.lenght()").isEqualTo(1)
			.jsonPath("$.name").isEqualTo(todo.getName())
			.jsonPath("$.description").isEqualTo(todo.getDescription())
			.jsonPath("$.isdone").isEqualTo(todo.getIsdone())
			.jsonPath("$.priority").isEqualTo(todo.getPriority());			
	}

	@Test
	void testCreateTodoFailure() {

	webTestClient
		.post()
			.uri("/todo")
			.bodyValue(
				new Todo("", "qqq", false, 2)
			)
			.exchange()
			.expectStatus().is5xxServerError();
			//.expectBody()
			//.jsonPath("$").isArray()
			//.jsonPath("$.lenght()").isEqualTo(1)
			// .jsonPath("$.name").isEqualTo(todo.getName())
			// .jsonPath("$.description").isEqualTo(todo.getDescription())
			// .jsonPath("$.isdone").isEqualTo(todo.getIsdone())
			// .jsonPath("$.priority").isEqualTo(todo.getPriority());
	}

}
