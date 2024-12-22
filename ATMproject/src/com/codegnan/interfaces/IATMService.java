package com.codegnan.interfaces;

import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InsufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;

public interface IATMService {
	//to ge the user is normal user or user id operator
	public abstract String getuserType() throws NotAOperatorException;
	
	//to with draw amount

	
	public abstract double withdrawAmount(double withAmount) throws
	InvalidAmountException,
	InsufficientBalanceException,
	InsufficientMachineBalanceException;
	
	
	public abstract double depositeAmount(double dptAmount) throws InvalidAmountException;
	
	public abstract double checkBalance();
	
	
	public abstract void changePinNumber(int pinNumber);
	
	
	
	public abstract int getPinNumber();
	
	
	public abstract String getUsername();
	
	public abstract int getChances();
	
	public abstract void decreseChances();
	
	public abstract void resetPinChances();
	
	public abstract void getMiniStatement();
	

}
