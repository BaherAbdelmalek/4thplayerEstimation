package com.example.baher.rab3_estimation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapters.CardAdapter;
import data.ApiBase;
import data.RestApi;
import models.Card;
import models.Cards;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity  extends ActionBarActivity {

    public static int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    private static Context context;
    public static int type;
    int position;
    Parcelable state;
    String key;
    CardAdapter cardsAdapter;
    List<Card> mycards;
    RestApi apiService;
    //   models.Cards cards;
    Intent intent;
    GridView gridView;
    boolean startgame;
    boolean calldone;
    boolean callfinish;
    TextView player1bids;
    TextView player2bids;
    TextView player3bids;
    TextView player4bids;
    TextView played1;
    TextView played2;
    TextView played3;
    TextView played4;

    String url;
    boolean waitfocall;
    boolean waitforbids;
    boolean playing;
    boolean startplaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1bids = (TextView)findViewById(R.id.player1bids);
        player2bids = (TextView)findViewById(R.id.player2bids);
        player3bids = (TextView)findViewById(R.id.player3bids);
        player4bids = (TextView)findViewById(R.id.player4bids);
        played1 = (TextView)findViewById(R.id.player1playing);
        played2 = (TextView)findViewById(R.id.player2playing);
        played3 = (TextView)findViewById(R.id.player3playing);
        played4 = (TextView)findViewById(R.id.player4playing);




        apiService =
                ApiBase.getClient().create(RestApi.class);

        try {
            gridView = (GridView) findViewById(R.id.cards_grid);

            if (savedInstanceState != null)
                position = (int) savedInstanceState.get("position");
            if (position != gridView.INVALID_POSITION) {
                gridView.setSelection(position);
            }



            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (startplaying) {
                        Call<Cards> call = apiService.playcard(position);
                        call.enqueue(new Callback<Cards>() {
                            @Override
                            public void onResponse(Call<Cards> call, Response<Cards> response) {
                                int[] cards = response.body().getStatus();
                                for (int i = 0; i < 4; i++) {
                                    if (i == 0) {
                                        int cardnum=(cards[i]%13)+1;
                                        int cardvalue=cards[i]/13;
                                        String value="";
                                        switch ((cardvalue)){
                                            case 0:value="spad";break;
                                            case 1:value="Heart";break;
                                            case 2:value="careux";break;
                                            case 3:value="Clubs";break;
                                            case 4:value="no trump";break;
                                        }
                                        switch (cardnum){
                                            case 11:played1.setText("played: "+cardnum +" "+ "jack" );break;
                                            case 12:played1.setText("played: "+cardnum +" "+ "dama" );break;
                                            case 13:played1.setText("played: "+cardnum +" "+ "queen" );break;
                                            default:played1.setText("played: "+cardnum +" "+ value );

                                        }
                                    }
                                    if (i == 1) {
                                        int cardnum=(cards[i]%13)+1;
                                        int cardvalue=cards[i]/13;
                                        String value="";
                                        switch ((cardvalue)){
                                            case 0:value="spad";break;
                                            case 1:value="Heart";break;
                                            case 2:value="careux";break;
                                            case 3:value="Clubs";break;
                                            case 4:value="no trump";break;
                                        }
                                        switch (cardnum){
                                            case 11:played2.setText("played: "+cardnum +" "+ "jack" );break;
                                            case 12:played2.setText("played: "+cardnum +" "+ "dama" );break;
                                            case 13:played2.setText("played: "+cardnum +" "+ "queen" );break;
                                            default:played2.setText("played: "+cardnum +" "+ value );

                                        }
                                    }
                                    if (i == 2) {
                                        int cardnum=(cards[i]%13)+1;
                                        int cardvalue=cards[i]/13;
                                        String value="";
                                        switch ((cardvalue)){
                                            case 0:value="spad";break;
                                            case 1:value="Heart";break;
                                            case 2:value="careux";break;
                                            case 3:value="Clubs";break;
                                            case 4:value="no trump";break;
                                        }
                                        switch (cardnum){
                                            case 11:played3.setText("played: "+cardnum +" "+ "jack" );break;
                                            case 12:played3.setText("played: "+cardnum +" "+ "dama" );break;
                                            case 13:played3.setText("played: "+cardnum +" "+ "queen" );break;
                                            default:played3.setText("played: "+cardnum +" "+ value );

                                        }
                                    }
                                    if (i == 3) {
                                        int cardnum=(cards[i]%13)+1;
                                        int cardvalue=cards[i]/13;
                                        String value="";
                                        switch ((cardvalue)){
                                            case 0:value="spad";break;
                                            case 1:value="Heart";break;
                                            case 2:value="careux";break;
                                            case 3:value="Clubs";break;
                                            case 4:value="no trump";break;
                                        }
                                        switch (cardnum){
                                            case 11:played4.setText("played: "+cardnum +" "+ "jack" );break;
                                            case 12:played4.setText("played: "+cardnum +" "+ "dama" );break;
                                            case 13:played4.setText("played: "+cardnum +" "+ "queen" );break;
                                            default:played4.setText("played: "+cardnum +" "+ value);

                                        }
                                    }
                                }


                            }

                            @Override
                            public void onFailure(Call<Cards> call, Throwable t) {
                                // Log error here since request failed
                                Log.e("error", t.toString());
                            }
                        });
                    }
                }
            });
        }catch (NullPointerException e){
            startActivity(intent);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent i;
        switch (id) {
            case R.id.menuRefresh:
             if(!startgame){
                 Call<Cards> call = apiService.getMyCards();
                 Log.e("started", "here");
                 call.enqueue(new Callback<Cards>() {
                     @Override
                     public void onResponse(Call<Cards> call, Response<Cards> response) {
                         int[] cards = response.body().getStatus();
                         Log.e("call", "here");
                         mycards = new ArrayList<Card>();
                         for (int i = 0; i < 13; i++) {
                             Card card = new Card(cards[i]);
                             mycards.add(card);
                         }


                         startgame = true;
                         for (int i = 0; i < 13; i++) {
                             if (cards[i] == -1)
                                 startgame = false;

                         }
                         if (startgame) {
                             cardsAdapter = new CardAdapter(MainActivity.this, mycards);
                             cardsAdapter.notifyDataSetChanged();
                             gridView.setAdapter(cardsAdapter);
                         }

                     }

                     @Override
                     public void onFailure(Call<Cards> call, Throwable t) {
                         // Log error here since request failed
                         Toast.makeText(
                                 MainActivity.this,
                                 "there is no updates ",
                                 Toast.LENGTH_SHORT).show();
                     }
                 });

             }


                if(!calldone&&startgame){
                    Call<Cards> call = apiService.waitForDash();
                   // Log.e("call dash started", "here");
                    call.enqueue(new Callback<Cards>() {
                        @Override
                        public void onResponse(Call<Cards> call, Response<Cards> response) {
                            int[] cards = response.body().getStatus();
                       //     Log.e("call dash", "here");
                            Arrays.toString(cards);
                            calldone=true;
                            for (int i = 0; i < 4; i++) {
                                Card card = new Card(cards[i]);
                                if( i==0 ){
                                    if(cards[i]==1) {
                                        player1bids.setText("dashcall");
                                    }else{
                                        player1bids.setText("pass");

                                    }
                                }
                                if( i==1 ){
                                    if(cards[i]==1) {
                                        player2bids.setText("dashcall");
                                    }else{
                                        player2bids.setText("pass");

                                    }
                                }
                                if( i==2 ){
                                    if(cards[i]==1) {
                                        player3bids.setText("dashcall");
                                    }else{
                                        player3bids.setText("pass");

                                    }
                                }
                                if( i==3 ){
                                    if(cards[i]==1) {
                                        player4bids.setText("dashcall");
                                    }else{
                                        if(cards[i]!=-1) {
                                            player4bids.setText("pass");
                                        }

                                    }
                                }
                                if(cards[i]==-1)
                                    calldone=false;

                            }

                           if(cards[2]!=-1){

                               final EditText txtUrl = new EditText(MainActivity.this);


                               AlertDialog.Builder builder =    new AlertDialog.Builder(MainActivity.this)
                                       .setTitle("Dash Call")
                                       .setMessage("if you want to be dash call write 1 else zero")
                                       .setView(txtUrl)
                                       .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                           public void onClick(DialogInterface dialog, int whichButton) {
                                               url = txtUrl.getText().toString();
                                               Log.e("dash call ",url);


                                               Call<Cards> call1 = apiService.isDashcall(Integer.parseInt(url));
                                               Log.e("call dash started", "here");
                                               call1.enqueue(new Callback<Cards>() {
                                                   @Override
                                                   public void onResponse(Call<Cards> call, Response<Cards> response) {

                                                       Log.e("isdashcall","called");

                                                       int[] cards = response.body().getStatus();
                                                       Arrays.toString(cards);
                                                       for (int i = 0; i < 4; i++) {
                                                           if( i==0 ){
                                                               if(cards[i]==1) {
                                                                   player1bids.setText("dashcall");
                                                               }else{
                                                                   player1bids.setText("pass");

                                                               }
                                                           }
                                                           if( i==1 ){
                                                               if(cards[i]==1) {
                                                                   player2bids.setText("dashcall");
                                                               }else{
                                                                   player2bids.setText("pass");

                                                               }
                                                           }
                                                           if( i==2 ){
                                                               if(cards[i]==1) {
                                                                   player3bids.setText("dashcall");
                                                               }else{
                                                                   player3bids.setText("pass");

                                                               }
                                                           }
                                                           if( i==3 ){
                                                               if(cards[i]==1) {
                                                                   player4bids.setText("dashcall");
                                                               }else{
                                                                   player4bids.setText("pass");

                                                               }
                                                           }
                                                           if(cards[i]==-1)
                                                               calldone=false;

                                                       }

                                                       calldone=true;
                                                       for(int i=0;i<4;i++){
                                                           if(cards[i]==-1)
                                                               calldone=false;
                                                       }

                                                   }

                                                   @Override
                                                   public void onFailure(Call<Cards> call, Throwable t) {
                                                       // Log error here since request failed
                                                       Log.e("error", t.toString());
                                                   }
                                               });
                                           }
                                       })
                                       .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                           public void onClick(DialogInterface dialog, int whichButton) {
                                           }
                                       });
                               AlertDialog dialog = builder.create();
                               dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                               WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();

                               wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                               wmlp.x = 50;   //x position
                               wmlp.y = 1400;   //y position

                               dialog.show();



                           }




                        }

                        @Override
                        public void onFailure(Call<Cards> call, Throwable t) {
                            // Log error here since request failed
                            Toast.makeText(
                                    MainActivity.this,
                                    "there is no updates ",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                if(!waitfocall&&startgame&&calldone){
                    Call<Cards> call = apiService.waitForCall();
                    Log.e("call dash started", "here");
                    call.enqueue(new Callback<Cards>() {
                        @Override
                        public void onResponse(Call<Cards> call, Response<Cards> response) {
                            int[] cards = response.body().getStatus();
                            Arrays.toString(cards);
                            Log.e("call dash", "here");
                            waitfocall=true;

                            for(int i=0;i<4;i++) {
                                if (cards[i] != -2)
                                    waitfocall = false;
                            }
                            if(!waitfocall) {
                                for (int i = 0; i < 4; i++) {
                                    if (cards[i] != 1 && i == 0) {
                                        Log.e("card" +i," "+cards[i]);
                                        if (cards[i] == -2) {
                                            player1bids.setText("Pass");
                                        } else {
                                            int cardnum = (cards[i] % 13) + 1;
                                            int cardvalue = cards[i] / 13;
                                            String value = "";
                                            switch ((cardvalue)) {
                                                case 0:
                                                    value = "spade";
                                                    break;
                                                case 1:
                                                    value = "Heart";
                                                    break;
                                                case 2:
                                                    value = "careux";
                                                    break;
                                                case 3:
                                                    value = "Clubs";
                                                    break;
                                                case 4:
                                                    value = "no trump";
                                                    break;
                                            }

                                            player1bids.setText("call: " + value + " " + cardnum);

                                        }

                                    }
                                    if (cards[i] != 1 && i == 1) {
                                        Log.e("card" +i," "+cards[i]);
                                        if (cards[i] == -2) {
                                            player2bids.setText("Pass");
                                        } else {
                                            int cardnum = (cards[i] % 13) + 1;
                                            int cardvalue = cards[i] / 13;
                                            String value = "";
                                            switch ((cardvalue)) {
                                                case 0:
                                                    value = "spade";
                                                    break;
                                                case 1:
                                                    value = "Heart";
                                                    break;
                                                case 2:
                                                    value = "careux";
                                                    break;
                                                case 3:
                                                    value = "Clubs";
                                                    break;
                                                case 4:
                                                    value = "no trump";
                                                    break;
                                            }
                                            player2bids.setText("call: " + value + " " + cardnum);

                                        }

                                    }
                                    if (cards[i] != 1 && i == 2) {
                                        Log.e("card" +i," "+cards[i]);
                                        if (cards[i] == -2) {
                                            player3bids.setText("Pass");
                                        } else {
                                            int cardnum = (cards[i] % 13) + 1;
                                            int cardvalue = cards[i] / 13;
                                            String value = "";
                                            switch ((cardvalue)) {
                                                case 0:
                                                    value = "spade";
                                                    break;
                                                case 1:
                                                    value = "Heart";
                                                    break;
                                                case 2:
                                                    value = "careux";
                                                    break;
                                                case 3:
                                                    value = "Clubs";
                                                    break;
                                                case 4:
                                                    value = "no trump";
                                                    break;
                                            }
                                            player3bids.setText("call: " + value + " " + cardnum);

                                        }
                                    }
                                    if (cards[i] != 1 && i == 3) {
                                        Log.e("card" +i," "+cards[i]);
                                        if (cards[i] == -2) {
                                            player4bids.setText("Pass");
                                        } else {
                                            int cardnum = (cards[i] % 13) + 1;
                                            int cardvalue = cards[i] / 13;
                                            String value = "";
                                            switch ((cardvalue)) {
                                                case 0:
                                                    value = "spade";
                                                    break;
                                                case 1:
                                                    value = "Heart";
                                                    break;
                                                case 2:
                                                    value = "careux";
                                                    break;
                                                case 3:
                                                    value = "Clubs";
                                                    break;
                                                case 4:
                                                    value = "no trump";
                                                    break;
                                            }
                                            player3bids.setText("call: " + value + " " + cardnum);

                                        }
                                    }

                                    if (cards[i] != -2)
                                        waitfocall = false;

                                }

                                if (cards[2] != -1) {

                                    final EditText txtUrl = new EditText(MainActivity.this);


                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                                            .setTitle("your Call")
                                            .setMessage("write your call or pass")
                                            .setView(txtUrl)
                                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int whichButton) {
                                                    url = txtUrl.getText().toString();
                                                    Log.e("call ", url);
                                                    int finalval = 0;
                                                    waitfocall = true;
                                                    if (url.equals("pass")) {
                                                        finalval = 0;
                                                    } else {
                                                        String[] parts = url.split(" ");
                                                        int num = Integer.parseInt(parts[0]);
                                                        int value = -1;
                                                        switch (parts[1]) {
                                                            case "spade":
                                                                value = 0;
                                                                break;
                                                            case "heart":
                                                                value = 1;
                                                                break;
                                                            case "careux":
                                                                value = 2;
                                                                break;
                                                            case "clubs":
                                                                value = 3;
                                                                break;
                                                            case "no trump":
                                                                value = 4;
                                                                break;
                                                        }
                                                        finalval = (num - 1) + (13 * value);
                                                    }
                                                    Call<Cards> call1 = apiService.iscall(finalval);
                                                    Log.e("call dash started", "here");
                                                    call1.enqueue(new Callback<Cards>() {
                                                        @Override
                                                        public void onResponse(Call<Cards> call, Response<Cards> response) {
                                                            Log.e("is call", "called");
                                                            int[] cards = response.body().getStatus();
                                                            Arrays.toString(cards);
                                                            for (int i = 0; i < 4; i++) {
                                                                if (cards[i] != 1 && i == 0) {
                                                                    if (cards[i] == -2) {
                                                                        player1bids.setText("Pass");
                                                                    } else {
                                                                        int cardnum = (cards[i] % 13) + 1;
                                                                        int cardvalue = cards[i] / 13;
                                                                        String value = "";
                                                                        switch ((cardvalue)) {
                                                                            case 0:
                                                                                value = "spade";
                                                                                break;
                                                                            case 1:
                                                                                value = "Heart";
                                                                                break;
                                                                            case 2:
                                                                                value = "careux";
                                                                                break;
                                                                            case 3:
                                                                                value = "Clubs";
                                                                                break;
                                                                            case 4:
                                                                                value = "no trump";
                                                                                break;
                                                                        }
                                                                        player1bids.setText("call: " + value + " " + cardnum);

                                                                    }

                                                                }
                                                                if (cards[i] != 1 && i == 1) {
                                                                    if (cards[i] == -2) {
                                                                        player2bids.setText("Pass");
                                                                    } else {
                                                                        int cardnum = (cards[i] % 13) + 1;
                                                                        int cardvalue = cards[i] / 13;
                                                                        String value = "";
                                                                        switch ((cardvalue)) {
                                                                            case 0:
                                                                                value = "spade";
                                                                                break;
                                                                            case 1:
                                                                                value = "Heart";
                                                                                break;
                                                                            case 2:
                                                                                value = "careux";
                                                                                break;
                                                                            case 3:
                                                                                value = "Clubs";
                                                                                break;
                                                                            case 4:
                                                                                value = "no trump";
                                                                                break;
                                                                        }
                                                                        player2bids.setText("call: " + value + " " + cardnum);

                                                                    }

                                                                }
                                                                if (cards[i] != 1 && i == 2) {
                                                                    if (cards[i] == -2) {
                                                                        player3bids.setText("Pass");
                                                                    } else {
                                                                        int cardnum = (cards[i] % 13) + 1;
                                                                        int cardvalue = cards[i] / 13;
                                                                        String value = "";
                                                                        switch ((cardvalue)) {
                                                                            case 0:
                                                                                value = "spade";
                                                                                break;
                                                                            case 1:
                                                                                value = "Heart";
                                                                                break;
                                                                            case 2:
                                                                                value = "careux";
                                                                                break;
                                                                            case 3:
                                                                                value = "Clubs";
                                                                                break;
                                                                            case 4:
                                                                                value = "no trump";
                                                                                break;
                                                                        }
                                                                        player3bids.setText("call: " + value + " " + cardnum);

                                                                    }
                                                                }
                                                                if (cards[i] != 1 && i == 3) {
                                                                    if (cards[i] == -2) {
                                                                        player4bids.setText("Pass");
                                                                    } else {
                                                                        int cardnum = (cards[i] % 13) + 1;
                                                                        int cardvalue = cards[i] / 13;
                                                                        String value = "";
                                                                        switch ((cardvalue)) {
                                                                            case 0:
                                                                                value = "spade";
                                                                                break;
                                                                            case 1:
                                                                                value = "Heart";
                                                                                break;
                                                                            case 2:
                                                                                value = "careux";
                                                                                break;
                                                                            case 3:
                                                                                value = "Clubs";
                                                                                break;
                                                                            case 4:
                                                                                value = "no trump";
                                                                                break;
                                                                        }
                                                                        player4bids.setText("call: " + value + " " + cardnum);

                                                                    }
                                                                }

                                                                if (cards[i] != -2)
                                                                    waitfocall = false;

                                                            }


                                                        }

                                                        @Override
                                                        public void onFailure(Call<Cards> call, Throwable t) {
                                                            // Log error here since request failed
                                                            Log.e("error", t.toString());
                                                        }
                                                    });
                                                }
                                            })
                                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int whichButton) {
                                                }
                                            });
                                    AlertDialog dialog = builder.create();
                                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                    WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();

                                    wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                                    wmlp.x = 50;   //x position
                                    wmlp.y = 1400;   //y position

                                    dialog.show();


                                }


                            }
                        }

                        @Override
                        public void onFailure(Call<Cards> call, Throwable t) {
                            // Log error here since request failed
                            Toast.makeText(
                                    MainActivity.this,
                                    "there is no updates ",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });


                }

                if(!waitforbids&&waitfocall&&startgame&&calldone){
                    Call<Cards> call = apiService.waitForbids();
                    Log.e("call bids started", "here");
                    call.enqueue(new Callback<Cards>() {
                        @Override
                        public void onResponse(Call<Cards> call, Response<Cards> response) {
                            int[] cards = response.body().getStatus();
                            Arrays.toString(cards);
                            Log.e("call bids", "here");
                            waitforbids=true;
                            startplaying=true;
                            for (int i = 0; i < 4; i++) {
                                if(cards[i]!=1 && i==0 ) {
                                        player1bids.setText("bids: "+cards[i]);
                                }
                                if(cards[i]!=1 && i==1 ) {
                                    player2bids.setText("bids: "+cards[i]);
                                }
                                if(cards[i]!=1 && i==2 ) {
                                    player3bids.setText("bids: "+cards[i]);
                                }
                                if(cards[i]!=1 && i==3) {
                                    player4bids.setText("bids: "+cards[i]);
                                }

                                if(cards[i]==-1) {
                                    waitforbids = false;
                                    startplaying=false;
                                }

                            }

                            if(cards[2]!=-1){
                                final EditText txtUrl = new EditText(MainActivity.this);
                                AlertDialog.Builder builder =    new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("your bids ")
                                        .setMessage("write your bids ")
                                        .setView(txtUrl)
                                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                url = txtUrl.getText().toString();
                                                Log.e("call ",url);
                                                Call<Cards> call1 = apiService.mybid(Integer.parseInt(url));
                                                Log.e("call dash started", "here");
                                                call1.enqueue(new Callback<Cards>() {
                                                    @Override
                                                    public void onResponse(Call<Cards> call, Response<Cards> response) {
                                                        Log.e("is call","called");
                                                        int[] cards = response.body().getStatus();
                                                        Arrays.toString(cards);

                                                        waitforbids=true;
                                                        startplaying=true;
                                                        for (int i = 0; i < 4; i++) {

                                                            if(cards[i]!=1 && i==0 ) {
                                                                player1bids.setText("bids: "+cards[i]);
                                                            }
                                                            if(cards[i]!=1 && i==1 ) {
                                                                player2bids.setText("bids: "+cards[i]);
                                                            }
                                                            if(cards[i]!=1 && i==2 ) {
                                                                player3bids.setText("bids: "+cards[i]);

                                                            }
                                                            if(cards[i]!=1 && i==3) {
                                                                player4bids.setText("bids: "+cards[i]);

                                                            }

                                                            if(cards[i]==-1) {
                                                                waitforbids = false;
                                                                startplaying=false;
                                                            }
                                                        }



                                                    }

                                                    @Override
                                                    public void onFailure(Call<Cards> call, Throwable t) {
                                                        // Log error here since request failed
                                                        Log.e("error", t.toString());
                                                    }
                                                });
                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                            }
                                        });

                                AlertDialog dialog = builder.create();
                                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();

                                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                                wmlp.x = 50;   //x position
                                wmlp.y = 1400;   //y position

                                dialog.show();



                            }




                        }

                        @Override
                        public void onFailure(Call<Cards> call, Throwable t) {
                            // Log error here since request failed
                            Toast.makeText(
                                    MainActivity.this,
                                    "there is no updates ",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                }

                if(!playing&&waitfocall&&startgame&&calldone&&waitforbids){
                    Call<Cards> call = apiService.waitforRoll();
                    Log.e("call roll started", "here");
                    call.enqueue(new Callback<Cards>() {
                        @Override
                        public void onResponse(Call<Cards> call, Response<Cards> response) {
                            int[] cards = response.body().getStatus();
                            Arrays.toString(cards);

                            Log.e("call rolls", "here");
                            for (int i = 0; i < 4; i++) {
                                if(cards[i]!=1 && i==0 ) {
                                    int cardnum=(cards[i]%13)+1;
                                    int cardvalue=cards[i]/13;
                                    String value="";
                                    switch ((cardvalue)){
                                        case 0:value="spad";break;
                                        case 1:value="Heart";break;
                                        case 2:value="careux";break;
                                        case 3:value="Clubs";break;
                                        case 4:value="no trump";break;
                                    }
                                    switch (cardnum){
                                        case 11:played1.setText("played: "+cardnum +" "+ "jack" );break;
                                        case 12:played1.setText("played: "+cardnum +" "+ "dama" );break;
                                        case 13:played1.setText("played: "+cardnum +" "+ "queen" );break;
                                        default:played1.setText("played: "+cardnum +" "+ value );

                                    }

                                }
                                if(cards[i]!=1 && i==1 ) {
                                    int cardnum=(cards[i]%13)+1;
                                    int cardvalue=cards[i]/13;
                                    String value="";
                                    switch ((cardvalue)){
                                        case 0:value="spad";break;
                                        case 1:value="Heart";break;
                                        case 2:value="careux";break;
                                        case 3:value="Clubs";break;
                                        case 4:value="no trump";break;
                                    }
                                    switch (cardnum){
                                        case 11:played2.setText("played: "+cardnum +" "+ "jack" );break;
                                        case 12:played2.setText("played: "+cardnum +" "+ "dama" );break;
                                        case 13:played2.setText("played: "+cardnum +" "+ "queen" );break;
                                        default: played2.setText("played: "+cardnum +" "+ value );

                                    }
                                }
                                if(cards[i]!=1 && i==2 ) {
                                    int cardnum=(cards[i]%13)+1;
                                    int cardvalue=cards[i]/13;
                                    String value="";
                                    switch ((cardvalue)){
                                        case 0:value="spad";break;
                                        case 1:value="Heart";break;
                                        case 2:value="careux";break;
                                        case 3:value="Clubs";break;
                                        case 4:value="no trump";break;
                                    }
                                    switch (cardnum){
                                        case 11:played3.setText("played: "+cardnum +" "+ "jack" );break;
                                        case 12:played3.setText("played: "+cardnum +" "+ "dama" );break;
                                        case 13:played3.setText("played: "+cardnum +" "+ "queen" );break;
                                        default: played3.setText("played: "+cardnum +" "+ value );

                                    }
                                }
                                if(cards[i]!=1 && i==3) {
                                    int cardnum=(cards[i]%13)+1;
                                    int cardvalue=cards[i]/13;
                                    String value="";
                                    switch ((cardvalue)){
                                        case 0:value="spad";break;
                                        case 1:value="Heart";break;
                                        case 2:value="careux";break;
                                        case 3:value="Clubs";break;
                                        case 4:value="no trump";break;
                                    }
                                    switch (cardnum){
                                        case 11:played4.setText("played: "+cardnum +" "+ "jack" );break;
                                        case 12:played4.setText("played: "+cardnum +" "+ "dama" );break;
                                        case 13:played4.setText("played: "+cardnum +" "+ "king" );break;
                                        default:played4.setText("played: "+cardnum +" "+ value );
                                    }
                                }

                            }

                            if(cards[2]!=-1){
                                Toast.makeText(
                                        MainActivity.this,
                                        "your turn ",
                                        Toast.LENGTH_LONG).show();
                            }






                        }

                        @Override
                        public void onFailure(Call<Cards> call, Throwable t) {
                            // Log error here since request failed
                            Toast.makeText(
                                    MainActivity.this,
                                    "there is no updates ",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                }

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
