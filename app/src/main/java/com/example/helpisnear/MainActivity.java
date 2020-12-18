package com.example.helpisnear;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.helpisnear.classes.DialogCall;
import com.example.helpisnear.classes.LocaleHelper;
import com.example.helpisnear.classes.MyDrawerLayout;
import com.example.helpisnear.interfaces.MobileNavigation;
import com.example.helpisnear.model.HomeViewModel;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    private HomeViewModel mViewModel;

    private AppBarConfiguration mAppBarConfiguration;
    private MyDrawerLayout drawer;
    private NavController navController;
    private NavigationView navigationView;
    private SearchView searchView;
    private MobileNavigation navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String lang = LocaleHelper.getLanguage(getApplicationContext());
        LocaleHelper.onAttach(this, lang);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchView = findViewById(R.id.search_view);

        ImageButton btn_call = findViewById(R.id.btn_call);
        btn_call.setOnClickListener((v -> getSupportFragmentManager()
                                            .beginTransaction()
                                            .add(new DialogCall(), "dialogCall")
                                            .commit()));

        drawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

            if (destination.getId() == R.id.nav_home){

                toolbar.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

                toolbar.setNavigationOnClickListener(v -> drawer.open());

                toolbar.setBackgroundResource(R.drawable.ic_logo_home);

                ViewGroup.LayoutParams params = toolbar.getLayoutParams();

                params.height = Toolbar.LayoutParams.WRAP_CONTENT;

                toolbar.setLayoutParams(params);

            }else {

                toolbar.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

                toolbar.setNavigationOnClickListener(v -> controller.popBackStack());

                toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                final TypedValue tv = new TypedValue();

                int actionBarHeight = 0;

                if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                    actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
                }

                ViewGroup.LayoutParams params = toolbar.getLayoutParams();

                params.height = actionBarHeight;

                toolbar.setLayoutParams(params);

            }
        });

        navigation = new MobileNavigation() {

            @Override
            public void home_what_to_do() {
                navController.navigate(R.id.whatToDoFragment);
            }

            @Override
            public void home_first_aid() {
                navController.navigate(R.id.firstAidFragment);
            }

            @Override
            public void home_map_of_adverse_events() {
                navController.navigate(R.id.mapOfAdverseEventsFragment);
            }

            @Override
            public void home_check_your_self() {
                navController.navigate(R.id.checkYourSelfFragment);
            }

            @Override
            public void home_encyclopedia() {
                navController.navigate(R.id.encyclopediaFragment);
            }

            @Override
            public void home_information_and_settings() {
                navController.navigate(R.id.informationAndSettingsFragment);
            }

            @Override
            public void stranger_home() {
                navController.popBackStack();
            }

            @Override
            public void stranger_what_to_do() {
                navController.popBackStack();
                navController.navigate(R.id.whatToDoFragment);
            }

            @Override
            public void stranger_first_aid() {
                navController.popBackStack();
                navController.navigate(R.id.firstAidFragment);
            }

            @Override
            public void stranger_map_of_adverse_events() {
                navController.popBackStack();
                navController.navigate(R.id.mapOfAdverseEventsFragment);
            }

            @Override
            public void stranger_check_your_self() {
                navController.popBackStack();
                navController.navigate(R.id.checkYourSelfFragment);
            }

            @Override
            public void stranger_encyclopedia() {
                navController.popBackStack();
                navController.navigate(R.id.encyclopediaFragment);
            }

            @Override
            public void stranger_information_and_settings() {
                navController.popBackStack();
                navController.navigate(R.id.informationAndSettingsFragment);
            }
        };
    }

    public MobileNavigation getNavigation() {
        return navigation;
    }
}