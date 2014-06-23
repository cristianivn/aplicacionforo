package entitys;

import entitys.Questions;
import entitys.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-13T22:31:56")
@StaticMetamodel(Answers.class)
public class Answers_ { 

    public static volatile SingularAttribute<Answers, Users> username;
    public static volatile SingularAttribute<Answers, String> dates;
    public static volatile SingularAttribute<Answers, Integer> idAnswers;
    public static volatile SingularAttribute<Answers, String> answer;
    public static volatile SingularAttribute<Answers, Questions> idQuestions;

}