package com.cloudidev.islamic

import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudidev.islamic.adapter.RecyclerViewAdapter
import com.cloudidev.islamic.adapter.RecyclerViewAdapterBacaan
import java.util.ArrayList

class Activity_AsmaulHusna : AppCompatActivity() {

    /**
     * Created by Rdika19 19/08/2019 "Team Liquid/Dota2"|CloudiDev
     */

        internal lateinit var recyclerView: RecyclerView
        internal lateinit var recyclerView1: RecyclerView
        internal lateinit var recyclerViewAdapter: RecyclerViewAdapter
        internal lateinit var recyclerViewAdapterBacaan: RecyclerViewAdapterBacaan
        internal lateinit var recyclerViewLayoutManager: RecyclerView.LayoutManager
        internal lateinit var recyclerViewLayoutManager1: RecyclerView.LayoutManager
        internal lateinit var mediaPlayer: MediaPlayer

        private val userInformationn: List<User2>
            get() {
                val userList = ArrayList<User2>()
                userList.add(
                    User2(
                        "أشهد أن لا اله الا الله وأشهد ان محمد رسول الله",
                        "Asyhadu an laa ilaaha illallāh wa asyhadu anna Muhammad Rasuulullāh.",
                        "Aku bersaksi bahwa tiada Tuhan melainkan Allah dan Aku bersaksi Nabi Muhammad utusan Allah."
                    )
                )
                userList.add(
                    User2(
                        "اللهُمَّ صَلِّ عَلَى مُحَمَّد     يَارَبِّ صَلِّ عَلَيْهِ وَسَلِّم",
                        "Allahumma sholli ala muhammad ya robbi sholli alaihi wasallim",
                        "Ya Allah, limpahkanlah rahmat atas Nabi Muhammad Ya Tuhanku, limpahkanlah rahmat dan kesejahteraan atas beliau"
                    )
                )
                userList.add(
                    User2(
                        "وَلِلَّهِ الْأَسْمَاءُ الْحُسْنَىٰ فَادْعُوهُ بِهَا ۖ وَذَرُوا الَّذِينَ يُلْحِدُونَ فِي أَسْمَائِهِ ۚ سَيُجْزَوْنَ مَا كَانُوا يَعْمَلُونَ",
                        "Walillahil asmaa-ul husna faad'uuhu bihaa wadzaruul-ladziina yulhiduuna fii asmaa-ihi sayujzauna maa kaanuu ya'maluun(a)",
                        "Hanya milik Allah asmaa-ul husna, maka bermohonlah kepada-Nya dengan menyebut asmaa-ul husna itu dan tinggalkanlah orang-orang yang menyimpang dari kebenaran dalam (menyebut) nama-nama-Nya. Nanti mereka akan mendapat balasan terhadap apa yang telah mereka kerjakan."
                    )
                )

                return userList
            }

