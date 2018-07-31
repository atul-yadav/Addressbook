package com.jda.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



/**
 * @author atul
 *
 */


public class Utility2 {
	Scanner scanner;

	/**
	 * this constructor is for initializing scanner class object
	 */
	public Utility2() {
		scanner = new Scanner(System.in);
	}

	/**
	 * function to take user input as string
	 * 
	 * @return input input return to ReplaceString class
	 */
	public String inputString() {
		return scanner.next();

	}

	/**
	 * function to take user input as integer
	 * 
	 * @return input goes to Flipcoin class
	 */
	public int inputInteger() {
		int input = scanner.nextInt();
		return input;
	}

	public double inputDouble() {
		double input = scanner.nextDouble();
		return input;
	}

	/**
	 * replaceString function replaces the given input string part to user input.
	 * 
	 * @param template
	 *           is given input passing to replaceString function
	 * @param name
	 *           is user input by which we want to replace <<UserName>>
	 * @return
	 */
	public String replaceString(String template, String name) {
		template = template.replace("<<UserName>>", name);
		return template;
	}

	/**
	 * flip coin funtion
	 * 
	 */
	public void flipcoin(int number) {
		int noOfHeads = 0;

		int noOfTails = 0;
		int noOftoss = number;

		for (int i = 0; i < number; i++) {
			double random = Math.random();
			System.out.println(random);
			if (random < 0.5) {
				noOfTails++;
			} else {
				noOfHeads++;
			}

		}
		System.out.println("no of heads = " + noOfHeads);
		System.out.println("no of tails = " + noOfTails);
		System.out.println("percentage of head = " + (double) (noOfHeads * 100) / noOftoss);
		System.out.println("percentage of head = " + (double) (noOfTails * 100) / noOftoss);

	}

	/**
	 * function to check leap year or not
	 * 
	 * @param year
	 */
	public boolean leapyear(int year) {

		int count = 0;
		int temp = year;
		while (temp > 0) {
			temp = temp / 10;
			count++;
		}

		if (count == 4) {
			if ((year % 4 == 0 || year % 400 == 0) && year % 100 != 0) {
				//System.out.println("Yes, this is leap year");
				return true;
			} else {
				//System.out.println("Not a leap year");
				return false;
			}
		} else {
			//System.out.println("Enter 4 digit number please");
		}
		return false;
	}

	/**
	 * powervalue function computes the power value of given number
	 * 
	 * @param number
	 */
	public void powervalue(int number) {
		int res = 1;
		int j = 2;
		System.out.println("table of number " + number);
		for (int i = 0; i < number; i++) {
			res = res * j;
			System.out.println(res);
		}

	}

	/**
	 * harmonicValue is function for calculating nth harmonic value.
	 * 
	 * @param number
	 *           is nth value for which harmonic value is to be calculated
	 * @return nth harmonic value.
	 */
	public double harmonicValue(int number) {
		double res = 0.0;
		for (int i = 1; i <= number; i++) {
			res = res + (1.0 / i);
			System.out.println(i + "th harmonic value is  " + res);
		}
		return res;
	}

	/**
	 * primeFactor method is finding the prime factors of given number
	 * 
	 * @param number
	 *           the number is parameter for which we need find prime factors.
	 */
	public void primeFactors(int number) {
		System.out.println("Prime factors of  number  " + number + " " + "are  ");

		for (int i = 2; i * i <= number; i++) {

			while (number % i == 0) {

				System.out.println(i + " ");

				number = number / i;
			}

		}
		if (number > 1) {
			System.out.println(number);
		}
	}

	/**
	 * gambler function basically implement the logic of finding winning and
	 * losing percentage.
	 * 
	 * @param stake
	 *           is initial stake for gambler
	 * @param goal
	 *           is gambler will win if he has cash equals goal
	 * @param trials
	 *           is number of times he is playing
	 */
	public void gambler(int stake, int goal, int trials) {

		int numberOfWins = 0;
		int points;
		for (int i = 0; i < trials; i++) {
			points = stake;
			while (points > 0 && points < goal) {

				if (Math.random() < 0.5) {
					points++;
				} else {
					points--;
				}

			}
			if (points == goal) {
				numberOfWins++;
			}
		}
		System.out.println("Number of wins  =  " + numberOfWins);
		System.out.println("winning %  =  " + ((double) numberOfWins / trials) * 100.00);
		System.out.println("losing  %  = " + (100.00 - ((double) numberOfWins / trials) * 100.00));
	}

