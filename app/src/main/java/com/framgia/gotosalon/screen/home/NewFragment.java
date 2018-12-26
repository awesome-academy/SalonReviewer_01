package com.framgia.gotosalon.screen.home;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.framgia.gotosalon.R;
import com.framgia.gotosalon.data.model.Salon;
import com.framgia.gotosalon.data.repository.SalonRepository;
import com.framgia.gotosalon.data.source.remote.SalonRemoteDataSource;
import com.framgia.gotosalon.screen.adapter.SalonAdapter;
import com.framgia.gotosalon.screen.base.BaseFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class NewFragment extends BaseFragment implements HomeContract.View {
    private SalonAdapter mAdapter;
    private ProgressDialog mDialog;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_new;
    }

    @Override
    protected void initComponent(View view) {
        List<Salon> mSalons = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SalonAdapter(getContext(), mSalons);
        recyclerView.setAdapter(mAdapter);
        mDialog = new ProgressDialog(getContext());
    }

    @Override
    protected void initData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference();
        HomeContract.Presenter presenter = new HomePresenter(SalonRepository.
                getInstance(SalonRemoteDataSource.getInstance(reference)));
        presenter.setView(this);
        presenter.getNewSalons();
    }

    @Override
    public void onGetSalonsSucced(List<Salon> salons) {
        mAdapter.setData(salons);
        mDialog.hide();
    }

    @Override
    public void onGetSalonsFailed() {
        mDialog.hide();
    }

    @Override
    public void onGetSalonInProgress() {
        showProgressDialog(mDialog);
    }
}
