package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.databinding.ActivityOfTheDayBinding;

/**
 * Activity to display details of the activity of the day.
 */
public class ActivityOfTheDay extends AppCompatActivity {
    private AppManager m_AppManager;
    private ActivityOfTheDayBinding binding;
    private int m_ActivityIndex;
    private TextView m_PlaceText;
    private TextView m_AddressText;
    private ImageView m_ActivityImage;

    /**
     * Called when the activity is starting.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOfTheDayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        m_AppManager = AppManager.getInstance();
        getData();
        setContent();
        getSupportActionBar().setTitle(m_AppManager.m_ActivityPlace[m_ActivityIndex]);
    }

    /**
     * Retrieves the activity index from the intent extra.
     */
    private void getData() {
        m_ActivityIndex = getIntent().getIntExtra("activityIndex", 0);
    }

    /**
     * Sets the content of the activity with details of the selected activity.
     */
    private void setContent() {
        m_PlaceText = findViewById(R.id.activityOfTheDayPlace);
        m_AddressText = findViewById(R.id.activityOfTheDayAddress);
        m_ActivityImage = findViewById(R.id.activityOfTheDayImage);

        m_ActivityImage.setImageResource(m_AppManager.m_Activity[m_ActivityIndex]);
        m_PlaceText.setText(m_AppManager.m_ActivityPlace[m_ActivityIndex]);
        m_AddressText.setText(m_AppManager.m_ActivityAddress[m_ActivityIndex]);
    }
}
