package com.spring.angular.xfs;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/myservice")
public class XfsController {  
	
	private final XfsRepository xfsRepository; 
	
	public XfsController(XfsRepository xfsRepository ) {
		this.xfsRepository=xfsRepository;
	}

	@RequestMapping(
		    value = "/postKSR", 
		    method = RequestMethod.POST)
		public void alert(@RequestBody Map<String, Object> payload,
				@ModelAttribute("xfs") @Valid Xfs xfs,BindingResult result, Model model ) 
		    throws Exception {

		  System.out.println(payload);
		  xfsRepository.save(xfs);
    }
	
	  @GetMapping(value = "/hello")
	   public String hello() {
	      return "Hello World";
}
}