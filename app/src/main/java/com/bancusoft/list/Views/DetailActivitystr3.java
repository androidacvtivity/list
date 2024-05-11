package com.bancusoft.list.Views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bancusoft.list.Helpers.Utils;
import com.bancusoft.list.R;
import com.bancusoft.list.Retrofit.Scientist;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivitystr3 extends AppCompatActivity{
    //Let's define our instance fields
    private TextView nameTV,descriptionTV,galaxyTV,starTV,serviciuTV, sectiaTV, departTV, phoneTV, phoneinternalTV, emailTV, personalinfoTV,
            formnameTV,phonemobilTV, floorTV, officeTV;
    //  private FloatingActionButton editFAB;
    private Scientist receivedScientist;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        nameTV= findViewById(R.id.nameTVs);
        descriptionTV= findViewById(R.id.descriptionTVs);
        galaxyTV= findViewById(R.id.galaxyTVs);
        starTV= findViewById(R.id.starTVs);
        serviciuTV = findViewById(R.id.serviciuTVs);
        sectiaTV = findViewById(R.id.sectiaTVs);
        departTV = findViewById(R.id.departTVs);
        phoneTV = findViewById(R.id.phoneTVs);
        phoneinternalTV = findViewById(R.id.phoneinternalTVs);
        emailTV = findViewById(R.id.emailTVs);
        personalinfoTV = findViewById(R.id.personalinfoTVs);
        formnameTV = findViewById(R.id.formnameTVs);
        phonemobilTV = findViewById(R.id.phonemobilTVs);
        floorTV = findViewById(R.id.floorTVs);
        officeTV = findViewById(R.id.officeTVs);




        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayouts);
    }

    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedScientist = Utils.receiveScientist(getIntent(),DetailActivitystr3.this);

        if(receivedScientist != null){
            nameTV.setText(receivedScientist.getName());
            descriptionTV.setText(receivedScientist.getDescription());
            galaxyTV.setText(receivedScientist.getGalaxy());
            starTV.setText(receivedScientist.getStar());
            serviciuTV.setText(receivedScientist.getServiciu());
            sectiaTV.setText(receivedScientist.getSectia());
            departTV.setText(receivedScientist.getDepart());
            phoneTV.setText(receivedScientist.getPhone());
            phoneinternalTV.setText(receivedScientist.getPhoneinternal());
            emailTV.setText(receivedScientist.getEmail());
            personalinfoTV.setText(receivedScientist.getPersonalinfo());
            formnameTV.setText(receivedScientist.getFormname());
            phonemobilTV.setText(receivedScientist.getPhonemobil());
            floorTV.setText(receivedScientist.getFloor());
            officeTV.setText(receivedScientist.getOffice());
            mCollapsingToolbarLayout.setTitle(receivedScientist.getName());

            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        }
    }
    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_str, menu);
        return true;
    }

    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.action_edit_str){
            Utils.sendScientistToActivity(this,receivedScientist,help.class);
            finish();
            return true;
        }
        else

        if (id==R.id.action_edit_en_str){
            Utils.sendScientistToActivity(this,receivedScientist,helpen.class);
            finish();
            return true;

        }

        else
        if (id==R.id.action_edit_ru_str){
            Utils.sendScientistToActivity(this,receivedScientist,helpru.class);
            finish();
            return true;
        }


        else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this, ScientistsActivitystr3.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.video3_str){

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.list.Helpers.Utils.youtube_level_stat));

            startActivity(browserIntent);


        }


        return super.onOptionsItemSelected(item);
    }




    /**
     * Let's once again override the attachBaseContext. We do this for our
     * Calligraphy library
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    /**
     * Let's finish the current activity when back button is pressed
     */
    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(this, ScientistsActivitystr3.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_str);

        nameTV= findViewById(R.id.nameTVs);
        descriptionTV= findViewById(R.id.descriptionTVs);
        galaxyTV= findViewById(R.id.galaxyTVs);
        starTV= findViewById(R.id.starTVs);
        serviciuTV = findViewById(R.id.serviciuTVs);
        sectiaTV = findViewById(R.id.sectiaTVs);
        departTV = findViewById(R.id.departTVs);
        phoneTV = findViewById(R.id.phoneTVs);
        phoneinternalTV = findViewById(R.id.phoneinternalTVs);
        emailTV = findViewById(R.id.emailTVs);
        personalinfoTV = findViewById(R.id.personalinfoTVs);
        formnameTV = findViewById(R.id.formnameTVs);
        phonemobilTV = findViewById(R.id.phonemobilTVs);
        floorTV = findViewById(R.id.floorTVs);
        officeTV = findViewById(R.id.officeTVs);

        Button mBtnShare = findViewById(R.id.btnShares);

        mBtnShare.setOnClickListener(view -> {
            String s_nameTV = nameTV.getText().toString();
            String s_descriptionTV = descriptionTV.getText().toString();
            String s_floorTV = floorTV.getText().toString();
            String  s_officeTV = officeTV.getText().toString();
            String  s_galaxyTV = galaxyTV.getText().toString();
            String  s_serviciuTV = serviciuTV.getText().toString();
            String  s_sectiaTV = sectiaTV.getText().toString();
            String  s_departTV = departTV.getText().toString();
            String  s_starTV = starTV.getText().toString();
            String  s_phoneTV = phoneTV.getText().toString();
            String  s_phonemobilTV = phonemobilTV.getText().toString();
            String  s_phoneinternalTV = phoneinternalTV.getText().toString();
            String  s_formnameTV = formnameTV.getText().toString();
            String  s_emailTV = emailTV.getText().toString();


            String contentShare = " Nume, prenume  : " + s_nameTV + "-   Locația :  "+ s_descriptionTV + " - Etajul :  " +  s_floorTV
                    + " -  Oficiul :  " +  s_officeTV + "  - Functia :  " + s_galaxyTV + " -  Serviciu :  " + s_serviciuTV
                    + " - Sectia :  " + s_sectiaTV +  " -  Directia :  " +  s_departTV + " -  Directia generala :  " + s_starTV
                    + " - Telefon fix serviciu :  " + s_phoneTV  + "  - Telefon mobil serviciu :  " +  s_phonemobilTV
                    + " -  Telefon intern :  " +  s_phoneinternalTV + " - Cercetări Statistice  :  " + s_formnameTV
                    +  " -  E-mail :   " +  s_emailTV;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");

            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Informatia de contact despre angajat BNS");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });




        nameTV= findViewById(R.id.nameTVs);
        descriptionTV= findViewById(R.id.descriptionTVs);
        galaxyTV= findViewById(R.id.galaxyTVs);
        starTV= findViewById(R.id.starTVs);
        serviciuTV = findViewById(R.id.serviciuTVs);
        sectiaTV = findViewById(R.id.sectiaTVs);
        departTV = findViewById(R.id.departTVs);
        phoneTV = findViewById(R.id.phoneTVs);
        phoneinternalTV = findViewById(R.id.phoneinternalTVs);
        emailTV = findViewById(R.id.emailTVs);
        personalinfoTV = findViewById(R.id.personalinfoTVs);
        formnameTV = findViewById(R.id.formnameTVs);
        phonemobilTV = findViewById(R.id.phonemobilTVs);
        floorTV = findViewById(R.id.floorTVs);
        officeTV = findViewById(R.id.officeTVs);

        Button mBtnSend = findViewById(R.id.btnnNtices);

        mBtnSend.setOnClickListener(view -> {
            String s_nameTV = nameTV.getText().toString();
            String s_descriptionTV = descriptionTV.getText().toString();
            String s_floorTV = floorTV.getText().toString();
            String  s_officeTV = officeTV.getText().toString();
            String  s_galaxyTV = galaxyTV.getText().toString();
            String  s_serviciuTV = serviciuTV.getText().toString();
            String  s_sectiaTV = sectiaTV.getText().toString();
            String  s_departTV = departTV.getText().toString();
            String  s_starTV = starTV.getText().toString();
            String  s_phoneTV = phoneTV.getText().toString();
            String  s_phonemobilTV = phonemobilTV.getText().toString();
            String  s_phoneinternalTV = phoneinternalTV.getText().toString();
            String  s_formnameTV = formnameTV.getText().toString();
            String  s_emailTV = emailTV.getText().toString();


            String a = " Nume, prenume  : " + s_nameTV + "  -   Locația :  "+  s_descriptionTV +  "  - Etajul :   " +  s_floorTV
                    + "  -  Oficiul :  " +  s_officeTV + "  -  Functia :  " + s_galaxyTV + "  -  Serviciu :   " + s_serviciuTV
                    + "  -  Sectia :   " + s_sectiaTV +   " -   Directia :   " +  s_departTV + " -   Directia generala :  " + s_starTV
                    + " -  Telefon fix serviciu :   " + s_phoneTV  + "  -  Telefon mobil serviciu :   " +  s_phonemobilTV
                    + " -   Telefon intern :  " +  s_phoneinternalTV + " -  Cercetări Statistice  :   " + s_formnameTV
                    +  "  -  E-mail :   " +  s_emailTV
                    ;




            String email2 = "bancusoft@gmail.com";
            String subject= "The list of contacts of Employer are wrong. Write please,  which of fields is wrong.  ";
            String mailTo = "mailto:" + email2 + //"," + email2 +
                    "?&subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(a);
            Intent emailIntent = new Intent(Intent.ACTION_VIEW);
            emailIntent.setData(Uri.parse(mailTo));
            startActivity(emailIntent);
        });








        initializeWidgets();
        receiveAndShowData();
    }
}
