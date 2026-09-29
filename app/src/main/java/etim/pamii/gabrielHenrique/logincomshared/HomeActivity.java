package etim.pamii.gabrielHenrique.logincomshared;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    SharedPreferences preferences;
    Button logoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            initComponents();

            preferences = getSharedPreferences("login", 0);

            logoff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    preferences = getSharedPreferences("login", 0);
                    SharedPreferences.Editor dados = preferences.edit();
                    dados.clear();
                    dados.commit();

                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            return insets;
        });
    }

    private void initComponents() {
        logoff = findViewById(R.id.logoff);
    }
}