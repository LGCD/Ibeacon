package com.example.a60310.ibeaconapp.ibeacon;

import com.example.a60310.ibeaconapp.R;
import com.example.a60310.ibeaconapp.ibeacon.iBeaconClass;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.ListView;
import android.widget.Toast;

/**
 * NearbyScanActivity扫描附近的ibeacon设备，模拟从后台取商品信息
 *
 * @author cheny
 */
public class NearbyScanActivity extends Activity {

    private CommodityAdapter mLeDeviceListAdapter;
    private static final int PERMISSION_GRANTED = 0;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothManager bluetoothManager;
    private ListView lv_ommodity;

    // iBeacon设备扫描回调结果
    @SuppressLint("NewApi")
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {

        @Override
        public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {

            final iBeaconClass.iBeacon ibeacon = iBeaconClass.fromScanData(device, rssi, scanRecord);
            final Commodity commodity = getCommodity(ibeacon);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLeDeviceListAdapter.addCommodity(commodity);
                    mLeDeviceListAdapter.notifyDataSetChanged();
                }
            });
        }
    };


    // 扫描频率
    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        lv_ommodity = findViewById(R.id.lv_ommodity);

        // 判断手机等设备是否支持BLE，即是否可以扫描iBeacon设备
        bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, R.string.ble_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        // 开启蓝牙
        mBluetoothAdapter.enable();

        //判断是否有权限
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //请求权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_GRANTED);
            //判断是否需要 向用户解释，为什么要申请该权限
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                Toast.makeText(this, "shouldShowRequestPermissionRationale", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mBluetoothAdapter.startLeScan(mLeScanCallback);
        // scanLeDevice(true);
        mLeDeviceListAdapter = new CommodityAdapter(this);
        lv_ommodity.setAdapter(mLeDeviceListAdapter);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        super.onPause();
        mBluetoothAdapter.stopLeScan(mLeScanCallback);
        mLeDeviceListAdapter.clear();
    }

    /**
     * 模拟根据ibeacon信息从后台取对应商品据信息
     *
     * @param ibeacon
     * @return
     */
    private Commodity getCommodity(iBeaconClass.iBeacon ibeacon) {

        if(ibeacon==null){
            return null;
        }

        if ("fda50693-a4e2-4fb1-afcf-c6eb07647825".equalsIgnoreCase(ibeacon.proximityUuid) && 10000 == ibeacon.major    // 这里是对照UUID，major,minor作为模拟唯一的识别id
                && 1000 == ibeacon.minor) {
            return new Commodity("1122", R.mipmap.a, 288.00, "老诚一锅6-8人餐\n6-8人餐,免费wifi,美味营养,回味无穷!", ibeacon.distance);

        } else if ("fda50693-a4e2-4fb1-afcf-c6eb07647825".equalsIgnoreCase(ibeacon.proximityUuid) && 10000 == ibeacon.major
                && 1001 == ibeacon.minor) {
            return new Commodity("4455", R.mipmap.b, 258.00, "净味真烤羊腿套餐\n烤羊腿套餐,可使用包间", ibeacon.distance);

        } else if ("fda50693-a4e2-4fb1-afcf-c6eb07647825".equalsIgnoreCase(ibeacon.proximityUuid)
                && 10111 == ibeacon.major && 7 == ibeacon.minor) {
            return new Commodity("7788", R.mipmap.c, 258.00, "新疆纸皮核桃\n【全国免费配送】新疆纸皮核桃2袋共1000g,仅55元，享价值116元（原价值每袋68元）",
                    ibeacon.distance);
        }
        return null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}