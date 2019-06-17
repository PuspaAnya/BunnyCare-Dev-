package com.example.tamarapuspa.bunny1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class jenis extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jenis);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        //set title
        actionBar.setTitle("Jenis Penyakit");

        //RecyclerView
        mRecyclerView = findViewById(R.id.myRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        //set layout as LinearLayour
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //send Query to Firebase
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Penyakit");
    }

    //search data
    private void firebaseSearch(String searchText){
        //convert string entered in SearchView to lowercase
        String query = searchText.toLowerCase();

        Query firebaseSearchQuery = mRef.orderByChild("search").startAt(query).endAt(query + "\uf8ff");

        FirebaseRecyclerAdapter<modelJenisPenyakit, viewholderJenisPenyakit> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<modelJenisPenyakit, viewholderJenisPenyakit>(
                        modelJenisPenyakit.class,
                        R.layout.row_jenis_penyakit,
                        viewholderJenisPenyakit.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(viewholderJenisPenyakit viewHolder, modelJenisPenyakit model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getDescription(), model.getImage());
                    }

                    @Override
                    public viewholderJenisPenyakit onCreateViewHolder(ViewGroup parent, int viewType) {

                        viewholderJenisPenyakit viewHolderJenis = super.onCreateViewHolder(parent, viewType);

                        viewHolderJenis.setOnClickListener(new viewholderJenisPenyakit.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView mTitleTv = view.findViewById(R.id.tv_title);
                                TextView mDescTv = view.findViewById(R.id.tv_desc);
                                ImageView mImageView = view.findViewById(R.id.iv_image);

                                //get data from views
                                String mTitle = mTitleTv.getText().toString();
                                String mDesc = mDescTv.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap  = ((BitmapDrawable)mDrawable).getBitmap();

                                //pass this data to new activity
                                Intent intent = new Intent(view.getContext(), JenisPenyakitDetail.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image", bytes); //put bitmap image as array of bytes
                                intent.putExtra("title", mTitle); //put title
                                intent.putExtra("description", mDesc); //put description
                                startActivity(intent); //start activity
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {
                                //TODO do your own implementation on long item click
                            }
                        });

                        return viewHolderJenis;
                    }
                };
        //set adapter to recyclerview
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }


    //load data into recycler view onStart
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<modelJenisPenyakit, viewholderJenisPenyakit> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<modelJenisPenyakit, viewholderJenisPenyakit>(
                        modelJenisPenyakit.class,
                        R.layout.row_jenis_penyakit,
                        viewholderJenisPenyakit.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(viewholderJenisPenyakit viewHolder, modelJenisPenyakit model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getDescription(), model.getImage());
                    }

                    @Override
                    public viewholderJenisPenyakit onCreateViewHolder(ViewGroup parent, int viewType) {

                        viewholderJenisPenyakit viewHolderJenis = super.onCreateViewHolder(parent, viewType);

                        viewHolderJenis.setOnClickListener(new viewholderJenisPenyakit.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView mTitleTv = view.findViewById(R.id.tv_title);
                                TextView mDescTv = view.findViewById(R.id.tv_desc);
                                ImageView mImageView = view.findViewById(R.id.iv_image);

                                //get data from views
                                String mTitle = mTitleTv.getText().toString();
                                String mDesc = mDescTv.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap  = ((BitmapDrawable)mDrawable).getBitmap();

                                //pass this data to new activity
                                Intent intent = new Intent(view.getContext(), JenisPenyakitDetail.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image", bytes); //put bitmap image as array of bytes
                                intent.putExtra("title", mTitle); //put title
                                intent.putExtra("description", mDesc); //put description
                                startActivity(intent); //start activity
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {
                                //TODO do your own implementation on long item click
                            }
                        });

                        return viewHolderJenis;
                    }
                };

        //set adapter to recyclerview
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu; this adds item to the action bar if it present
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.act_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //filter as you type
                firebaseSearch(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //handle other action bar item clicks here
        if (id == R.id.act_search){
            //TODO
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
