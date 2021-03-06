package fauzi.hilmy.basket_team;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fauzi.hilmy.basket_team.model.TeamsItem;
import fauzi.hilmy.basket_team.presenter.MainPresenter;
import fauzi.hilmy.basket_team.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.recyclerNba)
    RecyclerView recyclerNba;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter();
        onAttachView();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSuccess(List<TeamsItem> data) {
        recyclerNba.setLayoutManager(new LinearLayoutManager(this));
        recyclerNba.setAdapter(new AdapterClub(data, MainActivity.this));
    }

    @Override
    public void onAttachView() {
        presenter.getData();
        presenter.onAttach(this);
    }

    @Override
    public void onDetachView() {

    }
}
