package com.elifnuroksuz.quiz


object setData {

    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()

        val question1 = QuestionData(
            1,
            "Which city in Turkey is known for its therapeutic thermal springs and has historically been a retreat destination, especially after being visited by Mustafa Kemal Atatürk?",
            "Bursa",
            "Yalova",
            "İzmir",
            "Ankara",
            2 // Correct answer: Yalova
        )

        val question2 = QuestionData(
            2,
            "Which event marked the beginning of the Turkish War of Independence?",
            "The Treaty of Lausanne",
            "The Armistice of Mudros",
            "The Greek occupation of İzmir",
            "The signing of the Treaty of Sèvres",
            3 // Correct answer: The Greek occupation of İzmir
        )

        val question3 = QuestionData(
            3,
            "What was the primary objective of the Tanzimat reforms in the Ottoman Empire during the 19th century?",
            "To establish a democratic republic",
            "To centralize power and modernize the military",
            "To improve the education system",
            "To create a unified legal system based on Islamic law",
            2 // Correct answer: To centralize power and modernize the military
        )

        val question4 = QuestionData(
            4,
            "Which ancient city, located in modern-day Turkey, was famously said to be the site of the Trojan War?",
            "Ephesus",
            "Troy",
            "Pergamon",
            "Antioch",
            2 // Correct answer: Troy
        )

        val question5 = QuestionData(
            5,
            "Who was the leader of the Turkish nationalist movement that eventually led to the establishment of the Republic of Turkey?",
            "Sultan Mehmed VI",
            "Mustafa Kemal Atatürk",
            "Ismet Inönü",
            "Enver Pasha",
            2 // Correct answer: Mustafa Kemal Atatürk
        )


        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}