package VendingMachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    static VendingMachine vendingMachine;


    @Before
    public void init(){
        // setting up the common varibles that are being used
        vendingMachine =  new VendingMachine();
    }

    @Test
     public void getNameAndPrice(){
        String name = "Cookies";
        double price = 3.99;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        assertEquals(3.99,vendingMachineItem.getPrice(),.0);
        assertEquals("Cookies",vendingMachineItem.getName());
    }

    @Test
     public void addItemTestA(){
        String name = "Cookies";
        double price = 3.99;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.A_CODE);
        assertEquals(vendingMachineItem,vendingMachine.getItem(VendingMachine.A_CODE));

    }
    @Test
     public void addItemTestB(){
        String name = "Chips";
        double price = 0.99;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.B_CODE);
        assertEquals(vendingMachineItem,vendingMachine.getItem(VendingMachine.B_CODE));

    }
    @Test
    public void addItemTestC(){
        String name = "Fries";
        double price = 2.99;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.C_CODE);
        assertEquals(vendingMachineItem,vendingMachine.getItem(VendingMachine.C_CODE));

    }
    @Test
     public void addItemTestD(){
        String name = "Wine";
        double price = 13.99;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.D_CODE);
        assertEquals(vendingMachineItem,vendingMachine.getItem(VendingMachine.D_CODE));

    }

    @Test
    // This test is going to return false
    public void makePurchaseTestF(){
        String name = "Fries";
        double price = 2.99;
        double money = .99;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.C_CODE);
        vendingMachine.insertMoney(money);
        assertFalse(vendingMachine.makePurchase(VendingMachine.C_CODE));
    }
    @Test
    // This test is going to return false
    public void makePurchaseTestT(){
        String name = "Whisky";
        double price = 34.99;
        double money = 36.00;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.C_CODE);
        vendingMachine.insertMoney(money);
        assertTrue(vendingMachine.makePurchase(VendingMachine.C_CODE));
    }
    @Test
    public void getBalanceTestF(){
        String name = "Milk";
        double price = 2.99;
        double money = 12.00;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.C_CODE);
        vendingMachine.insertMoney(money);
        assertEquals(money,vendingMachine.getBalance(),.0);
    }

    @Test
    public void getBalanceTestT(){
        String name = "Water";
        double price = 0.01;
        double money = 1.00;
        double leftovermoney = .99;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.C_CODE);
        vendingMachine.insertMoney(money);
        vendingMachine.makePurchase(VendingMachine.C_CODE);
        assertEquals(leftovermoney,vendingMachine.getBalance(),.0);
        //water should be free
    }

    @Test
    public void returnChangeTestF(){
        String name = "Pickle Rick";
        double price = 1000.99;
        double money = 1.00;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.C_CODE);
        vendingMachine.insertMoney(money);
        vendingMachine.makePurchase(VendingMachine.C_CODE);
        assertEquals(money,vendingMachine.returnChange(),.0);
    }

    @Test
    public void returnChangeTestT(){
        String name = "Wubba lubba dub dub";
        double price = 100000.99;
        double money = 100000.99;
        double leftovermoney = 0;
        VendingMachineItem vendingMachineItem = new VendingMachineItem(name,price);
        vendingMachine.addItem(vendingMachineItem,VendingMachine.C_CODE);
        vendingMachine.insertMoney(money);
        vendingMachine.makePurchase(VendingMachine.C_CODE);
        assertEquals(0,vendingMachine.returnChange(),.0);
    }

}
