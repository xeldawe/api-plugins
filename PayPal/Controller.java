package com.xel.payment.paypal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping
@Async("rest")
@Scope(value = WebApplicationContext.SCOPE_REQUEST,  proxyMode = ScopedProxyMode.NO)
@CrossOrigin(origins = { "http://localhost:4200", "https://xeldawe.com/api/", "https://xeldawe.com" })
public class Controller {

	private PaymentWithPayPal pwp = new PaymentWithPayPal();
	
	@PostMapping({ "/pay1*" })
	private String getPost(HttpServletRequest request, HttpServletResponse response, @RequestBody RequestBean rb) {
		JSONObject obj = new JSONObject();
		obj.put("link", pwp.create(rb));
		System.out.println(obj.toString());
		return obj.toString();

	}
	
	@GetMapping({ "/process*" })
	private String getPost(HttpServletRequest request, HttpServletResponse response) {
		try {
		String paymentId = request.getParameter("paymentId");
		String payerID = request.getParameter("PayerID");
	    pwp.execute(paymentId, payerID);
	    return "OK";
		}catch (Exception e) {
			return "Sup :D";
		}
	    
	}
	
}
