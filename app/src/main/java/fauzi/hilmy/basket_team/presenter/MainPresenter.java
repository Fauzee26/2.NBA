package fauzi.hilmy.basket_team.presenter;

import java.util.List;

import fauzi.hilmy.basket_team.Base.BasePresenter;
import fauzi.hilmy.basket_team.api.ApiClient;
import fauzi.hilmy.basket_team.model.ResponseTeam;
import fauzi.hilmy.basket_team.model.TeamsItem;
import fauzi.hilmy.basket_team.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {
    MainView mainView;

    public void getData(){
        call().enqueue(new Callback<ResponseTeam>() {
            @Override
            public void onResponse(Call<ResponseTeam> call, Response<ResponseTeam> response) {
                if (response.isSuccessful()){
                    List<TeamsItem> itemList = response.body().getTeams();
                    mainView.onSuccess(itemList);
                }else {
                    mainView.onError("Gagal Mengambil Data");
                }
            }

            @Override
            public void onFailure(Call<ResponseTeam> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }
    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }

    Call<ResponseTeam> call(){
        return ApiClient.getInstance().getTeams();
    }
}
