/**
 * 
 */
package com.infrrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infrrd.model.Input;
import com.infrrd.model.Output;
import com.infrrd.service.IRegexService;

/**
 * @author Harshith Gowda B T
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class RegexController {

	@Autowired
	IRegexService regexservice;

	@PostMapping("/")
	public ResponseEntity<Output> validateandExtractRegex(@RequestBody Input input) {
		try {
			return new ResponseEntity<Output>(regexservice.validateandExtractRegex(input), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Output>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
