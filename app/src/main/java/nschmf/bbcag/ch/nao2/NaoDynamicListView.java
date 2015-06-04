package nschmf.bbcag.ch.nao2;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.util.Swappable;

import java.util.ArrayList;
import java.util.List;

import model.Command;


public class NaoDynamicListView extends ActionBarActivity {

    private List<Command> mainContentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list_view);


        final DynamicListView mainContentListView = (DynamicListView) findViewById(R.id.dynamiclistview);

        mainContentList = Command.getAviableCommands();
        ObjectListArrayAdapter mainContentAdapter = new ObjectListArrayAdapter();

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(mainContentAdapter);
        animationAdapter.setAbsListView(mainContentListView);
        mainContentListView.setAdapter(animationAdapter);

        mainContentListView.enableDragAndDrop();
        mainContentListView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(final AdapterView<?> parent, final View view,
                                                   final int position, final long id) {
                        mainContentListView.startDragging(position);
                        return true;
                    }
                }
        );


    }

    private class ObjectListArrayAdapter extends BaseAdapter implements Swappable{


        @Override
        public int getCount() {
            return mainContentList.size();
        }

        @Override
        public Object getItem(int position) {
            return mainContentList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return mainContentList.get(position).getId();
        }

        //Drag and Drop
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View result = inflater.inflate(R.layout.object_list, parent, false);

            TextView label = (TextView) result.findViewById(R.id.tv_ObjectList_label);
            label.setText(mainContentList.get(position).getLabel());

            return result;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public void swapItems(int i, int i2) {
            Command tmp = mainContentList.get(i);
            mainContentList.set(i, mainContentList.get(i2));
            mainContentList.set(i2, tmp);
        }
    }



}
