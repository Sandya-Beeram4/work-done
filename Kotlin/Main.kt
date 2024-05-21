fun numberSteps (num : Int) {
    print("[ ")
    for(i in 0..num step 2)
        print("$i ")
    print("]\n")
}

fun caseConversion (inpStr : String, case: String){
    if (case == "upper") println(inpStr.uppercase())
    else if (case == "lower") println(inpStr.lowercase())
    else println("Choose upper or lower case")
}

fun longestWordInStr (strInp : String) : String{
 var longestWord : String = ""
 val words = strInp.split(" ")
 var maxLen = 0
 for (word in words){
     if(word.length > maxLen){
         maxLen = word.length
         longestWord = word
     }
 }
 return longestWord
}

fun palindromeCheck(inputStr : String) : Boolean {
    val n = inputStr.length
    for(i in 0..n / 2){
        if(inputStr[i] != inputStr[n-1-i]) {
            return false
        }
    }
    return true
}

fun main(){
    numberSteps(8)
    caseConversion("jhdsjjdw", "upper")
    caseConversion("EHWJBSWJKSIbdjbiwue", "lower")
    caseConversion("bdwh", "camel")
    var wordLongest = longestWordInStr("Orewa Luffy Kaizoku ni naru otoko da")
    println(wordLongest)
    println(palindromeCheck("racecar"))
}