package com.example.browsesolar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

import org.jetbrains.annotations.NotNull;

import es.dmoral.toasty.Toasty;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.browsesolar.R.drawable.buttongradient;
import static com.example.browsesolar.R.drawable.buttongradient2;


public class MainActivity extends AppCompatActivity
{
    ImageView sun, dayland  , nightland;
    DayNightSwitch dayNightSwitch;
    RelativeLayout layout;
    ImageButton info ;
    Button searchbtn , covidbutton ,okaybtn , instagram,facebook, amazon,flipkart,google,meet,gmail,youtube;
    EditText googlesearchengine , citysearchet ;
    MeowBottomNavigation bottomNavigation ;
    TabLayout tabLayout;
    TabItem tabItem1, tabItem2,tabItem3 ,tabItem4;
    PageAdapter pagerAdapter;
    NavigationView navigationView;
    public DrawerLayout drawerLayout ;
    private BottomSheetDialog bottomSheetDialog;
    PopupWindow popupWindow;
    TextView htv;
    TextView ctv , citynametv;
    AutoCompleteTextView citynamegoogle;
    String[] urls = new String[9];
    String apikey = "2473e808897e197c194cd68a8874f60b";
    String[] listitem;

    @SuppressLint({"ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //color change of NAVIGATION BAR


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(Color.parseColor("#FFC300"));
        }
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);


        instagram=findViewById(R.id.instagram);
        facebook=findViewById(R.id.facebook);
        amazon=findViewById(R.id.amazon);
        flipkart=findViewById(R.id.flipkart);
        google=findViewById(R.id.google);
        meet=findViewById(R.id.meet);
        gmail=findViewById(R.id.gmail);
        youtube=findViewById(R.id.youtube);

        tabLayout=findViewById(R.id.tablayout1);
        tabItem1=findViewById(R.id.tab1);
        tabItem2=findViewById(R.id.tab2);
        tabItem3=findViewById(R.id.tab3);
        tabItem4=findViewById(R.id.tab4);
        drawerLayout = findViewById(R.id.drawer); //rightside
        okaybtn= findViewById(R.id.okaybutton);

        listitem = getResources().getStringArray(R.array.city);

        htv=findViewById(R.id.humiditytv);
        ctv=findViewById(R.id.celsiustv);
        citynamegoogle= findViewById(R.id.googlesearch);



        navigationView=findViewById(R.id.nav_view);


        layout=findViewById(R.id.layout1);
        info =  findViewById(R.id.btn_weather);
        searchbtn=findViewById(R.id.search);
        covidbutton=findViewById(R.id.covidweb);
        googlesearchengine= findViewById(R.id.googlesearch);
        bottomNavigation= findViewById(R.id.bottom_navigation);
        sun = findViewById(R.id.sun);
        dayland = findViewById(R.id.day_landscape);
        nightland = findViewById(R.id.night_landscape);
        citynametv= findViewById(R.id.cityname);


//BUTTON URL
        urls[0]="https://www.google.com/";
        urls[1]="https://www.facebook.com/";
        urls[2]="https://mail.google.com/";
        urls[3]="https://www.amazon.in/";
        urls[4]="https://www.flipkart.com/";
        urls[5]="https://meet.google.com/";
        urls[6]="https://www.youtube.com/";
        urls[7]="https://www.instagram.com/";
        urls[8]="https://www.cowin.gov.in/";

        google.setOnClickListener(new View.OnClickListener() {
              @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),webActivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
            }
         });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),webActivity.class);
                intent.putExtra("links",urls[1]);
                startActivity(intent);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),webActivity.class);
                intent.putExtra("links",urls[7]);
                startActivity(intent);
            }
        });
        meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),webActivity.class);
                intent.putExtra("links",urls[5]);
                startActivity(intent);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),webActivity.class);
                intent.putExtra("links",urls[6]);
                startActivity(intent);
            }
        });
        flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),webActivity.class);
                intent.putExtra("links",urls[4]);
                startActivity(intent);
            }
        });
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),webActivity.class);
                intent.putExtra("links",urls[2]);
                startActivity(intent);
            }
        });
        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),webActivity.class);
                intent.putExtra("links",urls[3]);
                startActivity(intent);
            }
        });

//news api
        ViewPager viewPager=findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.tablayout1);
       pagerAdapter = new PageAdapter(getSupportFragmentManager(), 4) ;


        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


//STRING ADAPTER
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,listitem);
        citynamegoogle.setAdapter(adapter);



//BOTTOM SHEET
        bottomSheetDialog = new BottomSheetDialog(MainActivity.this,R.style.BottomSheetTheme);

        View sheetview = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottomdrawerlayout,
                findViewById(R.id.bottomlayout));



