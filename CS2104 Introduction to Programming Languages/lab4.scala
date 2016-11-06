object Keyword {
  // permitted symbols 
  def symbols:List[String] = List("=","+","-","*","/","~","(",")")
  // reserved keywords in calculator 
  def alphas:List[String] = List("let","in")
  def specials:List[Char] = List('=','+','-','*','/','~','(',')')

}

package Lexical {
  // a lexical word
  sealed trait token
  case class Key(s: String) extends token
  case class Id(s: String) extends token
  case class Num(n: Int) extends token
  // exception for lexical analyser
  case class LexErr(s:String) extends Exception
  object test extends App {
    // printer for token
    def string_of_token (t:token) : String = 
      t match {
        case Key(s) => "Key "+s
        case Id(s) => "Id "+s
        case Num(n:Int) => "NumI "+n
      }

    def explode (s:String):List[Char] = {
      def expl(i:Int,l:List[Char]):List[Char] =
        if (i<0) l
        else expl(i-1,s.charAt(i)::l)
      expl(s.length-1,Nil)
    }

    def implode (xs:List[Char]) : String = 
      xs match {
        case Nil => ""
        case c::ts => c+implode(ts)
      }

    def is_letter_or_digit (s:Char) :Boolean = true

    def alphanum (cs:List[Char],id:List[Char]) : (String,List[Char]) =
        cs match {
          case c::cs2 => 
            if (is_letter_or_digit(c)) 
              alphanum(cs2,c::id)
            else (implode(id.reverse),cs)
          case Nil => (implode(id.reverse),Nil)
        }
    def is_mem[A](a:A,ls:List[A]) =
          ls exists ((x) => x.equals(a))
    def tokenof (a:String) : token =
          if (is_mem(a,Keyword.alphas))
            Key(a)
          else Id(a)
    def symbolic (cs:List[Char],sy:String):(String,List[Char]) =
      cs match {
        case c::cs2 => 
          if (is_mem(sy,Keyword.symbols)) (sy,cs)
          else if (!is_mem(c,Keyword.specials))
                 throw new LexErr("Unrecognized lex symbol "+sy)
          else symbolic(cs2,sy+c)
        case Nil => (sy,Nil)
      }
  }

/*
let tokenof (a:string) : token = 
	if List.mem a Keyword.alphas 
	then Key a 
	else Id a;;
*/
}

case class parseErr(smth:String)  extends Exception
case class toBeImplemented(smth:String)  extends Exception

