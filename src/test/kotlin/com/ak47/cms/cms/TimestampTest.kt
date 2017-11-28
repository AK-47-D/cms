package com.ak47.cms.cms

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.text.SimpleDateFormat

@RunWith(JUnit4::class)
class TimestampTest {

    @Test
    fun test(){
        val time= 1511850397.toLong() * 1000
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val d = format.format(time)
        println(d)
        val date = format.parse(d)
        println(date)
    }
}
