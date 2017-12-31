/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.data.BodyPartFragment;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity
{
    private int headIndex;
    private int torsoIndex;
    private int legsIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if(null==savedInstanceState)
        {
            setPartsIndex();
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setIndex(headIndex);
            BodyPartFragment torsoFragment = new BodyPartFragment();
            torsoFragment.setIndex(torsoIndex);
            BodyPartFragment legsFragment = new BodyPartFragment();
            legsFragment.setIndex(legsIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                            .add(R.id.head_container, headFragment)
                            .commit();

            fragmentManager.beginTransaction()
                            .add(R.id.torso_container, torsoFragment)
                            .commit();

            fragmentManager.beginTransaction()
                            .add(R.id.legs_container, legsFragment)
                            .commit();
        }
    }

    protected void setPartsIndex()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        headIndex = bundle.getInt(AndroidImageAssets.STR_HEAD_INDEX);
        torsoIndex = bundle.getInt(AndroidImageAssets.STR_TORSO_INDEX);
        legsIndex = bundle.getInt(AndroidImageAssets.STR_LEGS_INDEX);
    }
}
