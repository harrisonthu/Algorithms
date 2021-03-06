package module02;


//******************************************************************************
//
// File:    UC1.java
// Package: ---
// Unit:    Class UC1
//
// This Java source file is copyright (C) 2013 by Alan Kaminsky. All rights
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
 * Class UC1 is the main program for the URL Counter Version 1. It counts lines,
 * words, and bytes in the URLs given on the command line. It is a sequential
 * (single-threaded) program.
 * <P>
 * Usage: java UC1 <I>url</I> . . .
 *
 * @author  Alan Kaminsky
 * @version 13-Aug-2013
 */
public class UC1
	{

	/**
	 * Prevent construction.
	 */
	private UC1()
		{
		}

	/**
	 * Main program.
	 */
	public static void main
		(String[] args)
		throws Throwable
		{
		long stopwatch = -System.currentTimeMillis();

		for (String arg : args)
			{
			new URLCounterSeq (arg) .run();
			}

		stopwatch += System.currentTimeMillis();
		System.out.println (stopwatch + " msec");
		}

	}
