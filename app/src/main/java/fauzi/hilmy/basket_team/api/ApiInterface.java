package fauzi.hilmy.basket_team.api;

import fauzi.hilmy.basket_team.model.ResponseTeam;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("search_all_teams.php?l=NBA")
    Call<ResponseTeam> getTeams();
}