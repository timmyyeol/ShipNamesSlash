package com.timmyyeol.shipnamesslash;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

public class GameActivity extends AppCompatActivity {

    TextView txt1;
    ImageView imageView;
    String lvl = "", edt_text = "";
    private final int IDD_true = 1, IDD_false = 2;
    EditText edt;
    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    DatabaseHelper databaseHelper;
    long userId=1;
    String our_level = "";
    Button btnans1, btnans2, btnans3, btnans4, btnans5, btnans6, btnans7, btnans8, btnans9, btnans10, btnnames, btnmovie;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;
    String [] mas = {"avbisenkrtku", "srlfditneuke", "kaqodtosisek", "brydserjafrr", "nloiccswerju", "pertsgerkxid", "vsldcjgihala",
    "loopswinzkan", "uktucvirhikh", "ajacylimjexr", "tcohelaruymr", "linrjhetooke", "monjcorhpilk", "jokmykoiknln", "kemhoavdzsym",
    "quesonlcrtet", "parjevhujoys", "ibekehbwacna", "hiecakrijomn", "neraysrdeyrp", "kusaakurnsih", "ascitwcentie", "redyrcaulisu",
    "ookfisguphor", "qibwnartayic", "mirnearominy", "skuebercalik", "leyheapixsek", "ocstimalsrdr", "xrscxayimfxs", "yrifansporot",
    "useqwminytac", "kokdebtasuui", "pihasiluejta", "waxiekeylfnu", "spydernonope", "lykcruqystio", "uoojnkkiyiha", "orehuvsiyart",
            "beclalboersg"};

    String [] masans = {"evak", "destiel", "taekook", "frerard", "siren", "sterek", "gallavich", "kaisoo", "victuuri", "malec", "merthur",
            "thorki", "johnlock", "yoonmin", "adommy", "letocest", "josher", "chanbaek", "markjin", "drarry", "sasunaru", "wincest",
            "larry", "spirk", "britin", "riren", "sebaciel", "philkas", "sciam", "mcfassy","frostiron", "newtmas", "katsudeku", "asheiji",
            "klaine", "ryden", "stucky", "jikook", "sheriarty", "sebagrell"};

    String [] mas_names = {"even naesheim and isak valtersen", "dean winchester and castiel", "kim taehyung and jung jungkook", "frank iero and gerard way",
            "simon monroe and kieren walker", "stiles stilinski and derek hale", "ian gallagher and mickey milkovich","kai and do kyungsoo", "victor nikiforov and yuuri katsuki",
            "magnus bane and alec lightwood", "merlin and arthur pendragon", "thor and loki", "john watson and sherlock holmes","min yoongi and park jimin",
            "adam lambert and tommy ratliff", "jared leto and shannon leto", "josh dun and tyler joseph", "park chanyeol and byun baekhyun", "mark tuan and park jinyoung",
    "draco malfoy and harry potter", "sasuke uchiha and naruto uzumaki", "dean winchester and sam winchester", "louis tomlinson and harry styles", "spock and james kirk",
    "brian kinney and justin taylor", "eren yeager and rivaille ackerman", "sebastian michaelis and ciel phantomhive", "philip shea and lukas waldenbeck", "scott mccall and liam dunbar",
            "james mcavoy and michael fassbender", "loki and tony (iron man)", "newt and thomas", "izuku midoriya and katsuki bakugou", "ash and eiji", "kurt hummel and blaine anderson",
            "brendon urie and ryan ross", "steve (captain america) and bucky", "jung jungkook and park jimin", "sherlock holmes and jim moriarty", "sebastian michaelis and grell sutcliff"};

    String [] mas_movie = {"skam", "supernatural", "bts", "my chemical romance", "in the flesh", "teen wolf", "shameless", "exo", "yuri on ice",
    "shadowhunters", "merlin", "marvel", "sherlock", "bts", "adam lambert", "30 seconds to mars", "twenty one pilots", "exo", "got7", "harry potter",
    "naruto", "supernatural", "one direction", "star trek", "queer as folk", "attack on titan", "black butler (kuroshitsuji)", "eyewitness", "teen wolf", "james mcavoy and michael fassbender",
            "marvel", "the maze runner", "boku no hero academia", "banana fish", "glee", "panic! at the disco", "marvel", "bts", "sherlock", "black butler (kuroshitsuji)"};

