package com.moneib.happycube.entity;

import java.io.PrintWriter;

import com.moneib.happycube.utility.Nullified;
import com.moneib.happycube.utility.Printable;

public class NullCube extends Cube implements Printable, Nullified {
	private String error;

	public NullCube(String error) {
		this.error = error;
	}

	@Override
	public void print(PrintWriter writer) {
		writer.println(error);
	}

	@Override
	public String getError() {
		return error;
	}

	@Override
	public void setError(String error) {
		this.error = error;

	}
}
