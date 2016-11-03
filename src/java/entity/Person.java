package entity;




import interfaces.Peaple;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import util.ParseCode;


@Entity
public class Person implements Peaple {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String code;
    @Transient
    private Integer age;
    @Transient
    private String birthdey;
    @Transient
    private String gender;
    @Transient
    private ParseCode parseCode;
    
    
    public Person() {
    }

    public Person(String firstname, String lastname, String code) {
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setCode(code);
        this.parseCode = new ParseCode(this.code);
        this.setAge(this.parseCode);
        this.setBirthdey(this.parseCode);
        this.setGender(this.parseCode);
    }

    
    
    
    public Integer getAge() {
        return this.age;
    }
 
    public String getBirthday() {
        return this.birthdey;
    }

    @Override
    public String getFirstname() {
        return this.firstname;
    }

    @Override
    public String getLastname() {
        return this.lastname;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAge(ParseCode parseCode) {
        //ParseCode parseCode=new ParseCode(code);
        this.age = parseCode.getAge();
    }

    public void setBirthdey(ParseCode parseCode) {
        //ParseCode parseCode=new ParseCode(code);
        this.birthdey = parseCode.getBirthdey();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(ParseCode parseCode) {
        //ParseCode parseCode=new ParseCode(code);
        this.gender = parseCode.getGender();
    }

    @Override
    public String toString() {
        return "Person:\n name=" + firstname + ",\n surname=" + lastname + ",\n code=" + code + ",\n age=" + age + ",\n birthdey=" + birthdey + ",\n gender=" + gender;
    }
    
}
