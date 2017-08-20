package com.moneib.happycube.rule;

import com.moneib.happycube.entity.Cube;

public class FitRule extends Rule {
	private static final FitRule FIT_RULE = new FitRule();

	private FitRule() {
	}

	public FitRule getFitRule() {
		return FIT_RULE;
	}

	@Override
	public boolean check(Cube cube) {
		// TODO Auto-generated method stub
		return false;
	}

}
