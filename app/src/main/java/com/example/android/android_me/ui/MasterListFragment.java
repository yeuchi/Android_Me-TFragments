package com.example.android.android_me.ui;

/**
 * Created by ctyeung on 12/30/17.
 */
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import android.widget.ImageView;
import java.util.ArrayList;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;

public class MasterListFragment extends Fragment
{
    private View rootView;
    OnImageClickListener mCallback;

    public interface OnImageClickListener
    {
        void onImageSelected(int position);
    }

    public void onAttach(Context context)
    {
        super.onAttach(context);

        try
        {
            mCallback = (OnImageClickListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "must implement OnImageClickListner");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle saveInstanceState)
    {

        rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        List<Integer> list = AndroidImageAssets.getAll();
        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        MasterListAdapter adapter = new MasterListAdapter(getContext(), list);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v,
                                    int position,
                                    long id)
            {
                mCallback.onImageSelected(position);
            }
        });
        return rootView;
    }
}
