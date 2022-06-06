package com.app.bgodriver.view.driverProfileUi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.app.bgodriver.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;


    public class MyStepperAdapter extends AbstractFragmentStepAdapter {

        private static final String CURRENT_STEP_POSITION_KEY = "new_position";
        private String title;

        public MyStepperAdapter(FragmentManager fm, Context context) {
            super(fm, context);
        }

        @Override
        public Step createStep(int position) {
            switch (position){
                case 0:

                    return new Step1();
                case 1:

                    return new Step2();
                case 2:

                    return new Step3();
                default:
                    return new Step1();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public StepViewModel getViewModel(@IntRange(from = 0) int position) {
          //  String[] title={"General Info","Nide","Selfie"};
            CharSequence cs[];

            cs = new String[3];

            cs[0] = "foo";
            cs[1] = "bar";
            cs[2] = "bar";
            CharSequence tiile[]={"General Info","Nid","Selfie"};

            //Override this method to set Step title for the Tabs, not necessary for other stepper types
            return new StepViewModel.Builder(context)
                    .setTitle(tiile[position]) //can be a CharSequence instead
                    .create();
        }
    }

