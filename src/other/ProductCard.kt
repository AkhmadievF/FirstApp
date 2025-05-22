package other

class ProductCard(val name:String,
                  val brand:String,
                  val size:Float,
                  val price:Int) {



    fun printInfo(){
        println("Name: $name Brand: $brand Size: $size Price: $price")
    }
}