package com.koriah.study_kasus_yayu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity_listpilihtenda extends ListActivity {
    String[] jenistenda = {
            "Tenda Biasa",
            "Tenda Pernikahan",
            "Tenda Camping",
            "Tenda dan kursi",
            "Paket Lengkap",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listpilihtenda);
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, jenistenda));
    }

    public void onListItemClick(
            ListView parent, View view, int position, long id)
    {

    }
    public void onClick (View view) {
        ListView listView = getListView();
        String menu = "";
        for (int i = 0; i < listView.getCount() ; i++){
            if (listView.isItemChecked(i)) {
                menu += listView.getItemAtPosition(i)+"\n";
            }
        }
        Intent intent = new Intent(this, MainActivity.class);
    intent.putExtra("jenis tenda", menu);
    startActivity(intent);
    }

}
