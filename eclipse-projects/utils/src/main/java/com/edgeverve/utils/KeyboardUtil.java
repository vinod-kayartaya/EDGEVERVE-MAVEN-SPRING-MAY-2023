package com.edgeverve.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("resource")
public final class KeyboardUtil {

	private KeyboardUtil() {
	}

	public static String getString(String message) {
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static int getInt(String message) {
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static double getDouble(String message) {
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
	
	public static Date getDate(String message) {
		System.out.printf("%s (dd/mm/yyyy format): ", message);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		try {
			return sdf.parse(input);
		} catch (ParseException e) {
			return null;
		}
	}
}
