package com.moneib.happycube.rule;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.utility.DataModifier;

public class FitRule extends Rule {
	private static final FitRule FIT_RULE = new FitRule();

	private FitRule() {
	}

	public static FitRule getFitRule() {
		return FIT_RULE;
	}

	@Override
	public boolean check(Cube cube) {
		return checkCorners(cube) && checkEdges(cube);
	}

	private boolean checkCorners(Cube cube) {

		return checkCorner(cube.getFace1().getSouth()[0], cube.getFace2().getNorth()[0], cube.getFace5().getEast()[0])
				&& checkCorner(cube.getFace1().getSouth()[4], cube.getFace2().getNorth()[4],
						cube.getFace6().getWest()[0])
				&& checkCorner(cube.getFace2().getSouth()[0], cube.getFace3().getNorth()[0],
						cube.getFace5().getEast()[4])
				&& checkCorner(cube.getFace2().getSouth()[4], cube.getFace3().getNorth()[4],
						cube.getFace6().getWest()[4])
				&& checkCorner(cube.getFace3().getSouth()[0], cube.getFace4().getNorth()[0],
						cube.getFace5().getWest()[4])
				&& checkCorner(cube.getFace3().getSouth()[4], cube.getFace4().getNorth()[4],
						cube.getFace6().getEast()[4])
				&& checkCorner(cube.getFace4().getSouth()[0], cube.getFace1().getNorth()[0],
						cube.getFace5().getWest()[0])
				&& checkCorner(cube.getFace4().getSouth()[4], cube.getFace1().getNorth()[4],
						cube.getFace6().getEast()[0]);
	}

	private boolean checkEdges(Cube cube) {
		return checkEdge(cube.getFace1().getSouth(), cube.getFace2().getNorth())
				&& checkEdge(cube.getFace2().getSouth(), cube.getFace3().getNorth())
				&& checkEdge(cube.getFace3().getSouth(), cube.getFace4().getNorth())
				&& checkEdge(cube.getFace4().getSouth(), cube.getFace1().getNorth())
				&& checkEdge(cube.getFace1().getWest(), cube.getFace5().getNorth())
				&& checkEdge(cube.getFace1().getEast(),
						DataModifier.getInstance().reverseEdge(cube.getFace6().getNorth()))
				&& checkEdge(cube.getFace2().getWest(), cube.getFace5().getEast())
				&& checkEdge(cube.getFace2().getEast(), cube.getFace6().getWest())
				&& checkEdge(cube.getFace3().getWest(),
						DataModifier.getInstance().reverseEdge(cube.getFace5().getSouth()))
				&& checkEdge(cube.getFace3().getEast(), cube.getFace6().getSouth())
				&& checkEdge(cube.getFace4().getWest(),
						DataModifier.getInstance().reverseEdge(cube.getFace5().getWest()))
				&& checkEdge(cube.getFace4().getEast(),
						DataModifier.getInstance().reverseEdge(cube.getFace6().getEast()));
	}

	private boolean checkCorner(char c1, char c2, char c3) {
		int count = 0;

		if (c1 == 'o')
			count++;
		if (c2 == 'o')
			count++;
		if (c3 == 'o')
			count++;

		return count == 1 ? true : false;
	}

	private boolean checkEdge(char[] e1, char[] e2) {

		for (int i = 1; i < e1.length - 1; i++)
			if (e1[i] == e2[i])
				return false;

		return true;
	}
}
