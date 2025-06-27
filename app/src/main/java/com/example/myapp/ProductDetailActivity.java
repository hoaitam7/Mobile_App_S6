package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);

        ImageView image = findViewById(R.id.ivProductImage);
        TextView name = findViewById(R.id.tvProductName);
        TextView desc = findViewById(R.id.tvProductDesc);
        TextView price = findViewById(R.id.tvProductPrice);
        // Nhận dữ liệu
        Intent intent = getIntent();
//        name.setText(intent.getStringExtra("productName"));
        desc.setText(intent.getStringExtra("productDesc"));
        price.setText("Giá: " + intent.getStringExtra("productPrice"));
        image.setImageResource(intent.getIntExtra("productImage", R.drawable.mwc));

        //nút back
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent goHome = new Intent(ProductDetailActivity.this, HomeActivity.class);
            goHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(goHome);
            finish();
        });

        //nút giỏ hàng
        ImageView ivCart = findViewById(R.id.ivCart);

        ivCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class); // thay CurrentActivity bằng tên activity hiện tại
                startActivity(intent);
            }
        });


    }
}