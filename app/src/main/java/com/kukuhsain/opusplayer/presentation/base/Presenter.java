package com.kukuhsain.opusplayer.presentation.base;

/**
 * Created by kukuh on 08/04/17.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
