/**
 * @file : ExtractCountries.java
 * @author    : Bernard Che Longho (blongho)
 * @since    : 2019-02-19
 * @brief : Extract countries from a json file This class has one public static method that reads the contents of a
 * 	json file into a string. This then can be used to parse the content using any third party JSon library to create
 * 	the
 * 	objects.
 */

package com.blongho.countryFlags.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @Deprecated
 *
 * ExtractCountries was initially created inorder to read the countries from the internet but a change of mind result
 * makes this class obsolete. Internet can be unstable and this might affect the user experience. Therefore the
 * countries are added as assets and downloaded only once when the project is built
 */
public class ExtractCountries {

	public static String readContent(final String path) {
		BufferedReader bufferedReader = null;
		StringBuffer   buffer         = null;
		try {
			URL url = new URL(path);
			bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
			int read;
			buffer = new StringBuffer();
			char[] chars = new char[1024];
			while ((read = bufferedReader.read(chars)) != -1) buffer.append(chars, 0, read);

			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		return buffer.toString();
	}
}