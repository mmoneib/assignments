package com.moneib.happycube.entity;

/**
 * The Class AbstractEntity provides the basics and common properties of an
 * entity.
 */
public abstract class AbstractEntity {

	/**
	 * The name of the entity. This is mainly used for presentation purposes.
	 */
	private String name;

	/**
	 * Gets the name of the entity.
	 *
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the entity.
	 *
	 * @param name
	 *            the new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
