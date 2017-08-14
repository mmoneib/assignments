package com.moneib.happycube.rule;

import com.moneib.happycube.entity.Piece;

public class FitRule extends Rule {
	private static final FitRule FIT_RULE = new FitRule();

	private FitRule() {
	}

	public FitRule getFitRule() {
		return FIT_RULE;
	}

	@Override
	public boolean check(Piece piece1, Piece piece2) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				piece2.rotateClockWise();
				
				if(isCompliment(piece1,piece2)){
					return true;
				}
			}
			piece1.rotateClockWise();
		}
		
		return false;
	}
	
	private boolean isCompliment(Piece piece1, Piece piece2){
		return false;
	}

}
