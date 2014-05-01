import java.awt.*;
import java.util.Scanner;

/**
 * Created by rt on 4/17/14.
 */public class SnackMachineMain {


    public static void main(String[] args) {

        //System.out.println("Please type what snacks you would like to see");
        //Scanner scan = new Scanner(System.in);

        SnackMachineView view = new SnackMachineView();
        //SnackMachineView v = new SnackMachineView(Model);
        view.pack();
        view.setVisible(true);

        //SnackMachineController controller = new SnackMachineController(model, view);

        // register controller as the listener
        //view.registerListener(controller);


    }

}

