package com.example.parsingxmlformat

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream



//private val students = ArrayList<Students>()
//private var text = ""
//
//private var id = 0
//private var name = ""
//private var grade = 0f
//class XmlPullParser {
//    fun parse(inputStream: InputStream): ArrayList<Students> {
//        try {
//            val factory = XmlPullParserFactory.newInstance()
//            val parser = factory.newPullParser()
//            parser.setInput(inputStream, null)
//            var eventType = parser.eventType
//            while (eventType != XmlPullParser.END_DOCUMENT) {
//                val tagName = parser.name
//                when (eventType) {
//                    XmlPullParser.TEXT -> text = parser.text
//                    XmlPullParser.END_TAG -> when {
//                        tagName.equals("id", true) -> id = text.toInt()
//                        tagName.equals("name", true) -> name = text
//                        tagName.equals("grade", true) -> {
//                            grade = text.toFloat()
//                            students.add(Students(id,name, grade))
//                        }
//                        else -> {
//                        }
//                    }
//                    else -> {
//                    }
//                }
//                eventType = parser.next()
//            }
//        } catch (e: XmlPullParserException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//        return students
//    }
//
//
//}
//





























class XmlPullParser {
    private val students = ArrayList<Students>()
    private var text: String? =null

    private var id = 0
    private var studentName = ""
    private var  studentGrades = 0f

    fun parse(inputStream: InputStream): List<Students>{
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream,null)

            var eventType = parser.eventType

            while (eventType != XmlPullParser.END_DOCUMENT ){
                val tagName = parser.name

                when(eventType){
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when{
                        tagName.equals("name", ignoreCase = true) ->{
                            studentName = text.toString()
                        }
                        tagName.equals("grade", ignoreCase = true)->{
                            studentGrades = text!!.toFloat()
                        }
//                        tagName.equals("id", ignoreCase = true)->{
//                            id = text!!.toInt()
//                        }
                        else -> students.add(Students(studentName,studentGrades))
                    }
                    else -> {
                    }
                }
                eventType = parser.next()
            }

        }catch ( e: XmlPullParserException){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        }
        return students
    }
}