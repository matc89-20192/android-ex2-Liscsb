package matc89.exercicio2;

/**
 * Created by lisandra.c.bernardo on 12/09/2019.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.*;
import android.content.*;

public class OutraActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        this.mViewHolder.editText = (EditText) findViewById(R.id.editText);
        this.mViewHolder.btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        this.mViewHolder.btnCancelar = (Button) findViewById(R.id.btnCancelar);

        this.mViewHolder.btnConfirmar.setOnClickListener(this);
        this.mViewHolder.btnCancelar.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            Log.d("ReceberUser", "Insere usuário no campo editText");
            String user = bundle.getString("USER");
            this.mViewHolder.editText.setText(user);
        }

    }

    public void onClick(View v){
        if(v.getId()==R.id.btnConfirmar){
            Bundle bundle = new Bundle();
            String username = this.mViewHolder.editText.getText().toString();
            Intent intent = new Intent();
            bundle.putString("USER_NAME", username);
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
        }else if(v.getId()==R.id.btnCancelar){
            finish();
        }
    }

    private static class ViewHolder{
        EditText editText;
        Button btnConfirmar, btnCancelar;

    }

}
