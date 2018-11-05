package fauzi.hilmy.basket_team.Base;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T v);
    void onDetach();
}
