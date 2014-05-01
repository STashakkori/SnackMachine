/**
 * Created by rt on 4/21/14.
 */
public class MoneyFactory{

    public Money makeMoney(String newMoneyType) {
        Snack newMoney = null;

        switch (newMoneyType) {
            case "nickel":
                return new Nickel();
            case "dime":
                return new Dime();
            case "quarter":
                return new Quarter();
            case "dollar":
                return new Dollar();

        };
        return null;
    }
}
