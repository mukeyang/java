package thinkinginjava;

/**
 * Created by CS on 2017/10/11.
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstname;
    @SQLString(50)
    String lastname;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, constrains = @Constrains(primary = true))
    String handle;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }
}
