package ict376.student.mobilejournal;

import android.app.Activity;
import android.os.Bundle;

public class StartingActivity extends Activity {

    makeNoteFragment makeNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        if (savedInstanceState == null) {
            makeNoteFragment makeNote = makeNoteFragment.newInstance();
            getFragmentManager().beginTransaction().add(R.id.activity_fragment_layout, makeNote).commit();
        }else{
            makeNote = (makeNoteFragment) getFragmentManager().findFragmentById(R.id.activity_fragment_layout);
        }
    }
}