	/**
	 * sumzero function finds the triplets and number of triplets whose sum is
	 * zero.
	 * 
	 * @param a
	 *           is array which is taken as input
	 * @param n
	 *           is size of array
	 */
	public void sumzero(int a[], int n) {
		boolean found = true;
		int count = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						System.out.print(a[i] + " ");
						System.out.print(a[j] + " ");
						System.out.print(a[k] + " ");

						count++;
						found = true;
					}

				}
			}
		}
		System.out.println();
		if (found == false) {
			System.out.println("No zero sum triplet exist");
		}
		System.out.println("Number of triplets  = " + count);

	}

	/**
	 * intArray method is array to be read.
	 * 
	 * @param array
	 *           is array to be read
	 * @param m
	 *           is row size
	 * @param n
	 *           is column size
	 */

	public void intArray(int[][] array, int m, int n) {
		System.out.println("enter the array elements");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = inputInteger();
			}
		}

	}

	/**
	 * printArray function for displaying array elements.
	 * 
	 * @param array
	 *           to be display
	 * @param m
	 *           is row size
	 * @param n
	 *           is column size i
	 */
	public void printArray(int[][] array, int m, int n) {
		intArray(array, m, n);

		PrintWriter p = new PrintWriter(System.out, true);
		p.println("displaying 2d array");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				p.print(array[i][j] + " ");
			}
			p.println();
		}
	}

	/**
	 * @param x
	 *           is x coordinate value
	 * @param y
	 *           is y coordinate value
	 * @return distance between (x,y) and (0,0)
	 */
	public static double getDistance(int x, int y) {
		double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return distance;
	}

	/**
	 * coupon function returns total random number needed to have all distinct
	 * numbers
	 * 
	 * @param n
	 *           is number of distinct coupon given
	 */
	public static void coupon(int n) {

		int count = 0;
		int unique = 0;

		int[] checking = new int[n];
		while (unique < n) {
			int var = (int) (Math.random() * n);
			// System.out.print(var+" ");
			count++;
			if (checking[var] != 1) {
				unique++;
				checking[var] = 1;
			}
		}
		System.out.println("total random number needed");
		System.out.println(count);
	}

	/**
	 * function stopwatch prints elapsed time
	 * 
	 * @param start
	 *           is starting time of stopwatch
	 */
	public void stopwatch(long start) {
		start = (System.currentTimeMillis());
		System.out.println("Start  Time is  = " + start);
		for (int i = 0; i < 120000; i++) {
			System.out.print(" ");
		}
		long current = (System.currentTimeMillis());
		System.out.println("End Time is  = " + current);
		System.out.println("total elapsed time  =  " + (current - start));

	}

	/**
	 * quadratic return the roots of given equation.
	 * 
	 * @param a
	 *           is coefficient of X^2
	 * @param b
	 *           is coefficient of X
	 * @param c
	 *           is constant
	 */
	public void quadratic(double a, double b, double c) {
		double d = b * b - 4 * a * c;
		double root1 = (-b + Math.sqrt(d)) / 2 * a;
		double root2 = (-b - Math.sqrt(d)) / 2 * a;

		if (d < 0) {
			System.out.println("roots are imaginery");
		} else {

			System.out.println("root1 =  " + root1);
			System.out.println("root2 =  " + root2);
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a
	 *           string value
	 * @param i
	 *           position 1
	 * @param j
	 *           position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	/*
	 * permutation function
	 * 
	 * @param str string to calculate permutation for
	 * 
	 * @param l starting index
	 * 
	 * @param r end index
	 */
	int count = 0;
	private static Scanner scanner2;

	public void permute(String str, int l, int r) {

		if (l == r) {
			count++;
			System.out.println(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}

		}
		System.out.println(count);
	}

	/**
	 * windChill function prints wind chill
	 * 
	 * @param t
	 *           is temperature
	 * @param v
	 *           is wind speed
	 */
	public void windChill(double t, double v) {
		double w = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
		System.out.println("wind chill  =  " + w);
	}

	static public boolean areAnagram(char[] str1, char[] str2) {
		int n1 = str1.length;
		int n2 = str2.length;
		if (n1 != n2) {
			return false;
		}
		Arrays.sort(str1);
		Arrays.sort(str2);

		for (int i = 0; i < n1; i++) {
			if (str1[i] != str2[i]) {
				return false;
			}
		}

		return true;
	}
	
	

	public boolean areAnagrams(String string1, String string2) {
		string1 = string1.replaceAll("\\s+", "");
		string1 = string1.toLowerCase();
		string2 = string2.replaceAll("\\s+", "");
		string2 = string2.toLowerCase();
		if (string1.length() != string2.length()) {
			return false;
		}
			char[] str1 = string1.toCharArray();
			char[] str2 = string2.toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);
			
			for (int i = 0; i < string1.length(); i++) {
				if (str1[i] != str2[i]) {
					return false;
				}
			}

			return true;
		
	}


	public static boolean isPrime(int n) {

		if (n <= 1)
			return false;

		for (int i = 2; i*i  <=  n; i++)
			if (n % i == 0) {
				return false;
			}

		return true;
	}

	public static boolean isPalindrome(char s[]) {
		int l = s.length;
		for (int i = 0; i < l - 1; i++) {
			if (s[i] != s[l - i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean primePalindrome(int n) {
		if (isPrime(n)) {
			String s1 = Integer.toString(n);
			char[] str1 = s1.toCharArray();
			if (isPalindrome(str1)) {
				return true;
			}
			return false;

		}
		return false;
	}

	public static void primeAnagram() {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			if (isPrime(i)) {
				list.add(Integer.toString(i));
			}
		}
		// char[] chars = list.toString().toCharArray();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				boolean b = (areAnagram((list.get(i)).toCharArray(), (list.get(j)).toCharArray()));
				if (b) {
					System.out.println("these numbers are anagrams");
					System.out.println(list.get(i) + " " + list.get(j));
					count++;
				}
			}

		}
		System.out.println("number of prime anagrams ="+ count);
	}

	/*
	 * public static int binarySearch(int arr[], int l, int r, int x) { if (r>=l)
	 * { int mid = l + (r - l)/2; if (arr[mid] == x) return mid; if (arr[mid] >
	 * x) return binarySearch(arr, l, mid-1, x);
	 * 
	 * 
	 * return binarySearch(arr, mid+1, r, x); } return -1; }
	 * 
	 * 
	 * public static int binarySearch(String[] a, String x) { int low = 0; int
	 * high = a.length - 1; int mid;
	 * 
	 * while (low <= high) { mid = (low + high) / 2;
	 * 
	 * if (a[mid].compareTo(x) < 0) { low = mid + 1; } else if
	 * (a[mid].compareTo(x) > 0) { high = mid - 1; } else { return mid; } }
	 * 
	 * return -1; }
	 */
	/**
	 * insertionSort function for sorting elements.
	 * @param elems is array which contains elements
	 * @return  arrray of sorted elements
	 */
	
	
	
	public static <T extends Comparable<T>> T[] insertionSort(T[] elems) {
		int size = elems.length;

		for (int i = 1; i < size; ++i) {
			for (int j = i; j > 0; --j) {
				if (elems[j - 1].compareTo(elems[j]) > 0) {
					T temp = elems[j - 1];
					elems[j - 1] = elems[j];
					elems[j] = temp;
				}
			}
		}
		//printarr(elems);
		return elems;

	}

	/**
	 * @param arr is array of elements
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		T temp;

		boolean swapped = true;

		for (int j = 1; j < arr.length & swapped; j++) {

			swapped = false;

			for (int i = 0; i < arr.length - j; i++) {

				if (arr[i].compareTo(arr[i + 1]) > 0) {

					temp = arr[i];

					arr[i] = arr[i + 1];

					arr[i + 1] = temp;

					swapped = true;

				}

			}
		}
	}

	/**
	 * binarySearch function is for searching element
	 * @param arr is array which  contains elements
	 * @param value is to be searched
	 * @param lo lower index 
	 * @param hi higher index
	 * @return index if found otherwise return -1
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] arr, T value, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			int cmp = arr[mid].compareTo(value);
			if (cmp == 0) {
				return mid;
			}
			if (cmp > 0) {
				return binarySearch(arr, value, lo, mid - 1);
			}
			if (cmp < 0) {
				return binarySearch(arr, value, mid + 1, hi);
			}

		}
		return -1;
	}
	

	/**
	 * prinarr function prints the array elements.
	 * @param arr is array of elements of any data type
	 */
	public static <T> void printarr(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	/**
	 * printString function prints the string elements.
	 * @param arr is array of elements of any data type
	 */
	public static <T> void printString(T[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	 
	
	/**
	 * @param lo is lower index
	 * @param hi is higher index
	 * @return the mid element
	 */
	public static int binarySearch1(int lo, int hi)
	{
		scanner2 = new Scanner(System.in);
			
	        if ((hi - lo) == 1) 
	        {
	      	  return lo;
	        }
	        int mid = (lo + hi)/2;
	        System.out.println("numer is less than   "+ mid);
	        char c = scanner2.next().charAt(0);
	        
	        if (c == 't')
	        {
	      	  return binarySearch1(lo, mid);
	        }  
	        else        
	        {
	      	  return binarySearch1(mid, hi);
	        }
	    }
	
/**
 * @param a is array of generic data type
 * @param p is intial index
 * @param mid is for mid index
 * @param q is last index
 */
public static <T extends Comparable<T>> void  merge(T[] a, int p, int mid, int q) {

		//T[] tmp = new  T[q-p+1]; 
	 Object tmp[] =  new Object[q-p+1];
		int i = p;
		int j = mid+1;
		int k = 0;
		while (i <= mid && j <= q) {
		    if (a[i].compareTo(a[j])<=0)
			tmp[k] = a[i++];
		    else
			tmp[k] = a[j++];
		    k++;
		}
		if (i <= mid && j > q) {
		    while (i <= mid) 
			tmp[k++] = a[i++];
		} else {
		    while (j <= q)
			tmp[k++] = a[j++];
		}
		for (k = 0; k < tmp.length; k++) {
		    a[k+p] = (T) (tmp[k]); 
		}
	    }
	 
	public static <T extends Comparable<T>> void mergeSort (T[] a, int i, int j) {
		if (j-i < 1) return;
		int mid = (i+j)/2;
		mergeSort(a, i, mid);
		mergeSort(a, mid+1, j);
		merge(a, i, mid, j);
	    }
	
	/**
	 * vending Machine is function for calculating minimum number of change
	 * @param value is money to which we have to find change
	 */
	public void vendingMachine (int value)
	{
		int notes[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int count = 0 ;
		List <Integer>list = new ArrayList<Integer>();
		for (int i =  notes.length-1;  i  >= 0;  i--)
		{
			
			while (value >= notes[i])
			{
				value = value - notes[i];
				list.add(notes[i]);
				count++;
			}
		}
		System.out.println("minimum no of notes  = " + count);
		System.out.println("denomintion values are  ");
		for (int i = 0; i < list.size();  i++)
		{
			System.out.println(list.get(i));
		}
		
		
	}
	
	/**
	 * @param d is day
	 * @param m is month
	 * @param y is year
	 * @return is returning day
	 */
	public static int dayOfWeek(int d, int m, int y)
	{
	
	int y0 = y - (14 - m) / 12;
   int x = y0 + y0/4 - y0/100 + y0/400;
   int m0 = m + 12 * ((14 - m) / 12) - 2;
   int d0 = (d + x +( (31*m0)/12)) % 7;
	return d0;
	 
		
	}
	
	/**
	 * forenhiteToCelsius changes forenhite to celsius
	 * @param temperature
	 * @return the celsius value of given forenhite value
	 */
	public double forenhiteToCelsius(double temperature ) {
			return ((double)temperature - 32) * 5 / 9;
		}
	
	/**
	 * @param temperature
	 * @return celsius value of given forenhite
	 */
	public double celsiusToForenhite(double temperature) {
		
			return  (((double)temperature * 9 / 5) + 32);
		}
	
	public static double monthlyPayment(double P, double Y, double R) {
		double r = R / (12 * 100);
		double n = - 1* 12 * Y;
		double payment = (P * r) / (1 - Math.pow((1 + r) , n));
		return payment;
	}
	
	

/**
*squareRoot is method for finding square root 
 * @param t is number whose square root has to be found
 * @return square root of given  number
 */
public static double squareRoot(double t) {
	double c = t;
	double epsilon = Math.pow(2.71828 , -15);
		
	while(Math.abs(t - (c / t)) > (epsilon * t)) {
			t = ((c / t) + t) / 2;
			//return t;
		}
		return t;

	}

/**
 * integerTobinary number function converts integer to binary
 * @param number
 * @return string of binary number
 */
public static String integerToBinary(int number) {
	String binary = " ";
	
	while (number  >  0)
	{
		int remainder = number % 2;
		
		binary =  binary + String.valueOf(remainder);
		number = number / 2;
	}
	binary = new StringBuffer(binary).reverse().toString();
	
	return binary;
	
}

/**
 * @param x 
 * @return the integer value of swapped binary numbers
 */
public  int swapNibbles(int x)
{
	int number = ((x & 0x0F) << 4 | (x & 0xF0) >> 4);
	String binary  = integerToBinary(number);
	System.out.println("swapped nibble");
	System.out.println(binary);
	double number1 = Math.log(number)/Math.log(2.0);
	if ((int)number1 == number1 )
	{
		System.out.println("yes number is power of 2");
	}
	else
	{
		System.out.println("no number is not power of 2");
	}
	
    return  number;
}




public void writeToFile(String word)
{
	try{
		//File file=new File("C:\\Users\\1023340\\Documents\\JAVAPROJECT\\src\\com\\jda\\datastructureprograms\\numbers.txt");
		File file=new File("C:\\Users\\1023340\\Documents\\JAVAPROJECT\\src\\com\\jda\\datastructureprograms\\word.txt");
      	file.createNewFile();
      	FileWriter fileWriter=new FileWriter(file);
      	System.out.println("displaying file after modification");
      	System.out.println(word);
        fileWriter.write(word);
        fileWriter.close();
	}
	catch(IOException e){
	}
}

public int noOfBst(int number) {
	int Sum = 0;
	if(number == 0 || number == 1) {
		return 1;
	} else if(number == 2) {
		return 2;
	} else {
		for(int i = 0; i < number; i++) {
			 Sum = Sum + noOfBst(i) * noOfBst(number - i - 1);
		}		
		return Sum;
	}
	
}


public String[] readFileForInteger(String fileLocation) {
	BufferedReader reader = null;
	String line = "";
	try {
		reader = new BufferedReader(new FileReader(fileLocation));
		while((line=reader.readLine()) != null){
			String[] words = line.split(" ");
			return words;
		}
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	finally {
		if(reader!=null) {
			try {
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	return null;
}
public String[] readsFileForSortedIntegers(String fileLocation) {
	BufferedReader reader = null;
	String line = "";
	try {
		reader = new BufferedReader(new FileReader(fileLocation));
		while((line=reader.readLine()) != null){
			String[] words = line.split(" ");
			Arrays.sort(words);
			reader.close();
			return words;
		}
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	return null;
}

public String[] readFileForIntegers(String fileLocation) {
	BufferedReader reader = null;
	String line = "";
	try {
		reader = new BufferedReader(new FileReader(fileLocation));
		while((line=reader.readLine()) != null){
			String[] words = line.split(" ");
			reader.close();
			return words;
		}
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	return null;
}

public ArrayList<Integer> PrimesRange(int input) {
	int i;
	ArrayList<Integer>array=new ArrayList<Integer>();
	for (i = 2; i <= input; i++) {
		if (isPrime(i))
			array.add(i);
		else
			continue;

	}
	return array;
}

public static StringBuilder createJsonfromArray(Collection products) {
	StringBuilder jsonstring = new StringBuilder();
	jsonstring.append('[');
	Iterator iterator = products.iterator();
	while (iterator.hasNext()) {

		jsonstring.append(iterator.next());
		if (iterator.hasNext()) {
			jsonstring.append(",");
		}
		

	}
	jsonstring.append("]");
	return jsonstring;

}


public String regularExpression(String string, String firstName, String lastName, String phoneNumber )
{
	string = string.replaceAll("<<[a-z]{4}>>", firstName);
	string = string.replaceAll("<<[a-z ]{9}>>", (firstName+" "+lastName));
	string = string.replaceAll("[x]{10}", phoneNumber);
	LocalDate ldate = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String day = ldate.format(formatter);

	string = string.replaceAll("01/01/2016", day);
	return string;
	
}



public String getRank(int rank) {
	switch(rank) {
	case 0:
		return "2";
	case 1:
		return "3";
	case 2:
		return "4";
	case 3:
		return "5";
	case 4:
		return "6";
	case 5:
		return "7";
	case 6:
		return "8";
	case 7:
		return "9";
	case 8:
		return "10";
	case 9:
		return "Jack";
	case 10:
		return "Queen";
	case 11:
		return "King";
	case 12:
		return "Ace";
	default:
		return "";
	}


}



public String getSuit(int suit) {
	switch(suit) {
	case 0:
		return "Clubs";
	case 1:
		return "Diamonds";
	case 2:
		return "Hearts";
	case 3:
		return "Spades";
	default:
		return "";
	}
}






	
}






	


	
	

	
	
	

	
	




