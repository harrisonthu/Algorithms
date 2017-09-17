package module02;

//******************************************************************************
//
// File:    URLCounter.java
// Package: ---
// Unit:    Class URLCounter
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
import java.io.InputStream;
import java.net.URL;
import java.net.MalformedURLException;

/**
 * Class URLCounter provides an object that counts lines, words, and bytes in
 * the data obtained from a URL. The number of lines equals the number of
 * linefeed bytes (<TT>'\n'</TT>). A word is a sequence of consecutive
 * non-whitespace bytes. A non-whitespace byte is any byte in the range
 * <TT>'!'</TT> through <TT>'~'</TT> (0x21 through 0x7e).
 * <P>
 * <I>Note:</I> Class URLCounter is designed to work with ASCII-encoded text
 * files and will not work in general with other character encodings.
 *
 * @author  Alan Kaminsky
 * @version 06-Sep-2013
 */
public class URLCounter
	{

// Hidden data members.

	private URL myURL;
	private long myLineCount;
	private long myWordCount;
	private long myByteCount;

// Exported constructors.

	/**
	 * Construct a new URL counter. The counts are initially cleared.
	 *
	 * @param  theURL  URL from which to obtain data. The URL is automatically
	 *                 prepended with <TT>"http://"</TT>.
	 *
	 * @exception  NullPointerException
	 *     (unchecked exception) Thrown if <TT>theURL</TT> is null.
	 * @exception  MalformedURLException
	 *     Thrown if <TT>theURL</TT> is not a valid URL.
	 */
	public URLCounter
		(String theURL)
		throws MalformedURLException
		{
		myURL = new URL ("http://" + theURL);
		}

// Exported operations.

	/**
	 * Clear this URL counter's counts.
	 */
	public void clear()
		{
		myLineCount = 0L;
		myWordCount = 0L;
		myByteCount = 0L;
		}

	/**
	 * Obtain this URL counter's URL.
	 *
	 * @return  URL from which data will be obtained.
	 */
	public URL getURL()
		{
		return myURL;
		}

	/**
	 * Count lines, words, and bytes in the data stream obtained from this URL
	 * counter's URL. The results are obtained by calling the
	 * <TT>getLineCount()</TT>, <TT>getWordCount()</TT>, and
	 * <TT>getCharCount()</TT> methods.
	 *
	 * @exception  IOException
	 *     Thrown if an I/O error occurred.
	 */
	public void count()
		throws IOException
		{
		// Open a data stream from the URL.
		InputStream stream = myURL.openStream();

		// Initialize counters.
		clear();
		boolean inaword = false;

		// Read data and update counters.
		int b;
		while ((b = stream.read()) != -1)
			{
			++ myByteCount;
			if (b == '\n') ++ myLineCount;
			if (0x21 <= b && b <= 0x7e) // Non-whitespace
				{
				if (! inaword) ++ myWordCount;
				inaword = true;
				}
			else // Whitespace
				{
				inaword = false;
				}
			}

		// Close data stream.
		stream.close();
		}

	/**
	 * Obtain the number of lines found by the last call of <TT>count()</TT>.
	 *
	 * @return  Line count.
	 */
	public long getLineCount()
		{
		return myLineCount;
		}

	/**
	 * Obtain the number of words found by the last call of <TT>count()</TT>.
	 *
	 * @return  Word count.
	 */
	public long getWordCount()
		{
		return myWordCount;
		}

	/**
	 * Obtain the number of bytes found by the last call of <TT>count()</TT>.
	 *
	 * @return  Byte count.
	 */
	public long getByteCount()
		{
		return myByteCount;
		}

	}
