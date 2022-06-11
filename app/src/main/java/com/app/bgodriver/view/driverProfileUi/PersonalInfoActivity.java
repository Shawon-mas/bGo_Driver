package com.app.bgodriver.view.driverProfileUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.bgodriver.R;
import com.app.bgodriver.adapter.MyFragmentAdapter;
import com.app.bgodriver.databinding.ActivityPersonalInfoBinding;
import com.app.bgodriver.model.FragmentToActivity;
import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.General_Info;
import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.Nid_Info;
import com.app.bgodriver.view.driverProfileUi.driverProfileFragment.Selfie_Info;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class PersonalInfoActivity extends AppCompatActivity implements FragmentToActivity {
    private ActivityPersonalInfoBinding binding;
    int Id;
    int backId;
   String a,b;
    private MyFragmentAdapter adapter;

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
                }else if (binding.viewPager2.getCurrentItem() < 2){
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

                }else if (binding.viewPager2.getCurrentItem() == 1){
                    binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() - 1);
                    binding.stepView.go(0,true);
                    binding.done.setVisibility(View.GONE);
                    binding.next.setVisibility(View.VISIBLE);
                }else if (binding.viewPager2.getCurrentItem() == 2){
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
                 opendialog();
            }
        });
    }

    private void opendialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_dialog);
        ImageView imageViewCancel=dialog.findViewById(R.id.cancel);
        imageViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        MaterialButton materialButton=dialog.findViewById(R.id.add_vehicle);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),VehicleInfoActivity.class));
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void initView() {
        /*FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,new General_Info());
        fragmentTransaction.addToBackStack(null)
                .commit();*/
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
        FragmentManager fragmentManager=getSupportFragmentManager();
        adapter=new MyFragmentAdapter(fragmentManager,getLifecycle());
        binding.viewPager2.setAdapter(adapter);



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
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),InitProfileActivity.class));
    }
}
