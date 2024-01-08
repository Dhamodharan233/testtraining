package com.CVJ.demo.Security.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
/*Logger interface is the main user entry point of SLF4J API.It is expected that logging
takes place through concrete implementations of this interface*/
/*getLogger-Return a logger named corresponding to the class passed as parameter,using 
the statically bound ILoggerFactory instance. */
/*Most users retrieve Logger instances through the static LoggerFactory.getLogger(String)
method. An instance of this interface is bound internally with LoggerFactory class at 
compile time. */
	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	  @Override
	  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	      throws IOException, ServletException {
		  logger.error("Unauthorized error: {}", authException.getMessage());

		  response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		  response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
/*Extends the ServletResponse interface to provide HTTP-specific functionality in sending
a response.For example,it has methods to access HTTP headers and cookies. 

The servlet container creates an HttpServletResponse object and passes it as an argument 
to theservlet's service methods (doGet, doPost, etc).*/


		  final Map<String, Object> body = new HashMap<>();
		  body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
		  body.put("error", "Unauthorized");
		  body.put("message", authException.getMessage());
		  body.put("path", request.getServletPath());

		  final ObjectMapper mapper = new ObjectMapper();
		  mapper.writeValue(response.getOutputStream(), body);
	  }

}
