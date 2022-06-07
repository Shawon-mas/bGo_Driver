package com.app.bgodriver.view.driverProfileUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.ActivityPersonalInfoBinding;
import com.app.bgodriver.model.FragmentToActivity;
import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.General_Info;
import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.Nid_Info;
import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.Selfie_Info;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class PersonalInfoActivity extends AppCompatActivity implements FragmentToActivity {
    private ActivityPersonalInfoBinding binding;
    int Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonalInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        stepViewImplement();
    }

    private void initView() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,new General_Info());
        fragmentTransaction.addToBackStack(null)
                .commit();
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

                     FrameLayout frameLayout=findViewById(R.id.frameLayout1);
                     frameLayout.setVisibility(View.GONE);

                     binding.stepView.go(id+1,true);
                     Toast.makeText(getApplicationContext(), "This is nid",  Toast.LENGTH_SHORT).show();

                     FragmentManager fragmentManager=getSupportFragmentManager();
                     FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                     fragmentTransaction.add(R.id.container,new Nid_Info());
                     fragmentTransaction.addToBackStack(null)
                             .commit();

                     Id=id+1;
                 }else if (Id==1)
                 {
                     FrameLayout frameLayout=findViewById(R.id.frameLayout2);
                     frameLayout.setVisibility(View.GONE);

                     binding.stepView.go(id+1,true);
                     Toast.makeText(getApplicationContext(), "This is selfie",  Toast.LENGTH_SHORT).show();

                     FragmentManager fragmentManager=getSupportFragmentManager();
                     FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                     fragmentTransaction.add(R.id.container,new Selfie_Info());
                     fragmentTransaction.addToBackStack(null)
                             .commit();
                     binding.next.setText("Complete");
                     binding.stepView.done(true);

                 }


             }
         });
         binding.backButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int id=binding.stepView.getCurrentStep();
                 if (id==0)
                 {
                     startActivity(new Intent(getApplicationContext(),InitProfileActivity.class));
                     Id=id+1;
                 }else if (id==1)
                 {
                     FrameLayout frameLayout=findViewById(R.id.frameLayout2);
                     frameLayout.setVisibility(View.GONE);

                     FrameLayout frameLayout1=findViewById(R.id.frameLayout1);
                     frameLayout1.setVisibility(View.VISIBLE);

                     binding.next.setText("Next");
                     binding.stepView.go(id-1,true);
                     Id=id+1;
                 }else if (id==2){
                     FrameLayout frameLayout=findViewById(R.id.frameLayout3);
                     frameLayout.setVisibility(View.GONE);

                     FrameLayout frameLayout2=findViewById(R.id.frameLayout2);
                     frameLayout2.setVisibility(View.VISIBLE);

                     binding.next.setText("Next");
                     binding.stepView.go(id-1,true);
                 }

             }
         });
    }

    @Override
    public void communicate(String comm,String name) {
        Log.d("received", comm+"\n"+name);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
/*
                stepView.go(stepView.getCurrentStep() + 1, true);

 */