//SIDE BAR
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.settings: Toast.makeText(MainActivity.this,"Setting", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.downloads:Toast.makeText(MainActivity.this,"Downloading", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.bookmark:Toast.makeText(MainActivity.this,"Bookmark", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.feedback:Toast.makeText(MainActivity.this,"Feedbacks", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.like:Toast.makeText(MainActivity.this,"Like", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.share:Toast.makeText(MainActivity.this,"Share", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.logout:    finish();
                                          System.exit(0);

                        break;
                    default:
                        return true;
                }
                return true;
            }
        });



//LISTEN FOR SCROLL OR PAGE CHANGE
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


//BOTTOM NAVIGATION 1 LOGIC
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.baseline));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.person_24));


        bottomNavigation.show(2,true);
        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){

                    case 1:
                                 bottomSheetDialog.setContentView(sheetview);
                                 bottomSheetDialog.show();
                        break;
                    case 2: Toasty.info(MainActivity.this, "2",Toasty.LENGTH_SHORT).show();
                        break;
                    case 3: drawerLayout.openDrawer(GravityCompat.END);
                        break;
                }
                return null;
            }
        });

// GOOGLE SEARCH BUTTON LOGIC
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getweather(v);
              String content = googlesearchengine.getText().toString();
              citynamegoogle.setText(content);
              //  Toasty.info(MainActivity.this, googlesearchengine.getText().toString() ,Toasty.LENGTH_LONG).show();
            }
        });


//SWITCH_LOGIC
        dayNightSwitch = findViewById(R.id.day_night_switch);
        sun.setTranslationY(-130);
        bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FFC300"));
        covidbutton.setBackgroundResource(buttongradient);
        tabLayout.setBackgroundResource(buttongradient);
        navigationView.setBackgroundResource(buttongradient);
        sheetview.setBackgroundResource(buttongradient);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));

        covidbutton.setTextColor(Color.parseColor("#000000"));

 //COVID WEBVIEW

    covidbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(getApplicationContext(),webActivity.class);
        intent.putExtra("links",urls[8]);
        startActivity(intent);
    }
});



// WEATHER REPORT
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater  layoutInflater =  (LayoutInflater)  MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.activity_popup,null);
                   popupWindow = new  PopupWindow(customView,LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);


                okaybtn=(Button) customView.findViewById(R.id.okaybutton);
                citynametv= (EditText) customView.findViewById(R.id.citysearch);


                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(drawerLayout, Gravity.CENTER, 10, 10);
                popupWindow.update(0,0,600,800);

                okaybtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View a) {



                        popupWindow.dismiss();


                    }
                });


            }
        });


//DAYSWITCH

        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night)
                {
                    sun.animate().translationY(130).setDuration(1000);
                    dayland.animate().alpha(0).setDuration(1300);
                    bottomNavigation.setBackgroundBottomColor(Color.parseColor("#0047AB"));
                    covidbutton.setBackgroundResource(buttongradient2);
                    tabLayout.setBackgroundResource(buttongradient2);
                    navigationView.setBackgroundResource(buttongradient2);
                    sheetview.setBackgroundResource(buttongradient2);


                    covidbutton.setTextColor(Color.parseColor("#FFFFFF"));

                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setNavigationBarColor(Color.parseColor("#0047AB"));
                    }


                    layout.setBackgroundResource(R.drawable.darkthme);
                }
                else {
                    sun.animate().translationY(-130).setDuration(1000);
                    dayland.animate().alpha(1).setDuration(1300);
                    layout.setBackgroundResource(R.drawable.lighttheme);
                    bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FFC300"));
                    covidbutton.setBackgroundResource(buttongradient);
                    tabLayout.setBackgroundResource(buttongradient);
                    navigationView.setBackgroundResource(buttongradient);
                    sheetview.setBackgroundResource(buttongradient);



                    covidbutton.setTextColor(Color.parseColor("#000000"));


                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setNavigationBarColor(Color.parseColor("#FFC300"));
                    }

                }
            }
        });

 // STATUS BAR INVISIBLE
        if(Build.VERSION.SDK_INT>=19 && Build.VERSION.SDK_INT<21)
        {
            SetWindowsFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,true);
        }
        if (Build.VERSION.SDK_INT>=19){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT>=21){
            SetWindowsFlag(this,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
    }

    private static void SetWindowsFlag(Activity activity, final int Bits , Boolean on)
    {
        Window win = activity.getWindow();
        WindowManager.LayoutParams Winparams = win.getAttributes();
        if (on){
            Winparams.flags |=Bits;
        }
        else{
            Winparams.flags &= ~Bits;
        }win.setAttributes(Winparams);
    }

    public void getweather(View view){

        ctv=findViewById(R.id.celsiustv);
        citysearchet= findViewById(R.id.citysearch);
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.openweathermap.org/data/2.5/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        weatherapi myapi =retrofit.create(weatherapi.class);
        Call<example> exampleCall = myapi.getweather(googlesearchengine.getText().toString().trim(),apikey);
        exampleCall.enqueue(new Callback<example>() {
            @Override
            public void onResponse(Call<example> call, Response<example> response) {
                if(response.code() == 404){
                    Toasty.error(MainActivity.this,"Wrong City",Toasty.LENGTH_SHORT).show();
                }
                else if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_LONG).show();

                }
                example mydata = response.body();
                Main main = mydata.getMain();
                Double temp = main.getTemp();
                Integer temperature =(int) (temp - 273.14);
                Integer humidity = main.getHumidity();
                htv.setText(String.valueOf("Humidity: "+humidity+"%"));
                ctv.setText(String.valueOf(temperature+ "°C"));
                citynametv.setText(googlesearchengine.getText().toString());

            }

            @Override
            public void onFailure(Call<example> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}