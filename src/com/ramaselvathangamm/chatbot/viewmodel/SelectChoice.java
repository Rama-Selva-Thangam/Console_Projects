package com.ramaselvathangamm.chatbot.viewmodel;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.parser.ParseException;

import com.ramaselvathangamm.chatbot.dto.Menu;

public class SelectChoice {
	private AddChoiceViewModel selectchoicevm;
	private Stack<Menu> backStack = new Stack<>();
	
	public SelectChoice() throws ParseException {
		selectchoicevm = new AddChoiceViewModel(this);
	}
	
	public void addChoice() {
		int choice;
		if(backStack.isEmpty()) {
			backStack.push(new Menu(0,0));
			selectchoicevm.print(0,0);
		}
		do {
            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            System.out.println("Select the Menu:");
            choice = input.nextInt();
              
            if (choice == 9) {
                backStack.pop();

                if (backStack.empty()) {
                    break;
                }
            } else {
                backStack.push(new Menu(backStack.peek().getStep() + 1, choice));
            }
            Menu top = backStack.peek();
            if (top.getStep() == 3) {
    			System.out.println("Your Option set Successfully");
    			System.out.println("9-Back");
    			System.out.println("0-Exit");
    		}
            selectchoicevm.print(top.getStep(), top.getChoice());
        } while (choice != 0);
		System.out.println("Thank you for visiting our website...");
		System.exit(0);
	}

}
