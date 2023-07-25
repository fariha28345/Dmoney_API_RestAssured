package testrunner;

import controller.Transaction;
import controller.User;
import io.restassured.path.json.JsonPath;
import model.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class TrnxTestRunner{
    Transaction transaction;
    @Test(priority = 1, description = "Deposit from system to agent")
    public void depositToAgent() throws IOException, ParseException {
        transaction = new Transaction();

        JSONArray userArray = Utils.readJSONArray();
        JSONObject userObj = (JSONObject) userArray.get(userArray.size()-1);
        String from_account = "SYSTEM";
        String to_account = userObj.get("phone_number").toString();
        double amount = 2000;

        JsonPath res = transaction.depositMoney(from_account, to_account, amount);
        String message = res.get("message");
        //System.out.println(message);
        Assert.assertTrue(message.contains("Deposit successful"));
    }
    @Test(priority = 2, description = "Deposit from agent to customer")
    public void depositToCustomer() throws IOException, ParseException {
        transaction = new Transaction();

        JSONArray userArray = Utils.readJSONArray();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size()-1);
        JSONObject userObj2 = (JSONObject) userArray.get(userArray.size()-3);
        String from_account = userObj1.get("phone_number").toString();
        String to_account = userObj2.get("phone_number").toString();
        double amount = 1500;

        JsonPath res = transaction.depositMoney(from_account, to_account, amount);
        String message = res.get("message");
        Assert.assertTrue(message.contains("Deposit successful"));
    }

    @Test(priority = 3, description = "Withdraw money by customer to the agent")
    public void withdrawMoneyByCustomer() throws IOException, ParseException {
        transaction = new Transaction();

        JSONArray userArray = Utils.readJSONArray();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size()-3);
        JSONObject userObj2 = (JSONObject) userArray.get(userArray.size()-1);
        String from_account = userObj1.get("phone_number").toString();
        String to_account = userObj2.get("phone_number").toString();
        double amount = 500;

        JsonPath res = transaction.withdrawMoney(from_account, to_account, amount);
        String message = res.get("message");
        //System.out.println(message);
        Assert.assertTrue(message.contains("Withdraw successful"));
    }

    @Test(priority = 4, description = "Send money from a customer to another customer")
    public void sendMoneyToAnotherCustomer() throws IOException, ParseException {
        transaction = new Transaction();

        JSONArray userArray = Utils.readJSONArray();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size()-3);
        JSONObject userObj2 = (JSONObject) userArray.get(userArray.size()-2);
        String from_account = userObj1.get("phone_number").toString();
        String to_account = userObj2.get("phone_number").toString();
        double amount = 500;

        JsonPath res = transaction.sendMoney(from_account, to_account, amount);
        String message = res.get("message");
        //System.out.println(message);
        Assert.assertTrue(message.contains("Send money successful"));
    }

    @Test(priority = 5, description = "Payment to a merchant by the recipient customer")
    public void paymentToMerchant() throws IOException, ParseException {
        transaction = new Transaction();

        JSONArray userArray = Utils.readJSONArray();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size()-2);
        String from_account = userObj1.get("phone_number").toString();
        String to_account = "01686606905";
        double amount = 100;

        JsonPath res = transaction.payment(from_account, to_account, amount);
        String message = res.get("message");
        //System.out.println(message);
        Assert.assertTrue(message.contains("Payment successful"));
    }

    @Test(priority = 6, description = "Check balance of the recipient customer")
    public void checkBalanceOfCustomer() throws IOException, ParseException {
        transaction = new Transaction();

        JSONArray userArray = Utils.readJSONArray();
        JSONObject userObj = (JSONObject) userArray.get(userArray.size()-2);
        String phone_number = userObj.get("phone_number").toString();
        JsonPath res = transaction.checkBalance(phone_number);
        String message = res.get("message");
        //System.out.println(message);
        Assert.assertTrue(message.contains("User balance"));
    }
}
