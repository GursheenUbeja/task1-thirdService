package com.example.third;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/third")
public class ThirdServiceController {

	@PostMapping("/contactName")
	public ResponseEntity<String> test(@RequestBody String req) {
		String result = "";
		try {
			JSONObject jObject = new JSONObject(req);
			result = (String) jObject.get("name") +  " " + (String) jObject.get("lastName") ;
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		} catch (JSONException e) {
			
			return new ResponseEntity<>("Problem with the service", HttpStatus.BAD_REQUEST);
		}
			
	}

}
