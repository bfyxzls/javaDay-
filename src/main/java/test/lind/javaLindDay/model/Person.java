package test.lind.javaLindDay.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {
  private int personId;
  private String name;
  private Date birthDate;
  private Gender gender;

  public Person(int personId, String name, Date birthDate, Gender gender) {
    super();
    this.personId = personId;
    this.name = name;
    this.birthDate = birthDate;
    this.gender = gender;
  }

  public static void testGroupBy() {
    try {
      DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

      List<Person> persons = new ArrayList<Person>();
      persons.add(new Person(1, "Yashwant", dateFormat.parse("11/02/1982"), Gender.MALE));
      persons.add(new Person(2, "Mahesh", dateFormat.parse("01/08/1981"), Gender.MALE));
      persons.add(new Person(3, "Vinay", dateFormat.parse("01/08/1981"), Gender.MALE));
      persons.add(new Person(4, "Dinesh", dateFormat.parse("01/08/1981"), Gender.MALE));
      persons.add(new Person(5, "Kapil", dateFormat.parse("01/02/1989"), Gender.MALE));
      persons.add(new Person(6, "Ganesh", dateFormat.parse("11/02/1982"), Gender.MALE));
      persons.add(new Person(7, "Nita", dateFormat.parse("01/08/1981"), Gender.FEMALE));
      persons.add(new Person(8, "Pallavi", dateFormat.parse("04/25/1987"), Gender.FEMALE));
      persons.add(new Person(9, "Mayuri", dateFormat.parse("01/08/1981"), Gender.FEMALE));
      persons.add(new Person(10, "Divya", dateFormat.parse("01/08/1981"), Gender.FEMALE));


      Map<Gender, Long> byGender = persons.stream()
          .collect(Collectors.groupingBy(p -> p.getGender(), Collectors.counting()));

      Map<Object, Long> byBirthDate = persons.stream()
          .collect(Collectors.groupingBy(p -> dateFormat.format(p.getBirthDate()), Collectors.counting()));

      Map<Gender, Map<Object, String>> byGenderAndBirthDate = persons.stream()
          .collect(Collectors.groupingBy(p -> p.getGender(),
              Collectors.groupingBy(p -> dateFormat.format(p.getBirthDate()),
                  Collectors.mapping(p -> p.getName(), Collectors.joining(", ")))));

      System.out.println("Group By Gender");
      System.out.println(byGender);
      System.out.println("\nGroup By BirthDate");
      System.out.println(byBirthDate);
      System.out.println("\nGroup By Gender & BirthDate");
      System.out.println(byGenderAndBirthDate);

    } catch (ParseException e) {
      e.printStackTrace();
    }

  }

  public boolean isMale() {
    return this.gender == Gender.MALE;
  }

  public boolean isFemale() {
    return this.gender == Gender.FEMALE;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    StringBuilder str = null;
    str = new StringBuilder();
    str.append("Person Id:- " + getPersonId() + " Gender:- " + getGender() + " Name:- " + getName() +
        " Birthdate:- " + dateFormat.format(getBirthDate()));
    return str.toString();
  }


  public static enum Gender {
    MALE,
    FEMALE
  }

}