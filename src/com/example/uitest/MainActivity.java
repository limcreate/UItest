package com.example.uitest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	public final String TAG = "Lim李敏测试";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Button button1 = (Button) findViewById(R.id.btn_1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 在此处添加逻辑
				EditText input = (EditText) findViewById(R.id.edit_text_1);
				String inputText = input.getText().toString();
				if (inputText != null && !"".equals(inputText)) {
					Toast.makeText(MainActivity.this, inputText,
							Toast.LENGTH_LONG).show();
				}

				ProgressBar proBar = (ProgressBar) findViewById(R.id.progress_bar_1);
				/*if(proBar.getVisibility()==View.VISIBLE){
					proBar.setVisibility(View.GONE);
				}else{
					proBar.setVisibility(View.VISIBLE);
				}*/
				if (proBar.getProgress() < 100) {
					proBar.setProgress(proBar.getProgress() + 10);
				} else {
					proBar.setProgress(0);
				}
			}
		});

		//演示AlertDialog.Builder 操作
		Button button2 = (Button) findViewById(R.id.btn_2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "btn2 点击了");
				AlertDialog.Builder dialog = new AlertDialog.Builder(
						MainActivity.this);
				dialog.setTitle("重要提醒");
				dialog.setMessage("你的确要毁灭地球？");
				dialog.setCancelable(false);
				dialog.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(MainActivity.this,
										"马上启动毁灭程序 54321", Toast.LENGTH_LONG)
										.show();
								finish();
							}
						});
				dialog.setNegativeButton("放弃",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(MainActivity.this, "你的选择是明智的 !",
										Toast.LENGTH_LONG).show();
							}
						});
				dialog.show();
				Log.d(TAG, "btn2 点击了 执行完毕");
			}
		});

		//演示 progressDialog 操作
		Button button3 = (Button) findViewById(R.id.btn_3);
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ProgressDialog pdialog = new ProgressDialog(MainActivity.this);
				pdialog.setTitle("批量数据操作中。。。");
				pdialog.setMessage("操作中，请稍后...");
				pdialog.setCancelable(true); //设置是否可esc 退出
				pdialog.show();
			}

		});
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
}
