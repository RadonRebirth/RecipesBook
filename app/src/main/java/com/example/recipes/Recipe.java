package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class Recipe extends AppCompatActivity {
    int recipe;
    String[] countries = { "Богиня вечности", "Смертная свобода", "Огненная птица", "Каменный контракт", "Вдалеке от святых"};
    String[] recipes = {
            "Коктейль: Богиня вечности\n" +
                    "Описание: плод стойкости незыблемого бога вечности и спокойствия Сёгун Райден, приготовлен с помощью электических разрядов и кровопролития тысячилетий в Инадзумской святой воде на вершине горы Ёго.\n" +
                    "Состав:\n" +
                    "1. Лепесток кровоцвета.\n" +
                    "2. Кристальный костный мозг.\n" +
                    "3. Валяшка.\n" +
                    "4. Ежевика.\n" +
                    "5. Горный лед с Драконьего хребта.\n" +
                    "Приготовление: замочите в холодной воде лепесток кровоцвета и ягоды на полчаса, в это время раздробите кристальный мозг и возьмите жилки руды на отдельную тарелку. В ёмкость 500 мл налейте 350 мл инадзумскую холодную воду, добавьте ягод, лепесток кровоцвета и жилки, затем добавьте горного льда, хорошо перемешайте.",
            "Коктейль: Смертная свобода.\n" +
                    "Описание: душа, которая покинула тело, уже не может жить самостоятельно. Венти, приняв чужой облик, навсегда унаследовал память о друге, став Божеством Свободы.\n" +
                    "Состав:\n" +
                    "1. Трава-светяшка\n" +
                    "2. Ветрянная астра\n" +
                    "3. Семена одуванчика\n" +
                    "4. Сесилия\n" +
                    "5. Волчий крюк\n" +
                    "6. Мёд\n" +
                    "7. Малиновый сироп\n" +
                    "Приготовление: в небольшую ёмкость положить сушённую траву-светяшку, сесилию, волчий крюк, астру и семена одуванчика и оставить настаиваться 10 минут, после чего добавить ложку мёда и малиновый сироп, перемешать и вылить в ёмкость.\n",
            "Коктейль: Огненная птица.\n" +
                    "Описание: храбрость - надломленный щит, и даже в покрове ночи можно остаться замеченным. Полуночной герой вновь спасает город от набегов в одиночку, оставляя лишь следы и пыль.\n" +
                    "Состав:\n" +
                    "1. Листья яблони\n" +
                    "2. Листья одуванчика\n" +
                    "3. Валяшка\n" +
                    "4. Малина\n" +
                    "5. Земляника\n" +
                    "Приготовление: кипятком залить валяшку, малину и землянику на 40 минут, в другой ёмкости кипятком залить сушённые листья, после жидкость из под ягод добавить к листьям и избавиться от листьев.",
            "Коктейль: Каменный контракт.\n" +
                    "Описание: выше облаков в горах протекает чистая вода китайской провинции, торгующей на протяжении уже нескольких тысячелетий. Напиток Властелина камня вдохновляет на новый день и готовность принимать правильные решения.\n" +
                    "Состав:\n" +
                    "1. Сесилия\n" +
                    "2. Стеклянные горные колокольчики\n" +
                    "3. Глазурная лилия\n" +
                    "4. Шелковица\n" +
                    "5. Заоблачный перчик\n" +
                    "6. Закатник\n" +
                    "Приготовление: просушить колокольчики, глазурную лилию и 1/4 заоблачного перчика, после залить кипятком листья, подождать 10 минут, добавить заоблачный перчик, порезать на мелкие части листья шелковицы и добавить, хорошо перемешать и избавиться только от листьев, после порезать закатник и украсить напиток или подать в качестве закуски.",
            "Коктейль: Вдалеке от святых.\n" +
                    "Описание: Человек, увидевший мастерство Сяо, вряд ли останется в живых, чтобы рассказать о нём. Но это не потому, что Сяо хочет навредить ему. Сяо сражается с тьмой такой могущественной, что она могла бы целиком поглотить Ли Юэ, а простой смертный, оказавшись рядом, неизбежно бы стал случайной жертвой. Сяо вовсе не избавляется от свидетелей таким образом.\n" +
                    "Состав:\n" +
                    "1. Сесилия\n" +
                    "2. Листья дуба\n" +
                    "3. Листья чайного дерева\n" +
                    "4. Кленовый сироп\n" +
                    "5. Малиновый сироп\n" +
                    "Приготовление: листья дуба и сесилии промыть кипятком, а после замочить в холодной воде на 1,5 часа, избавиться от листьев. Кипятком залить сушёные чайные листья, добавить кленовый и малиновый сиропы. Залить в ёмкость 350 мл 200 мл кипятка и разбавить холодной листовой водой."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        recipe = intent.getIntExtra("selectedItem",recipe);
        setContentView(R.layout.recipe);
        TextView text = findViewById(R.id.textView);
        TextView nametext = findViewById(R.id.nameText);
        nametext.setText(countries[recipe]);
        text.setText(recipes[recipe]);
        ConstraintLayout fon = findViewById(R.id.Recipe);
        switch (recipe){
            case 0:
                fon.setBackground(getResources().getDrawable(R.drawable.first));
                break;
            case 1:
                fon.setBackground(getResources().getDrawable(R.drawable.second));
                break;
            case 2:
                fon.setBackground(getResources().getDrawable(R.drawable.third));
                break;
            case 3:
                fon.setBackground(getResources().getDrawable(R.drawable.fourth));
                break;
            case 4:
                fon.setBackground(getResources().getDrawable(R.drawable.fifth));
                break;
        }
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        TextView mainView = findViewById(R.id.textView);
        outState.putString("mainText", String.valueOf(mainView.getText()));
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("mainText")) {
            recipe = savedInstanceState.getInt("selectedItem");
        }
    }
}