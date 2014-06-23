package entitys;

import entitys.Questions;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-13T22:31:56")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile SingularAttribute<Categories, Integer> idCategories;
    public static volatile SingularAttribute<Categories, String> category;
    public static volatile ListAttribute<Categories, Questions> questionsList;

}