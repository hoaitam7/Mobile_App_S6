package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        //ánh  xạ id của  layout chứa product vào biến
        LinearLayout cardProduct1 = findViewById(R.id.cardProduct1);
        //thêm sư kiện click
        cardProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
                // Gửi thêm thông tin sản phẩm nếu muốn (vd: tên, mô tả, ảnh)
                intent.putExtra("productName", "Tên sản phẩm");
                intent.putExtra("productDesc", "Mô tả ngắn...");
                intent.putExtra("productPrice", "250.000đ");
                intent.putExtra("productImage", R.drawable.mwc);
                startActivity(intent);
            }
        });
        //ivUser bat su kien nút UserInfor
        ImageView ivUser = findViewById(R.id.ivUser);
        ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, UserInforActivity.class);
                startActivity(intent);
            }
        });

        //ivCart bat su kien sang CartActivity
        ImageView ivCart = findViewById(R.id.ivCart);
        ivCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });



    }
}