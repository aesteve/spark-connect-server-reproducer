import org.apache.spark.sql.SparkSession

object Main extends App {

  val session = SparkSession.builder().remote("sc://localhost:15002").build()
  val df = session.createDataFrame(List((1, "A"), (2, "B")))
  println(df.count)


}
