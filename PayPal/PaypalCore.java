package com.xel.payment.paypal;

import java.util.HashMap;
import java.util.Map;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;



public class PaypalCore {
	
	private static Map<String, Payment> payments = new HashMap<>();
	// Replace with your application client ID and secret
	private static final String CLIENT_ID = "YOUR_CLIENT_ID";
	private static final String CLIENT_SECRET = "YOUR_SECRET";
	private static final String MODE = "sandbox";

	public APIContext getContext() {
		return new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
	}
	
	public void addNewPayment(String uniquePaymkentId, Payment payment) {
		payments.put(uniquePaymkentId, payment);
	}
	
	public Payment getPayment(String uniquePaymentId) {
		return payments.get(uniquePaymentId);
	}
	
	public void removePayment(String uniquePaymentId) {
		payments.remove(uniquePaymentId);
	}
}
