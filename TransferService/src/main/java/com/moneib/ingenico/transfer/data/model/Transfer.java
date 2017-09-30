package com.moneib.ingenico.transfer.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * The Class Transfer provides the model of an acount as represented in the
 * database.
 */
@Entity
public class Transfer {

	/** The id of the transaction. This is the primary key */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** The source account to be debited. */
	@OneToOne
	@JoinColumn(name = "sourceAccount_id")
	private Account sourceAccount;

	/** The destination account to be credited. */
	@OneToOne
	@JoinColumn(name = "destinationAccount_id")
	private Account destinationAccount;

	/** The amount of the transaction in Euros. */
	@Column(nullable=false)
	private double amount;

	/**
	 * Instantiates a new transaction without any information. This constructor
	 * is explicitely written just to limit external access and should not be
	 * used.
	 */
	@SuppressWarnings("unused")
	private Transfer() {
	}

	/**
	 * Instantiates a new transfer with all the parameters provided.
	 *
	 * @param sourceAccount
	 *            the source account to be debited
	 * @param destinationAccount
	 *            the destination account to be credited
	 * @param amount
	 *            the amount of the transaction in Euros
	 */
	public Transfer(Account sourceAccount, Account destinationAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the source account.
	 *
	 * @return the source account
	 */
	public Account getSourceAccount() {
		return sourceAccount;
	}

	/**
	 * Sets the source account.
	 *
	 * @param sourceAccount
	 *            the new source account
	 */
	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	/**
	 * Gets the destination account.
	 *
	 * @return the destination account
	 */
	public Account getDestinationAccount() {
		return destinationAccount;
	}

	/**
	 * Sets the destination account.
	 *
	 * @param destinationAccount
	 *            the new destination account
	 */
	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount
	 *            the new amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
