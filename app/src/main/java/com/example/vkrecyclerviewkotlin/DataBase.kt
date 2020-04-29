package com.example.vkrecyclerviewkotlin

import java.util.*

object DataBase {
    var news: MutableList<News> = ArrayList()

    init {
        news.add(
            News(
                0, R.drawable.icon5,
                "Убойный юмор",
                "6 минут назад",
                "Нигорь Королаев",
                R.drawable.news5,
                R.drawable.likemin,
                293,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "17",
                R.drawable.postmin,
                "3",
                R.drawable.viewermin,
                "11,3K"
            )
        )
        news.add(
            News(
                1, R.drawable.icon4,
                "TrollFace",
                "вчера в 10:22:00",
                null,
                R.drawable.news4,
                R.drawable.likemin,
                651,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "12",
                R.drawable.postmin,
                "5",
                R.drawable.viewermin,
                "39,6K"
            )
        )
        news.add(
            News(
                2, R.drawable.icon3,
                "Фёдор Емельяненко",
                "57 минут назад",
                """
                    💬 Александр Емельяненко

                    Рамзан Кадыров за слова отвечает! Надел перчатки и вышел в ринг!
                    """.trimIndent(),
                R.drawable.news12,
                R.drawable.likemin,
                111,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "9",
                R.drawable.postmin,
                "4",
                R.drawable.viewermin,
                "5,6K"
            )
        )
        news.add(
            News(
                3, R.drawable.icon2,
                "На приеме у Шевцова",
                "24 февраля в 15:36:50",
                null,
                R.drawable.news13,
                R.drawable.likemin,
                934,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "603",
                R.drawable.postmin,
                "65",
                R.drawable.viewermin,
                "323,4K"
            )
        )
        news.add(
            News(
                4, R.drawable.icon1,
                "Мой Компьютер",
                "вчера в 19:03:02",
                "Отличная инициатива, только вот по понятным причинам все производители гаджетов будут вставлять ей палки в колеса.",
                R.drawable.news6,
                R.drawable.likemin,
                568,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "519",
                R.drawable.postmin,
                "49",
                R.drawable.viewermin,
                "109,5K"
            )
        )
        news.add(
            News(
                5, R.drawable.icon9,
                "Наука и техника",
                "вчера в 19:17:03",
                null,
                R.drawable.news11,
                R.drawable.likemin,
                62,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "61",
                R.drawable.postmin,
                "102",
                R.drawable.viewermin,
                "277,4K"
            )
        )
        news.add(
            News(
                6, R.drawable.icon4,
                "TrollFace",
                "сегодня в 10:22:00",
                null,
                R.drawable.news10,
                R.drawable.likemin,
                155,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "8",
                R.drawable.postmin,
                "2",
                R.drawable.viewermin,
                "9,6K"
            )
        )
        news.add(
            News(
                7, R.drawable.icon6,
                "Убейся позитивом\uD83D\uDE05",
                "час назад",
                "Милахи ;))",
                R.drawable.news9,
                R.drawable.likemin,
                438,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "7",
                R.drawable.postmin,
                "11",
                R.drawable.viewermin,
                "14,5K"
            )
        )
        news.add(
            News(
                8, R.drawable.icon8,
                "Наука и техника",
                "два часа назад",
                "Настоящая легенда",
                R.drawable.news8,
                R.drawable.likemin,
                723,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "64",
                R.drawable.postmin,
                "9",
                R.drawable.viewermin,
                "38,5K"
            )
        )
        news.add(
            News(
                9, R.drawable.icon7,
                "Я очевидец Алматы",
                "вчера в 12:00:09",
                "Здравствуйте, можно напишу. Мне очень обидно за таких людей. Вчера прогуливаясь по горам, увидела такое. Что наши казахи сами все портят. Они залезли на крышу, и прыгали. Рядом сидят иностранцы из США. И это позор. Все для людей строят, а студенты их ломают. Я отругала их, и они слезли с крыши. Ведь это построили специально чтобы люди отдыхали, а не так чтобы деревня прыгала по крышам.",
                R.drawable.news7,
                R.drawable.likemin,
                379,
                0,
                R.drawable.kotmin,
                R.drawable.icon1,
                "Понравилось 1352 людям",
                "Показать ещё 454 комментариев",
                R.drawable.icon3,
                "Дамир Молдабаев",
                "Салам алейкум всем Родным!",
                "вчера в 20:30:50",
                R.drawable.reply,
                R.drawable.likemin,
                23,
                R.drawable.commentmin,
                "201",
                R.drawable.postmin,
                "3",
                R.drawable.viewermin,
                "26,5K"
            )
        )
    }
}