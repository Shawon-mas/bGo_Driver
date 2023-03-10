package com.app.bgodriver.view.driverProfileUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.app.bgodriver.R;
import com.app.bgodriver.adapter.ProfileDocFragmentAdapter;
import com.app.bgodriver.databinding.ActivityPersonalInfoBinding;
import com.app.bgodriver.model.FragmentToActivity;
import com.google.android.material.button.MaterialButton;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class PersonalInfoActivity extends AppCompatActivity implements FragmentToActivity {
    private ActivityPersonalInfoBinding binding;

    private ProfileDocFragmentAdapter adapter;
    LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonalInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        clickListener();
        stepViewImplement();
    }

    private void clickListener() {
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (binding.viewPager2.getCurrentItem() < 1)
                {
                    binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);
                    binding.stepView.go(1,true);
                }else if (binding.viewPager2.getCurrentItem() < 2)
                {
                    binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);
                    binding.stepView.go(2,true);
                    binding.done.setVisibility(View.VISIBLE);
                    binding.next.setVisibility(View.GONE);
                }
            }
        });

        binding.pBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.viewPager2.getCurrentItem() == 0)
                {
                    startActivity(new Intent(getApplicationContext(),InitProfileActivity.class));

                }else if (binding.viewPager2.getCurrentItem() == 1)
                {
                    binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() - 1);
                    binding.stepView.go(0,true);
                    binding.done.setVisibility(View.GONE);
                    binding.next.setVisibility(View.VISIBLE);
                }else if (binding.viewPager2.getCurrentItem() == 2)
                {
                    binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() - 1);
                    binding.stepView.go(1,true);
                    binding.done.setVisibility(View.GONE);
                    binding.next.setVisibility(View.VISIBLE);
                }
            }

        });
        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              final Dialog  dialog = new Dialog(PersonalInfoActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(R.layout.loading);
                dialog.getWindow().setLayout(500, 500);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setGravity(Gravity.CENTER);

                // dialog1.getWindow().setWindowAnimations(R.style.AnimationForDialog);
                lottieAnimationView=dialog.findViewById(R.id.animationView);
                dialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.cancel();
                        opendialog();

                    }
                },3000);
            }
        });
    }

    private void opendialog() {
        final Dialog dialog = new Dialog(PersonalInfoActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_dialog);
        ImageView imageViewCancel=dialog.findViewById(R.id.cancel);
        imageViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        MaterialButton materialButton=dialog.findViewById(R.id.add_vehicle);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),VehicleInfoActivity.class));
                finish();
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void initView() {

    }

    private void stepViewImplement() {

        binding.stepView.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.bGo_textColorPrimary))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.bGo_mainColor))
                .selectedCircleRadius(getResources().getDimensionPixelSize(R.dimen.circle_radius))
                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.white))
                .steps(new ArrayList<String>() {{
                    add("General Info");
                    add("Nid Upload");
                    add("Selfie");
                }})
                .stepsNumber(3)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .stepLineWidth(getResources().getDimensionPixelSize(R.dimen.line_width))
                .textSize(getResources().getDimensionPixelSize(R.dimen.text_size))
                .stepNumberTextSize(getResources().getDimensionPixelSize(R.dimen.text_size))
                .typeface(ResourcesCompat.getFont(getApplicationContext(), R.font.sf_ui_display))
                .commit();

        FragmentManager fragmentManager=getSupportFragmentManager();
        adapter=new ProfileDocFragmentAdapter(fragmentManager,getLifecycle());
        binding.viewPager2.setAdapter(adapter);
        binding.viewPager2.setUserInputEnabled(false);





    }

    @Override
    public void communicate(String a,String b) {
        Log.d("name", a);
        Log.d("number", b);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),InitProfileActivity.class));
    }
}
