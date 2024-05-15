package com.bancusoft.list.Views;

import static com.bancusoft.list.Helpers.Utils.app_google;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bancusoft.list.Helpers.Utils;
import com.bancusoft.list.R;
import com.bancusoft.list.Retrofit.Scientistsvw_ro;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
public class DetailActivityvw_ro extends AppCompatActivity{

    //Let's define our instance fields
    private TextView Nume_firma, cui, cod_inmatriculare, EUID, stare, Sediu, country, Localitate, Judet, act;

    private Scientistsvw_ro receivedScientist_ro;

    private CollapsingToolbarLayout mCollapsingToolbarLayoutvw_ro;

    private void initializeWidgets(){
        Nume_firma= findViewById(R.id.Nume_firma_det);
        cui = findViewById(R.id.cui_det);
        cod_inmatriculare  = findViewById(R.id.cod_inmatriculare_det);
        EUID = findViewById(R.id.eud_det);
        stare = findViewById(R.id.stare_det);
        Sediu = findViewById(R.id.sediu_det);
        country = findViewById(R.id.country_det);
        Localitate = findViewById(R.id.localitate_det);
        Judet = findViewById(R.id.judet_det);
        act = findViewById(R.id.last_update_det);

        mCollapsingToolbarLayoutvw_ro=findViewById(R.id.mCollapsingToolbarLayoutvw_ro);
    }



    private void receiveAndShowData() {

        receivedScientist_ro = Utils.receiveScientistvw_ro(getIntent(), DetailActivityvw_ro.this);

        if (receivedScientist_ro != null) {
            Nume_firma.setText(receivedScientist_ro.getNume_firma().trim());
            cui.setText(receivedScientist_ro.getCui().trim());
            cod_inmatriculare.setText(receivedScientist_ro.getcod_inmatriculare().trim());
            EUID.setText(receivedScientist_ro.getEUID().trim());
            stare.setText(receivedScientist_ro.getStare().trim());
            Sediu.setText(receivedScientist_ro.getSediu().trim());
            country.setText(receivedScientist_ro.getCountry().trim());
            Localitate.setText(receivedScientist_ro.getLocalitate().trim());
            Judet.setText(receivedScientist_ro.getJudet().trim());
            act.setText(receivedScientist_ro.getAct().trim());


            mCollapsingToolbarLayoutvw_ro.setTitle(receivedScientist_ro.getCui());
            mCollapsingToolbarLayoutvw_ro.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        }
    }


    /**
     * Let's once again override the attachBaseContext. We do this for our
     * Calligraphy library
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailvw_ro);

        Nume_firma= findViewById(R.id.Nume_firma_det);
        cui = findViewById(R.id.cui_det);
        cod_inmatriculare  = findViewById(R.id.cod_inmatriculare_det);
        EUID = findViewById(R.id.eud_det);
        stare = findViewById(R.id.stare_det);
        Sediu = findViewById(R.id.sediu_det);
        country = findViewById(R.id.country_det);
        Localitate = findViewById(R.id.localitate_det);
        Judet = findViewById(R.id.judet_det);
        act = findViewById(R.id.last_update_det);


        Button mBtnShare = findViewById(R.id.share_ro_det);

        mBtnShare.setOnClickListener(view -> {
            String s_Nume_firma = Nume_firma.getText().toString();
            String s_cui = cui.getText().toString();
            String s_cod_inmatriculare = cod_inmatriculare.getText().toString();
            String  s_EUID = EUID.getText().toString();
            String  s_stare = stare.getText().toString();
            String  s_Sediu = Sediu.getText().toString();
            String  s_country = country.getText().toString();
            String  s_Localitate = Localitate.getText().toString();
            String  s_Judet = Judet.getText().toString();
            String  s_act = act.getText().toString();


            String contentShare = " Nume firmă : " + s_Nume_firma + " - Cui :  " + s_cui + " - Cod Inmatriculare - " + s_cod_inmatriculare
                    + " - EUID. :  " +  s_EUID
                    + " -  Stare :  " +  s_stare + "  - Sediu  :  " + s_Sediu
                    + " -  Țara :  " + s_country
                    + " -  : Localitate " + s_Localitate
                    + " -  : Județ :  " +  s_Judet
                    + " -  actualizare" + s_act + " -- The application -Level Stat - can be downloaded from here "
                    +  app_google;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Informatia deschisa  despre firmă");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });



        initializeWidgets();
        receiveAndShowData();
    }


}
