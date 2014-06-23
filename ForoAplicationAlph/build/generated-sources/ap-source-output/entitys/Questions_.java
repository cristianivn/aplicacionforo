package entitys;

import entitys.Answers;
import entitys.Categories;
import entitys.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-13T22:31:56")
@StaticMetamodel(Questions.class)
public class Questions_ { 

    public static volatile SingularAttribute<Questions, Categories> idCategories;
    public static volatile SingularAttribute<Questions, Users> username;
    public static volatile SingularAttribute<Questions, String> dates;
    public static volatile ListAttribute<Questions, Answers> answersList;
    public static volatile SingularAttribute<Questions, String> question;
    public static volatile SingularAttribute<Questions, Integer> idQuestions;

}