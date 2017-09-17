package module02;

//******************************************************************************
//
// File:    UpDown2.java
// Package: ---
// Unit:    Class UpDown2
//
// This Java source file is copyright (C) 2014 by Alan Kaminsky. All rights
// reserved. For further information, contact the author, Alan Kaminsky, at
// ark@cs.rit.edu.
//
// This Java source file is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by the Free
// Software Foundation; either version 3 of the License, or (at your option) any
// later version.
//
// This Java source file is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
// FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You may obtain a copy of the GNU General Public License on the World Wide Web
// at http://www.gnu.org/licenses/gpl.html.
//
//******************************************************************************

/**
 * Class UpDown2 is the main program for the Up-Down Demo Version 2. Two threads
 * share an integer variable. One thread increases the variable <I>N</I> times,
 * the other thread decreases the variable <I>N</I> times, and the program
 * prints the final value. The threads are synchronized with a monitor.
 * <P>
 * Usage: java UpDown2 <I>N</I>
 *
 * @author  Alan Kaminsky
 * @version 04-Sep-2014
 */
public class UpDown2
	{

	/**
	 * Prevent construction.
	 */
	private UpDown2()
		{
		}

	/**
	 * A monitor class providing a shared integer.
	 */
	private static class SharedInteger
		{
		private int value;

		public synchronized void up()
			{
			++ value;
			}

		public synchronized void down()
			{
			-- value;
			}

		public synchronized int value()
			{
			return value;
			}
		}

	/**
	 * A runnable object that increases a shared integer N times.
	 */
	private static class Upper
		implements Runnable
		{
		private SharedInteger shared;
		private int N;

		public Upper
			(SharedInteger shared,
			 int N)
			{
			this.shared = shared;
			this.N = N;
			}

		public void run()
			{
			for (int i = 0; i < N; ++ i)
				{
				shared.up();
				}
			}
		}

	/**
	 * A runnable object that decreases a shared integer N times.
	 */
	private static class Downer
		implements Runnable
		{
		private SharedInteger shared;
		private int N;

		public Downer
			(SharedInteger shared,
			 int N)
			{
			this.shared = shared;
			this.N = N;
			}

		public void run()
			{
			for (int i = 0; i < N; ++ i)
				{
				shared.down();
				}
			}
		}

	/**
	 * Main program.
	 */
	public static void main
		(String[] args)
		throws Throwable
		{
		// Parse command line arguments.
		if (args.length != 1) usage();
		int N = Integer.parseInt (args[0]);

		// Create shared integer object.
		SharedInteger shared = new SharedInteger();

		// Create upper and downer threads, run them, and wait for them to
		// finish.
		Thread upper = new Thread (new Upper (shared, N));
		Thread downer = new Thread (new Downer (shared, N));
		upper.start();
		downer.start();
		upper.join();
		downer.join();

		// Print final value of shared integer.
		System.out.println (shared.value());
		}

	/**
	 * Print a usage message and exit.
	 */
	private static void usage()
		{
		System.err.println ("Usage: java UpDown2 <N>");
		System.exit (1);
		}

	}
