package joelschuman.ex1;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private int strikeCount = 0;
    private int ballCount = 0;
    private int totalOuts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //updates the ball and strike strings
    private void updateCount() {
        TextView b = (TextView)findViewById(R.id.ball_value);
        b.setText(Integer.toString(ballCount));
        TextView s = (TextView)findViewById(R.id.strike_value);
        s.setText(Integer.toString(strikeCount));
        TextView t = (TextView)findViewById(R.id.totalOuts_value);
        t.setText(Integer.toString(totalOuts));
    }

    //Called When user clicks Ball or Strike
    public void buttonClicked(View v) {
        switch (v.getId()) {
            case R.id.strike_button:
                strikeCount = strikeCount + 1;

                if (strikeCount == 3) {

                    totalOuts += 1;
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("OUT!");
                    builder.setCancelable(true);
                    builder.show();
                    strikeCount = 0;
                }
                break;
            case R.id.ball_button:
                ballCount = ballCount + 1;

                if (ballCount == 4){

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("WALK!");
                    builder.setCancelable(true);
                    builder.show();

                    ballCount = 0;
                }

                //update things
                break;

        }
        updateCount();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.reset:
                totalOuts = 0;
                updateCount();
                return true;
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
