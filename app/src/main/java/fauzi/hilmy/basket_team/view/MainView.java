package fauzi.hilmy.basket_team.view;

import java.util.List;

import fauzi.hilmy.basket_team.Base.BaseView;
import fauzi.hilmy.basket_team.model.TeamsItem;

public interface MainView extends BaseView {
    void onError(String msg);

    void onSuccess(List<TeamsItem> data);
}