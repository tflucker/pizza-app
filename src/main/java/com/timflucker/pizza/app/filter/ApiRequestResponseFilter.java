package com.timflucker.pizza.app.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet Filter which captures API request and response information. Used for
 * troubleshooting and error resolution.
 * 
 * @author Tim Flucker
 *
 */
@Component
@Slf4j
public class ApiRequestResponseFilter implements Filter {

	/**
	 * Method invoked after API request is sent but before actual API logic
	 * initiates. Logs API request information, then performs logic, then logs API
	 * response information.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String reqHeaders = Collections.list(req.getHeaderNames()).stream()
				.map(headerName -> headerName + " : " + Collections.list(req.getHeaders(headerName)))
				.collect(Collectors.joining(", "));
		String reqBody = "TBD";

		log.info("Request {} : {}", req.getMethod(), req.getRequestURI());
		log.info("Request Headers: {}", reqHeaders);
		log.info("Request Body: {}", reqBody);
		chain.doFilter(request, response);

		log.info("Response Info - {} : {}", res.getStatus(), res.getContentType());

	}

}
