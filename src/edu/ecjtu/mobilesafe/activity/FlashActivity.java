package edu.ecjtu.mobilesafe.activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;
import edu.ecjtu.mobilesafe.R;

public class FlashActivity extends Activity {

	private TextView tv_version;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		inflateViews();
	}

	private void initViews() {
		tv_version = (TextView) findViewById(R.id.tv_version);
	}

	private void inflateViews() {
		tv_version.setText("版本号：" + getVersionName());
	}

	private String getVersionName() {
		PackageManager packageManager = getPackageManager();
		try {
			PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
			String versionName = packageInfo.versionName;
			return versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
