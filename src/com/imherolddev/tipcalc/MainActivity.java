package com.imherolddev.tipcalc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private EditText etBill;
	private EditText etTip;
	private TextView billTotal;
	private TextView tipTotal;
	private CheckBox chkRound;

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

	public View onCreatePanelView(int featureId) {

		etBill = (EditText) findViewById(R.id.et_billAmt);
		etTip = (EditText) findViewById(R.id.et_tipAmt);
		billTotal = (TextView) findViewById(R.id.tv_billTotalMoney);
		tipTotal = (TextView) findViewById(R.id.tv_tipTotalMoney);
		chkRound = (CheckBox) findViewById(R.id.chk_round);

		return null;

	}

	public void calcBill(View v) {

		if (etBill.getText().toString().equals("")
				| etBill.getText().toString().equals("0")) {

			this.makeToast(this, getString(R.string.tst_billInvalid), Toast.LENGTH_LONG);

		} else if (etTip.getText().toString().equals("")
				| etTip.getText().toString().equals("0")) {

			this.makeToast(this, getString(R.string.tst_tipInvalid), Toast.LENGTH_LONG);

		} else {
			
			if(Integer.parseInt(etTip.getText().toString()) < 100) {
				
				if(this.chkRound.isChecked()) {
					
					calculator.calcBill(etBill.getText().toString(),
							etTip.getText().toString());
					
					billTotal.setText(calculator.roundUp());
					tipTotal.setText(calculator.getTipTotal());
					
				} else {
				
				calculator.calcBill(etBill.getText().toString(),
						etTip.getText().toString());
				
				billTotal.setText(calculator.getBillTotal());
				tipTotal.setText(calculator.getTipTotal());
				
				}
				
			} else {

			tipTotal.setText("");
			
			this.makeToast(this, getString(R.string.tst_lessHundred), Toast.LENGTH_LONG);
			
			}

		}

	}

	public void clearVals(View v) {

		etBill.setText("");
		etTip.setText("");
		billTotal.setText(getString(R.string.tv_defaultAmt));
		tipTotal.setText(getString(R.string.tv_defaultAmt));

	}
	
	public void makeToast(Context c, String msg, int length) {
		
		Toast.makeText(c, msg, length).show();;
		
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
