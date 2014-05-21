/**
 * Created by rt on 4/19/14.
 */
public class SnackFactory {

    public Snack makeSnack(String newSnackType) {
        Snack newSnack = null;

        switch (newSnackType) {
            case "doritosnacho":
                return new DoritosNacho();
            case "doritosranch":
                return new DoritosRanch();
            case "cheetos":
                return new Cheetos();
            case "fritos":
                return new Fritos();
            case "kitkats":
                return new Kitkat();
            case "laysclassic":
                return new Lays();
            case "laysvinegar":
                return new LaysSaltVinegar();
            case "milkyway":
                return new MilkyWay();
            case "reeses":
                return new Reeses();
            case "snickers":
                return new Snickers();
            case "sunchipsbbq":
                return new SunchipsBbq();
            case "twix":
                return new Twix();
            case "layscheddar":
                return new LaysCheddarCream();
            case "pretzels":
                return new Pretzels();
            case "sweetsaltymix":
                return new SweetSaltyMix();
            case "combospizza":
                return new CombosPizza();
            case "peanutbuttercrackers":
                return new PeanutButterCrackers();
            case "sunchipssalsa":
                return new SunchipsSalsa();
        };
        return null;
    }
}
