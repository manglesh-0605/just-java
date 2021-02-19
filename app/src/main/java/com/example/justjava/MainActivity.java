package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffees=1,pricePerCup=10,price=10;
    public String msg;
    boolean isWhippedCreamChecked=false,isChocolateChecked=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void increment(View v){
        numberOfCoffees++;
        displayQuantity(numberOfCoffees);
        price=calculatePrice(numberOfCoffees);
        displayPrice(price);

    }

    public void decrement(View v){
        if(numberOfCoffees>0) {
            numberOfCoffees--;
            displayQuantity(numberOfCoffees);
            price=calculatePrice(numberOfCoffees);
            displayPrice(price);
        }

    }


    public void submit(View v){
        EditText userName=(EditText) findViewById(R.id.uname);
        String name=userName.getText().toString();
        TextView priceText=(TextView) findViewById(R.id.price_text);

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedcreame);
        CheckBox chocolate=(CheckBox) findViewById(R.id.chocolate);


        //checking for whipped cream topping.
        if(whippedCream.isChecked()){
            isWhippedCreamChecked=true;
        }else{
            isWhippedCreamChecked=false;
        }
        //checking the chocolate topping
        if(chocolate.isChecked()){
            isChocolateChecked=true;
        }else{
            isChocolateChecked=false;
        }

        if(name.isEmpty()) {
            Toast.makeText(this,"Enter your name please",Toast.LENGTH_SHORT).show();

        }else{

            if (numberOfCoffees > 0) {
                String summery = createOrderSummery(name,isWhippedCreamChecked,isChocolateChecked);
                displayMessage(summery);
                priceText.setText("order summery");

            } else {

                msg = name + " you didn't order anything";
//                displayMessage(msg);
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

            }

        }
    }

    private void displayQuantity(int number){
        TextView text=(TextView) findViewById(R.id.quantity_value);
        text.setText("" + number);

    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceValue = (TextView) findViewById(R.id.price_value);
        priceValue.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message){
        TextView priceValue = (TextView) findViewById(R.id.price_value);
        priceValue.setText(message);

    }

    private int calculatePrice(int numberOfCoffees)
    {
        return numberOfCoffees*pricePerCup;


    }


    private String createOrderSummery(String name,boolean isChecked,boolean isChocolateChecked){
        return "name : "+name+"\n"+
                "quantity : "+numberOfCoffees+"\n"+
                "withWhippedCream : "+isChecked+"\n"+
                "chocolate :"+isChocolateChecked+"\n"+
                "Total :"+price+"\n"+
                "Thank You";


    }


}