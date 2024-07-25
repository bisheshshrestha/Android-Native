package edu.divyagyan.fragmentlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private final String TAG = MainFragment.class.getSimpleName();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach method called Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate method called Fragment");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView method called Fragment");

        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"onActivityCreated method called Fragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart method called Fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume method called Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"onPause method called Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onStop method called Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView method called Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy method called Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"onDetach method called Fragment");

    }
}
