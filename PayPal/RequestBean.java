package com.xel.payment.paypal;

public class RequestBean {

	private String paymentMethod;
	private String cancelUrl;
	private String returnUrl;
	private String shipping;
	private String subtotal;
	private String tax;
	private String currency;
	private String total;
	private String description;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
