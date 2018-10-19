package br.clinup.com.palmaresbus;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import br.clinup.com.palmaresbus.Adapter.TabsAdapter;
import br.clinup.com.palmaresbus.fragments.InterUrbanoFragment;
import br.clinup.com.palmaresbus.fragments.UrbanoFragment;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    //Drawerr com valor nulo para fechar caso o usuario aperte "voltar"
    private Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources resources = getResources();
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.add(new UrbanoFragment(), "Urbano");
        adapter.add(new InterUrbanoFragment(), "Interurbano");

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Se você quiser atualizar os itens mais tarde, é recomendável mantê-los em uma variável
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Urbano").withIcon(FontAwesome.Icon.faw_home);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Interurbano").withIcon(FontAwesome.Icon.faw_user);

        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Contato").withIcon(FontAwesome.Icon.faw_user);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Sobre").withIcon(FontAwesome.Icon.faw_user);

        //create the drawer and remember the `Drawer` result object
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        new DividerDrawerItem(),
                        item4,
                        item5)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Toast.makeText(MainActivity.this, "Urbano", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                })
                .build();


    }

    @Override
    public void onBackPressed() {
        // manipular a contrapressão: D fecha a gaveta primeiro e se a gaveta estiver fechada feche a atividade
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

}
