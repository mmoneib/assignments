package com.moneib.ingenico.transfer.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The Class Account provides the model of an acount as represented in the
 * database.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class Account {

	/** The id of the account. This is the primary key */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** The name of the account. */
	@Column(nullable = false)
	private String name;

	/** The balance currenlty in the account in Euros. */
	@Column(nullable = false)
	private double balance;

	/**
	 * Instantiates a new account without any information. This constructor is
	 * explicitely written just to limit external access and should not be used.
	 */
	@SuppressWarnings("unused")
	private Account() {
	}

	/**
	 * Instantiates a new account with all the paramters provided.
	 *
	 * @param name
	 *            the name of the account
	 * @param balance
	 *            the balance by ehich the account is initialized
	 */
	public Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance
	 *            the new balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Compares the current Account object to another one. It returns true if
	 * all attributes are equal.
	 *
	 * @param obj
	 *            the compared Account object
	 */
	@Override
	public boolean equals(Object obj) {
		Account comparedAccount = (Account) obj;

		if (this.id == comparedAccount.getId() && this.balance == comparedAccount.getBalance()
				&& this.name.equals(comparedAccount.getName())) {
			return true;
		}
		return false;
	}

}