package Parsing {
  import Lexical._
  // case class ParseErr(s:String) extends Exception
  // sealed abstract class ParseResult[+A] extends AnyRef
  // case class Success[+A](result:T,next:Input) extends ParseResult[A]
  // sealed abstract class NoSucess extends ParseResult[Nothing]
  // case class Error(msg:String,next:Input) extends NoSuccess
  // case class Failure(msg:String,next:Input) extends NoSuccess



  import scala.util.parsing.combinator._
  object P extends RegexParsers{
    //val alphanum = 
    val dateP1 = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
    val dateP1(yr, month, day) = "2011-07-15"
    val copyright: String = dateP1 findFirstIn "Date of this document: 2011-07-15" match {
      case Some(dateP1(year, month, day)) => "Copyright "+year
      case None                           => "No copyright"
    }
    def alphanum: Parser[String] = """[a-z][a-z0-9]*""".r
    def alphanum2: Parser[String] = """[a-zA-Z_][a-zA-Z0-9_]*""".r

    def getYears(text: String): Iterator[String] = 
      for (dateP1(year, _, _) <- dateP1 findAllIn text) 
      yield year

    def numbD: Parser[Double] = """\d+(\.\d*)?""".r ^^ { _.toDouble }
    def numbI: Parser[Int] = """0|[1-9]\d*""".r ^^ { _.toInt }
    def word: Parser[String]    = """[a-z]+""".r ^^ { _.toString }
    def main(args: Array[String]) = 
      println(parse(word, "johnny come lately"))
    def main2(args: Array[String]) = {
         parse(word, "johnny come lately") match {
           case Success(matched,_) => println(matched)
           case Failure(msg,_) => println("FAILURE: " + msg)
           case Error(msg,_) => println("ERROR: " + msg)
         }
    }
    val tmp = yr+5
    val plus = "+"
    val num = rep("[0-9]".r)
    val expr = num ~ plus ~ num
  }
  object Q extends RegexParsers{
    val plus = "+"
    val num = rep("[0-9]".r) map {_.mkString.toInt}
    val expr = num ~ plus ~ num map {case l ~ _ ~ r => l+r}
  }
  object R extends RegexParsers{
    val plus = "+"
    val num = rep("[0-9]".r) map {_.mkString.toInt}
    val side = "(" ~> expr <~ ")" | num
    val expr:Parser[Int] = side ~ plus ~ side map {case l ~ _ ~ r => l+r}
  }

  object Test {
    P.parseAll(P.expr,"123+123")
    P.parseAll(P.expr,"123123")
  }

  object Calculator extends RegexParsers {
    def number: Parser[Double] = """\d+(\.\d*)?""".r ^^ { _.toDouble }
    def factor: Parser[Double] = number | "(" ~> expr <~ ")"
    def term  : Parser[Double] = factor ~ ( "*" ~ factor | "/" ~ factor
       ).* ^^ {
        case number ~ list => (number /: list) {
        case (x, "*" ~ y) => x * y
        case (x, "/" ~ y) => x / y
      }
    }
    def expr  : Parser[Double] = term ~ ("+" ~ log(term)("Plus term") | "-" ~ log(term)("Minus term")).* ^^ {
      case number ~ list => list.foldLeft(number) { // same as before, using alternate name for /:
        case (x, "+" ~ y) => x + y
        case (x, "-" ~ y) => x - y
      }
    }

  def apply(input: String): Double = parseAll(expr, input) match {
    case Success(result, _) => result
    case failure : NoSuccess => scala.sys.error(failure.msg)
  }
}
  class Parsec[+A] {
    type Parser[A] = List[token] => (A,List[token])
    type tokens = List[token]
    def symbol(s:String):Parser[Unit] = {
      val exc = new ParseErr("Symbol "+s+" expected.")
      (toks:List[token]) => toks match {
        case Key(b)::toks => 
          if (s.equals(b)) ((),toks)
          else throw exc
        case _ => throw exc
      }
    }
    def ident:Parser[String] =
      (toks:List[token]) => toks match {
        case Id(a)::toks => (a,toks)
        case _ => throw new ParseErr("Identifier expected")
      }
    def numb:Parser[Int] =
      (toks:List[token]) => toks match {
        case Num(a)::toks => (a,toks)
        case _ => throw new ParseErr("Integer expected")
      }

    def alt[A,B](ph1:Parser[A],ph2:Parser[B]) (toks:List[token]) = {
      val tup1 = ph1 (toks) 
      val tup2 = ph2 (tup1._2)
      ((tup1._1,tup2._1),tup2._2)
    }

    def |[A](ph1:Parser[A],ph2:Parser[A]) (toks:List[token]) = {
      try {
        ph1(toks)
        } 
      catch { 
        case e:ParseErr => 
          ph2(toks)
      }
    }
/*
 let (++) (ph1 : tokens->'a*tokens) 
          (ph2 : tokens->'b*tokens) 
          (toks:tokens) : ('a*'b)*tokens =
     let (t1,toks1) = ph1 toks in
     let (t2,toks2) = ph2 toks1 in
     ((t1,t2),toks2)

let (|%|) (ph1:tokens -> 'a*tokens) 
         	(ph2:tokens -> 'a*tokens) 
         	(toks:tokens) : 'a*tokens =
     try
       ph1 toks
     with (ParseErr _) -> ph2 toks;; 
*/
    def ^^[A,B](ph:Parser[A],f:A=>B) (toks:List[token]) = {
      val tup = ph(toks)
      (f(tup._1),tup._2)
    }


    def repeat[A](ph:Parser[A]) (toks:List[token]) : (List[A],List[token]) =   {
       |(^^(alt(ph,repeat[A](ph)(_)),
             ((ab:(A,List[A])) => ab._1::ab._2)),
         empty[A](_)) (toks)
    }

    def empty[A] (toks:List[token]) = (Nil:List[A],toks)

    def ?[A](ph:Parser[A]) (toks:List[token]) : (Option[A],List[token]) =   
       |(^^(ph,((a:A) => Some(a))),
          ((t:List[token]) => (None,t))) (toks)


/*

*
* https://wiki.scala-lang.org/display/SW/Parser+Combinators--Getting+Started

https://kerflyn.wordpress.com/2012/08/25/playing-with-scala-parser-combinator/

*/
  }


/*
 // convert parser below to Scala..

 let rec factor  = 
    (numb >> (fun x-> ENum x))
|%| (ident >> (fun s -> EId s))
|%| (key_open ++ expr ++ key_close 
	        >> (fun ((_,e),_) -> e))
and term = 
  ((factor ++ key_times) ++ term >> 
	   (fun ((e1,_),e2) -> ETimes (e1,e2)))
   |%| ((factor ++ key_div) ++ term >> 
        (fun ((e1,_),e2) -> EDiv (e1,e2)))
   |%| factor)

and expr tok = 
  ((term ++ key_plus) ++ expr >> 
    (fun ((e1,_),e2) -> EPlus (e1,e2)))
  |%| ((term ++ key_minus) ++ expr >> 
    (fun ((e1,_),e2) -> EMinus (e1,e2)))
  |%| term )

and term = 
  ((term ++ key_times) ++ factor>> 
	   (fun ((e1,_),e2) -> ETimes (e1,e2)))
   |%| ((term ++ key_div) ++ factor >> 
        (fun ((e1,_),e2) -> EDiv (e1,e2)))
   |%| factor)
   *
  and term = 
  ((factor ++ repeat 
     ((key_times |%| key_div) ++ factor)) 
   >> (fun (e1,lst) -> List.fold_left 
    (fun e (op,e2) -> 
      if op="*" then ETimes (e,e2) 
      else EDiv(e,e2)) e1 lst))

*/
}

