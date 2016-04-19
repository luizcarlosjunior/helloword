package univel.helloword;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText EditName;
    private EditText EditLastName;
    private EditText EditAge;
    private Spinner spinnerSex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //carregar os elementos
        EditName = (EditText) findViewById(R.id.editName);
        EditLastName = (EditText) findViewById(R.id.editLastName);
        EditAge = (EditText) findViewById(R.id.editAge);
        spinnerSex = (Spinner) findViewById(R.id.spinnerSex);


        Button btnSave = (Button) findViewById(R.id.btnSAVE);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPerson(view)) {
                    SendMessage(view, "O usuário " + EditName.getText() + ", foi cadastrado com sucesso!");
                    clearForm();
                }
            }
        });


        Button btnClean = (Button) findViewById(R.id.btnCLEAN);
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearForm();
                SendMessage(view, "O formulário foi limpo!");
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ainda não está implementado...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void clearForm(){
        EditName.setText("");
        EditLastName.setText("");
        EditAge.setText("");
        spinnerSex.setSelection(0);
    }

    private boolean checkPerson(View view) {
        String name = EditName.getText().toString();
        String lastname = EditLastName.getText().toString();

        Integer age = Integer.parseInt(EditAge.getText().toString().equals("") ?  "0" : EditAge.getText().toString());

        if (name.equals("")){
            SendMessage(view, "Você precisa preencher seu nome.");
            EditName.requestFocus();
            return false;
        }

        if (lastname.equals("")){
            SendMessage(view, "Você precisa preencher seu sobrenome.");
            EditLastName.requestFocus();
            return false;
        }

        if (age <= 0){
            SendMessage(view, "A idade precisa ser maior que 0 (zero).");
            EditAge.requestFocus();
            return false;
        }

        return true;
    }

    private void SendMessage(View view, String texto) {
        Snackbar.make(view, texto, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }



}
