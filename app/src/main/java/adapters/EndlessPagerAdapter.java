package adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.simpleideas.gymmate.DynamicFragment;

/**
 * Created by programmerByAccident on 9/17/2016.
 */

public class EndlessPagerAdapter extends FragmentStatePagerAdapter {


    private int get_count_return_value = 100000;
    Context context;


    public EndlessPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        int difference_between_days = position - 50000;


        return DynamicFragment.createInstanceBasedOnDifferenceBetweenCurrentDateAndPosition(difference_between_days);
    }

    @Override
    public int getCount() {
        return get_count_return_value;
    }
}