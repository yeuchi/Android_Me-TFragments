package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.data.BodyPartFragment;

/**
 * Created by ctyeung on 12/30/17.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener
{
    private int headIndex;
    private int torsoIndex;
    private int legsIndex;

    @Override
    protected void onCreate(Bundle onSaveInstance)
    {
        super.onCreate(onSaveInstance);
        setContentView(R.layout.activity_main);

        MasterListFragment listFragment = new MasterListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.master_list_container, listFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Bundle b = new Bundle();
        b.putInt(AndroidImageAssets.STR_HEAD_INDEX, headIndex);
        b.putInt(AndroidImageAssets.STR_TORSO_INDEX, torsoIndex);
        b.putInt(AndroidImageAssets.STR_LEGS_INDEX, legsIndex);

        Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);
        startActivity(intent);
        return true;
    }

        @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position clicked:"+position, Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position / AndroidImageAssets.PARTS_LENGTH;
        int listIndex = position - bodyPartNumber * AndroidImageAssets.PARTS_LENGTH;
        switch (bodyPartNumber)
        {
            case AndroidImageAssets.INDEX_HEAD:
                headIndex = listIndex;
                break;

            case AndroidImageAssets.INDEX_TORSO:
                torsoIndex = listIndex;
                break;

            case AndroidImageAssets.INDEX_LEGS:
                legsIndex = listIndex;
                break;

            default:
                break;
        }
    }
}
