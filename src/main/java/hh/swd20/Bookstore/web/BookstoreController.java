package hh.swd20.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookstoreController {
	
	@RequestMapping("/index")
	public String index() {
		return "Welcome to the bookstore.";
	}

}
