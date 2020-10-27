package springtemplate.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomerRestExceptionHandler {
	
	// Add an exception handler for CustomerNotFoundException
	
		@ExceptionHandler
		public ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exc) {
			
			// create PersonErrorResponse
			
			PersonErrorResponse error = new PersonErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												exc.getMessage(),
												System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		
		// Add another exception handler ... to catch any exception (catch all)

		@ExceptionHandler
		public ResponseEntity<PersonErrorResponse> handleException(Exception exc) {
			
			// create CustomerErrorResponse
			
			PersonErrorResponse error = new PersonErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

}
