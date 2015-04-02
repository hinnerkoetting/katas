package de.oetting.katas.diamond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegrateDiamondIntoConsole {

	public static void main(String[] args) throws IOException {
		System.out.println("Input character: ");
		String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
		PrintableObject printableObject = new Diamond().create(line.charAt(0));
		System.out.println("Diamond:\n---");
		System.out.println(printableObject.createString());
	}
}
