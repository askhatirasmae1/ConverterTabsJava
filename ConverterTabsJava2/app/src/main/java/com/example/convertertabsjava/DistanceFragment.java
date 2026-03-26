package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    private RadioGroup rgDist;
    private RadioButton rbKmToMiles, rbMilesToKm;
    private EditText etDistInput;
    private Button btnConvertDist;
    private TextView tvDistResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        rgDist = view.findViewById(R.id.rgDist);
        rbKmToMiles = view.findViewById(R.id.rbKmToMiles);
        rbMilesToKm = view.findViewById(R.id.rbMilesToKm);
        etDistInput = view.findViewById(R.id.etDistInput);
        btnConvertDist = view.findViewById(R.id.btnConvertDist);
        tvDistResult = view.findViewById(R.id.tvDistResult);

        btnConvertDist.setOnClickListener(v -> {
            String input = etDistInput.getText().toString();
            if (TextUtils.isEmpty(input)) {
                Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double val = Double.parseDouble(input);
            double result;

            if (rbKmToMiles.isChecked())
                result = val * 0.621371; // Conversion précise
            else
                result = val / 0.621371;

            tvDistResult.setText("Résultat : " + String.format("%.2f", result));
        });

        return view;
    }
}