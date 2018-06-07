package com.example.a60310.ibeaconapp.ibeacon;

import android.bluetooth.BluetoothDevice;

/**
 * iBeaconClass类
 * 
 * @author cheny
 *
 */
public class iBeaconClass {
	/**
	 * iBeacon静态内部实体类
	 * 
	 * @author cheny
	 *
	 */
	static public class iBeacon {
		public String name;
		public int major;
		public int minor;
		public String proximityUuid;
		public String bluetoothAddress;
		public int txPower;
		public int rssi;
		public String distance;
	}

	/**
	 * 解析iBeacon信息
	 * 
	 * @param device
	 * @param rssi
	 * @param scanData
	 * @return
	 */
	public static iBeacon fromScanData(BluetoothDevice device, int rssi, byte[] scanData) {

		int startByte = 2;
		boolean patternFound = false;
		while (startByte <= 5) {
			if (((int) scanData[startByte + 2] & 0xff) == 0x02 && ((int) scanData[startByte + 3] & 0xff) == 0x15) {
				// 这是 iBeacon
				patternFound = true;
				break;
			} else if (((int) scanData[startByte] & 0xff) == 0x2d && ((int) scanData[startByte + 1] & 0xff) == 0x24
					&& ((int) scanData[startByte + 2] & 0xff) == 0xbf
					&& ((int) scanData[startByte + 3] & 0xff) == 0x16) {
				iBeacon iBeacon = new iBeacon();
				iBeacon.major = 0;
				iBeacon.minor = 0;
				iBeacon.proximityUuid = "00000000-0000-0000-0000-000000000000";
				iBeacon.txPower = -55;
				iBeacon.distance = String.format("%.2f", calculateAccuracy(iBeacon.txPower, rssi));
				return iBeacon;
			} else if (((int) scanData[startByte] & 0xff) == 0xad && ((int) scanData[startByte + 1] & 0xff) == 0x77
					&& ((int) scanData[startByte + 2] & 0xff) == 0x00
					&& ((int) scanData[startByte + 3] & 0xff) == 0xc6) {

				iBeacon iBeacon = new iBeacon();
				iBeacon.major = 0;
				iBeacon.minor = 0;
				iBeacon.proximityUuid = "00000000-0000-0000-0000-000000000000";
				iBeacon.txPower = -55;
				iBeacon.distance = String.format("%.2f", calculateAccuracy(iBeacon.txPower, rssi));
				return iBeacon;
			}
			startByte++;
		}

		if (patternFound == false) {
			// 这不是iBeacon
			return null;
		}

		iBeacon iBeacon = new iBeacon();

		iBeacon.major = (scanData[startByte + 20] & 0xff) * 0x100 + (scanData[startByte + 21] & 0xff);
		iBeacon.minor = (scanData[startByte + 22] & 0xff) * 0x100 + (scanData[startByte + 23] & 0xff);
		iBeacon.txPower = (int) scanData[startByte + 24];
		iBeacon.rssi = rssi;

		// 格式化UUID
		byte[] proximityUuidBytes = new byte[16];
		System.arraycopy(scanData, startByte + 4, proximityUuidBytes, 0, 16);
		String hexString = bytesToHexString(proximityUuidBytes);
		StringBuilder sb = new StringBuilder();
		sb.append(hexString.substring(0, 8));
		sb.append("-");
		sb.append(hexString.substring(8, 12));
		sb.append("-");
		sb.append(hexString.substring(12, 16));
		sb.append("-");
		sb.append(hexString.substring(16, 20));
		sb.append("-");
		sb.append(hexString.substring(20, 32));
		iBeacon.proximityUuid = sb.toString();


		if (device != null) {
			iBeacon.bluetoothAddress = device.getAddress();
			iBeacon.name = device.getName();
		}
		iBeacon.distance = String.format("%.2f", calculateAccuracy(iBeacon.txPower, rssi));
		return iBeacon;
	}

	/**
	 * 转换十进制
	 * 
	 * @param src
	 * @return
	 */
	private static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 估算用户设备到ibeacon的距离
	 * 
	 * @param txPower
	 * @param rssi
	 * @return
	 */
	protected static double calculateAccuracy(int txPower, double rssi) {
		if (rssi == 0) {
			return -1.0; // if we cannot determine accuracy, return -1.
		}

		double ratio = rssi * 1.0 / txPower;
		if (ratio < 1.0) {
			return Math.pow(ratio, 10);
		} else {
			double accuracy = (0.89976) * Math.pow(ratio, 7.7095) + 0.111;
			return accuracy;
		}
	}
}
