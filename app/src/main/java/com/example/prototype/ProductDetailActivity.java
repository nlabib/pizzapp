package com.example.prototype;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.prototype.models.Extras;
import com.example.prototype.models.PizzaModel;
import com.google.android.material.checkbox.MaterialCheckBox;
import java.util.ArrayList;


public class ProductDetailActivity extends AppCompatActivity {
    ArrayList<PizzaModel> cart, pizzaModels;
    ArrayList<Extras> extras;
    int pos, defaultPos;
    Button addToCart;
    double price, curPrice;
    int quantity = 1;
    ImageView pizzaImage, next, prev, add, sub;
    TextView name, quant, priceTv;
    MaterialCheckBox tomato, salami, sausage, cheese, stoneOven, pepper, fanta, sprite, coke, water;
    Extras tomatoEX, salamiEX, sausageEX, cheeseEX, stoneOvenEX, pepperEX, fantaEX, spriteEX, cokeEX, waterEX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_product_detail);

        pos = getIntent().getIntExtra("pos", 0);

        defaultPos = -1;

        pizzaImage = findViewById(R.id.pizzaImage);
        priceTv = findViewById(R.id.price);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        add = findViewById(R.id.addQuan);
        sub = findViewById(R.id.subQuan);
        name = findViewById(R.id.pizzaName);
        quant = findViewById(R.id.quantityText);
        addToCart = findViewById(R.id.addToCart);

        //Food
        tomato = findViewById(R.id.tomato);
        salami = findViewById(R.id.salami);
        sausage = findViewById(R.id.sausage);
        cheese = findViewById(R.id.extraCheese);
        stoneOven = findViewById(R.id.ovenbkd);
        pepper = findViewById(R.id.pepper);
        fanta = findViewById(R.id.fanta);
        sprite = findViewById(R.id.sprite);
        coke = findViewById(R.id.coke);
        water = findViewById(R.id.water);

        //Food Prices
        
        tomatoEX = new Extras("Tomato", 1.5);
        salamiEX = new Extras("Salami", 2.5);
        sausageEX = new Extras("Sausage", 2.5);
        cheeseEX = new Extras("Cheese", 2.5);
        stoneOvenEX = new Extras("StoneOven", 3.5);
        pepperEX = new Extras("Pepper", 1.5);

        waterEX = new Extras("Water", 2.5);
        cokeEX = new Extras("Coke", 2.5);
        fantaEX = new Extras("Fanta", 2.5);
        spriteEX = new Extras("Sprite", 2.5);

        extras = new ArrayList<>();
        cart = new ArrayList<>();
        pizzaModels = new ArrayList<>();


        pizzaImage.setImageResource(pizzaModels.get(pos).getImage());
        name.setText(pizzaModels.get(pos).getName());
        curPrice = pizzaModels.get(pos).getPrice();
        price = curPrice;
        priceTv.setText(curPrice + "");

        checkStates();

        add.setOnClickListener(v -> {
            quantity++;
            quant.setText(quantity + "");
            price = price + curPrice;
            priceTv.setText(String.format("%.2f", price));
        });
        sub.setOnClickListener(v -> {
            if (quantity>1){
                quantity--;
                quant.setText(quantity + "");
                price = price - curPrice;
                priceTv.setText(String.format("%.2f", price));
            }
        });

        next.setOnClickListener(v -> {
            setViews(true);
        });

        prev.setOnClickListener(v -> {
            setViews(false);
        });

        addToCart.setOnClickListener(v -> {
            cart.add(new PizzaModel(pizzaModels.get(pos).getImage(), pizzaModels.get(pos).getName(), price, extras, quantity));
        });

    }

    private void checkStates() {
        water.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(waterEX);
            } else {
                price = price - 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(waterEX);
            }
        });

        fanta.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(fantaEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(fantaEX);
            }
        });

        coke.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(cokeEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(cokeEX);
            }
        });

        sprite.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(spriteEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(spriteEX);
            }
        });

        // -----------------------------------------------------------

        sausage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(sausageEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(sausageEX);
            }
        });

        salami.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(salamiEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(salamiEX);
            }
        });

        tomato.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(tomatoEX);
            } else {
                price = price - 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(tomatoEX);
            }
        });

        cheese.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(cheeseEX);
            } else {
                price = price - 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(cheeseEX);
            }
        });

        pepper.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(pepperEX);
            } else {
                price = price - 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(pepperEX);
            }
        });

        stoneOven.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 3.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(stoneOvenEX);
            } else {
                price = price - 3.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(stoneOvenEX);
            }
        });

    }

    private void setViews(boolean b) {
        if (b){
            if (pos < 5){
                pos++;
                pizzaImage.setImageResource(pizzaModels.get(pos).getImage());
                name.setText(pizzaModels.get(pos).getName());
                curPrice = pizzaModels.get(pos).getPrice();
                price = curPrice;
                priceTv.setText(curPrice + "");
                quantity = 1;
                quant.setText(quantity + "");
                extras.clear();
            }
        } else {
            if (pos>0) {
                pos--;
                pizzaImage.setImageResource(pizzaModels.get(pos).getImage());
                name.setText(pizzaModels.get(pos).getName());
                curPrice = pizzaModels.get(pos).getPrice();
                price = curPrice;
                priceTv.setText(curPrice + "");
                quantity = 1;
                extras.clear();
                quant.setText(quantity + "");
            }
        }
    }
}