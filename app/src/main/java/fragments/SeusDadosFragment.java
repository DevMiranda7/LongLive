package fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.longlive.R;

public class SeusDadosFragment extends Fragment {

    public SeusDadosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate o layout para este fragment
        return inflater.inflate(R.layout.fragment_seus_dados, container, false);
    }
}
