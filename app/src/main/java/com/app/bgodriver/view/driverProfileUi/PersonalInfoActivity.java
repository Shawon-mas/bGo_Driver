package com.app.bgodriver.view.driverProfileUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.ActivityOtpBinding;
import com.app.bgodriver.databinding.ActivityPersonalInfoBinding;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class PersonalInfoActivity extends AppCompatActivity {
    private ActivityPersonalInfoBinding binding;
    int Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonalInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        stepViewImplement();
    }

    private void stepViewImplement() {
        binding.stepView.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.bGo_textColorPrimary))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.bGo_mainColor))
                .selectedCircleRadius(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._14sdp))
                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.white))
                .steps(new ArrayList<String>() {{
                    add("General Info");
                    add("Nid Upload");
                    add("Selfie");
                }})
                .stepsNumber(3)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .stepLineWidth(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._1sdp))
                .textSize(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp))
                .stepNumberTextSize(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp))
                .typeface(ResourcesCompat.getFont(getApplicationContext(), R.font.sf_ui_display))
                .commit();
         binding.next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                 int id=binding.stepView.getCurrentStep();

                 if (id==0)
                 {
                     binding.stepView.go(id+1,true);
                     Toast.makeText(getApplicationContext(), "This is nid",  Toast.LENGTH_SHORT).show();

                     Id=id+1;
                 }else if (Id==1)
                 {
                     binding.stepView.go(id+1,true);
                     Toast.makeText(getApplicationContext(), "This is selfie",  Toast.LENGTH_SHORT).show();
                     binding.next.setText("Complete");
                 }


             }
         });
    }
}
/*
                stepView.go(stepView.getCurrentStep() + 1, true);

 */