package com.bancusoft.list.Views;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.widget.TextView;
import com.bancusoft.list.R;
import com.bancusoft.list.Views.structbns.Full_description;
public class AboutUsActivity extends AppCompatActivity {
    public void openMapsLink(View view) {
        String url = "https://www.google.com/maps/place/Chi%C8%99in%C4%83u,+Moldova/@46.9999566,28.7757764,12z/data=!3m1!4b1!4m6!3m5!1s0x40c97c3628b769a1:0x37d1d6305749dd3c!8m2!3d47.0104529!4d28.8638102!16zL20vMGZuNzc?authuser=0";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void onMImageViewClick(View view) {
        // LinkedIn profile URL
        String linkedinProfileUrl = getString(R.string.http_linkedin);

        // Create an intent to open the URL in the Chrome browser
        Intent chromeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedinProfileUrl));
        chromeIntent.setPackage("com.linkedin.android"); // Package name for Chrome browser

        try {
            // Open the URL in Chrome if it's installed
            startActivity(chromeIntent);
        } catch (ActivityNotFoundException e) {
            // Chrome is not installed or not available, handle the exception
            e.printStackTrace();

            // Fall back to opening the URL in a WebView within your app
            openLinkInWebView(linkedinProfileUrl);
        }
    }

    private void openLinkInWebView(String url) {
        Intent webViewIntent = new Intent(this, WebViewActivity.class);
        webViewIntent.putExtra("url", url);
        startActivity(webViewIntent);
    }
    private static final int CALL_PERMISSION_REQUEST_CODE = 123;

    public void onCallImageViewClick(View view) {
        String phoneNumber = getString(R.string.phone_number);
        handleCall(phoneNumber, view);
    }
    public void onCallImageViewClick_ro(View view) {
        String phoneNumber = getString(R.string.phone_number_ro);
        handleCall(phoneNumber, view);
    }

    public void handleCall(String phoneNumber, View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            makePhoneCall(phoneNumber);
        } else {
            // Request the CALL_PHONE permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with calling
                handleCall(getString(R.string.phone_number), null); // You can pass null or an actual View instance here
            } else {
                // Permission denied, show a message or take appropriate action
                showSupportEmailOption();
            }
        }
    }

    private void showSupportEmailOption() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permission Denied");
        builder.setMessage("You have denied the permission to make phone calls. If you need assistance, please contact our support team via email.");

        builder.setPositiveButton("Email Support", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Open an email client to compose an email to support
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "bancusoft@google.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Support Request");
                startActivity(Intent.createChooser(emailIntent, "Choose an email client"));
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle cancel action
                dialog.dismiss();
            }
        });

        builder.show();
    }



    private void makePhoneCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

//--------------------------------------------------------------------------
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_me);
        Toolbar toolbar = findViewById(R.id.aboutUsToolBar);
        setSupportActionBar(toolbar);

        findViewById(R.id.mBackArrow).setOnClickListener(v -> finish());
        // Register the onBackPressed callback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                Intent intent = new Intent(AboutUsActivity.this, DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        };

        // Add the callback to the dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);


        // Find the TextView that should open the disclaimer content
        TextView disclaimerTextView = findViewById(R.id.disclaimer_layout);
        disclaimerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this, Full_description.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_dgti, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_dgti) {
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish(); // Move finish() after startActivity
            return true;
        } else if (id == android.R.id.home) {
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish(); // Move finish() after startActivity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void setReceivedScientist() {
    }


}
