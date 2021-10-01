package com.example.itquiz

object Constans{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "Correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(
            1,
            "What does HTML stand for?",
            "Hyper Text Markup Language",
            "Hot Mail",
            "How to Make Lasagna",
            1)
        questionList.add(que1)

        val que2 = Question(
            2,
        "How many tags are in a regular element?",
        "2",
        "1",
        "3",
            1)
        questionList.add(que2)

        val que3 = Question(
            3,
        "What is the difference between an opening tag and a closing tag?",
            "Opening tag has a / in front",
            "Closing tag has a / in front",
            "There is no difference",
            2)
        questionList.add(que3)

        val que4 = Question(
            4,
        "< br  / > What type of tag is this?",
            "Break tag",
            "A broken one",
            "An opening tag",
            1)
        questionList.add(que4)

        val que5 = Question(
            5,
        "< body > Is this an opening tag or a closing tag?",
        "Opening",
        "Closing",
        "both",
        1)
        questionList.add(que5)

        val que6 = Question(
            6,
        "< / body > Is this an opening tag or a closing tag?",
            "Opening",
            "Closing",
            "both",
            2)
        questionList.add(que6)

        val que7 = Question(
            7,
        "Where is the meta tag only found?",
        "The last page",
        "The home page",
        "The second page",
        2)
        questionList.add(que7)

        val que8 = Question(
            8,
        "Which is the correct way to tag an image?",
        "src='image.jpg/gif' alt='type some text'",
            "Src='image.jpg/gif' alt='type some text'",
            " ",
            3)
        questionList.add(que8)

        val que9 = Question(
            9,
        " What is an element that does not have a closing tag called?",
        "Tag",
        "Empty element",
            "Closed element",
            2)
        questionList.add(que9)

        val que10 = Question(
            10,
        "Which of the following is an example of an empty element?",
            "< img / >",
            "< img > < / img >",
            "< / img >",
            1)
        questionList.add(que10)

        val que11 = Question(
            11,
            "What should values always be enclosed in?",
            "Quotation marks",
            "Commas",
            "Parenthesis",
            1)
        questionList.add(que11)

        val que12 = Question(
            12,
        "Where do all items for the same website need to be saved?",
        "In the same folder",
            "Where ever is fine",
            "In different folders",
            1)
        questionList.add(que12)

        val que13 = Question(
            13,
        "What does < a  h r e f = 'h t t p : / / w w w . g o o g l e . c o m'  t i t l e = ' L i n k  t o   G o o g l e  ' t a r g e t = ' _  b l a n k  ' > G o o g l e  < / a > do?",
            "Adds a link to google on the page",
            "Adds a search engine to the page",
            "Nothing",
            1)
        questionList.add(que13)

        val que14 = Question(
            14,
            "What is always a welcome page, and explains the purpose or topic of the site?",
            "Page 4",
            "Homepage",
            "Table of contents",
            2)
        questionList.add(que14)

        val que15 = Question(
            15,
            "What does View Source do?",
            "Nothing",
            "Brings up a note pad with the HTML code already used for the site.",
            "Opens a new website.",
        2)
        questionList.add(que15)

        return questionList
    }
}