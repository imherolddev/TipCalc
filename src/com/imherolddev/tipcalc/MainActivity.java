package com.imherolddev.tipcalc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private EditText etBill;
	private EditText etTip;
	private TextView billTotal;
	private TextView tipTotal;

	BillCalculator calculator = new BillCalculator();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void calcBill(View v) {

		etBill = (EditText) findViewById(R.id.et_billAmt);
		etTip = (EditText) findViewById(R.id.et_tipAmt);
		billTotal = (TextView) findViewById(R.id.tv_billTotalMoney);
		tipTotal = (TextView) findViewById(R.id.tv_tipTotalMoney);

		if (etBill.getText().toString().equals("")
				| etBill.getText().toString().equals("0")) {

			Toast.makeText(this, getString(R.string.tst_billInvalid),
					Toast.LENGTH_LONG).show();

		} else if (etTip.getText().toString().equals("")
				| etTip.getText().toString().equals("0")) {

			Toast.makeText(this, getString(R.string.tst_tipInvalid),
					Toast.LENGTH_LONG).show();

		} else {

			billTotal.setText(calculator.calcBill(etBill.getText().toString(),
					etTip.getText().toString()));
			tipTotal.setText(calculator.getTipTotal());

		}

	}

	public void clearVals(View v) {

		etBill.setText("");
		etTip.setText("");
		billTotal.setText(getString(R.string.tv_defaultAmt));
		tipTotal.setText(getString(R.string.tv_defaultAmt));

	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
