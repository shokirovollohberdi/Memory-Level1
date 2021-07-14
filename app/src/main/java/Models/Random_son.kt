package Models

import java.util.*
import kotlin.collections.ArrayList

class Random_son {
    var bir = -1
    var ikki = -1
    var uch = -1
    var tort = -1
    var besh = -1
    var olti = -1
    var yetti = -1
    var sakkiz = -1
    var toqqiz = -1
    var on = -1
    var OnBir = -1
    var OnIkki = -1

    fun random(){
        val array  = ArrayList<Int>()
        var num = -1
        for (i in 0..12){
            num = Random().nextInt(11)
            for (i in array) {
                if (array[i] != i){
                    array.add(num)
                }
            }
        }
        bir  = array[0]
        ikki = array[1]
        uch = array[2]
        tort = array[3]
        besh = array[4]
        olti = array[5]
        yetti = array[6]
        sakkiz = array[7]
        toqqiz = array[8]
        on = array[9]
        OnBir = array[10]
        OnIkki = array[11]
    }

}