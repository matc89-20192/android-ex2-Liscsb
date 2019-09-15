package matc89.exercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;
import android.content.*;
import android.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private ViewHolder mViewHolder = new ViewHolder();
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textView = (TextView) findViewById(R.id.textView);
        this.mViewHolder.btnTrocar = (Button) findViewById(R.id.btnTrocar);
        this.mViewHolder.btnTrocar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnTrocar){
            Intent it = new Intent(this, OutraActivity.class);


            if(!TextUtils.isEmpty(username)){
                Log.d("VerificaUser", "Já existe um usuário logado: " + username);
                it.putExtra("USER", username);
            }
            startActivityForResult(it, 1);
        }
    }

    private static class ViewHolder{
        TextView textView;
        Button btnTrocar;

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == OutraActivity.RESULT_OK) {
                 username=data.getStringExtra("USER_NAME");
                if(!TextUtils.isEmpty(username)){
                    this.mViewHolder.textView.setText("Oi, " + username + "!");

                }else{
                    this.mViewHolder.textView.setText("Oi!");

                }
            }
        }
    }
}