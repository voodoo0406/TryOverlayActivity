package tw.com.voodoo0406.tryoverlayactivity;

import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import tw.com.voodoo0406.tryoverlayactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private PopupWindow popupWindow;
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    initPopupWindow();
    binding.buttonPopupWindow.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (popupWindow.isShowing()) {
          popupWindow.dismiss();
        } else {
          popupWindow.showAtLocation(binding.getRoot(), Gravity.BOTTOM, 0, 0);
          VideoView videoView = popupWindow.getContentView().findViewById(R.id.videoView);
          Uri uri = Uri.parse("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
          videoView.setVideoURI(uri);
          videoView.start();
        }
      }
    });
  }

  private void initPopupWindow() {
    LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
    View layout = inflater.inflate(R.layout.popup_window, null);
    popupWindow = new PopupWindow(layout);
    popupWindow.setFocusable(true);
    popupWindow.setWidth(1000);
    popupWindow.setHeight(1500);
  }
}
