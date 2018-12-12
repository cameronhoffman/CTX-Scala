object Main extends App{
  var a : Char = '0'
  while(a!='Q') {
    println("What would you like to do? F-Factorial, G-GCD, P-PigLatin ---- Q-Quit")
    val input = scala.io.StdIn.readChar()
    a = input
    if (input == 'F' || input == 'f') {
      println("Enter number to preform factorial on:")
      val f = scala.io.StdIn.readInt()
      println("Returned value: " + fact(f))
    }
    else if (input == 'G' || input == 'g') {
      println("Enter two numbers (one at a time) to find the GCD:")
      val a = scala.io.StdIn.readInt()
      val b = scala.io.StdIn.readInt()
      println("The GCF of " + a + " and " + b + " is " + gcd(a, b))
    }
    else if (input == 'P' || input == 'p'){
      println("Enter word to convert to Pig Latin:")
      val s : String = scala.io.StdIn.readLine()
      val original : String = s
      val latin = pig(s)
      println(original + " in Pig Latin is " + latin)
    }
    else if (input == 'Q' || input == 'q') println("Ending Process")
    else println("Input is invalid, please try again:")
  }
  def fact(x: Int): Int ={
    if (x==0)
      return 1
    else
      return x*fact(x-1)
  }

  def gcd(x: Int,y: Int): Int ={
    if(y==0) x
    else gcd(y, x%y)
  }

  def pig(str: String): String ={
    var s = str
    if(!(s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u") || s.startsWith("A") || s.startsWith("E") || s.startsWith("I") || s.startsWith("O") || s.startsWith("U"))){
      val last : Int = s.length() - 1
      val first : Int = 0
      val beginChar : Char = s.charAt(first)
      val endChar : Char = s.charAt(last)
      var sArray = s.toArray
      sArray(first) = endChar
      sArray(last) = beginChar
      s = sArray.mkString("")
      s = s.toLowerCase
      s = s.capitalize
    }
    s = s + "ay"
    s
  }
}
