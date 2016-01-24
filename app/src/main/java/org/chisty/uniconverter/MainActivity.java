package org.chisty.uniconverter;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity {

    /**
     * The current measure.
     */
    private String currentMeasure = "";

    /**
     * The right unit spinner.
     */
    private Spinner spinner, leftUnitSpinner, rightUnitSpinner;

    /**
     * The to unit txt.
     */
    private EditText fromUnitTxt, toUnitTxt;

    /**
     * The obj right.
     */
    private Object objLeft, objRight;

    /**
     * The adapter.
     */
    private LabelValueAdapter adapter;

    /**
     * The unit array str.
     */
    private String[] unitArrayStr = {"LENGTH", "WEIGHT", "AREA", "TEMPERATURE", "SPEED", "POWER", "TIME"};

    /**
     * The image buttons
     */
    private ImageButton resetBtn, exitBtn, helpBtn;

    private String leftUnitName, rightUnitName;

    private AdView mAdView;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    /*
     * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // With this mode activated, your app will always display the same sample ad.
        // Remove it before publishing to Google Play.
//        AdBuddiz.setTestModeActive();
        AdBuddiz.setPublisherKey("a66d32b2-dbf3-480c-9864-1849206f70e5");
        AdBuddiz.cacheAds(this);
        AdBuddiz.showAd(MainActivity.this);

        // -----------------------------------------------------------------------------
        // Components initialization
        // -----------------------------------------------------------------------------
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        leftUnitSpinner = (Spinner) findViewById(R.id.spinnerLeft);
        leftUnitSpinner.setMinimumHeight(100);
        rightUnitSpinner = (Spinner) findViewById(R.id.spinnerRight);
        rightUnitSpinner.setMinimumHeight(200);
        fromUnitTxt = (EditText) findViewById(R.id.fromUnitTxt);
        toUnitTxt = (EditText) findViewById(R.id.toUnitTxt);
        resetBtn = (ImageButton) findViewById(R.id.resetBtn);
        exitBtn = (ImageButton) findViewById(R.id.exitBtn);
        helpBtn = (ImageButton) findViewById(R.id.helpBtn);

        // -----------------------------------------------------------------------------
        // Google Admob initialization
        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in values/strings.xml.
        // -----------------------------------------------------------------------------
        mAdView = (AdView) findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);


        // -----------------------------------------------------------------------------
        // General adapter configuration
        // -----------------------------------------------------------------------------
        ArrayAdapter<String> strAdapter = new ArrayAdapter<>(this, R.layout.spinner_txtview, unitArrayStr);
        spinner.setAdapter(strAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentMeasure = (String) parent.getItemAtPosition(position);
                reset();
                populateLeftRightSpinners();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // -----------------------------------------------------------------------------
        // Left (from) and right (to) unit conversion spinner configuration
        // -----------------------------------------------------------------------------
        leftUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                objLeft = parent.getItemAtPosition(position);
                updateToUnitTxtValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        rightUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                objRight = parent.getItemAtPosition(position);
                updateToUnitTxtValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // -----------------------------------------------------------------------------
        // Left and right textView configuration to show result
        // -----------------------------------------------------------------------------
        toUnitTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                updateToUnitTxtValue();
                if (null != toUnitTxt.getText()) {
                    helpBtn.setVisibility(View.VISIBLE);
                } else {
                    helpBtn.setVisibility(View.GONE);
                }
                return true;
            }
        });

        // -----------------------------------------------------------------------------
        // Buttons configuration
        // -----------------------------------------------------------------------------
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (null != fromUnitTxt.getText() && null != toUnitTxt.getText()) {
                    String detail = fromUnitTxt.getText() + " " + leftUnitName + "=" + result.toPlainString() + " "
                            + rightUnitName;
                    Toast.makeText(getApplicationContext(), detail, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();  // Always call the superclass
        // Stop method tracing that the activity started during onCreate()
//        android.os.Debug.stopMethodTracing();
    }

    private void manageHelpBtn() {
        if (null != toUnitTxt.getText() && toUnitTxt.getText().length() > 0) {
            helpBtn.setVisibility(View.VISIBLE);
        } else {
            helpBtn.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Update to unit txt value.
     */
    private void updateToUnitTxtValue() {
        toUnitTxt.setText("");
        if (null != fromUnitTxt.getText() && fromUnitTxt.getText().length() != 0) {
            if (null == toUnitTxt.getText() || toUnitTxt.getText().length() == 0) {
                calculateTo();
            }
        }
    }

    /**
     * Calculate.
     */

    private BigDecimal result;

    private void calculateTo() {
        CharSequence cs = fromUnitTxt.getText();
        if (cs.length() > 0) {
            StringBuffer sb = new StringBuffer(cs);
            result = getConvertedUnitValue(sb.toString()).stripTrailingZeros();
            String tmp = "";
            if (result.precision() > Constant.PRECISION) {
                tmp = result.abs(Constant.MC).toEngineeringString();
            } else {
                tmp = result.toPlainString();
            }
            toUnitTxt.setText("");

            // toUnitTxt.append(result.toEngineeringString());
            toUnitTxt.append(tmp);
            toUnitTxt.setTextIsSelectable(true);
        }
    }

    /**
     * Populate left right spinners.
     */
    // TODO
    private void populateLeftRightSpinners() {
        if (currentMeasure.equals("WEIGHT")) {
            ArrayAdapter<WeightTypeEnum> strAdapter = new ArrayAdapter<>(this, R.layout.spinner_txtview,
                    WeightTypeEnum.values());
            leftUnitSpinner.setAdapter(strAdapter);
            rightUnitSpinner.setAdapter(strAdapter);
        } else if (currentMeasure.equals("LENGTH")) {
            ArrayAdapter<LengthTypeEnum> strAdapter = new ArrayAdapter<>(this, R.layout.spinner_txtview,
                    LengthTypeEnum.values());
            leftUnitSpinner.setAdapter(strAdapter);
            rightUnitSpinner.setAdapter(strAdapter);
        } else if (currentMeasure.equals("SPEED")) {
            adapter = new LabelValueAdapter(this, R.layout.spinner_txtview);
            for (SpeedTypeEnum s : SpeedTypeEnum.values()) {
                LabelValue lv = new LabelValue(s.getLabel(), s.getValue());
                adapter.add(lv);
            }
            leftUnitSpinner.setAdapter(adapter);
            rightUnitSpinner.setAdapter(adapter);
        } else if (currentMeasure.equals("TIME")) {
            ArrayAdapter<TimeEnum> strAdapter = new ArrayAdapter<>(this, R.layout.spinner_txtview, TimeEnum.values());
            leftUnitSpinner.setAdapter(strAdapter);
            rightUnitSpinner.setAdapter(strAdapter);
        } else if (currentMeasure.equals("TEMPERATURE")) {
            ArrayAdapter<TemperatureEnum> strAdapter = new ArrayAdapter<>(this, R.layout.spinner_txtview,
                    TemperatureEnum.values());
            leftUnitSpinner.setAdapter(strAdapter);
            rightUnitSpinner.setAdapter(strAdapter);
        } else if (currentMeasure.equals("POWER")) {
            adapter = new LabelValueAdapter(this, R.layout.spinner_txtview);
            for (PowerEnum s : PowerEnum.values()) {
                LabelValue lv = new LabelValue(s.getLabel(), s.getValue());
                adapter.add(lv);
            }
            leftUnitSpinner.setAdapter(adapter);
            rightUnitSpinner.setAdapter(adapter);
        } else {
            leftUnitSpinner.setAdapter(null);
            rightUnitSpinner.setAdapter(null);
        }
    }

    /**
     * Reset.
     */
    private void reset() {
        fromUnitTxt.setText("");
        toUnitTxt.setText("");
        manageHelpBtn();
    }

    /**
     * Gets the converted unit value as text.
     *
     * @param sourceUnitAsText the source unit as text
     * @return the converted unit value as text
     */

    private BigDecimal getConvertedUnitValue(String sourceUnitAsText) {
        BigDecimal targetAmount = BigDecimal.ZERO;
        if (null == sourceUnitAsText) {
            Toast.makeText(getApplicationContext(), "Value is empty", Toast.LENGTH_SHORT).show();
            return BigDecimal.ZERO;
        }
        BigDecimal sourceAmount = new BigDecimal(sourceUnitAsText);
        if (currentMeasure.equals("LENGTH")) {
            LengthTypeEnum sourceEnum = (LengthTypeEnum) objLeft;
            LengthTypeEnum targetEnum = (LengthTypeEnum) objRight;
            leftUnitName = sourceEnum.name();
            rightUnitName = targetEnum.name();
            targetAmount = LengthManager.getConvertedAmount(sourceEnum, targetEnum, sourceAmount);
        } else if (currentMeasure.equals("WEIGHT")) {
            WeightTypeEnum sourceEnum = (WeightTypeEnum) objLeft;
            WeightTypeEnum targetEnum = (WeightTypeEnum) objRight;
            leftUnitName = sourceEnum.name();
            rightUnitName = targetEnum.name();
            targetAmount = WeightManager.getConvertedAmount(sourceEnum, targetEnum, sourceAmount);
        } else if (currentMeasure.equals("SPEED")) {
            LabelValue left = (LabelValue) objLeft;
            LabelValue right = (LabelValue) objRight;
            SpeedTypeEnum sourceEnum = SpeedTypeEnum.getName(left.getValue());
            SpeedTypeEnum targetEnum = SpeedTypeEnum.getName(right.getValue());
            leftUnitName = sourceEnum.name();
            rightUnitName = targetEnum.name();
            targetAmount = SpeedManager.getConvertedAmount(sourceEnum, targetEnum, sourceAmount);
        } else if (currentMeasure.equals("TIME")) {
            TimeEnum sourceEnum = (TimeEnum) objLeft;
            TimeEnum targetEnum = (TimeEnum) objRight;
            leftUnitName = sourceEnum.name();
            rightUnitName = targetEnum.name();
            targetAmount = TimeManager.getConvertedAmount(sourceEnum, targetEnum, sourceAmount);
        } else if (currentMeasure.equals("TEMPERATURE")) {
            TemperatureEnum sourceEnum = (TemperatureEnum) objLeft;
            TemperatureEnum targetEnum = (TemperatureEnum) objRight;
            leftUnitName = sourceEnum.name();
            rightUnitName = targetEnum.name();
            targetAmount = TemperatureManager.getConvertedAmount(sourceEnum, targetEnum, sourceAmount);
        } else if (currentMeasure.equals("POWER")) {
            LabelValue left = (LabelValue) objLeft;
            LabelValue right = (LabelValue) objRight;
            PowerEnum sourceEnum = PowerEnum.getName(left.getValue());
            PowerEnum targetEnum = PowerEnum.getName(right.getValue());
            leftUnitName = sourceEnum.name();
            rightUnitName = targetEnum.name();
            targetAmount = PowerManager.getConvertedAmount(sourceEnum, targetEnum, sourceAmount);
        }

        return targetAmount;
    }

    /**
     * On create options menu.
     *
     * @param menu the menu
     * @return true, if successful
     */
    /*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * On options item selected.
     *
     * @param item the item
     * @return true, if successful
     */
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
