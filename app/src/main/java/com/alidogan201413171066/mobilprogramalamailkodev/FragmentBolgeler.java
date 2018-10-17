package com.alidogan201413171066.mobilprogramalamailkodev;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alido on 29.03.2017.
 */

public class FragmentBolgeler extends Fragment{

    String[] bolgeler;
    String[] bolge_bilgileri;
    TextView tv;
    ScrollView sv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frg_bolgeler, container,false);

        sv = (ScrollView) view.findViewById(R.id.sv_bolgeler);
        tv = (TextView) view.findViewById(R.id.tv_bolgeler);

        Spinner sp = (Spinner) view.findViewById(R.id.spinner);
        bolgeler=new String[]{"   Bir Bölge Seçiniz..","1) Marmara Bölgesi","2) Ege Bölgesi","3) Akdeniz Bölgesi",
                "4) Karadeniz Bölgesi","5) İç Anadolu Bölgesi", "6) Güneydoğu Anadolu Bölgesi","7) Doğu Anadolu Bölgesi"};
        bolge_bilgileri = new String[]{"Türkiye'nin Coğrafi Bölgeleri\nTürkiye'nin coğrafi bölgeleri, 6 Haziran - 21 Haziran 1941 tarihleri arasında Ankara'da toplanan Birinci Coğrafya Kongresi tarafından belirlenmiştir. Kongre ilk, orta ve lise müfredat programları ile okul kitapları, coğrafya terimleri ve coğrafî isimlerin yazılması, Türkiye Coğrafyası'nın ana hatları ve yerlerin adlandırılması üzerinde çalışmalar yapmak amacıyla toplanmıştı. Bu çalışmanın sonucunda Türkiye'nin üç tarafının denizlerle çevrilmiş olması, dağların Anadolu'nun iç kesimlerini kıyılardan ayırması, iklim, ulaşım ve bitki örtüsü gibi kriterler dikkate alınarak Türkiye'nin coğrafi bölgeleri belirlenmiştir.\nDoğal, beşerî ve ekonomik özellikler yönünden sınırları içinde benzerlik gösteren geniş alanlara bölge denir. Sınırları içinde benzerlikleri olan ancak bölgenin diğer yerlerinden farklı olan küçük alanlara ise bölüm denir. Birinci Coğrafya Kongresinde Türkiye 7 coğrafi bölgeye ve 21 bölüme ayrılmıştır.\n" +
                "\n" +
                "Akdeniz Bölgesi:\n" +
                "Adana Bölümü, Antalya Bölümü\n" +
                "Doğu Anadolu Bölgesi:\n" +
                "Yukarı Fırat Bölümü, Erzurum-Kars Bölümü, Yukarı Murat-Van Bölümü, Hakkâri Bölümü\n" +
                "Ege Bölgesi:\n" +
                "Ege Bölümü, İç Batı Anadolu Bölümü\n" +
                "Güneydoğu Anadolu Bölgesi:\n" +
                "Orta Fırat Bölümü, Dicle Bölümü\n" +
                "İç Anadolu Bölgesi:\n" +
                "Konya Bölümü, Yukarı Sakarya Bölümü, Orta Kızılırmak Bölümü, Yukarı Kızılırmak Bölümü\n" +
                "Marmara Bölgesi:\n" +
                "Yıldız Bölümü, Ergene Bölümü, Çatalca - Kocaeli Bölümü, Güney Marmara Bölümü\n" +
                "Karadeniz Bölgesi:\n" +
                "Batı Karadeniz Bölümü, Orta Karadeniz Bölümü, Doğu Karadeniz Bölümü","Marmara Bölgesi, Türkiye'nin 7 coğrafi bölgesinden biridir.\n" +
                "\n" +
                "Köprü niteliği ile Avrupa ve Asya'yı birbirine bağladığı söylenebilir. Yaklaşık 67.000 kilometrekarelik bir yüzölçüme sahip olup Türkiye'nin %8,5'ine karşı gelir.\n" +
                "\n" +
                "Marmara Denizi de yaklaşık 11.000 km2'lik yüzölçümüyle bu bölgenin bir iç denizi durumunda olup bölgenin tam ortasını kaplar. Marmara Bölgesi'nin toplam nüfusu TÜİK 2009 yılı nüfus sayımına göre 23 milyondan fazladır.\n" +
                "\n" +
                "Marmara Bölgesinde sanayi, ticaret, turizm ve tarım gelişmiştir. Bölgedeki en gelişmiş sanayi İstanbul-Bursa-Kocaeli şehirlerinde olmakla birlikte bölgenin diğer yörelerinde de yaygın sanayi faaliyetleri vardır. Başlıca sanayi ürünleri olarak; otomotiv endüstrisi parçaları,çeşitli metal ürünler, işlenmiş gıda, dokuma, hazır giyim, çimento, kimya, kâğıt, petrokimya ürünleri, beyaz eşya sayılabilir.\n" +
                "\n" +
                "Ekili alanların yaklaşık yarısı buğday olup buğdayı şekerpancarı, mısır ve ayçiçeği izler. Bölge, Türkiye'nin ayçiçeği üretiminin yaklaşık %73'ünü, mısır üretiminin ise yaklaşık %30'unu gerçekleştirir. Bağcılık da hayli gelişmiş olup Tekirdağ, Şarköy, Mürefte, Avşa ve Bozcaada üzüm ve şarapları meşhurdur.\n" +
                "\n" +
                "Yedi coğrafi bölge içinde yükseltisi en az olan bölgedir. Ekili-dikili arazi oranı %30'dur. Ormanlık alan oranı %11,5'dir. Kümes hayvancılığı ve ipek böcekçiliği yaygındır. Nüfus ve nüfus yoğunluğu, göç alması nedeniyle çok yüksektir. Enerji tüketimi ve turizm gelirleri en yüksek bölgedir.\n" +
                "\n" +
                "İstanbul, Tekirdağ, Edirne, Kırklareli, Yalova, Kocaeli tamamen bölge sınırları içinde; Sakarya ve Bilecik'in Karadeniz Bölgesi'nde toprakları olup; Bursa ve Balıkesir'in Ege Bölgesi'nde de toprakları vardır. Çanakkale ilinin topraklarının çok büyük bir bölümü Marmara Bölgesi içinde olup sadece Edremit Körfezi çevresindeki yerleşim yerleri Ege Bölgesi sınırları içinde kalır.\n" +
                "\n" +
                "Marmara bölgesi'nin en büyük kenti İstanbul'dur. Marmara Bölgesi'ndeki en küçük kenti ise Yalova'dır.\n" +
                "\n" +
                "İstanbul, Marmara bölgesinin yoğun nüfuslu olmasında önemli bir rol oynar. İl merkezleri baz alındığında Marmara Bölgesinde yer alan iller şunlardır.\n" +
                "\n" +
                "İstanbul\n" +
                "Edirne\n" +
                "Kırklareli\n" +
                "Tekirdağ\n" +
                "Çanakkale\n" +
                "Kocaeli\n" +
                "Yalova\n" +
                "Sakarya\n" +
                "Bilecik\n" +
                "Bursa\n" +
                "Balıkesir","Ege Bölgesi, Türkiye'nin yedi coğrafi bölgesinden biridir. İsmini kıyısında olduğu Ege Denizi'nden alır. Ege (Asıl Ege, Kıyı Ege) ve İç Batı Anadolu (İç Ege) olmak üzere iki bölüme ayrılır. Kuzeyde Marmara, doğuda İç Anadolu, güneyde Akdeniz bölgeleriyle ve batıda Ege Denizi'yle çevrilidir. Türkiye'nin en uzun kıyı şeridine sahip bölgesidir. Tarihi mekanlar çoktur örneğin; Efes Antik Kenti daha birçok tarihi mekanlar vardır. Ege Bölgesinin iklimi Akdeniz İklimi'dir.\nKentleşmenin en yoğun yaşandığı bölge konumundadır. Ege Bölgesi'ndeki kentler, çoğunlukla ana yolların geçtiği oluklar ve verimli ovaların kenarlarında yer alır; kıyı kesiminde ise körfezlerin kenarlarında bulunur. Kırsal yerleşmeler, genellikle ovalardaki akarsu kenarlarında ve vadi içlerinde görülür. Türkiye nüfusunun 1/8 kadarı Ege Bölgesi'nde yaşamaktadır. Bu nüfusun yarıdan fazlası (%62,2) kentlerdedir. Ege Bölgesi'nin ortalama nüfus yoğunluğu ise Türkiye ortalamasının üzerindedir. Nüfus yoğunluğu açısından Marmara Bölgesi'nden sonra ikinci sırada bulunur. Ege Bölümü'ndeki ovalar üzerinde fazla olan nüfus yoğunluğu, İç Batı Anadolu Bölümü'nde ve Menteşe Yöresi'nde azalır.\n" +
                "\n" +
                "Nüfus bakımından Ege Bölgesi'ndeki illerin sırası şöyledir :\n" +
                "\n" +
                "İzmir\n" +
                "Manisa\n" +
                "Aydın\n" +
                "Denizli\n" +
                "Muğla\n" +
                "Afyonkarahisar\n" +
                "Kütahya\n" +
                "Uşak","Akdeniz Bölgesi, Türkiye’nin yedi coğrafi bölgesinden biridir. Anadolu’nun güneyinde Akdeniz kıyısı boyunca uzanır. Genişliği 120–180 km arasında değişir. Batı ve kuzey batısında Ege Bölgesi, kuzeyinde İç Anadolu Bölgesi, doğusunda Güneydoğu Anadolu Bölgesi, güneyinde ise Akdeniz bulunur. Güneydoğudan Suriye ile komşudur. Türkiye’nin başka bölgelerinde olduğu gibi Akdeniz Bölgesi’nde de bölge sınırları ile yönetim birimleri olan illerin sınırları tümüyle çakışmaz.\nAkdeniz Bölgesi sınırları içerisindeki iller şunlardır:\n" +
                "\n" +
                "Adana\n" +
                "Antalya\n" +
                "Burdur\n" +
                "Hatay\n" +
                "Isparta\n" +
                "Mersin\n" +
                "Osmaniye\n" +
                "Kahramanmaraş (Afşin ve Elbistan ilçeleri hariç. Bu ilçeler Doğu Anadoludadır.)\n" +
                "Karaman'ın merkez ilçe ve Ayrancı ilçelerinin bazı bölümleri Ermenek, Sarıveliler, Başyayla\n" +
                "Afyonkarahisar’ın Başmakçı, Dinar ve Dazkırı ilçeleri\n" +
                "Denizli'nin Acıpayam, Çameli, Bozkurt ve Beyağaç ilçeleri\n" +
                "Gaziantep'in İslahiye ve Nurdağı ilçeleri","Karadeniz Bölgesi, ismini Karadeniz'den alan, Sakarya Ovası'nın doğusundan Gürcistan sınırına kadar uzanan Türkiye'nin yedi coğrafi bölgesinden biridir. Türkiye'deki bölgeler arasında büyüklük bakımından üçüncü sırada yer almaktadır, ayrıca doğu-batı genişliği ve bu nedenle yerel saat farkı en fazla olan bölgedir. Karadeniz Bölgesi'nin en büyük ve gelişmiş şehirleri sırasıyla 1.250.076  kişilik toplam nüfusuyla Samsun ardından Trabzon ve Ordu'dur.\n" +
                "\n" +
                "Batı Karadeniz; Orta ve Doğu Karadeniz bölümünden daha düz olduğu için burada nüfus dağınık olarak serpilmiştir. Orta ve özellikle Doğu Karadeniz Bölümü'nde ise engebe ve yükselti fazla olduğundan dolayı nüfus toplu olarak dağılmıştır.\nİl merkezleri temel alındığında, Karadeniz Bölgesi sınırları içinde yer alan 18 ili şunlardır:\n" +
                "\n" +
                "Karabük\n" +
                "Düzce\n" +
                "Amasya\n" +
                "Artvin\n" +
                "Bartın\n" +
                "Bayburt\n" +
                "Bolu\n" +
                "Gümüşhane\n" +
                "Samsun\n" +
                "Trabzon\n" +
                "Sinop\n" +
                "Zonguldak\n" +
                "Tokat\n" +
                "Rize\n" +
                "Ordu\n" +
                "Çorum\n" +
                "Kastamonu\n" +
                "Giresun","İç Anadolu Bölgesi, Anadolu'nun orta kısmında yer alan Türkiye'nin yedi coğrafi bölgesinden biridir. Türkiye'de gelişmiş bölgeler arasında yer alır. Bu konumu sebe\u00ADbiyle bu bölgeye \"Orta Anadolu\" da denir. İç Anadolu Bölgesi'nin yüz ölçümü 151.000 km² olup bu alan Türkiye topraklarının %21'ini kaplar. Yüzölçümü bakımından Doğu Anadolu'dan sonra ikinci büyük bölgedir. Güneydoğu Anadolu Bölgesi dışında diğer bölgelerin hepsiyle komşudur. Aynı zamanda Türkiye'de \"tahıl ambarı\" olarak da anımsanır.İç Anadolu Bölgesinde toplam 13 il vardır.\n" +
                "\n" +
                "İl merkezleri temel alındığında, İç Anadolu Bölgesi sınırları içinde yer alan 13 ili şunlardır:\n" +
                "\n" +
                "Ankara\n" +
                "Konya\n" +
                "Kayseri\n" +
                "Eskişehir\n" +
                "Sivas\n" +
                "Kırıkkale\n" +
                "Aksaray\n" +
                "Karaman\n" +
                "Kırşehir\n" +
                "Niğde\n" +
                "Nevşehir\n" +
                "Yozgat\n" +
                "Çankırı\n" +
                "Bu illerden Ankara, Eskişehir, Çankırı ve Yozgat'ın bazı ilçeleri Karadeniz Bölgesi'ne, Sivas'ın bazı ilçeleri Karadeniz ve Doğu Anadolu Bölgesi'ne, Konya, Karaman ve Niğde'nin güney ilçeleri Akdeniz Bölgesi'ne, Kayseri'nin bazı ilçeleri Akdeniz ve Doğu Anadolu Bölgeleri'ne girer. Ayrıca Afyonkarahisar, Bilecik, Çorum ve Tokat illerinin bazı ilçeleri bu bölgeye girer. Karasal iklim görülür.","Güneydoğu Anadolu Bölgesi, Türkiye'nin yedi coğrafi bölgesinden biridir. Güneydoğu Torosların güneyinden Suriye sınırına kadar olan yerleri kaplar. Bölge doğu ve kuzeyden Doğu Anadolu Bölgesi, batıdan Akdeniz Bölgesi, güneyden Suriye ve kısa bir sınırla da Irak ile çevrilidir.\n" +
                "\n" +
                "Güneydoğu Anadolu Bölgesi, Türkiye'nin en düzlük bölgelerinden biri olup, bu düzlükler Arap Yarımadası'nın güneyindeki Hint Okyanusu'na kadar gider. Bölge etli ve baharatlı yiyeceklere sahip olan zengin bir mutfak kültürüne sahiptir.\nGüneydoğu Anadolu Bölgesi'nin 9 ili vardır:\n" +
                "\n" +
                "Gaziantep\n" +
                "Diyarbakır\n" +
                "Şanlıurfa\n" +
                "Batman\n" +
                "Adıyaman\n" +
                "Siirt\n" +
                "Mardin\n" +
                "Kilis\n" +
                "Şırnak","Doğu Anadolu Bölgesi, Türkiye'nin yedi coğrafi bölgesinden biridir. Anadolu topraklarındaki konumunda doğuda yer alması nedeniyle Birinci Coğrafya Kongresi tarafından 1941 yılında böyle isimlendirilmiştir. Ülkenin, nüfus yoğunluğu ve nüfusu en az olan bölgesidir. Bunda bölgenin yüz ölçümünün büyük olması başlıca etkilerindendir.\n" +
                "\n" +
                "Doğu Anadolu Bölgesinin yüz ölçümü 164.000 km²'dir. Yüz ölçümü bakımından Türkiye topraklarının %21′ini kaplar. 2012 yılındaki nüfus sayımına göre bölgenin nüfusu 5.906.680 kişidir. Nüfus bakımından en büyük il Van, yüz ölçümü bakımından en büyük il Erzurum'dur. Başlıca geçim kaynakları hayvancılık ve tarımcılıktır.\n" +
                "\n" +
                "Doğu Anadolu Bölgesi'nde dört bölüm vardır:\n" +
                "\n" +
                "Erzurum-Kars Bölümü\n" +
                "Yukarı Fırat Bölümü\n" +
                "Yukarı Murat-Van Bölümü\n" +
                "Hakkâri Bölümü\nDoğu Anadolu'da 14 tane il vardır. En çok nüfusa sahip il Van'dır.\n" +
                "\n" +
                "Ağrı\n" +
                "Ardahan\n" +
                "Bitlis\n" +
                "Bingöl\n" +
                "Elâzığ\n" +
                "Erzincan\n" +
                "Erzurum\n" +
                "Hakkâri\n" +
                "Iğdır\n" +
                "Kars\n" +
                "Malatya\n" +
                "Muş\n" +
                "Tunceli\n" +
                "Van"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,bolgeler);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)parent.getItemAtPosition(position);
                String str = value.substring(3, value.length());


                long a = parent.getSelectedItemId();
                 tv.setText(bolge_bilgileri[(int)a]);



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
}
