package com.example.myapplication1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.FragmentFirstBinding;
import com.example.myapplication1.databinding.FragmentSecondBinding;
import com.example.myapplication1.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SeekBar colorSeekBar = view.findViewById(R.id.colorSeekBar);
        colorSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update colors of the boxes based on SeekBar progress
                updateBoxColors(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void updateBoxColors(int progress) {
        // Update the background color of each box with a different color
        binding.box1.setBackgroundColor(getColorForBox(1, progress));
        binding.box2.setBackgroundColor(getColorForBox(2, progress));
        binding.box3.setBackgroundColor(getColorForBox(3, progress));
        binding.box4.setBackgroundColor(getColorForBox(4, progress));
        binding.box5.setBackgroundColor(getColorForBox(5, progress));
    }


    private int getColorForBox(int boxIndex, int progress) {
        // Customize the RGB values based on the box index
        int red, green, blue;

        switch (boxIndex) {
            case 1:
                red = 25;
                green = 255;
                blue = 25 + progress;
                break;
            case 2:
                red = 255;
                green = 25;
                blue = 25 + progress;
                break;
            case 3:
                red = 255 - progress;
                green = 255;
                blue = 25;
                break;
            case 4:
                red = 255 - progress;
                green = 0;
                blue = 255;
                break;
            case 5:
                red = progress;
                green = 255;
                blue = 255 - progress;
                break;
            default:
                red = 0;
                green = 0;
                blue = 0;
                break;
        }

        // Combine the RGB values into a single color integer
        return Color.rgb(red, green, blue);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}