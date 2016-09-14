package famaf.unc.edu.ar.activitiesassignment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {
    static final int LOGIN_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sign_in) {
            Intent newIntent = new Intent(this, LoginActivity.class);
            startActivityForResult(newIntent, LOGIN_REQUEST);
            //NewsActivityFragment newsfragment = (NewsActivityFragment)
            //        getSupportFragmentManager().findFragmentById(R.id.news_activity_fragment_id);
            //TextView textView = (TextView) findViewById(R.id.loginStatusTextView);
            //textView.setText("User XXXX logged in");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // If the request went well (OK) and the request was PICK_CONTACT_REQUEST
        if (requestCode == LOGIN_REQUEST) {
            NewsActivityFragment newsFragment = (NewsActivityFragment)
                    getSupportFragmentManager().findFragmentById(R.id.news_activity_fragment_id);
            TextView textView = (TextView) findViewById(R.id.loginStatusTextView);

            if (resultCode == Activity.RESULT_OK) {
                String userName = data.getStringExtra(LoginActivity.USERNAME);
                textView.setText("User " + userName + " logged in");
            } else
                textView.setText("User is not logged in");
        }
    }
}
