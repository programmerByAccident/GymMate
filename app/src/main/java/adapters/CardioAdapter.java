package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simpleideas.gymmate.CardioArea;
import com.simpleideas.gymmate.R;

import java.util.ArrayList;

/**
 * Created by Geprge on 20/06/2017.
 */

public class CardioAdapter extends RecyclerView.Adapter<CardioAdapter.CardioViewHolder> implements View.OnClickListener{

    ArrayList<String> cardioElements;
    Context context;

    public CardioAdapter(Context context, ArrayList<String> cardioElements){


        this.cardioElements = cardioElements;
        this.context = context;

    }

    @Override
    public CardioAdapter.CardioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.muscle_item, viewGroup,false);
        CardioViewHolder cardioViewHolder = new CardioViewHolder(view);

        return cardioViewHolder;
    }

    @Override
    public void onBindViewHolder(CardioAdapter.CardioViewHolder cardioViewHolder, int i) {

        cardioViewHolder.textView.setText(cardioElements.get(i));

    }

    @Override
    public int getItemCount() {
        return cardioElements.size();
    }

    @Override
    public void onClick(View v) {

    }


    class CardioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView textView;

        public CardioViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.muscleItem);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch(v.getId()){

                case R.id.muscleItem:

                    context.startActivity(new Intent(context, CardioArea.class));

                    break;


            }

        }
    }
}