        private val userInformation: List<User>
            get() {

                val userList = ArrayList<User>()
                userList.add(User("", "الله", "Allah", "Allah"))
                userList.add(User("1", "الرحمن", "Ar Rahman", "Yang Maha Pengasih"))
                userList.add(User("2", "الرحيم", "Ar Rahiim", "Yang Maha Penyayang"))
                userList.add(User("3", "الملك", "Al Malik", "Yang Maha Merajai / Memerintah"))
                userList.add(User("4", "القدوس", "Al Quddus", "Yang Maha Suci"))
                userList.add(User("5", "السلام", "As Salaam", "Yang Maha Memberi Kesejahteraan"))
                userList.add(User("6", "المؤمن", "Al Mu`min", "Yang Maha Memberi Keamanan"))
                userList.add(User("7", "المهيمن", "Al Muhaimin", "Yang Maha Pemelihara"))
                userList.add(User("8", "العزيز", "Al `Aziiz", "Yang Maha PerkasaYang Maha Perkasa"))
                userList.add(User("9", "الجبار", "Al Jabbar", "Yang Memiliki Mutlak Kegagahan"))
                userList.add(User("10", "المتكبر", "Al Mutakabbir", "Yang Maha Megah, Yang Memiliki Kebesaran"))
                userList.add(User("11", "الخالق", "Al Khaliq", "Yang Maha Pencipta"))
                userList.add(
                    User(
                        "12",
                        "البارئ",
                        "Al Baari`",
                        "Yang Maha Melepaskan (Membuat, Membentuk, Menyeimbangkan)"
                    )
                )
                userList.add(User("13", "المصور", "Al Mushawwir", "Yang Maha Membentuk Rupa (makhluknya)"))
                userList.add(User("14", "الغفار", "Al Ghaffaar", "Yang Maha Pengampun"))
                userList.add(User("15", "القهار", "Al Qahhaar", "Yang Maha Menundukan"))
                userList.add(User("16", "الوهاب", "Al Wahhaab", "Yang Maha Pemberi Karunia"))
                userList.add(User("17", "الرزاق", "Ar Razzaaq", "Yang Maha Pemberi Rezeki"))
                userList.add(User("18", "الفتاح", "Al Fattaah", "Yang Maha Pembuka Rahmat"))
                userList.add(User("19", "العليم", "Al `Aliim", "Yang Maha Mengetahui (Memiliki Ilmu)"))
                userList.add(User("20", "القابض", "Al Qaabidh", "Yang Maha Menyempitkan (makhluknya)"))
                userList.add(User("21", "الباسط", "Al Baasith", "Yang Maha Melapangkan (makhluknya)"))
                userList.add(User("22", "الخافض", "Al Khaafidh", "Yang Maha Merendahkan (makhluknya)"))
                userList.add(User("23", "الرافع", "Ar Raafi`", "Yang Maha Meninggikan (makhluknya)"))
                userList.add(User("24", "المعز", "Al Mu`izz", "Yang Maha Memuliakan (makhluknya)"))
                userList.add(User("25", "المذل", "Al Mudzil", "Yang Maha Menghinakan (makhluknya)"))
                userList.add(User("26", "السميع", "Al Samii`", "Yang Maha Mendengar"))
                userList.add(User("27", "البصير", "Al Bashiir", "Yang Maha Melihat"))
                userList.add(User("28", "الحكم,", "Al Hakam", "Yang Maha Menetapkan"))
                userList.add(User("29", "العدل", "Al `Adl", "Yang Maha Adil"))
                userList.add(User("30", "اللطيف", "Al Lathiif", "Yang Maha Lembut"))
                userList.add(User("31", "الخبير", "Al Khabiir", "Yang Maha Mengenal"))
                userList.add(User("32", "الحليم", "Al Haliim", "Yang Maha Penyantun"))
                userList.add(User("33", "العظيم", "Al `Azhiim", "Allah Yang Maha Agung"))
                userList.add(User("34", "الغفور", "Al Ghafuur", "Allah Yang Maha Memberi Pengampunan"))
                userList.add(User("35", "الشكور", "As Syakuur", "Allah Yang Maha Pembalas Budi (Menghargai)"))
                userList.add(User("36", "العلى", "Al `Aliy", "Allah Yang Maha Tinggi"))
                userList.add(User("37", "الكبير", "Al Kabiir", "Yang Maha Besar"))
                userList.add(User("38", "الحفيظ", "Al Hafizh", "Allah Yang Maha Memelihara"))
                userList.add(User("39", "المقيت", "Al Muqiit", "Allah Yang Maha Pemberi Kecukupan"))
                userList.add(User("40", "الحسيب", "Al Hasiib", "Allah Yang Maha Membuat Perhitungan"))
                userList.add(User("41", "الجليل", "Al Jaliil", "Allah Yang Maha Luhur"))
                userList.add(User("42", "الكريم", "Al Kariim", "Allah Yang Maha Pemurah"))
                userList.add(User("43", "الرقيب", "Ar Raqiib", "Allah Yang Maha Mengawasi"))
                userList.add(User("44", "المجيب", "Al Mujiib", "Allah Yang Maha Mengabulkan"))
                userList.add(User("45", "الواسع", "Al Waasi`", "Allah Yang Maha Luas"))
                userList.add(User("46", "الحكيم", "Al Hakim", "Allah Yang Maha Bijaksana"))
                userList.add(User("47", "الودود", "Al Waduud", "Allah Yang Maha Mengasihi"))
                userList.add(User("48", "المجيد", "Al Majiid", "Allah Yang Maha Mulia"))
                userList.add(User("49", "الباعث", "Al Baa`its", "Allah Yang Maha Membangkitkan"))
                userList.add(User("50", "الشهيد", "As Syahiid", "Allah Yang Maha Menyaksikan"))
                userList.add(User("51", "الحق", "Al Haqq", "Allah Yang Maha Benar"))
                userList.add(User("52", "الوكيل", "Al Wakiil", "Allah Yang Maha Memelihara"))
                userList.add(User("53", "القوى", "Al Qawiyyu", "Allah Yang Maha Kuat"))
                userList.add(User("54", "المتين", "Al Matiin", "Allah Yang Maha Kokoh"))
                userList.add(User("55", "الولى", "Al Waliyy", "Allah Yang Maha Melindungi"))
                userList.add(User("56", "الحميد", "Al Hamiid", "Allah Yang Maha Terpuji"))
                userList.add(
                    User(
                        "57",
                        "المحصى",
                        "Al Muhshii",
                        "Allah Yang Maha Mengalkulasi (Menghitung Segala Sesuatu)"
                    )
                )
                userList.add(User("58", "المبدئ", "Al Mubdi`", "Allah Yang Maha Memulai"))
                userList.add(User("59", "المعيد", "Al Mu`iid", "Allah Yang Maha Mengembalikan Kehidupan"))
                userList.add(User("60", "المحيى", "Al Muhyii", "Allah Yang Maha Menghidupkan"))
                userList.add(User("61", "المميت", "Al Mumiitu", "Allah Yang Maha Mematikan"))
                userList.add(User("62", "الحي", "Al Hayyu", "Allah Yang Maha Hidup"))
                userList.add(User("63", "القيوم", "Al Qayyuum", "Allah Yang Maha Mandiri"))
                userList.add(User("64", "الواجد", "Al Waajid", "Allah Yang Maha Penemu"))
                userList.add(User("65", "الماجد", "Al Maajid", "Allah Yang Maha Mulia"))
                userList.add(User("66", "الواحد", "Al Wahid", "Allah Yang Maha Tunggal"))
                userList.add(User("67", "الاحد", "Al Ahad", "Allah Yang Maha Esa"))
                userList.add(User("68", "الصمد", "As Shamad", "Allah Yang Maha Dibutuhkan, Tempat Meminta"))
                userList.add(User("69", "القادر", "Al Qaadir", "Allah Yang Maha Menentukan, Maha Menyeimbangkan"))
                userList.add(User("70", "المقتدر", "Al Muqtadir", "Allah Yang Maha Berkuasa"))
                userList.add(User("71", "المقدم", "Al Muqaddim", "Allah Yang Maha Mendahulukan"))
                userList.add(User("72", "المؤخر", "Al Mu`akkhir", "Allah Yang Maha Mengakhirkan"))
                userList.add(User("73", "الأول", "Al Awwal", "Allah Yang Maha Awal"))
                userList.add(User("74", "الأخر", "Al Aakhir", "Allah Yang Maha Akhir"))
                userList.add(User("75", "الظاهر", "Az Zhaahir", "Allah Yang Maha Nyata"))
                userList.add(User("76", "الباطن", "Al Baathin", "Allah Yang Maha Ghaib"))
                userList.add(User("77", "الوالي", "Al Waali", "Allah Yang Maha Memerintah"))
                userList.add(User("78", "المتعالي", "Al Muta`aalii", "Allah Yang Maha Tinggi"))
                userList.add(User("79", "البر", "Al Barru", "Allah Yang Maha Penderma (Maha Pemberi Kebajikan)"))
                userList.add(User("80", "التواب", "At Tawwaab", "Allah Yang Maha Penerima Tobat"))
                userList.add(User("81", "المنتقم", "Al Muntaqim", "Allah Yang Maha Pemberi Balasan"))
                userList.add(User("82", "العفو", "Al Afuww", "Allah Yang Maha Pemaaf"))
                userList.add(User("83", "الرؤوف", "Ar Ra`uuf", "Allah Yang Maha Pengasuh"))
                userList.add(User("84", "مالك الملك", "Malikul Mulk", "Allah Yang Maha Penguasa Kerajaan (Semesta)"))
                userList.add(
                    User(
                        "85",
                        "ذو الجلال و الإكرام",
                        "Dzul Jalaali Wal Ikraam",
                        "Allah Yang Maha Pemilik Kebesaran dan Kemuliaan"
                    )
                )
                userList.add(User("86", "المقسط", "Al Muqsith", "Allah Yang Maha Pemberi Keadilan"))
                userList.add(User("87", "الجامع", "Al Jamii`", "Allah Yang Maha Mengumpulkan"))
                userList.add(User("88", "الغنى", "Al Ghaniyy", "Allah Yang Maha Kaya"))
                userList.add(User("89", "المغنى", "Al Mughnii", "Allah Yang Maha Pemberi Kekayaan"))
                userList.add(User("90", "المانع", "Al Maani", "Allah Yang Maha Mencegah"))
                userList.add(User("91", "الضار", "Ad Dhaar", "Allah Yang Maha Penimpa Kemudharatan"))
                userList.add(User("92", "النافع", "An Nafii`", "Allah Yang Maha Memberi Manfaat"))
                userList.add(User("93", "النور", "An Nuur", "Allah Yang Maha Bercahaya (Menerangi, Memberi Cahaya)"))
                userList.add(User("94", "الهادئ", "Al Haadii", "Allah Yang Maha Pemberi Petunjuk"))
                userList.add(User("95", "البديع", "Al Badii’", "Allah Yang Maha Pencipta Yang Tiada Bandingannya"))
                userList.add(User("96", "الباقي", "Al Baaqii", "Allah Yang Maha Kekal"))
                userList.add(User("97", "الوارث", "Al Waarits", "Allah Yang Maha Pewaris"))
                userList.add(User("98", "الرشيد", "Ar Rasyiid", "Allah Yang Maha Pandai"))
                userList.add(User("99", "الصبور", "As Shabuur", "Allah Yang Maha Sabar"))

                return userList
            }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_asmaulhusna)
            title = "Asmaul Husna"

            mediaPlayer = MediaPlayer.create(this@Activity_AsmaulHusna, R.raw.asmaul_husna)

            recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
            recyclerView1 = findViewById<View>(R.id.recycler_view1) as RecyclerView
            recyclerView.isNestedScrollingEnabled = true

            //Change 2 to your choice because here 2 is the number of Grid layout Columns in each row.
            recyclerViewLayoutManager = GridLayoutManager(this, 1)
            recyclerViewLayoutManager.isAutoMeasureEnabled = true
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = recyclerViewLayoutManager
            recyclerViewAdapter = RecyclerViewAdapter(applicationContext, userInformation)
            recyclerView.adapter = recyclerViewAdapter

            recyclerViewLayoutManager1 = GridLayoutManager(this, 1)
            recyclerViewLayoutManager1.isAutoMeasureEnabled = true
            recyclerView1.setHasFixedSize(true)
            recyclerView1.layoutManager = recyclerViewLayoutManager1
            recyclerViewAdapterBacaan = RecyclerViewAdapterBacaan(applicationContext, userInformationn)
            recyclerView1.adapter = recyclerViewAdapterBacaan

        }

        inner class User(val no: String, val ayat: String, val bacaan: String, val arti: String)

        inner class User2(val bacaan: String, val arti: String, val bacaanLatin: String)

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.main, menu)
            return true
        }

        //Tombol Kembali
        override fun onOptionsItemSelected(item: MenuItem): Boolean {

            when (item.itemId) {
                R.id.ket -> {
                    mediaPlayer.reset()
                    mediaPlayer = MediaPlayer.create(this@Activity_AsmaulHusna, R.raw.asmaul_husna)
                }

                R.id.suara -> if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                    item.setIcon(R.drawable.ic_play)
                } else {
                    mediaPlayer.start()
                    Toast.makeText(
                        this@Activity_AsmaulHusna,
                        "Suara Dari Bapak Dr. H.C Ary Ginanjar Agustian",
                        Toast.LENGTH_SHORT
                    ).show()
                    item.setIcon(R.drawable.ic_pause)
                }
            }
            return super.onOptionsItemSelected(item)
        }

        //override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
            // return to the App's Home Activity
            //if (keyCode == KeyEvent.KEYCODE_BACK) {
                //mediaPlayer.stop()
                //mediaPlayer.reset()
                //val alBuilder = AlertDialog.Builder(this@Activity_AsmaulHusna)
                //alBuilder.setMessage("Apa kamu ingin menutup aplikasi ini ?")
                //alBuilder.setPositiveButton("Iya") { dialog, which ->
                    //val keluar = Intent(Intent.ACTION_MAIN)
                    //keluar.addCategory(Intent.CATEGORY_HOME)
                    //keluar.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    //startActivity(keluar)
                //}.setNegativeButton("Tidak") { dialog, which -> dialog.cancel() }

                //val dialog: AlertDialog

                //dialog = alBuilder.create()
                //dialog.show()
                //return true
            //}
            //return super.onKeyDown(keyCode, event)
        }
    //}