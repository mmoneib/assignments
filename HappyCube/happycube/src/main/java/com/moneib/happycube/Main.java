package com.moneib.happycube;

import java.io.PrintWriter;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.SimpleGenerator;
import com.moneib.happycube.generator.progressor.RandomProgressor;
import com.moneib.happycube.rule.FitRule;
import com.moneib.happycube.utility.DataModifier;

public class Main {

	public static void main(String[] args) {
		SimpleGenerator generator = new SimpleGenerator(new RandomProgressor(), FitRule.getInstance());
		PrintWriter outWriter = new PrintWriter(System.out);

		Cube blue = new Cube(DataModifier.getInstance().separateInput(Input.BLUE_INPUT));
		Cube red = new Cube(DataModifier.getInstance().separateInput(Input.RED_INPUT));
		Cube purple = new Cube(DataModifier.getInstance().separateInput(Input.PURPLE_INPUT));
		Cube yellow = new Cube(DataModifier.getInstance().separateInput(Input.YELLOW_INPUT));

		System.out.println("Generating solutions...");

		Cube newBlueCube = generator.generateCube(blue);
		newBlueCube.setName("Blue");
		Cube newRedCube = generator.generateCube(red);
		newRedCube.setName("Red");
		Cube newPurpleCube = generator.generateCube(purple);
		newPurpleCube.setName("Purple");
		Cube newYellowCube = generator.generateCube(yellow);
		newYellowCube.setName("Yellow");

		printOutput(newBlueCube, outWriter);
		printOutput(newRedCube, outWriter);
		printOutput(newPurpleCube, outWriter);
		printOutput(newYellowCube, outWriter);

		outWriter.close();
	}

	private static void printOutput(Cube solvedCube, PrintWriter outWriter) {
		System.out.println("\n" + solvedCube.getName() + "'s Solution:");
		solvedCube.print(outWriter);
	}

	private static final class Input {
		private static final char[][] BLUE_INPUT = {
				{ ' ', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', ' ' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', ' ' },
				{ ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', 'o', ' ', 'o', 'o' } };

		private static final char[][] RED_INPUT = {
				{ ' ', ' ', ' ', 'o', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', 'o', ' ', 'o' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', ' ', 'o', 'o', ' ', 'o', ' ', ' ', ' ', 'o', ' ', ' ', 'o', 'o' },
				{ ' ', ' ', 'o', ' ', ' ', ' ', ' ', 'o', 'o', ' ', ' ', 'o', 'o', ' ', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ' },
				{ ' ', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', ' ', 'o', 'o', ' ', 'o', 'o' } };

		private static final char[][] PURPLE_INPUT = {
				{ 'o', 'o', ' ', 'o', ' ', ' ', ' ', ' ', 'o', 'o', ' ', 'o', ' ', ' ', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ ' ', ' ', 'o', ' ', ' ', ' ', 'o', ' ', 'o', ' ', ' ', ' ', 'o', ' ', ' ' },
				{ 'o', 'o', ' ', 'o', 'o', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', 'o', ' ', 'o', 'o', ' ', 'o', ' ' } };

		private static final char[][] YELLOW_INPUT = {
				{ ' ', ' ', 'o', ' ', ' ', ' ', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ' },
				{ 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', ' ', ' ', 'o', ' ', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ' },
				{ 'o', ' ', 'o', ' ', ' ', 'o', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o', 'o' } };
	}
}
