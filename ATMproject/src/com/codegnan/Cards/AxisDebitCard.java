package com.codegnan.Cards;

import java.util.ArrayList;
import java.util.Collections;

import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InsufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;
import com.codegnan.interfaces.IATMService;



public class AxisDebitCard implements IATMService {
	String name;
	long debitCardnumber;
	double accountBalance;
	int PinNumber;
	ArrayList<String> statement;
	final String type ="User";
	int chances;
	
	
	
	public AxisDebitCard(long debitCardNumber, String name, double accountBalance, int PinNumber) {
	chances=3;
	this.name=name;
	this.accountBalance=accountBalance;
	this.PinNumber=PinNumber;
	statement=new ArrayList<>();
	
	
	}
	
	public String getUserType() throws NotAOperatorException {
		
		return type;
	}

	@Override
	public  double withdrawAmount(double withAmount) throws InvalidAmountException, InsufficientBalanceException, InsufficientMachineBalanceException {
		if(withAmount<=0){
			throw new InvalidAmountException("You can't enter Zero amount to withdraw ");
		}else if(withAmount%100!=0) {
			throw new InvalidAmountException("please enter the multiplies of 100");
			
		}else if(withAmount<500) {
			throw new InvalidAmountException("please withdraw morethan 500");
			
		}else if(withAmount>accountBalance){
			throw new InsufficientBalanceException("You don't have sufficient balance to withdraw... ");
			} else {
				accountBalance = accountBalance - withAmount;
				statement.add("Debited:" + withAmount);
				return withAmount;
			}
		}
			
		
		

	public double depositAmount(double dptAmount) throws InvalidAmountException {
		if(dptAmount<=0) {
			throw new InvalidAmountException("you can't enter deposit zero or les than");
		}else if(dptAmount%100!=0) {
			throw new InvalidAmountException("please deposit multiplies of 100..");
		}else if(dptAmount<500) {
			throw new  InvalidAmountException("please deposit more than 500 rupees");
		}else {
			accountBalance = accountBalance+dptAmount;
			statement.add("credited:" +dptAmount);
		}
		return dptAmount;
	}

	@Override
	public double checkBalance() {
		
		return accountBalance;
	}

	@Override
	public void changePinNumber(int pinNumber) {
		this.PinNumber=pinNumber;
		
	}

	@Override
	public int getPinNumber() {
		// TODO Auto-generated method stub
		return PinNumber ;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getChances() {
		// TODO Auto-generated method stub
		return chances;
	}

	public void decreasedChances() {
		--chances;
		
	}

	@Override
	public void resetPinChances() {
		chances=3;
		
	}

	@Override
	public void getMiniStatement() {
		int count=5;
		if(statement.size()==0) {
			System.out.println("there are no transactions happend.. ");
			return; 
		}
		System.out.println("==================Last 5 transactions=============");
		Collections.reverse(statement);
		for(String trans:statement) {
			if(count==0) {
				break;
			}
			System.out.println(trans);
			count--;
			
		}
		Collections.reverse(statement);
	}

	public double withdrawAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getuserType() throws NotAOperatorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double depositeAmount(double dptAmount) throws InvalidAmountException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void decreseChances() {
		// TODO Auto-generated method stub
		
	}


}