package com.framgia.gotosalon.screen.manager;

import com.framgia.gotosalon.data.model.Salon;

import java.util.List;

public interface ManagerContract {
    interface View {
        void onGetSalonsSuccess(List<Salon> salons);

        void onGetSalonFailed();

        void onGetSalonProgress();
    }

    interface Presenter<View> {
        void setView(ManagerContract.View view);

        void getSalons(String userId);
    }
}
