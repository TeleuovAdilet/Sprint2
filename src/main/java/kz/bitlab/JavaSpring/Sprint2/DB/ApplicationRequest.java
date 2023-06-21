package kz.bitlab.JavaSpring.Sprint2.DB;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    Long ID;
    String userName;
    String courseName;
    String commentary;
    String phone;
    boolean handled;

}
