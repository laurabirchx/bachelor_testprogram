package dk.au.bachelor_testprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.widget.Toast;

import com.mbientlab.bletoolbox.scanner.BleScannerFragment;

import java.util.Locale;
import java.util.UUID;

public class BleScannerActivity extends AppCompatActivity implements BleScannerFragment.ScannerCommunicationBus {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble_scanner);
    }

    @Override
    public long getScanDuration() {
        ///< Scan for 10000ms (10 seconds)
        return 10000;
    }

    @Override
    public UUID[] getFilterServiceUuids() {
        ///< Only return MetaWear boards in the scan
        return new UUID[] {UUID.fromString("326a9000-85cb-9195-d9dd-464cfbbae75a")};
    }

    @Override
    public void onDeviceSelected(BluetoothDevice bluetoothDevice) {
        Toast.makeText(this, String.format(Locale.US, "Selected device: %s",
                bluetoothDevice.getAddress()), Toast.LENGTH_LONG).show();
    }
}