package com.example.rolldice



fun main(){
    // Pobiera z klawiatury liczbę kostek do rzucenia z przedziału
    // od 3 do 10. Punkt 1 jest powtarzany dopóki podana liczba nie
    // należy do przedziału <3, 10> - obraz 2.
    var numberOfDice: Int
    do {
        println("Ile kostek chesz rzucić?(4-10)")
        numberOfDice = readln().toInt()
    }while(numberOfDice !in 3..10)

    // Losuje tyle liczb całkowitych z przedziału od 1 do 6, ile
    // podano z klawiatury, co odpowiada rzutom kośćmi
    var diceSides = arrayOf(1, 2, 3, 4, 5, 6)

    var score: Int = 0
    while(true) {
        var diceRolls = List(numberOfDice) { diceSides.random() }

        // Wypisuje ile wyrzucono oczek na każdej kostce w formacie
        // „Kostka <numer-kostki>: <liczba-oczek>”
        // for ((index, number) in diceRolls.withIndex()) {
        //    println("Kostka ${index + 1} : $number")
        // }
        diceRolls.forEachIndexed{index, roll ->
            println("Kostka ${index+1}: $roll")
        }

        // Liczy punkty i je wyświetla zgodnie z obrazem 1.
        // Punkty są sumą oczek, gdy dana liczba została wylosowana
        // dwa razy lub więcej.
        // val rollCounts = mutableMapOf<Int, Int>()
        //   for(number in dice){
        //      rollCount[number] = rollCounts.getOrDefault(number, 0) + 1
        // }
        //wersja kotlinowa
        val rollCounts = diceRolls.groupingBy { it }.eachCount()


        // for((key, value) in iceCounts){
        //     if(value >= 2){
        //        score += key * value
        //    }
        // }
       score += rollCounts.filter { it.value >= 2 }
            .map { it.key * it.value }
            .sum()
        println("Liczba uzyskanych punktów: $score")


        println("Jeszcze raz? (t/n)")
        var response = readln()
        if (response == "n") {
            break
        }
    }
}


