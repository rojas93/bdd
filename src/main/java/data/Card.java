package data;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Card {
    private String number;
    private double balance;
    private String secretNumber;

    public Card(String number, double balance, String secretNumber) {
        this.number = number;
        this.balance = balance;
        this.secretNumber = secretNumber;
    }
}
