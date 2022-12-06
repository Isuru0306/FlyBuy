package com.flybuy.controllers;

import android.content.Context;
import android.content.Intent;

import com.flybuy.model.ItemData;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ItemController {
    Context context;
    int potion;
    Intent intent;
    List<ItemData> list;


    public ItemController(Context context, int potion, Intent intent, List<ItemData> list) {
        this.context = context;
        this.potion = potion;
        this.intent = intent;
        this.list = list;

        writeFile(list.get(potion).getQty(), "qty");
        writeFile(list.get(potion).getPlaceName(), "nameItem");
        writeFile(list.get(potion).getRating(), "rating");
        writeFile(list.get(potion).getPrice(), "price");
        writeFile(list.get(potion).getImageUrl().toString(), "imageUrlHeading");
        writeFile(list.get(potion).getAbout(), "about");

        openDetails();

    }

    public void writeFile(String data, String filename) {
        File path = context.getFilesDir();
        System.out.println(path);
        try {

            FileOutputStream writer = new FileOutputStream(new File(path, filename ));
            writer.write(data.getBytes());
            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void openDetails(){
        context.startActivity(this.intent);
    }
}
