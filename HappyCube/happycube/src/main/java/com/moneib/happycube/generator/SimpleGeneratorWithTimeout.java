package com.moneib.happycube.generator;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.NullCube;
import com.moneib.happycube.generator.progressor.AbstractProgressor;
import com.moneib.happycube.rule.AbstractRule;

/**
 * The Class SimpleGeneratorWithTimeout extends the {@link SimpleGenerator}
 * mechanism with a timeout fall back strategy in case no solution is found.
 */
public class SimpleGeneratorWithTimeout extends SimpleGenerator {

	/** The timeout before a generation fails. */
	private long timeout;

	/** The time unit of the timeout. */
	private TimeUnit timeUnit;

	/**
	 * Instantiates a new simple generator of a {@link Cube} in accordance with
	 * a specific {@link AbstractRule} and through a specific {@link AbstractProgressor} with a
	 * timeout fall back strategy.
	 *
	 * @param progressor
	 *            the progressor which defines the cube's next state.
	 * @param rule
	 *            the rule which checks if the current state of the cube is
	 *            satisfactory in accordance to the rule specified.
	 * @param timeout
	 *            the timeout before a generation fails.
	 * @param timeUnit
	 *            the time unit of the timeout.
	 */
	public SimpleGeneratorWithTimeout(AbstractProgressor progressor, AbstractRule rule, long timeout, TimeUnit timeUnit) {
		super(progressor, rule);
		this.timeout = timeout;
		this.timeUnit = timeUnit;
	}

	/**
	 * Tries to generate a specific cube out of an input cube representation
	 * during a time period specified by {@link #timeout} and {@link timeUnit}
	 * using the {@link AbstractProgressor} to change the state of the cube, and the
	 * {@link AbstractRule} to check if the current states is satifactory as a solution.
	 * <br>
	 * <br>
	 * This implimentation creates a new thread in which the job of cube
	 * generation is done by calling
	 * {@link SimpleGenerator#generateSimply(Cube)}. The threads execution is
	 * cut short if the timeout is reached.
	 * 
	 * @return the solution out of the specific cube generation mechanism as
	 *         defined by the progressor, or a {@code NullCube} object loaded
	 *         with an error message in case no solution is found.
	 */
	@Override
	public Cube generateCube(final Cube cube) {
		final SimpleGenerator simpleGenerator = this;
		FutureTask<Cube> task = new FutureTask<Cube>(new Callable<Cube>() {

			@Override
			public Cube call() throws Exception {
				return simpleGenerator.generateSimply(cube);
			}

		});
		try {
			Executors.newSingleThreadExecutor().execute(task);
			return task.get(timeout, timeUnit);
		} catch (TimeoutException e) {
			return new NullCube("Failure: Timeout exceeded without finding a solution.");
		} catch (InterruptedException | ExecutionException e) {
			return new NullCube("Failure: " + e.getLocalizedMessage());
		}

	}

	/**
	 * Gets the specified {@link #timeout} as a number. This should be used in
	 * combination with {@code #timeUnit}.
	 *
	 * @return the timeout
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * Sets the {@link #timeout} to a new duration. This should be used in
	 * combination with {@code #timeUnit}.
	 *
	 * @param timeout
	 *            the new timeout
	 */
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	/**
	 * Gets the specified time unit. This should be used in combination with
	 * {@code #timeout}.
	 *
	 * @return the time unit
	 */
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	/**
	 * Sets the time unit. This should be used in combination with
	 * {@code #timeout}.
	 *
	 * @param timeUnit
	 *            the new time unit
	 */
	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

}