    String names = "   names   ";
    String word;
    Button[] btn = new Button[12];
    Button[] btnans;
    int wordscount = 0;
    PublisherInterstitialAd mInterstitialAd, hintAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
       // setContentView(R.layout.game5);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            lvl = extras.getString("lvl");
        }

        if(lvl.equals("1")){
            setContentView(R.layout.game4);
            wordscount = 4;
        } if(lvl.equals("5") ||lvl.equals("10")|| lvl.equals("23") || lvl.equals("24") || lvl.equals("26") || lvl.equals("29") || lvl.equals("36")){
            setContentView(R.layout.game5);
            wordscount = 5;
        } if(lvl.equals("6") || lvl.equals("8") || lvl.equals("12") || lvl.equals("15") || lvl.equals("17") || lvl.equals("20") || lvl.equals("25") ||
                lvl.equals("35") || lvl.equals("37") || lvl.equals("38")){
            setContentView(R.layout.game6);
            wordscount = 6;
        } if(lvl.equals("2") || lvl.equals("3") || lvl.equals("4") || lvl.equals("11") || lvl.equals("14") || lvl.equals("19") || lvl.equals("22") ||
                lvl.equals("28") || lvl.equals("30") || lvl.equals("32") || lvl.equals("34")){
            setContentView(R.layout.game7);
            wordscount = 7;
        } if(lvl.equals("9") || lvl.equals("13") || lvl.equals("16") || lvl.equals("18") || lvl.equals("21") || lvl.equals("27")) {
            setContentView(R.layout.game8);
            wordscount = 8;
        } if(lvl.equals("7") || lvl.equals("31") || lvl.equals("33") || lvl.equals("39") || lvl.equals("40")) {
            setContentView(R.layout.game9);
            wordscount = 9;
     //   } if(lvl.equals("")) {
     //       setContentView(R.layout.game10);
      //      wordscount = 10;
        }

        mInterstitialAd = new PublisherInterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4640210318249760/8237611111");
        requestNewInterstitial();

        hintAd = new PublisherInterstitialAd(this);
        hintAd.setAdUnitId("ca-app-pub-4640210318249760/6026380746");
        requestNewInterstitial1();

        sqlHelper = new DatabaseHelper(this);
        db = sqlHelper.getWritableDatabase();

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);
        btn12 = (Button) findViewById(R.id.button12);

        btnnames = (Button) findViewById(R.id.buttonnames);
        btnmovie = (Button) findViewById(R.id.buttonmovie);

        btnans1 = (Button) findViewById(R.id.buttonans1);
        btnans2 = (Button) findViewById(R.id.buttonans2);
        btnans3 = (Button) findViewById(R.id.buttonans3);
        btnans4 = (Button) findViewById(R.id.buttonans4);
        if(wordscount > 4) {
            btnans5 = (Button) findViewById(R.id.buttonans5);
        } if(wordscount > 5) {
            btnans6 = (Button) findViewById(R.id.buttonans6);
        } if(wordscount > 6) {
            btnans7 = (Button) findViewById(R.id.buttonans7);
        } if(wordscount > 7) {
            btnans8 = (Button) findViewById(R.id.buttonans8);
        } if(wordscount > 8) {
            btnans9 = (Button) findViewById(R.id.buttonans9);
        } if(wordscount > 9) {
            btnans10 = (Button) findViewById(R.id.buttonans10);
        }

        txt1 = (TextView) findViewById(R.id.textView);
        txt1.setText("   " + lvl + "   ");

        btn[0] = btn1; btn[1] = btn2; btn[2] = btn3; btn[3] = btn4; btn[4] = btn5; btn[5] = btn6;
        btn[6] = btn7; btn[7] = btn8; btn[8] = btn9; btn[9] = btn10; btn[10] = btn11; btn[11] = btn12;

        btnans = new Button[wordscount];
        btnans[0] = btnans1; btnans[1] = btnans2; btnans[2] = btnans3; btnans[3] = btnans4;
        if(wordscount > 4) {
            btnans[4] = btnans5;
        } if(wordscount > 5) {
            btnans[5] = btnans6;
        } if(wordscount > 6) {
            btnans[6] = btnans7;
        } if(wordscount > 7) {
            btnans[7] = btnans8;
        } if(wordscount > 8) {
            btnans[8] = btnans9;
        } if(wordscount > 9) {
            btnans[9] = btnans10;
        }

        for (int i = 0; i < 12; i++) {
            btn[i].setTypeface(Typeface.createFromAsset(
                    getAssets(), "OzHandicraftWin.ttf"));
        }
        for (int i = 0; i < wordscount; i++) {
            btnans[i].setTypeface(Typeface.createFromAsset(
                    getAssets(), "OzHandicraftWin.ttf"));
        }
        txt1.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));

        imageView = (ImageView) findViewById(R.id.imageView);
        int id = getResources().getIdentifier("q" + lvl, "drawable", getPackageName());
       // imageView.setImageResource(id);

        Resources res = getResources();
        Bitmap src = BitmapFactory.decodeResource(res, id);
        RoundedBitmapDrawable dr =
                RoundedBitmapDrawableFactory.create(res, src);
        dr.setCornerRadius(Math.max(src.getWidth()/20f, src.getHeight())/20f);
        imageView.setImageDrawable(dr);


        word = mas[Integer.decode(lvl)-1];
        char [] mas1 = new char[12];
        for (int i = 0; i < word.length(); i++){
            mas1[i] = word.charAt(i);
        }


        for (int i = 0; i < 12; i++) {
            btn[i].setText(Character.toString(mas1[i]));
        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                names();
            }
        });
        hintAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial1();
                movie();
            }
        });

    }

    private void requestNewInterstitial() {
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adRequest);
    }
    private void requestNewInterstitial1() {
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder()
                .build();
        hintAd.loadAd(adRequest);
    }

    public void btn1Click(View view) {
        btnPress(btn1);
    }

    public void btn2Click(View view) {
        btnPress(btn2);
    }

    public void btn3Click(View view) {
        btnPress(btn3);
    }

    public void btn4Click(View view) {
        btnPress(btn4);
    }

    public void btn5Click(View view) {
        btnPress(btn5);
    }

    public void btn6Click(View view) {
        btnPress(btn6);
    }

    public void btn7Click(View view) {
        btnPress(btn7);
    }

    public void btn8Click(View view) {
        btnPress(btn8);
    }

    public void btn9Click(View view) {
        btnPress(btn9);
    }

    public void btn10Click(View view) {
        btnPress(btn10);
    }

    public void btn11Click(View view) {
        btnPress(btn11);
    }

    public void btn12Click(View view) {
       btnPress(btn12);
    }

    public  void btnPress(Button btn) {
        db();
        boolean full = true;
        for(int j = 0; j < wordscount; j++){
            if (btnans[j].length() == 0) full = false;
        }
        if (!full) {
            btn.setVisibility(View.INVISIBLE);
            if (btnans1.length() == 0) {
                btnans1.setText(btn.getText());
                btnans1.setBackgroundResource(R.drawable.btnpress);
                result();
            } else if (btnans2.length() == 0) {
                btnans2.setText(btn.getText());
                btnans2.setBackgroundResource(R.drawable.btnpress);
                result();
            } else if (btnans3.length() == 0) {
                btnans3.setText(btn.getText());
                btnans3.setBackgroundResource(R.drawable.btnpress);
                result();
            } else if (btnans4.length() == 0) {
                btnans4.setText(btn.getText());
                btnans4.setBackgroundResource(R.drawable.btnpress);
                result();
            } else if (wordscount > 4) {
                if (btnans5.length() == 0) {
                    btnans5.setText(btn.getText());
                    btnans5.setBackgroundResource(R.drawable.btnpress);
                    result();
                } else if (wordscount > 5) {
                    if (btnans6.length() == 0) {
                        btnans6.setText(btn.getText());
                        btnans6.setBackgroundResource(R.drawable.btnpress);
                        result();
                    } else if (wordscount > 6) {
                        if (btnans7.length() == 0) {
                            btnans7.setText(btn.getText());
                            btnans7.setBackgroundResource(R.drawable.btnpress);
                            result();
                        } else if (wordscount > 7) {
                            if (btnans8.length() == 0) {
                                btnans8.setText(btn.getText());
                                btnans8.setBackgroundResource(R.drawable.btnpress);
                                result();
                            } else if (wordscount > 8) {
                                if (btnans9.length() == 0) {
                                    btnans9.setText(btn.getText());
                                    btnans9.setBackgroundResource(R.drawable.btnpress);
                                    result();
                                } else if (wordscount > 9) {
                                    if (btnans10.length() == 0) {
                                        btnans10.setText(btn.getText());
                                        btnans10.setBackgroundResource(R.drawable.btnpress);
                                        result();
                                    }
                                }
                            }
                        }
                    }
                }
            } else btn.setVisibility(View.VISIBLE);
        }
    }

    private  void db(){
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where " +
                DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(userId)});
        userCursor.moveToFirst();
        our_level = userCursor.getString(2);
        userCursor.close();
    }

    private void result(){
        String res = "";
        for (int i = 0; i < wordscount; i++){
            res = res + btnans[i].getText().toString();
        }
   /*     if (wordscount == 5) {
            res = btnans1.getText().toString() + btnans2.getText().toString() + btnans3.getText().toString() +
                    btnans4.getText().toString() + btnans5.getText().toString();
        } if (wordscount == 6) {
            res = btnans1.getText().toString() + btnans2.getText().toString() + btnans3.getText().toString() +
                    btnans4.getText().toString() + btnans5.getText().toString() + btnans6.getText().toString();
        } */
        if (res.equals(masans[Integer.decode(lvl)-1])){
            yes();
        }
    }

    private void yes() {

        int lev = Integer.valueOf(our_level);

        if(lev < 40) {
            lev = lev + 1;
            if(our_level.equals(lvl)) {
                ContentValues cv = new ContentValues();
                cv.put(DatabaseHelper.COLUMN_LEVELS, Integer.toString(lev));
                db.update(DatabaseHelper.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + String.valueOf(userId), null);
            }
            right();
        } else {
            if(our_level.equals(lvl)) {
                end();
            } else {
                right();
            }
        }



    }
    private  void right(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final View relativeLayout = getLayoutInflater().inflate(R.layout.idd_true, null);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.textVol);
        textView.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));

        builder.setView(relativeLayout);
        builder.setCancelable(false);
        builder.setPositiveButton("Next",

                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        int nextlvl = Integer.valueOf(lvl);
                        nextlvl = nextlvl + 1;
                        Intent i = new Intent(getApplicationContext(), GameActivity.class);
                        i.putExtra("lvl", Integer.toString(nextlvl));
                        startActivity(i);
                        dialog.cancel();
                    }
                })
                .setNeutralButton("Levels",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                Intent i = new Intent(getApplicationContext(), LevelsActivity.class);
                                startActivity(i);
                                dialog.cancel();

                            }
                        });

        AlertDialog alert = builder.create();
        alert.getWindow().setDimAmount(0);
        alert.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog));
        alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp = alert.getWindow().getAttributes();
        wmlp.gravity = Gravity.BOTTOM;
        wmlp.y = 35;
        alert.show();
        Button btnnext = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        Button btnlevels = alert.getButton(DialogInterface.BUTTON_NEUTRAL);
        btnlevels.setTextSize(30);
        btnnext.setTextSize(30);
        btnlevels.setTextColor(Color.parseColor("#000000"));
        btnnext.setTextColor(Color.parseColor("#000000"));
        btnlevels.setBackground(getResources().getDrawable(R.drawable.round_yellow));
        btnnext.setBackground(getResources().getDrawable(R.drawable.round_blue));
        btnnext.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
        btnlevels.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));

        txt1.setVisibility(View.INVISIBLE);

        for (int i = 0; i < 12; i++) {
            btn[i].setVisibility(View.INVISIBLE);
        }
        btnnames.setVisibility(View.INVISIBLE);
        btnmovie.setVisibility(View.INVISIBLE);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        int id = getResources().getIdentifier("a" + lvl, "drawable", getPackageName());
        imageView.setImageResource(id);

    }
    private  void  end(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View relativeLayout1 = getLayoutInflater().inflate(R.layout.idd_end, null);
        TextView textView1 = (TextView) relativeLayout1.findViewById(R.id.textVol);
        textView1.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
        builder.setView(relativeLayout1);
        builder.setCancelable(false);

        builder.setPositiveButton("Menu",

                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                        dialog.cancel();
                    }
                });
        AlertDialog alert1 = builder.create();
        alert1.getWindow().setDimAmount(0);
        alert1.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog));
        alert1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp = alert1.getWindow().getAttributes();
        wmlp.gravity = Gravity.BOTTOM;
        wmlp.y = 35;
        alert1.show();
        Button cont = alert1.getButton(DialogInterface.BUTTON_POSITIVE);
        cont.setTextSize(30);
        cont.setTextColor(Color.parseColor("#000000"));
        cont.setBackground(getResources().getDrawable(R.drawable.round_yellow));
        cont.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));

        txt1.setVisibility(View.INVISIBLE);

        for (int i = 0; i < 12; i++) {
            btn[i].setVisibility(View.INVISIBLE);
        }
        btnnames.setVisibility(View.INVISIBLE);
        btnmovie.setVisibility(View.INVISIBLE);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        int id = getResources().getIdentifier("a" + lvl, "drawable", getPackageName());
        imageView.setImageResource(id);

    }


    public void ans1Click(View view) {
        ansPress(btnans1);
    }

    public void ans2Click(View view) {
        ansPress(btnans2);
    }

    public void ans3Click(View view) {
        ansPress(btnans3);
    }

    public void ans4Click(View view) {
        ansPress(btnans4);
    }

    public void ans5Click(View view) {
        ansPress(btnans5);
    }

    public void ans6Click(View view) {
        ansPress(btnans6);
    }

    public void ans7Click(View view) {
        ansPress(btnans7);
    }

    public void ans8Click(View view) {
        ansPress(btnans8);
    }

    public void ans9Click(View view) {
        ansPress(btnans9);
    }

    public void ans10Click(View view) {
        ansPress(btnans10);
    }

    public  void ansPress(Button btnans) {
        if (btnans.length() > 0) {
            for (int i = 0; i < 12; i++) {
                Button[] btn = new Button[12];
                btn[0] = btn1; btn[1] = btn2; btn[2] = btn3; btn[3] = btn4; btn[4] = btn5; btn[5] = btn6;
                btn[6] = btn7; btn[7] = btn8; btn[8] = btn9; btn[9] = btn10; btn[10] = btn11; btn[11] = btn12;
                if (btn[i].getVisibility() == View.INVISIBLE && btnans.getText().toString().equals(btn[i].getText().toString())) {
                    btn[i].setVisibility(View.VISIBLE);
                    btnans.setBackgroundResource(R.drawable.img_round);
                    break;
                }
            }
            btnans.setText("");
        }
    }

    @Override
    public void onBackPressed() {
        db.close();
        Intent i = new Intent(getApplicationContext(), LevelsActivity.class);
        startActivity(i);
    }

    public void namesClick(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else
            names();
    }
    public  void names(){
        String str = "   " + mas_names[Integer.valueOf(lvl)-1] + "   ";
        help_Click(str);
    }

    public void moviesClick(View view) {
        if (hintAd.isLoaded()) {
            hintAd.show();
        } else
            movie();
    }

    public void movie() {
        String str = "   " + mas_movie[Integer.valueOf(lvl)-1] + "   ";
        help_Click(str);
    }

    public  void help_Click(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View relativeLayout1 = getLayoutInflater().inflate(R.layout.idd_names, null);
        TextView textView1 = (TextView) relativeLayout1.findViewById(R.id.textVol);
        textView1.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
        builder.setView(relativeLayout1);
        builder.setCancelable(false);

        builder.setPositiveButton("OK",

                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert1 = builder.create();
        alert1.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.round_white));
        alert1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp = alert1.getWindow().getAttributes();
        wmlp.gravity = Gravity.CENTER;
        textView1.setText(str);
        alert1.show();
        Button cont = alert1.getButton(DialogInterface.BUTTON_POSITIVE);
        cont.setTextSize(30);
        cont.setTextColor(Color.parseColor("#000000"));
        cont.setBackground(getResources().getDrawable(R.drawable.round_purple));
        cont.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
    }
}
