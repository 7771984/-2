/* Дана строка sql-запроса"select * from students where "Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Входная строка:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Выходная строка:
select * from students where name = "Ivanov" and country = "Russia" and city = "Moscow"
*/

public class Задание__1 {

  public static final String query = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
  public static final String task = "select * from students where ";

  public static void main(String[] args) {
      String elementary = query.replace('{', ' ').replace('}', ' ');
      String [] finalStr = elementary.split(",");
      StringBuilder stringBuilder = new StringBuilder(task);
      for (int i = 0; i < finalStr.length; i++) {
          String[] elements = finalStr[i].replace('"', ' ').split(":");
          if (!"null".equals(elements[1].trim())) {
              stringBuilder.append(elements[0].trim()).append(" = ").append("'").append(elements[1].trim()).append("'");
              if (i < finalStr.length - 2)
                  stringBuilder.append(" and ");
          }
      }
      System.out.println(stringBuilder);
  }
}