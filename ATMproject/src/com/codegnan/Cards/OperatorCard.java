package com.codegnan.Cards;

import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InsufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;
import com.codegnan.interfaces.IATMService;

public class OperatorCard implements IATMService {

    private int pinNumber;
    private long id;
    private String name;
    private final String type = "operator";

    public OperatorCard(long id, int pin, String name) {
        this.id = id;
        this.pinNumber = pin;
        this.name = name;
    }

    @Override
    public String getuserType() throws NotAOperatorException {
        if (!type.equals("operator")) {
            throw new NotAOperatorException("This card does not belong to an operator.");
        }
        return type;
    }

    @Override
    public double withdrawAmount(double wthAmount)
            throws InvalidAmountException, InsufficientBalanceException, InsufficientMachineBalanceException {
        throw new UnsupportedOperationException("Withdraw operation is not supported for operator cards.");
    }

    @Override
    public double depositeAmount(double dptAmount) throws InvalidAmountException {
        throw new UnsupportedOperationException("Deposit operation is not supported for operator cards.");
    }

    @Override
    public double checkBalance() {
        throw new UnsupportedOperationException("Check balance operation is not supported for operator cards.");
    }

    @Override
    public void changePinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    @Override
    public int getPinNumber() {
        return pinNumber;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public int getChances() {
        throw new UnsupportedOperationException("Chances are not applicable for operator cards.");
    }

    @Override
    public void decreseChances() {
        throw new UnsupportedOperationException("Decreasing chances is not applicable for operator cards.");
    }

    @Override
    public void resetPinChances() {
        throw new UnsupportedOperationException("Resetting PIN chances is not applicable for operator cards.");
    }

    @Override
    public void getMiniStatement() {
        throw new UnsupportedOperationException("Mini statement operation is not supported for operator cards.");
    }
}
