package com.bancusoft.list.Views;
import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.list.Helpers.Utils;



public class BaseActivity  extends AppCompatActivity {
    protected void show(String message){
        Utils.show(this,message);
    }
}

