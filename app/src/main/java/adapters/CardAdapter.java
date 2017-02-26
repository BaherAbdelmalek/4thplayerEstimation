package adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.baher.rab3_estimation.R;

import java.util.List;

import models.Card;

/**
 * Created by baher on 12/2/16.
 */
public class CardAdapter  extends ArrayAdapter<Card> {

    public CardAdapter(Activity context, List<Card> CardsList) {

        super(context, 0, CardsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position

        Card card = getItem(position);

        // Adapters recycle views to AdapterViews.
        // If this is a new View object we're getting, then inflate the layout.
        // If not, this view already has the layout inflated from a previous call to getView,
        // and we modify the View widgets as usual.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.card_item, parent, false);
        }
        ImageView iconView = (ImageView) convertView.findViewById(R.id.card_image);
        if (card != null) {
            Log.e("num",""+card.getCard());
            switch (card.getCard()) {
               case 0:iconView.setImageResource(R.drawable.t0);break;
               case 1:iconView.setImageResource(R.drawable.t1);break;
               case 2:iconView.setImageResource(R.drawable.t2);break;
               case 3:iconView.setImageResource(R.drawable.t3);break;
               case 4:iconView.setImageResource(R.drawable.t4);break;
               case 5:iconView.setImageResource(R.drawable.t5);break;
               case 6:iconView.setImageResource(R.drawable.t6);break;
               case 7:iconView.setImageResource(R.drawable.t7);break;
               case 8:iconView.setImageResource(R.drawable.t8);break;
               case 9:iconView.setImageResource(R.drawable.t9);break;
               case 10:iconView.setImageResource(R.drawable.t10);break;
               case 11:iconView.setImageResource(R.drawable.t11);break;
               case 12:iconView.setImageResource(R.drawable.t12);break;
               case 13:iconView.setImageResource(R.drawable.t14);break;
               case 14:iconView.setImageResource(R.drawable.t15);break;
               case 15:iconView.setImageResource(R.drawable.t16);break;
               case 16:iconView.setImageResource(R.drawable.t17);break;
               case 17:iconView.setImageResource(R.drawable.t18);break;
               case 18:iconView.setImageResource(R.drawable.t19);break;
               case 19:iconView.setImageResource(R.drawable.t20);break;
               case 20:iconView.setImageResource(R.drawable.t21);break;
               case 21:iconView.setImageResource(R.drawable.t22);break;
               case 22:iconView.setImageResource(R.drawable.t23);break;
               case 23:iconView.setImageResource(R.drawable.t24);break;
               case 24:iconView.setImageResource(R.drawable.t25);break;
               case 25:iconView.setImageResource(R.drawable.t26);break;
               case 26:iconView.setImageResource(R.drawable.t27);break;
               case 27:iconView.setImageResource(R.drawable.t28);break;
               case 28:iconView.setImageResource(R.drawable.t29);break;
               case 29:iconView.setImageResource(R.drawable.t30);break;
               case 30:iconView.setImageResource(R.drawable.t30);break;
               case 31:iconView.setImageResource(R.drawable.t32);break;
               case 32:iconView.setImageResource(R.drawable.t33);break;
               case 33:iconView.setImageResource(R.drawable.t34);break;
               case 34:iconView.setImageResource(R.drawable.t35);break;
               case 35:iconView.setImageResource(R.drawable.t36);break;
               case 36:iconView.setImageResource(R.drawable.t37);break;
               case 37:iconView.setImageResource(R.drawable.t38);break;
               case 38:iconView.setImageResource(R.drawable.t39);break;
               case 39:iconView.setImageResource(R.drawable.t40);break;
               case 40:iconView.setImageResource(R.drawable.t41);break;
               case 41:iconView.setImageResource(R.drawable.t42);break;
               case 42:iconView.setImageResource(R.drawable.t43);break;
               case 43:iconView.setImageResource(R.drawable.t44);break;
               case 44:iconView.setImageResource(R.drawable.t45);break;
               case 45:iconView.setImageResource(R.drawable.t46);break;
               case 46:iconView.setImageResource(R.drawable.t47);break;
               case 47:iconView.setImageResource(R.drawable.t48);break;
               case 48:iconView.setImageResource(R.drawable.t49);break;
               case 49:iconView.setImageResource(R.drawable.t50);break;
               case 50:iconView.setImageResource(R.drawable.t51);break;
               case 52:iconView.setImageResource(R.drawable.t52);break;

           }


           }


        return convertView;
    }
}
