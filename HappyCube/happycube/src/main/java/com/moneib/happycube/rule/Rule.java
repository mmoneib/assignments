package com.moneib.happycube.rule;

import com.moneib.happycube.entity.Piece;

public abstract class Rule {
	public abstract boolean check(Piece piece1, Piece piece2);
}
