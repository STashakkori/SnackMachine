import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Date;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * SnackMachineView --- View class for the snack machine simulation program.
 * @author st79375
 * @date on 4/17/2014
 */
public class SnackMachineView extends JFrame implements WindowListener {

    //// fields ////
    JButton[] optionButtons;
    JTextField console;
    JPanel mainPanel, transactionPanel, choicePanel, retrievalPanel, sidePanel, snackPanel, rightPanel,
           box, dispensorPanel, moneyPanel, pricePanel, walletPanel;
    JLabel retrievalLabel, insertMoneyLabel1, insertMoneyLabel2, priceLabelChips, priceLabelCandy;

    JLabel[] snackSlots;
    JLabel[] moneySlots;
    JButton[] minusbuttons;

    String[] snacks;

    JLabel optionKey;

    JButton plusButtonNickel;
    JButton plusButtonDime;
    JButton plusButtonQuarter;
    JButton plusButtonDollar;
    JButton minusButtonNickel;
    JButton minusButtonDime;
    JButton minusButtonQuarter;
    JButton minusButtonDollar;

    JPanel plusPanelNickel;
    JPanel plusPanelDime;
    JPanel plusPanelQuarter;
    JPanel plusPanelDollar;
    JPanel minusPanelNickel;
    JPanel minusPanelDime;
    JPanel minusPanelQuarter;
    JPanel minusPanelDollar;
    JPanel test1 = new JPanel();
    JPanel test2 = new JPanel();
    JPanel test3 = new JPanel();
    JPanel test4 = new JPanel();

    String[] optionKeys;
    String[] moneys;
    JSlider insertTextSlider;
    HashMap<String,String> optionMap;
    int optioncounter;
    String option;
    double payment;

    SnackFactory snackfac = new SnackFactory();         // object that creates snack G.U.I. representations
    MoneyFactory moneyfac = new MoneyFactory();         // object that creates money G.U.I. representations

    public String[] getOptionKeys() {
        return optionKeys;
    }

    public String[] getMoneys() {
        return moneys;
    }

    public JSlider getInsertTextSlider() {
        return insertTextSlider;
    }

    public HashMap<String, String> getOptionMap() {
        return optionMap;
    }

    public int getOptioncounter() {
        return optioncounter;
    }

    public String getOption() {
        return option;
    }

    public double getPayment() {
        return payment;
    }

    public JButton[] getOptionButtons() {

        return optionButtons;
    }

