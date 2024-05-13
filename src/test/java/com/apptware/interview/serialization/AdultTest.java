package com.apptware.interview.serialization;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * This test class has a validation for {@link com.apptware.interview.serialization.Adult}. The
 * first test tests the validation using a constructor by creating an illegal entity and expecting
 * an error message for the same. The second test has a same purpose using serialization.
 *
 * <p>The candidate is expected to modify the test case and the corresponding class for which the
 * test case is written so that the appropriate exception is thrown with appropriate messages.
 */
class AdultTest {

  @Test
  void testConstructorValidation() {
	    // Testing constructor validation
	    assertThrows(IllegalArgumentException.class, () -> new Adult("", "", 18),
	        "Firstname or Lastname CANNOT be blank.");

	    assertThrows(IllegalArgumentException.class, () -> new Adult("Firstname", "Lastname", 17),
	        "Inappropriate Age for an Adult.");

	    String json1 ="{\"firstName\":\" \",\"lastName\":\" \",\"age\":18}";
	       
	    String json2 ="{\"firstName\":\"Firstname\",\"lastName\":\"Lastname\",\"age\":17}";
	     

	    ObjectMapper objectMapper = new ObjectMapper();

	    // Testing JSON deserialization
	    assertThrows(JsonProcessingException.class, () -> objectMapper.readValue(json1, Adult.class),
	        "Firstname or Lastname CANNOT be blank.");

	    assertThrows(JsonProcessingException.class, () -> objectMapper.readValue(json2, Adult.class),
	        "Inappropriate Age for an Adult.");
	  }
}
