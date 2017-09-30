package com.moneib.ingenico.transfer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneib.ingenico.transfer.data.model.Transfer;
import com.moneib.ingenico.transfer.service.TransferService;

/**
 * The Class TransferController provides RESTful API for performing actions
 * inviolving money transfer.
 */
@RestController
@RequestMapping(path = "/transfers")
public class TransferController {

	/** The service layer for the Transfer entity. */
	@Autowired
	private TransferService service;

	/**
	 * Performs the money transfer from the source to the destination accounts.
	 *
	 * @param source
	 *            the source account
	 * @param destination
	 *            the destination account
	 * @param amount
	 *            the amount of money to be transferred in Euros
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/transfer")
	public ResponseEntity<Transfer> performTransfer(@RequestParam String source, @RequestParam String destination,
			@RequestParam String amount) {
		Transfer transfer = service.makeTransfer(source, destination, Double.valueOf(amount));

		HttpHeaders headers = new HttpHeaders();
		headers.add("TransactionID", String.valueOf(transfer.getId()));

		return new ResponseEntity<Transfer>(transfer, HttpStatus.OK);
	}
}