    public JTextField getConsole() {
        return console;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getTransactionPanel() {
        return transactionPanel;
    }

    public JPanel getChoicePanel() {
        return choicePanel;
    }

    public JPanel getRetrievalPanel() {
        return retrievalPanel;
    }

    public JPanel getSidePanel() {
        return sidePanel;
    }

    public JPanel getSnackPanel() {
        return snackPanel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public JPanel getBox() {
        return box;
    }

    public JPanel getDispensorPanel() {
        return dispensorPanel;
    }

    public JPanel getMoneyPanel() {
        return moneyPanel;
    }

    public JPanel getPricePanel() {
        return pricePanel;
    }

    public JPanel getWalletPanel() {
        return walletPanel;
    }

    public JLabel getRetrievalLabel() {
        return retrievalLabel;
    }

    public JLabel getInsertMoneyLabel1() {
        return insertMoneyLabel1;
    }

    public JLabel getInsertMoneyLabel2() {
        return insertMoneyLabel2;
    }

    public JLabel getPriceLabelChips() {
        return priceLabelChips;
    }

    public JLabel getPriceLabelCandy() {
        return priceLabelCandy;
    }

    public JLabel[] getSnackSlots() {
        return snackSlots;
    }

    public JLabel[] getMoneySlots() {
        return moneySlots;
    }

    public String[] getSnacks() {
        return snacks;
    }

    public JLabel getOptionKey() {
        return optionKey;
    }

    public JButton[] getMinusbuttons() {
        return minusbuttons;
    }

    public JButton getPlusButtonNickel() {
        return plusButtonNickel;
    }

    public JButton getPlusButtonDime() {
        return plusButtonDime;
    }

    public JButton getPlusButtonQuarter() {
        return plusButtonQuarter;
    }

    public JButton getPlusButtonDollar() {
        return plusButtonDollar;
    }

    public JButton getMinusButtonNickel() {
        return minusButtonNickel;
    }

    public JButton getMinusButtonDime() {
        return minusButtonDime;
    }

    public JButton getMinusButtonQuarter() {
        return minusButtonQuarter;
    }

    public JButton getMinusButtonDollar() {
        return minusButtonDollar;
    }

    public JPanel getPlusPanelNickel() {
        return plusPanelNickel;
    }

    public JPanel getPlusPanelDime() {
        return plusPanelDime;
    }

    public JPanel getPlusPanelQuarter() {
        return plusPanelQuarter;
    }

    public JPanel getPlusPanelDollar() {
        return plusPanelDollar;
    }

    public JPanel getMinusPanelNickel() {
        return minusPanelNickel;
    }

    public JPanel getMinusPanelDime() {
        return minusPanelDime;
    }

    public JPanel getMinusPanelQuarter() {
        return minusPanelQuarter;
    }

    public JPanel getMinusPanelDollar() {
        return minusPanelDollar;
    }

    /**
    * SnackMachineView --- constructor
    */
    public SnackMachineView(){
        System.out.println("Building the view.");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // If the window is closed, the program terminates

        //// Controller Initialization ////
        SnackMachineController controller = new SnackMachineController();

        /*
        JLabel bg = new JLabel(new ImageIcon("bg.jpg"));
        bg.setSize(500,500);
        bg.setLayout(new FlowLayout());
        this.add(bg);
        */

        //// Panel Initialization ////
        mainPanel = new JPanel();                           // mainPanel --- panel that spans the whole frame
        choicePanel = new JPanel(new GridLayout(0,3));      // choicePanel --- panel that holds buttons, console, and money insert
        retrievalPanel = new JPanel();                      // retrievalPanel --- panel that holds purchased snack
        sidePanel = new JPanel(new GridLayout(0,1));        // sidePanel --- panel that holds console
        snackPanel = new JPanel();                          // snackPanel --- panel that holds
        transactionPanel = new JPanel();                    // transactionPanel --- panel that holds all transaction involved items
        dispensorPanel = new JPanel();                      // dispensorPanel --- panel that holds the retrieval panel
        moneyPanel = new JPanel();                          // moneyPanel --- panel that takes money
        rightPanel = new JPanel();                          // rightPanel --- option keys alone goes in here
        pricePanel = new JPanel();                          // pricePanel --- displays the snack item prices in USD
        walletPanel = new JPanel(new FlowLayout());         //

        plusPanelNickel = new JPanel();                     //
        plusPanelDime = new JPanel();                       //
        plusPanelQuarter = new JPanel();                    //
        plusPanelDollar = new JPanel();                     //
        minusPanelNickel = new JPanel();                    //
        minusPanelDime = new JPanel();                      //
        minusPanelQuarter = new JPanel();                   //
        minusPanelDollar = new JPanel();                    //

        // Text and Button Initializiation ////
        console = new JTextField("enter option");           // console -- textfield that shows transaction and option data

        optionButtons = initOptionButtons(optionButtons);   // generate collection of snack option buttons
        optionKeys = initOptionKeys(optionKeys);            // generate collection of snack option numbers
        snacks = initSnackStrings(snacks);                  // generate collection of snack names
        moneys = initMoneyStrings(moneys);
        optionMap = combineToHash(optionKeys,snacks);       // make map of optionKeys as key and snack names as value
        option = "";                                        //
        payment = 0.0;                                      //

        snackSlots = new JLabel[snacks.length];             // snack and option key goes in here
        moneySlots = new JLabel[moneys.length];             //
        insertMoneyLabel1 = new JLabel("Snack Machine");    //
        insertMoneyLabel2 = new JLabel("Version 1.0");      //
        priceLabelChips = new JLabel("Chips: $1.10");       //
        priceLabelCandy = new JLabel("Candy: $0.80");       //

        //// user payment setting panels
        plusButtonNickel = new JButton("+");                //
        plusButtonDime = new JButton("+");                  //
        plusButtonQuarter = new JButton("+");               //
        plusButtonDollar = new JButton("+");                //
        minusButtonNickel = new JButton("-");               //
        minusButtonDime = new JButton("-");                 //
        minusButtonQuarter = new JButton("-");              //
        minusButtonDollar = new JButton("-");               //

        //// component styling methods ////
        styleFrame(this);                                   //
        styleMainPanel(mainPanel);                          //
        styleSnackPanel(snackPanel);                        //
        styleConsoleTextField(console);                     //
        styleChoicePanel(choicePanel);                      //
        styleRetrievalPanel(retrievalPanel);                //
        styleSidePanel(sidePanel);                          //
        styleRightPanel(rightPanel);                        //
        styleDispensorPanel(dispensorPanel);                //
        styleMoneyPanel(moneyPanel);                        //
        styleInsertMoneyLabel1(insertMoneyLabel1);          //
        styleInsertMoneyLabel2(insertMoneyLabel2);          //
        stylePricePanel(pricePanel);                        //
        stylePriceLabelChips(priceLabelChips);              //
        stylePriceLabelCandy(priceLabelCandy);              //
        styleTransactionPanel(transactionPanel);            //
        styleWalletPanel(walletPanel);                      //

        //// action listen methods ////
        for(JButton button : optionButtons) button.addActionListener(controller);

        //// Piece Gui components together ////
        this.add(mainPanel);
        moneyPanel.add(insertMoneyLabel1);
        moneyPanel.add(insertMoneyLabel2);
        pricePanel.add(priceLabelChips);
        pricePanel.add(priceLabelCandy);
        transactionPanel.add(pricePanel);
        transactionPanel.add(moneyPanel);
        transactionPanel.add(console);
        sidePanel.add(transactionPanel);
        sidePanel.add(choicePanel);
        mainPanel.add(sidePanel, BorderLayout.WEST);

        retrievalLabel = new JLabel();

        for(JButton b : optionButtons) choicePanel.add(b);
        for(int i = 0; i < snackSlots.length; i++) snackSlots[i] = imageToLabelSnack(snackfac.makeSnack(snacks[i]));
        for(int i = 0; i < moneySlots.length; i++) moneySlots[i] = imageToLabelMoney(moneyfac.makeMoney(moneys[i]));

        int tempLoopIterator = 0;
        for(JLabel image : snackSlots) {
            box = new JPanel(new BorderLayout());
            box.add(image);
            optionKey = new JLabel(optionKeys[tempLoopIterator++]);
            styleOptionKey(optionKey);
            styleBoxSnack(box);
            box.add(optionKey, BorderLayout.SOUTH);
            snackPanel.add(box);
        }
        retrievalPanel.add(dispensorPanel);
        dispensorPanel.add(retrievalLabel);
        snackPanel.add(retrievalPanel);
        rightPanel.add(snackPanel);
        mainPanel.add(rightPanel,BorderLayout.EAST);
        tempLoopIterator = 0;

        /// Button styliing methods
        stylePlusMinusButton(plusButtonNickel);
        stylePlusMinusButton(minusButtonNickel);
        stylePlusMinusButton(plusButtonDime);
        stylePlusMinusButton(minusButtonDime);
        stylePlusMinusButton(plusButtonQuarter);
        stylePlusMinusButton(minusButtonQuarter);
        stylePlusMinusButton(plusButtonDollar);
        stylePlusMinusButton(minusButtonDollar);

        plusButtonNickel.setPreferredSize(new Dimension(40, 40));
        plusButtonDime.setPreferredSize(new Dimension(40, 40));
        plusButtonQuarter.setPreferredSize(new Dimension(40, 40));
        plusButtonDollar.setPreferredSize(new Dimension(40, 40));
        minusButtonNickel.setPreferredSize(new Dimension(40, 40));
        minusButtonDime.setPreferredSize(new Dimension(40, 40));
        minusButtonQuarter.setPreferredSize(new Dimension(40, 40));
        minusButtonDollar.setPreferredSize(new Dimension(40, 40));

        //// adding action listenerers to each money item for click transactions
        plusButtonNickel.addActionListener(controller);
        plusButtonDime.addActionListener(controller);
        plusButtonQuarter.addActionListener(controller);
        plusButtonDollar.addActionListener(controller);
        minusButtonNickel.addActionListener(controller);
        minusButtonDime.addActionListener(controller);
        minusButtonQuarter.addActionListener(controller);
        minusButtonDollar.addActionListener(controller);

        //// styling methods for money item panels
        plusPanelNickel.setBackground(Color.lightGray);
        plusPanelDime.setBackground(Color.lightGray);
        plusPanelQuarter.setBackground(Color.lightGray);
        plusPanelDollar.setBackground(Color.lightGray);
        minusPanelNickel.setBackground(Color.lightGray);
        minusPanelDime.setBackground(Color.lightGray);
        minusPanelQuarter.setBackground(Color.lightGray);
        minusPanelDollar.setBackground(Color.lightGray);

        //// adding images to money holding Panels
        for(JLabel image : moneySlots) {

            // box holds an image and attaches it inside of the snack panel
            box = new JPanel(new BorderLayout());
            box.add(image);
            styleBoxMoney(box);

            //
            switch(tempLoopIterator){
                case 0:
                    plusPanelNickel.add(plusButtonNickel);
                    minusPanelNickel.add(minusButtonNickel);
                    test1.setBackground(Color.lightGray);
                    test1.add(plusPanelNickel);
                    box.setPreferredSize(new Dimension(70,90));
                    test1.add(box);
                    test1.add(minusButtonNickel);
                    walletPanel.add(test1);
                    break;
                case 1:
                    plusPanelDime.add(plusButtonDime);
                    minusPanelDime.add(minusButtonDime);
                    test2.add(plusPanelDime);
                    test2.setBackground(Color.lightGray);
                    box.setPreferredSize(new Dimension(60,90));
                    test2.add(box);
                    test2.add(minusButtonDime);
                    walletPanel.add(test2);
                    break;
                case 2:
                    plusPanelQuarter.add(plusButtonQuarter);
                    minusPanelQuarter.add(minusButtonQuarter);
                    test3.add(plusPanelQuarter);
                    test3.setBackground(Color.lightGray);
                    box.setPreferredSize(new Dimension(80,90));
                    test3.add(box);
                    test3.add(minusPanelQuarter);
                    walletPanel.add(test3);
                    break;
                case 3:
                    plusPanelDollar.add(plusButtonDollar);
                    minusPanelDollar.add(minusButtonDollar);
                    test4.add(plusPanelDollar);
                    test4.setBackground(Color.lightGray);
                    box.setPreferredSize(new Dimension(172,90));
                    test4.add(box);
                    test4.add(minusPanelDollar);
                    walletPanel.add(test4);
                    break;
            }
            tempLoopIterator++;
        }

        // create lookup hash to hold object keys and snack values
        combineToHash(optionKeys,snacks);

        // style the panel that holds money increments
        walletPanel.setBackground(Color.lightGray);
        mainPanel.add(walletPanel);
    }

    /**
     *
     * @param s
     * @return
     */
    private static String[] initSnackStrings(String[] sArray){
        sArray = new String[]{
            "doritosnacho", "doritosranch","cheetos", "fritos",
            "combospizza", "laysclassic", "laysvinegar", "layscheddar",
            "pretzels","sweetsaltymix","sunchipssalsa", "sunchipsbbq",
            "reeses", "snickers", "milkyway", "twix",
        };
        return sArray;
    }

    private static String[] initMoneyStrings(String[] sArray){
        sArray = new String[]{
            "nickel", "dime", "quarter", "dollar"
        };
        return sArray;
    }

    /**
     *
     * @param s
     * @return
     */
    private static String[] initOptionKeys(String[] s){
        s = new String[]{
                "A0", "A1", "A2", "A3",
                "B0", "B1", "B2", "B3",
                "C0", "C1", "C2", "C3",
                "D0", "D1", "D2", "D3",
        };
        return s;
    }

    private static JButton[] initOptionButtons(JButton[] s){
        s = new JButton[]{
                new JButton("A"), new JButton("0"), new JButton("1"),
                new JButton("B"),new JButton("2"), new JButton("3"),
                new JButton("C"), new JButton("D"), new JButton("X")
        };
        return s;
    }

    /**
     *
     * @param sArray1
     * @param sArray2
     * @return
     */
    private static HashMap<String,String> combineToHash(String[] sArray1,String[] sArray2){
        HashMap<String,String> map = new HashMap<>();
        int tempLoopIterator = 0;
        for(String key: sArray1){
            map.put(key,sArray2[tempLoopIterator++]);
        }
        return map;
    }

    /**
     *
     * @param s
     * @return
     */
    private static JLabel imageToLabelSnack(Snack s){
        Image img = s.getIcon().getImage();
        Image newimg = img.getScaledInstance(s.getImgWidth(), s.getImgHeight(),  Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        JLabel image = new JLabel(newIcon);
        return image;
    }

    /**
     *
     * @param m
     * @return
     */
    private static JLabel imageToLabelMoney(Money m){
        Image img = m.getIcon().getImage();
        Image newimg = img.getScaledInstance(m.getImgWidth(), m.getImgHeight(),  Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        JLabel image = new JLabel(newIcon);
        return image;
    }

    /**
     *
     * @param f
     */
    private static void styleFrame(JFrame f){
        f.setTitle("Snack Machine");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        f.setPreferredSize(new Dimension((int)width, 950));
        //f.getContentPane().setBackground(Color.gray);
    }

    /**
     *
     * @param t
     */
    private static void styleConsoleTextField(JTextField t){
        t.setBackground(Color.white);
        t.setPreferredSize(new Dimension(100,35));
        t.setHorizontalAlignment(JTextField.CENTER);
        t.setEditable(false);
    }

    /**
     *
     * @param p
     */
    private static void stylePricePanel(JPanel p){
        Color lightestGray = new Color(207,207,207);
        p.setBackground(lightestGray);
        p.setPreferredSize(new Dimension(100, 50));
    }

    /**
     *
     * @param p
     */
    private static void stylePriceLabelChips(JLabel l){
        l.setForeground(Color.black);
    }

    /**
     *
     * @param l
     */
    private static void stylePriceLabelCandy(JLabel l){
        l.setForeground(Color.black);
    }

    /**
     *
     * @param p
     */
    private static void styleMainPanel(JPanel p){
        p.setBackground(new Color(184,226,247));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        p.setPreferredSize(new Dimension((int)width, 950));
    }

    /**
     *
     * @param p
     */
    private static void styleSnackPanel(JPanel p){
        p.setPreferredSize(new Dimension(650,790));
        p.setBackground(Color.BLACK);
    }

    /**
     *
     * @param p
     */
    private static void styleSidePanel(JPanel p){
        p.setPreferredSize(new Dimension(190, 400));
    }

    private static void styleWalletPanel(JPanel p){
        GroupLayout gLay = new GroupLayout(p);
        p.setPreferredSize(new Dimension(280, 450));
    }

    /**
     *
     * @param p
     */
    private static void styleChoicePanel(JPanel p){
        p.setPreferredSize(new Dimension(250,100));
        p.setBackground(Color.lightGray);

    }

    /**
     *
     * @param p
     */
    private static void styleMoneyPanel(JPanel p){
        p.setBackground(Color.darkGray);
        p.setPreferredSize(new Dimension(100, 100));
    }

    /**
     *
     * @param p
     */
    private static void styleDispensorPanel(JPanel p){
        p.setPreferredSize(new Dimension(150,200));
        p.setBackground(Color.black);
    }

    /**
     *
     * @param p
     */
    private static void styleTransactionPanel(JPanel p){
        Color lightestGrey = new Color(207,207,207);
        p.setBackground(lightestGrey);
    }

    /**
     *
     * @param p
     */
    private static void styleRetrievalPanel(JPanel p){
        p.setPreferredSize(new Dimension(650, 200));
        p.setBackground(Color.DARK_GRAY);
        p.setBorder(BorderFactory.createLineBorder(Color.black, 5));
    }

    /**
     *
     * @param p
     */
    private static void styleRightPanel(JPanel p){
        p.setBackground(Color.lightGray);
    }

    /**
     *
     * @param p
     */
    private static void styleBoxSnack(JPanel p){
        p.setBackground(Color.black);
        p.setPreferredSize(new Dimension(149, 149));
        p.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
    }

    private static void styleBoxMoney(JPanel p){
        p.setBackground(Color.lightGray);
        p.setPreferredSize(new Dimension(100, 100));
    };

    /**
     *
     * @param l
     */
    private static void styleOptionKey(JLabel l){
        l.setForeground(Color.white);
    }

    /**
     *
     * @param l
     */
    private static void styleInsertMoneyLabel1(JLabel l){
        l.setPreferredSize(new Dimension(78,45));
        l.setForeground(Color.lightGray);
        l.setFont(new Font("Monospaced", Font.PLAIN, 10));
    }

    private static JButton stylePlusMinusButton(JButton b){
        return b;
    }

    /**
     *
     * @param l
     */
    private static void styleInsertMoneyLabel2(JLabel l){
        l.setPreferredSize(new Dimension(68,30));
        l.setForeground(Color.lightGray);
        l.setFont(new Font("Monospaced", Font.PLAIN, 10));
    }

    private static int calculatePadding(double payment){
        int padding = 0;
        if(payment<1.0 && payment>0.0) padding = 41;
        else if(payment>=1.0 && payment<10.0) padding = 43;
        else if(payment==10.0) padding = 45;

        /*
        else if(payment < 0.0 && payment>-1.00) padding = 36;
        else if(payment < 1.00 && payment > -10.00) padding = 37;
        else if(payment==-10.00) padding = 45;
        else if(payment<-10.00) padding =42;
        */

        return padding;
    }


    public void setOptionKeys(String[] optionKeys) {
        this.optionKeys = optionKeys;
    }

    public void setMoneys(String[] moneys) {
        this.moneys = moneys;
    }

    public void setInsertTextSlider(JSlider insertTextSlider) {
        this.insertTextSlider = insertTextSlider;
    }

    public void setOptionMap(HashMap<String, String> optionMap) {
        this.optionMap = optionMap;
    }

    public void setOptioncounter(int optioncounter) {
        this.optioncounter = optioncounter;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setOptionButtons(JButton[] optionButtons) {

        this.optionButtons = optionButtons;
    }

    public void setConsole(JTextField console) {
        this.console = console;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setTransactionPanel(JPanel transactionPanel) {
        this.transactionPanel = transactionPanel;
    }

    public void setChoicePanel(JPanel choicePanel) {
        this.choicePanel = choicePanel;
    }

    public void setRetrievalPanel(JPanel retrievalPanel) {
        this.retrievalPanel = retrievalPanel;
    }

    public void setSidePanel(JPanel sidePanel) {
        this.sidePanel = sidePanel;
    }

    public void setSnackPanel(JPanel snackPanel) {
        this.snackPanel = snackPanel;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

    public void setBox(JPanel box) {
        this.box = box;
    }

    public void setDispensorPanel(JPanel dispensorPanel) {
        this.dispensorPanel = dispensorPanel;
    }

    public void setMoneyPanel(JPanel moneyPanel) {
        this.moneyPanel = moneyPanel;
    }

    public void setPricePanel(JPanel pricePanel) {
        this.pricePanel = pricePanel;
    }

    public void setWalletPanel(JPanel walletPanel) {
        this.walletPanel = walletPanel;
    }

    public void setRetrievalLabel(JLabel retrievalLabel) {
        this.retrievalLabel = retrievalLabel;
    }

    public void setInsertMoneyLabel1(JLabel insertMoneyLabel1) {
        this.insertMoneyLabel1 = insertMoneyLabel1;
    }

    public void setInsertMoneyLabel2(JLabel insertMoneyLabel2) {
        this.insertMoneyLabel2 = insertMoneyLabel2;
    }

    public void setPriceLabelChips(JLabel priceLabelChips) {
        this.priceLabelChips = priceLabelChips;
    }

    public void setPriceLabelCandy(JLabel priceLabelCandy) {
        this.priceLabelCandy = priceLabelCandy;
    }

    public void setSnackSlots(JLabel[] snackSlots) {
        this.snackSlots = snackSlots;
    }

    public void setMoneySlots(JLabel[] moneySlots) {
        this.moneySlots = moneySlots;
    }

    public void setSnacks(String[] snacks) {
        this.snacks = snacks;
    }

    public void setOptionKey(JLabel optionKey) {
        this.optionKey = optionKey;
    }

    public void setMinusbuttons(JButton[] minusbuttons) {
        this.minusbuttons = minusbuttons;
    }

    public void setPlusButtonNickel(JButton plusButtonNickel) {
        this.plusButtonNickel = plusButtonNickel;
    }

    public void setPlusButtonDime(JButton plusButtonDime) {
        this.plusButtonDime = plusButtonDime;
    }

    public void setPlusButtonQuarter(JButton plusButtonQuarter) {
        this.plusButtonQuarter = plusButtonQuarter;
    }

    public void setPlusButtonDollar(JButton plusButtonDollar) {
        this.plusButtonDollar = plusButtonDollar;
    }

    public void setMinusButtonNickel(JButton minusButtonNickel) {
        this.minusButtonNickel = minusButtonNickel;
    }

    public void setMinusButtonDime(JButton minusButtonDime) {
        this.minusButtonDime = minusButtonDime;
    }

    public void setMinusButtonQuarter(JButton minusButtonQuarter) {
        this.minusButtonQuarter = minusButtonQuarter;
    }

    public void setMinusButtonDollar(JButton minusButtonDollar) {
        this.minusButtonDollar = minusButtonDollar;
    }

    public void setPlusPanelNickel(JPanel plusPanelNickel) {
        this.plusPanelNickel = plusPanelNickel;
    }

    public void setPlusPanelDime(JPanel plusPanelDime) {
        this.plusPanelDime = plusPanelDime;
    }

    public void setPlusPanelQuarter(JPanel plusPanelQuarter) {
        this.plusPanelQuarter = plusPanelQuarter;
    }

    public void setPlusPanelDollar(JPanel plusPanelDollar) {
        this.plusPanelDollar = plusPanelDollar;
    }

    public void setMinusPanelNickel(JPanel minusPanelNickel) {
        this.minusPanelNickel = minusPanelNickel;
    }

    public void setMinusPanelDime(JPanel minusPanelDime) {
        this.minusPanelDime = minusPanelDime;
    }

    public void setMinusPanelQuarter(JPanel minusPanelQuarter) {
        this.minusPanelQuarter = minusPanelQuarter;
    }

    public void setMinusPanelDollar(JPanel minusPanelDollar) {
        this.minusPanelDollar = minusPanelDollar;
    }


    public class SnackMachineController implements ActionListener, Controller{

        SnackMachineModel model;

        public SnackMachineController() {
            try {
                model = new SnackMachineModel();    // Create a snack machine model
                model.migrateDB();                  // Map backend to Model objects
                model.clearProducts();              // Clear out snack objects from previous session.
                model.stockDB();                    // Restock the machine.
                //model.removeSnack("twix");
                model.countItems(initSnackStrings(snacks));
            }
            catch(UnknownHostException u){
                System.out.println("Can't find host -- connection failed.");
                model = null;
            }
        }

        public void updateView(double test1, double test2, double test3){

        }


        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e){

            //// configure option pad button functionality ///
            //
            // 'X' action command --- clears the option console
            // 'A','B','C','D' action commands --- snack row selection
            // '0','1','2','3' action commands --- snack column selection
            //
            if (e.getActionCommand().equals("X")) {
                console.setText("");
                option = "";
                optioncounter = 0;
            } else if (optioncounter < 2 && !e.getActionCommand().equals("+") && !e.getActionCommand().equals("-")) {
                option += e.getActionCommand().toString();
                console.setText(option);
                optioncounter++;
                if (optioncounter == 2) {
                    //console.setText("Purchased");
                    System.out.println(option);
                    System.out.println(optionMap.get(option));
                    if (optionMap.containsKey(option) && payment >= 1.10) {
                        if (option.equals("D0") || option.equals("D1") || option.equals("D2") || option.equals("D3")) {
                            dispensorPanel.remove(retrievalLabel);
                            retrievalLabel = imageToLabelSnack(snackfac.makeSnack(optionMap.get(option)));
                            dispensorPanel.add(retrievalLabel);
                            dispensorPanel.revalidate();
                            dispensorPanel.repaint();
                            payment -= 0.80;
                        } else {
                            dispensorPanel.remove(retrievalLabel);
                            retrievalLabel = imageToLabelSnack(snackfac.makeSnack(optionMap.get(option)));
                            dispensorPanel.add(retrievalLabel);
                            dispensorPanel.revalidate();
                            dispensorPanel.repaint();
                            payment -= 0.80;
                        }
                    } else if (optionMap.containsKey(option) && payment >= 0.80) {
                        if (option.equals("D0") || option.equals("D1") || option.equals("D2") || option.equals("D3")) {
                            dispensorPanel.remove(retrievalLabel);
                            retrievalLabel = imageToLabelSnack(snackfac.makeSnack(optionMap.get(option)));
                            dispensorPanel.add(retrievalLabel);
                            dispensorPanel.revalidate();
                            dispensorPanel.repaint();
                            payment -= 0.80;
                        } else {
                            dispensorPanel.remove(retrievalLabel);
                        }
                    } else System.out.println("Invalid Option");
                    option = "";
                    optioncounter = 0;
                }
            } else if (!e.getActionCommand().equals("+") && !e.getActionCommand().equals("-")) {
                console.setText("");
                option = "";
                option += e.getActionCommand().toString();
                console.setText(option);
                optioncounter = 1;
            } else {
                Object source = e.getSource();
                DecimalFormat df = new DecimalFormat("#.00");
                int padding = 0;

                //// Configure arithmetic functionality to plus buttons ////
                if (source == plusButtonNickel) {
                    payment += .05;

                    // exactly at 0 dollars logic
                    if (payment == 0.00) {
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }

                    // between 0 and 10 dollars Logic
                    else if (payment < 10.0 && payment > 0.00) {
                        if (payment >= 0.80 && payment < 1.10) {
                            insertMoneyLabel1.setForeground(Color.yellow);
                            insertMoneyLabel1.setForeground(Color.yellow);
                        } else if (payment >= 1.10) {
                            insertMoneyLabel1.setForeground(Color.green);
                            insertMoneyLabel1.setForeground(Color.green);
                        }
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                    }

                    // restrict from exceeding 10 dollars
                    else if (payment > 10.00) {
                        insertMoneyLabel1.setForeground(Color.lightGray);
                        insertMoneyLabel1.setForeground(Color.lightGray);
                        payment = 10.00;
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // restrict negative dollar amounts
                    else if (payment < 0.00) {
                        SnackMachineView.this.setPayment(0.00);
                        padding = calculatePadding(payment);
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }
                } else if (source == plusButtonDime) {
                    payment += .10;
                    insertMoneyLabel1.setText("$ " + df.format(payment));

                    // between 0 and 10 dollar logic
                    if (payment <= 10.0 && payment > 0.00) {
                        if (payment >= 0.80 && payment < 1.10) {
                            insertMoneyLabel1.setForeground(Color.yellow);
                            insertMoneyLabel1.setForeground(Color.yellow);
                        } else if (payment >= 1.10) {
                            insertMoneyLabel1.setForeground(Color.green);
                            insertMoneyLabel1.setForeground(Color.green);
                        }
                        insertMoneyLabel1.setFont(new Font("Monospaced", Font.PLAIN, 10));
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // exactly at 0 dollars logic
                    else if (payment == 0.00) {
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }

                    // restrict from exceeding 10 dollars
                    else if (payment > 10.00) {
                        insertMoneyLabel1.setForeground(Color.lightGray);
                        insertMoneyLabel1.setForeground(Color.lightGray);
                        payment = 10.00;
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // restrict negative dollar amounts
                    else if (payment < 0.00) {
                        SnackMachineView.this.setPayment(0.00);
                        padding = calculatePadding(payment);
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }
                } else if (source == plusButtonQuarter) {
                    payment += .25;
                    insertMoneyLabel1.setText("$ " + df.format(payment));

                    // between 0 and 10 dollars Logic
                    if (payment <= 10.0 && payment > 0.00) {
                        if (payment >= 0.80 && payment < 1.10) {
                            insertMoneyLabel1.setForeground(Color.yellow);
                            insertMoneyLabel1.setForeground(Color.yellow);
                        } else if (payment >= 1.10) {
                            insertMoneyLabel1.setForeground(Color.green);
                            insertMoneyLabel1.setForeground(Color.green);
                        }
                        insertMoneyLabel1.setFont(new Font("Monospaced", Font.PLAIN, 10));
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // exactly at 0 dollars logic
                    else if (payment == 0.00) {
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }

                    // restrict from exceeding 10 dollars
                    else if (payment > 10.00) {
                        insertMoneyLabel1.setForeground(Color.lightGray);
                        insertMoneyLabel1.setForeground(Color.lightGray);
                        payment = 10.00;
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // restrict negative dollar amounts
                    else if (payment < 0.00) {
                        SnackMachineView.this.setPayment(0.00);
                        padding = calculatePadding(payment);
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }
                } else if (source == plusButtonDollar) {
                    payment += 1.0;
                    insertMoneyLabel1.setText("$ " + df.format(payment));

                    // between 0 and 10 dollars Logic
                    if (payment <= 10.0 && payment > 0.00) {
                        if (payment >= 0.80 && payment < 1.10) {
                            insertMoneyLabel1.setForeground(Color.yellow);
                            insertMoneyLabel1.setForeground(Color.yellow);
                        } else if (payment >= 1.10) {
                            insertMoneyLabel1.setForeground(Color.green);
                            insertMoneyLabel1.setForeground(Color.green);
                        }
                        insertMoneyLabel1.setFont(new Font("Monospaced", Font.PLAIN, 10));
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // exactly at 0 dollars logic
                    else if (payment == 0.00) {
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }

                    // restrict from exceeding 10 dollars
                    else if (payment > 10.00) {
                        insertMoneyLabel1.setForeground(Color.lightGray);
                        insertMoneyLabel1.setForeground(Color.lightGray);
                        payment = 10.00;
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // restrict negative dollar amounts
                    else if (payment < 0.00) {
                        SnackMachineView.this.setPayment(0.00);
                        padding = calculatePadding(payment);
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }
                }

                //// Configure arithmetic functionality to minus buttons ////
                else if (source == minusButtonNickel) {
                    payment -= .05;
                    insertMoneyLabel1.setText("$ " + df.format(payment));

                    // between 0 and 10 dollars Logic
                    if (payment <= 10.0 && payment > 0.00) {
                        if (payment >= 0.80 && payment < 1.10) {
                            insertMoneyLabel1.setForeground(Color.yellow);
                            insertMoneyLabel1.setForeground(Color.yellow);
                        } else if (payment >= 1.10) {
                            insertMoneyLabel1.setForeground(Color.green);
                            insertMoneyLabel1.setForeground(Color.green);
                        } else {
                            insertMoneyLabel1.setForeground(Color.lightGray);
                            insertMoneyLabel1.setForeground(Color.lightGray);
                        }
                        insertMoneyLabel1.setFont(new Font("Monospaced", Font.PLAIN, 10));
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // exactly at 0 dollars logic
                    else if (payment == 0.00) {
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }

                    // restrict negative dollar amounts
                    else if (payment < 0.00) {
                        SnackMachineView.this.setPayment(0.00);
                        padding = calculatePadding(payment);
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }
                } else if (source == minusButtonDime) {
                    payment -= .10;
                    insertMoneyLabel1.setText("$ " + df.format(payment));

                    // between 0 and 10 dollars Logic
                    if (payment <= 10.0 && payment > 0.00) {
                        if (payment >= 0.80 && payment < 1.10) {
                            insertMoneyLabel1.setForeground(Color.yellow);
                            insertMoneyLabel1.setForeground(Color.yellow);
                        } else if (payment >= 1.10) {
                            insertMoneyLabel1.setForeground(Color.green);
                            insertMoneyLabel1.setForeground(Color.green);
                        } else {
                            insertMoneyLabel1.setForeground(Color.lightGray);
                            insertMoneyLabel1.setForeground(Color.lightGray);
                        }
                        insertMoneyLabel1.setFont(new Font("Monospaced", Font.PLAIN, 10));
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // exactly at 0 dollars logic
                    else if (payment == 0.00) {
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }

                    // restrict negative dollar amounts
                    else if (payment < 0.00) {
                        SnackMachineView.this.setPayment(0.00);
                        padding = calculatePadding(payment);
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }
                } else if (source == minusButtonQuarter) {
                    payment -= .25;
                    insertMoneyLabel1.setText("$ " + df.format(payment));

                    // between 0 and 10 dollars Logic
                    if (payment <= 10.0 && payment > 0.00) {
                        if (payment >= 0.80 && payment < 1.10) {
                            insertMoneyLabel1.setForeground(Color.yellow);
                            insertMoneyLabel1.setForeground(Color.yellow);
                        } else if (payment >= 1.10) {
                            insertMoneyLabel1.setForeground(Color.green);
                            insertMoneyLabel1.setForeground(Color.green);
                        } else {
                            insertMoneyLabel1.setForeground(Color.lightGray);
                            insertMoneyLabel1.setForeground(Color.lightGray);
                        }
                        insertMoneyLabel1.setFont(new Font("Monospaced", Font.PLAIN, 10));
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // exactly at 0 dollars logic
                    else if (payment == 0.00) {
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }

                    // restrict negative dollar amounts
                    else if (payment < 0.00) {
                        SnackMachineView.this.setPayment(0.00);
                        padding = calculatePadding(payment);
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }
                } else {
                    payment -= 1.0;
                    insertMoneyLabel1.setText("$ " + df.format(payment));

                    // between 0 and 10 dollars Logic
                    if (payment <= 10.0 && payment > 0.00) {
                        if (payment >= 0.80 && payment < 1.10) {
                            insertMoneyLabel1.setForeground(Color.yellow);
                            insertMoneyLabel1.setForeground(Color.yellow);
                        } else if (payment >= 1.10) {
                            insertMoneyLabel1.setForeground(Color.green);
                            insertMoneyLabel1.setForeground(Color.green);
                        } else {
                            insertMoneyLabel1.setForeground(Color.lightGray);
                            insertMoneyLabel1.setForeground(Color.lightGray);
                        }
                        insertMoneyLabel1.setFont(new Font("Monospaced", Font.PLAIN, 10));
                        insertMoneyLabel1.setText("$ " + df.format(payment));
                        insertMoneyLabel2.setText(" Deposited ");
                        padding = calculatePadding(payment);
                        insertMoneyLabel1.setPreferredSize(new Dimension(padding, 45));
                    }

                    // exactly at 0 dollars logic
                    else if (payment == 0.00) {
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }

                    // restrict negative dollar amounts
                    else if (payment < 0.00) {
                        SnackMachineView.this.setPayment(0.00);
                        padding = calculatePadding(payment);
                        styleInsertMoneyLabel1(insertMoneyLabel1);
                        styleInsertMoneyLabel2(insertMoneyLabel2);
                        insertMoneyLabel1.setText("Snack Machine");
                        insertMoneyLabel2.setText("Version 1.0");
                    }
                }
            }
        }

    }


    /**
     *
     * @param e
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void windowClosing(WindowEvent e) {
    }

    /**
     *
     * @param e
     */
    @Override
    public void windowClosed(WindowEvent e) {
       System.out.println("Window closed. Program terminated");
    }

    /**
     *
     * @param e
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }


    /*
        snackSlots = new JLabel[snacks.length*4];
        int snackCount = -1;
        for (int i = 0; i < snackSlots.length; i++) {
            if(i%4!=0) {
                snackCount++;
                snackSlots[i] = imageToLabel(snackfac.makeSnack(snacks[snackCount]));
            }
            else{
                snackCount = 0;
                snackSlots[i] = imageToLabel(snackfac.makeSnack(snacks[snackCount]));
            }
        }
        */

}