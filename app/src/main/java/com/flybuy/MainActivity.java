package com.flybuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.flybuy.adapter.ItemAdapter;
import com.flybuy.model.ItemData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    ItemAdapter itemAdapter;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        List<ItemData> itemDataList = new ArrayList<>();
        itemDataList.add(new ItemData(
                "Mask",
                "5.00",
                "$70",
                R.drawable.mask,
                "At a time when the people worshipped trees and animals, " +
                        "masks were an indispensable part of Sri Lankan rituals and ceremonies. " +
                        "Now centuries later they are more of an interesting oddity. However, " +
                        "the traditional mask industry is still a thriving business that continues to " +
                        "fascinate both locals and tourists alike ",
                "7"));

        itemDataList.add(new ItemData(
                "Traditional Mask Wall Art",
                "4.5",
                "$50",
                R.drawable.mask3,
                "Traditional Sri Lankan crafts are vital industries in many " +
                        "parts of the island, and include: drum making; " +
                        "mat weaving; handloom; wood carving and mask making",
                "2"));

        itemDataList.add(new ItemData(
                "DIAMONDS, GEMS & JEWELLERY",
                "4.5",
                "$70",
                R.drawable.diamond,
                "As one of the most important gemstone producing countries in the world," +
                        "Sri Lanka is known for the export of top quality blue sapphire, and 75 " +
                        "other precious gemstones to the global market. Moreover, the country is also " +
                        "a global leader in providing gemstone and " +
                        "diamond faceting services and manufacturing precious jewellery.",
                "6"));

        itemDataList.add(new ItemData(
                "CEYLON TEA",
                "5.00",
                "$40",
                R.drawable.tea,
                "Ceylon Tea is a cherished name among the " +
                        "global tea drinkers for its finest quality, orthodox methods of " +
                        "harvesting and production, and purity from chemicals. While Ceylon Black Tea " +
                        "is the heart of the country’s tea production, the time is high for Sri Lankan Ceylon " +
                        "Tea manufacturers to diversity tea types, specialities, and flavours.",
                "8"));

        itemDataList.add(new ItemData(
                " Samahan Tea",
                "4.5",
                "$15",
                R.drawable.samhan,
                "Samahan is a 100% natural instant Ayurvedic drink. It is a very " +
                        "concentrated herbal preparation in the form of a powder, which is diluted with water. " +
                        "After drinking, there is an immediate supply of energy." +
                        "For flu and colds, it relieves upper respiratory tract pain.",
                "5"));

        itemDataList.add(new ItemData(
                "SOBAKO SRI LANKAN BASMATHI",
                "4.5",
                "$70",
                R.drawable.lankabasmathi,
                "Basmati rice is simply different; it’s just not the regular rice you eat. " +
                        "This one has a unique taste and aroma. The word “basmati” means “fragrant” " +
                        "or “full of aroma”. " +
                        "In some areas, basmati rice is known as the “queen of perfumed rice.”",
                "9"));

        itemDataList.add(new ItemData(
                "Cinnamon",
                "4.5",
                "$290",
                R.drawable.cinnomon,
                "Cinnamon is a spice obtained from the inner bark of several " +
                        "tree species from the genus Cinnamomum. Cinnamon is used mainly as an " +
                        "aromatic condiment and flavouring additive in a wide variety of cuisines, " +
                        "sweet and savoury dishes, breakfast cereals, snack foods, teas, and traditional foods",
                "1kg"));
        itemDataList.add(new ItemData(
                "Harischandra Coffee",
                "6.00",
                "$110",
                R.drawable.coffe,
                "Is coffee grown in Sri Lanka?\n" +
                        "Image result for harischandra coffee\n" +
                        "The varieties of coffee grown in Sri Lanka are mainly Arabica " +
                        "coffee, Robusta coffee, and Liberica coffee. The last isn't, however, considered " +
                        "to be commercially important. A major coffee variety with Ethiopian roots, " +
                        "Arabica coffee favors regions of cooler climes with higher (over 800m) elevations",
                "10"));



        setTopPlacesRecycler(itemDataList);


    }

    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {

            finishAffinity();

        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    private  void setTopPlacesRecycler(List<ItemData> itemDataList){

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
//        topPlacesRecycler.setLayoutManager(layoutManager);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        topPlacesRecycler.setLayoutManager(manager);
        itemAdapter = new ItemAdapter(this, itemDataList);
        topPlacesRecycler.setAdapter(itemAdapter);

    }
}