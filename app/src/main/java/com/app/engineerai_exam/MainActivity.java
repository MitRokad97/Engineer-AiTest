package com.app.engineerai_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.app.engineerai_exam.adapter.PostAdapter;
import com.app.engineerai_exam.api.ServiceGenerator;
import com.app.engineerai_exam.model.HitsItem;
import com.app.engineerai_exam.model.Story;
import com.app.engineerai_exam.utility.Utility;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.alexbykov.nopaginate.callback.OnLoadMoreListener;
import ru.alexbykov.nopaginate.paginate.NoPaginate;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, PostAdapter.OnItemClickListener, View.OnClickListener {

    private SwipeRefreshLayout swipeTorefreshLayout;
    private RecyclerView rvPost;
    private TextView txtSelectedCount;
    private TextView txtRetry;
    private LinearLayout llRetry;
    private Button btnRetry;
    private int pageCount = 1;
    private NoPaginate noPaginate;
    private PostAdapter postAdapter;
    private List<HitsItem> hitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initViews();
        listeners();
        setAdapter();
        storyApiCall(pageCount);
    }

    private void initViews() {
        swipeTorefreshLayout = findViewById(R.id.swipeTorefreshLayout);
        llRetry = findViewById(R.id.llRetry);
        rvPost = findViewById(R.id.rvPost);
        txtSelectedCount = findViewById(R.id.txtSelectedCount);
        txtRetry = findViewById(R.id.txtRetry);
        btnRetry = findViewById(R.id.btnRetry);
    }

    private void listeners() {
        swipeTorefreshLayout.setOnRefreshListener(this);
        btnRetry.setOnClickListener(this);
    }

    private void setAdapter() {
        hitList = new ArrayList<>();
        postAdapter = new PostAdapter(hitList, this);
        rvPost.setAdapter(postAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getBaseContext(),
                LinearLayoutManager.HORIZONTAL);
        rvPost.addItemDecoration(dividerItemDecoration);

        noPaginate = NoPaginate.with(rvPost)
                .setOnLoadMoreListener(new OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        storyApiCall(pageCount);
                    }
                })
                .build();
        noPaginate.showLoading(true);
    }

    private void storyApiCall(final int pageNum) {
        Call<Story> storyList = ServiceGenerator.createService().getStory(pageNum);
        storyList.enqueue(new Callback<Story>() {
            @Override
            public void onResponse(@NotNull Call<Story> call, @NotNull Response<Story> response) {
                Story story = response.body();
                if (swipeTorefreshLayout.isRefreshing()) {
                    swipeTorefreshLayout.setRefreshing(false);
                }
                if (pageCount == 1) {
                    hitList.clear();
                }
                if (story != null && story.getHits() != null) {
                    hitList.addAll(story.getHits());
                    postAdapter.setItem(hitList);
                }
                if (hitList.size() == 0) {
                    llRetry.setVisibility(View.VISIBLE);
                    rvPost.setVisibility(View.GONE);
                } else {
                    llRetry.setVisibility(View.GONE);
                    rvPost.setVisibility(View.VISIBLE);
                }
                pageCount++;
                noPaginate.showLoading(false);
            }

            @Override
            public void onFailure(@NotNull Call<Story> call, @NotNull Throwable t) {
                if (swipeTorefreshLayout.isRefreshing()) {
                    swipeTorefreshLayout.setRefreshing(false);
                }
                noPaginate.showLoading(false);
                txtRetry.setText(t.getLocalizedMessage());
                llRetry.setVisibility(View.VISIBLE);
                rvPost.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        noPaginate.unbind();
    }

    @Override
    public void onRefresh() {
        refreshList();
    }

    private void refreshList() {
        pageCount = 1;
        storyApiCall(pageCount);
        txtSelectedCount.setText(getString(R.string.zero));
    }

    @Override
    public void onItemClick(List<HitsItem> item) {
        int checkedCount = 0;
        for (int i = 0; i < hitList.size(); i++) {
            if (hitList.get(i).getChecked()) {
                checkedCount++;
            }
        }
        txtSelectedCount.setText(String.valueOf(checkedCount));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRetry:
                refreshList();
                break;

            default:
                break;
        }
    }
}
