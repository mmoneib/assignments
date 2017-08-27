package com.moneib.happycube;

import java.io.PrintWriter;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.SimpleGenerator;
import com.moneib.happycube.generator.progressor.RandomProgressor;
import com.moneib.happycube.rule.FitRule;
import com.moneib.happycube.utility.DataModifier;

/**
 * The Class Main, providing the entry point of the application and the
 * initiator of all its logic.
 */
public class Main {

	/**
	 * The main method is the entry point of the application. No arguments are
	 * expected in this implementation.
	 *
	 * @param args
	 *            the arguments as provided by the user in the command line.
	 */
	public static void main(String[] args) {
		SimpleGenerator generator = new SimpleGenerator(new RandomProgressor(), FitRule.getInstance());

		Cube blue = new Cube(DataModifier.separateInput(Input.BLUE_INPUT));
		Cube red = new Cube(DataModifier.separateInput(Input.RED_INPUT));
		Cube purple = new Cube(DataModifier.separateInput(Input.PURPLE_INPUT));
		Cube yellow = new Cube(DataModifier.separateInput(Input.YELLOW_INPUT));

		System.out.println("Generating solutions...");

		Cube newBlueCube = generator.generateCube(blue);
		newBlueCube.setName("Blue");
		Cube newRedCube = generator.generateCube(red);
		newRedCube.setName("Red");
		Cube newPurpleCube = generator.generateCube(purple);
		newPurpleCube.setName("Purple");
		Cube newYellowCube = generator.generateCube(yellow);
		newYellowCube.setName("Yellow");

		printAllOutput(newBlueCube, newRedCube, newPurpleCube, newYellowCube);
	}

	/**
	 * Prints the output to the user as retrieved from the state of all the
	 * prossessed {@code Cube cubes}.
	 *
	 * @param cubes
	 *            the prossessed cubes.
	 */
	private static void printAllOutput(Cube... cubes) {
		PrintWriter outWriter = new PrintWriter(System.out);

		for (Cube cube : cubes) {
			printOutput(cube, outWriter);
		}

		outWriter.close();
	}

	/**
	 * Prints the output to the user as retrieved from the state of the
	 * prossessed {@code Cube cube}.
	 *
	 * @param solvedCube
	 *            the solved cube.
	 * @param outWriter
	 *            the output writer.
	 */
	private static void printOutput(Cube solvedCube, PrintWriter outWriter) {
		System.out.println("\n" + solvedCube.getName() + "'s Solution:");
		solvedCube.print(outWriter);
	}

	/**
	 * The Class Input provides the raw structure of 4 cubes.
	 */
	private static final class Input {

		/** The raw structure of the blue cube. */
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

		/** The raw structure of the red cube. */
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

		/** The raw structure of the purple cube. */
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

		/** The raw structure of the yellow cube. */
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
