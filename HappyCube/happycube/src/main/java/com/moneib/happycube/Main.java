package com.moneib.happycube;

import java.io.PrintWriter;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.SimpleGenerator;
import com.moneib.happycube.generator.progressor.RandomProgressor;
import com.moneib.happycube.rule.FitRule;
import com.moneib.happycube.utility.DataModifier;

public class Main {

	public static void main(String[] args) {
		char[][] inputPieces = { { ' ', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', ' ' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', ' ' },
				{ ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', 'o', ' ', 'o', 'o' } };

		Cube cube = new Cube(DataModifier.getInstance().separateInput(inputPieces));

		SimpleGenerator generator = new SimpleGenerator(new RandomProgressor(), FitRule.getFitRule());

		Cube newCube = generator.generateCube(cube);

		System.out.println(FitRule.getFitRule().check(newCube));
		newCube.print(new PrintWriter(System.out));
	}

}
