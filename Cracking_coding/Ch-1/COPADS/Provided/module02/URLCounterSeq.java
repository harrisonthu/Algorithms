package module02;

//******************************************************************************
//
// File:    URLCounterSeq.java
// Package: ---
// Unit:    Class URLCounterSeq
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class URLCounterSeq provides an object that counts lines, words, and bytes in
 * the data obtained from a URL and prints the results; it is designed to be
 * used in a sequential (single-threaded) program.
 *
 * @author  Alan Kaminsky
 * @version 06-Sep-2013
 */
public class URLCounterSeq
	{

// Hidden data members.

	private String myArg;

// Exported constructors.

	/**
	 * Construct a new URL counter.
	 *
	 * @param  arg  Command line argument naming the URL from which to obtain
	 *              data.
	 */
	public URLCounterSeq
		(String arg)
		{
		myArg = arg;
		}

// Exported operations.

	/**
	 * Count lines, words, and bytes in the data stream obtained from this URL
	 * counter's URL. The results are printed on the standard output.
	 */
	public void run()
		{
		URLCounter counter = null;
		try
			{
			counter = new URLCounter (myArg);
			counter.count();
			System.out.print (counter.getLineCount());
			System.out.print ('\t');
			System.out.print (counter.getWordCount());
			System.out.print ('\t');
			System.out.print (counter.getByteCount());
			System.out.print ('\t');
			System.out.print (counter.getURL());
			System.out.println();
			}
		catch (MalformedURLException exc)
			{
			System.err.println ("\"" + myArg + "\": Malformed URL");
			}
		catch (IOException exc)
			{
			System.err.println (counter.getURL() + ": I/O error");
			}
		}

	}
