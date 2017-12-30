package com.example.android.android_me.data;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import com.example.android.android_me.R;
import android.widget.ImageView;
import android.view.View.OnClickListener;
/**
 * Created by ctyeung on 12/29/17.
 */

public class BodyPartFragment extends Fragment
{
    public final static String PART_HEAD = "head";
    public final static String PART_TORSO = "torso";
    public final static String PART_LEGS = "legs";
    private ImageView imageView;
    private View rootView;
    private String part;
    private int mListIndex = 0;
    private int numParts = 0;

    public BodyPartFragment()
    {
    }

    public void setPart(String part)
    {
        this.part = part;
        numParts = getPartCount();
    }

    public void setIndex(int index)
    {
        mListIndex = index;
    }

    public int getIndex()
    {
        return mListIndex;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle saveInstanceState)
    {
        inflate(inflater, container);
        setImageView();

        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // pick the next index or circle back to 0
                mListIndex = (mListIndex < numParts)? mListIndex+1:0;
                setImageView();
            }
        });

        return rootView;
    }

    private void inflate(LayoutInflater inflater,
                         ViewGroup container)
    {
        switch(this.part)
        {
            default:
            case PART_HEAD:
                rootView = inflater.inflate(R.layout.fragment_head_part, container, false);
                imageView = (ImageView) rootView.findViewById(R.id.iv_head_part);
                break;

            case PART_TORSO:
                rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
                imageView = (ImageView) rootView.findViewById(R.id.iv_body_part);
                break;

            case PART_LEGS:
                rootView = inflater.inflate(R.layout.fragment_legs_part, container, false);
                imageView = (ImageView) rootView.findViewById(R.id.iv_legs_part);
                break;
        }
    }

    private int getPartCount()
    {
        switch(part)
        {
            default:
            case PART_HEAD:
                return AndroidImageAssets.getHeads().size();

            case PART_TORSO:
                return AndroidImageAssets.getBodies().size();

            case PART_LEGS:
                return AndroidImageAssets.getLegs().size();
        }
    }

    private void setImageView()
    {
        switch(part)
        {
            default:
            case PART_HEAD:
                imageView.setImageResource(AndroidImageAssets.getHeads().get(mListIndex));
                break;

            case PART_TORSO:
                imageView.setImageResource(AndroidImageAssets.getBodies().get(mListIndex));
                break;

            case PART_LEGS:
                imageView.setImageResource(AndroidImageAssets.getLegs().get(mListIndex));
                break;
        }
    }
}
