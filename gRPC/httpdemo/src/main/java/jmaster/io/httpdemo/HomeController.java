package jmaster.io.httpdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/http1")
	public String http1() {
		return "http1";
	}

	@GetMapping("/http2")
	public String http2() {
		return "http2";
	}
}
