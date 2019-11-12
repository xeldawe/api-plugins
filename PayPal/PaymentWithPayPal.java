// #Create Payment Using PayPal Sample
// This sample code demonstrates how you can process a 
// PayPal Account based Payment.
// API used: /v1/payments/payment
package com.xel.payment.paypal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Authorization;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentWithPayPal {

	// This is simple API call which will capture a specified amount for any given
	// Payer or User
	public String create(RequestBean rb) {
		PaypalCore pc = new PaypalCore();
		/*
		 * Flow would look like this: 1. Create Payer object and set PaymentMethod 2.
		 * Set RedirectUrls and set cancelURL and returnURL 3. Set Details and Add
		 * PaymentDetails 4. Set Amount 5. Set Transaction 6. Add Payment Details and
		 * set Intent to "authorize" 7. Create APIContext by passing the clientID,
		 * secret and mode 8. Create Payment object and get paymentID 9. Set payerID to
		 * PaymentExecution object 10. Execute Payment and get Authorization
		 * 
		 */

		Payer payer = new Payer();
		payer.setPaymentMethod(rb.getPaymentMethod());

		// Redirect URLs
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(rb.getCancelUrl());
		redirectUrls.setReturnUrl(rb.getReturnUrl());

		// Set Payment Details Object
		Details details = new Details();
		details.setShipping(rb.getShipping());
		details.setSubtotal(rb.getSubtotal());
		details.setTax(rb.getTax());

		// Set Payment amount
		Amount amount = new Amount();
		amount.setCurrency(rb.getCurrency());
		amount.setTotal(rb.getTotal());
		amount.setDetails(details);

		// Set Transaction information
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription(rb.getDescription());
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// Add Payment details
		Payment payment = new Payment();

		// Set Payment intent to authorize
		payment.setIntent("authorize");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		payment.setRedirectUrls(redirectUrls);

		// Pass the clientID, secret and mode. The easiest, and most widely used option.
		APIContext apiContext = pc.getContext();

		try {

			Payment myPayment = payment.create(apiContext);
			System.out.println(myPayment.getLinks());
			Iterator links = myPayment.getLinks().iterator();
			String linkStr = null;
			while (links.hasNext()) {
				Links link = (Links) links.next();
				if (link.getRel().equalsIgnoreCase("approval_url")) {
					linkStr = link.getHref();
				}
			}
			System.out.println("createdPayment Obejct Details ==> " + myPayment.toString());

			// Identifier of the payment resource created
			payment.setId(myPayment.getId());
			pc.addNewPayment(myPayment.getId(), payment);
			return linkStr;
			//////////////////////

		} catch (PayPalRESTException e) {

			// The "standard" error output stream. This stream is already open and ready to
			// accept output data.
			System.err.println(e.getDetails());
			return null;
		}
	}

	public void execute(String uniquePaymentId, String playerId) {
		PaypalCore pc = new PaypalCore();
		PaymentExecution paymentExecution = new PaymentExecution();
		// Set your PayerID. The ID of the Payer, passed in the `return_url` by PayPal.
		paymentExecution.setPayerId(playerId);

		// This call will fail as user has to access Payment on UI. Programmatically
		// there is no way you can get Payer's consent.
		Payment payment = pc.getPayment(uniquePaymentId);
		Payment createdAuthPayment = null;
		try {
			createdAuthPayment = payment.execute(pc.getContext(), paymentExecution);
			// Transactional details including the amount and item details.
			Authorization authorization = createdAuthPayment.getTransactions().get(0).getRelatedResources().get(0)
					.getAuthorization();

			log("Here is your Authorization ID" + authorization.getId());
			pc.removePayment(uniquePaymentId);
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void log(String string) {
		System.out.println(string);

	}

}