package com.code.exercise.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipcodeRange {
	private static List<Range> inputRangeList = new ArrayList<Range>();
	private static List<Range> outputRangeList = new CopyOnWriteArrayList<Range>();

	public static void addZipRange(Range addRange) {
		if (outputRangeList.size() == 0) {
			outputRangeList.add(addRange);
		} else {
			boolean addFlag = true;
			for (Range range : outputRangeList) {
				// if new range exist in existing range, no need to add
				if (range.getLowerLimit() <= addRange.getLowerLimit()
						&& range.getUpperLimit() >= addRange.getUpperLimit()) {
					addFlag = false;
				}
				// if new range is not exist, add it
				else if (range.getLowerLimit() > addRange.getUpperLimit()
						|| range.getUpperLimit() < addRange.getLowerLimit()) {
					addFlag = true;
				}
				else {
					if(range.getLowerLimit() < addRange.getLowerLimit()) {
						addRange.setLowerLimit(range.getLowerLimit());
						
					}
					if(range.getUpperLimit() > addRange.getUpperLimit()) {
						addRange.setUpperLimit(range.getUpperLimit());
					}
					outputRangeList.remove(range);
					addFlag = true;
				}
				
			}
			if (addFlag) {
				outputRangeList.add(addRange);
			}
		}
	}
	 public static void showRange() {
		 if(inputRangeList.size()>0) {
			 System.out.println("Input Range:");
			   for(Range range :inputRangeList) {
				   System.out.print(range.toString());
			   }
		   }
		 System.out.println("\nOutput Range:");
		   if(outputRangeList.size()>0) {
			   for(Range range :outputRangeList) {
				   System.out.print(range.toString());
			   }
		   }
		   
	   }
	public static void main(String[] args) {
		/*Range a = new Range(94133, 94133);
		Range b = new Range(94200, 94299);
		Range c = new Range(94600, 94699);
		
		ZipcodeRange.addZipRange(a);
		ZipcodeRange.addZipRange(b);
		ZipcodeRange.addZipRange(c);
		showRange();*/
		System.out.println("ENTER 1 TO ADD 5 DIGIT ZIP CODE RANGE OR ENTER 2 TO DISPLAY");
		mainPrompt();
	}
	
	private static void mainPrompt() {
		System.out.println("1. ADD RANGE");
		System.out.println("2. SHOW INPUT & OUTPUT RANGE");
		

		String input;
		try {
			input = getInput();
			if (input.equals("1")) {
				addRange();
			} else if (input.equals("2")) {
				showRange();
			} else if(!input.equals("1") || !input.equals("2")) {
				System.out.println("WRONG INPUT. PLEASE PROVIDE A VALID INPUT.");
				mainPrompt();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	private static void addRange() throws IOException {
		System.out.println("ENTER LOWER RANGE: ");
		int lowerLimit = validateInput(getInput());
		System.out.println("ENTER UPPER RANGE: ");
		int upperLimit = validateRange(lowerLimit, validateInput(getInput()));
		inputRangeList.add(new Range(lowerLimit, upperLimit));
		ZipcodeRange.addZipRange(new Range(lowerLimit, upperLimit));
		System.out.println("ENTER 1 TO ADD MORE OR 2 TO DISPLAY");
		mainPrompt();
	}
	
	private static String getInput() throws IOException {
		
		return new BufferedReader(new java.io.InputStreamReader(System.in)).readLine();
	}
	
	private static int validateInput(String input) throws IOException {
		if(input.length() != 5 || !isValidNumber(input)) {
			System.out.println("INVALID RANGE! PLEASE ENTER 5 DIGIT NUMERIC ZIP CODE: ");
			return validateInput(getInput());
		}
		return Integer.parseInt(input);
	}
	
	private static boolean isValidNumber(String input) throws IOException {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private static int validateRange(int lowerLimit, int upperLimit) throws IOException {
		if(upperLimit < lowerLimit){
			System.out.println("UPPER LIMIT CAN'T BE LESSER THAN LOWER LIMIT. PLEASE PROVIDE A VALID INPUT.");
			return validateRange(lowerLimit, validateInput(getInput()));
		}
		return upperLimit;
	}
}
