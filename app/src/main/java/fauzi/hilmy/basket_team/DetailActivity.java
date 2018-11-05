package fauzi.hilmy.basket_team;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import fauzi.hilmy.basket_team.model.TeamsItem;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_TEAM = "team";
    @BindView(R.id.imgDetail)
    ImageView imgDetail;
    @BindView(R.id.txtDetail)
    TextView txtName;
    @BindView(R.id.txtYear)
    TextView txtYear;
    @BindView(R.id.txStadium)
    TextView txStadium;
    @BindView(R.id.txtDeskripsi)
    TextView txtDeskripsi;
    @BindView(R.id.imgWeb)
    ImageView imgWeb;
    @BindView(R.id.imgFacebook)
    ImageView imgFacebook;
    @BindView(R.id.imgTwitter)
    ImageView imgTwitter;
    @BindView(R.id.imgInstagram)
    ImageView imgInstagram;

    TeamsItem teamsItem;

    @BindView(R.id.relativ)
    RelativeLayout relativ;
    @BindView(R.id.scrolll)
    ScrollView scrolll;
    @BindView(R.id.vw)
    View vw;
    @BindView(R.id.rell)
    RelativeLayout rell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        teamsItem = getIntent().getParcelableExtra(EXTRA_TEAM);

        Picasso.get()
                .load(teamsItem.getStrTeamBadge())
                .fit()
                .into(imgDetail);

        txtName.setText(teamsItem.getStrTeam());
        txtYear.setText(teamsItem.getIntFormedYear());
        txStadium.setText(teamsItem.getStrStadium());
        txtDeskripsi.setText(teamsItem.getStrDescriptionEN());

        Log.d("List Web", teamsItem.getStrWebsite() + ", " + teamsItem.getStrFacebook() + ", " + teamsItem.getStrTwitter() + ", " + teamsItem.getStrInstagram());
        if (teamsItem.getStrWebsite() == null) {
            imgWeb.setVisibility(View.INVISIBLE);
        } else {
            imgWeb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + teamsItem.getStrWebsite()));
                    startActivity(intent);
                }
            });

        }

        if (teamsItem.getStrFacebook() == null) {
            imgFacebook.setVisibility(View.INVISIBLE);
        } else {
            imgFacebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + teamsItem.getStrFacebook()));
                    startActivity(intent);
                }
            });
        }

        if (teamsItem.getStrTwitter() == null) {
            imgTwitter.setVisibility(View.INVISIBLE);
        } else {
            imgTwitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + teamsItem.getStrTwitter()));
                    startActivity(intent);
                }
            });
        }

        if (teamsItem.getStrInstagram() == null) {
            imgInstagram.setVisibility(View.INVISIBLE);
        } else {
            imgInstagram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + teamsItem.getStrInstagram()));
                    startActivity(intent);
                }
            });
        }
    }
}
