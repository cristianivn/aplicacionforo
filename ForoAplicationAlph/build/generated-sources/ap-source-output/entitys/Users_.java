package entitys;

import entitys.Answers;
import entitys.Questions;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-13T22:31:56")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile ListAttribute<Users, Answers> answersList;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile ListAttribute<Users, Questions> questionsList;

}