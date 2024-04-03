package com.reverseStringAssignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseStringAssignment {

	public static void main(String str[]) {

		String inputFile = "src/main/resources/generated_file.txt";
		String outputFile = "src/main/resources/stringReversalFile.txt";

		writeStringMoreThanRam(inputFile);  //Method to create a file of string which is more using for loop

		reverseStringAndWriteFile(inputFile, outputFile); //method is used to write the above files string in reverse order in output file

	}

	private static void reverseStringAndWriteFile(String inputFile, String outputFile) {

		try {

			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferReader = new BufferedReader(fileReader);

			FileWriter fileWriter = new FileWriter(outputFile);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

			long startTime = System.currentTimeMillis();

			StringBuilder stringReader = new StringBuilder();
			String line;
			String reverseString = "";
			char ch;
			long endTime = 0L;
			while ((line = bufferReader.readLine()) != null) {

				if (line.trim().isEmpty()) {
					System.out.println("Can't reverse it and write as file is empty");
				} else {

					stringReader.append(line);

//					for (int i = 0; i < line.length(); i++) {
//						ch = line.charAt(i);
//						reverseString = ch + reverseString;
//
//					}
//					
					// Commented above as it was taking a lot time to reverse the string due to that
					// used stringbuilder in built methof

				}

			}

			bufferReader.close();
			fileReader.close();

//			bufferWriter.write(reverseString);
			stringReader.reverse();
			bufferWriter.write(stringReader.toString());

			endTime = System.currentTimeMillis();

			bufferWriter.close();
			fileWriter.close();

			System.out.println(" Start time in millisecond : " + startTime
					+ " Done writing in another file after reversing in millisecond : " + endTime);

		} catch (IOException e) {
			System.out.println("Error occured while writing into file : " + e.getMessage());
			e.printStackTrace();
		}

	}

	private static void writeStringMoreThanRam(String inputFile) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10000; i++) {
			sb.append("A file generating to check string reversal test.   ");
		}

		try {

			FileWriter fileWriter = new FileWriter(inputFile);

			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

			bufferWriter.write(sb.toString());
			bufferWriter.close();
			fileWriter.close();
			System.out.println("Done");
		} catch (IOException e) {
			System.out.println("Error occured while writing into file : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