// You may use the following abstract syntax tree from Tut7


object Lab4 extends App {


  abstract class Term
  case class Var(name: String) extends Term {
    override def toString = name
  }
  case class Fun(arg: String, body: Term) extends Term {
    override def toString = "\\" ++ arg ++ "." ++ body.toString
  }
  case class FApp(f: Term, v: Term) extends Term {
    override def toString = "("++f.toString ++ " " ++ v.toString++")"
  }
  case class Let(n: String,t1: Term, t2: Term) extends Term {
    override def toString = "(let "++n.toString ++ "=" ++ t1.toString++
    " in "++t2.toString ++")"
  }

  def free_vars (t:Term) : List[String] =
    t match {
      case Var(n) => List(n)
      case Fun(arg,body) => {
        val vs = free_vars(body)
        vs filterNot (x => (x==arg))
      }
      case FApp(t1,t2) => free_vars(t1) ++ free_vars(t2)
      case Let(v,t1,t2) => {
         val vs = free_vars(t1)
         (vs filterNot (x => (x==v))) ++ free_vars(t2)
      }
    }

  def parse_lambda(x:String):Option[Term] = 
    throw new toBeImplemented("parser for lambda term")

  def eval_to_value(x:Term):Term = 
    throw new toBeImplemented("evaluator for lambda term")

  import Parsing._
  println("Welcome to Lab4 on Parsing Lambda Calculus")
  // println(P.parseAll(P.expr,"123+123"))
  // println(P.parseAll(P.expr,"123123"))

  // println(Q.parseAll(Q.expr,"123+123"))
  // println(Q.parseAll(Q.expr,"123123"))

  // println(R.parseAll(R.expr,"1+(3+4)"))
  // println(R.parseAll(R.expr,"((1+2)+(3+4))+5"))
  // println(R.parseAll(R.expr,"((1+2)+(3+4))+5"))




}

