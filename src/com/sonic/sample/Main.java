package com.sonic.sample;

import java.util.*;

import com.sonic.entity.*;
import com.sonic.process.*;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		boolean isContinue = true;
		while (isContinue) {
			try {
				System.out.println(Mess.getMainScreen());
				sc = new Scanner(System.in);
				int input = sc.nextInt();

				switch (input) {
				case 1:
					ClassicAttack.process();
					break;
				case 2:
					RandomAttack.process();
					break;
				case 3:
					BalancePoint.process();
					break;
				default:
					System.out.println("Goodbye!");
					isContinue = false;
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please input right option!");
			} 
		}
	}
}
